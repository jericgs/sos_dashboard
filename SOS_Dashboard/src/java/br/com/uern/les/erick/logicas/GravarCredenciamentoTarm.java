/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ContatoDAO;
import br.com.uern.les.erick.daos.TarmDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Contato;
import br.com.uern.les.erick.modelos.ModeloEmail;
import br.com.uern.les.erick.modelos.Tarm;
import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarCredenciamentoTarm implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DE TELA
        String nomeUsuario = req.getParameter("nomeUsuario");
        String login = req.getParameter("loginC");
        String senha = req.getParameter("senha");
        String senhaR = req.getParameter("senhaR");

        //INSTÂNCIANDO MODELO USUARIO
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);

        //INSTÂNCIANDO USUARIODAO
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        int confirmacao = usuarioDAO.atualizarCredencial(usuario, nomeUsuario);
        Usuario usuarioBuscado = usuarioDAO.getUsuario(nomeUsuario);

        if (confirmacao != 0) {

            //INSTÂNCIANDO TARMDAO
            TarmDAO tarmDAO = new TarmDAO(connection);
            Tarm tarm = tarmDAO.getDadosTarm(usuarioBuscado.getNomeUsuario());

            //INSTÂNCIANDO CONTATODAO
            ContatoDAO contatoDAO = new ContatoDAO(connection);
            Contato contato = contatoDAO.getContato(tarm.getIdC());

            //INSTÂNCIANDO CLASSE DE E-MAIL
            EnviarEmail enviar = new EnviarEmail();
            enviar.setEmailDestinatario(contato.getEmail());
            enviar.setAssunto("Contato - SAMU MOSSORÓ");

            //CHAMO MODELO DO E-MAIL
            ModeloEmail modeloEmail = new ModeloEmail();
            StringBuilder texto = modeloEmail.modelo3(tarm.getNome(), usuarioBuscado.getNomeUsuario(), usuarioBuscado.getSenha());

            new Thread() {
                @Override
                public void run() {
                    //ENVIANDO MENSAGEM
                    enviar.setMsg(texto.toString());
                    boolean enviou = enviar.enviarGmail();
                }
            }.start();

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("alerta", alerta);

            //SETANDO PÁGINA
            pagina = "contaTarm.jsp";

        } else {

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("error");
            alerta.setMsnAlerta("Erro ao Gravar!");
            req.setAttribute("alerta", alerta);

            //SETANDO PÁGINA
            pagina = "contaTarm.jsp";

        }

        return pagina;
    }

}
