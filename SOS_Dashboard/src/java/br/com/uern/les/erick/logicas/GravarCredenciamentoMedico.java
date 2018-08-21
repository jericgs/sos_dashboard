/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ContatoDAO;
import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Contato;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import br.com.uern.les.erick.modelos.ModeloEmail;
import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarCredenciamentoMedico implements Logica {

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

            //INSTÂNCIANDO MEDICODAO
            MedicoDAO medicoDAO = new MedicoDAO(connection);
            MedicoRegulador medicoRegulador = medicoDAO.getDadosMedicoRegulador(nomeUsuario);

            //INSTÂNCIANDO CONTATODAO
            ContatoDAO contatoDAO = new ContatoDAO(connection);
            Contato contato = contatoDAO.getContato(medicoRegulador.getIdC());

            //INSTÂNCIANDO CLASSE DE E-MAIL
            EnviarEmail enviar = new EnviarEmail();
            enviar.setEmailDestinatario(contato.getEmail());
            enviar.setAssunto("Contato - SAMU MOSSORÓ");

            //CHAMO MODELO DO E-MAIL
            ModeloEmail modeloEmail = new ModeloEmail();
            StringBuilder texto = modeloEmail.modelo3(medicoRegulador.getNome(), usuarioBuscado.getNomeUsuario(), usuarioBuscado.getSenha());

            //ENVIANDO MENSAGEM
            enviar.setMsg(texto.toString());
            boolean enviou = enviar.enviarGmail();

            if (enviou) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "contaMedico.jsp";

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("error");
                alerta.setMsnAlerta("Erro ao Gravar!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "contaMedico.jsp";

            }

        } else {

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("error");
            alerta.setMsnAlerta("Erro ao Gravar!");
            req.setAttribute("alerta", alerta);

            //SETANDO PÁGINA
            pagina = "contaMedico.jsp";

        }

        return pagina;
    }

}
