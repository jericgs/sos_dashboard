/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarCredenciamentoAdmin implements Logica {

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

        if (confirmacao != 0) {

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("alerta", alerta);

            //SETANDO PÁGINA
            pagina = "contaAdmin.jsp";

        } else {

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("error");
            alerta.setMsnAlerta("Erro ao Gravar!");
            req.setAttribute("alerta", alerta);

            //SETANDO PÁGINA
            pagina = "contaAdmin.jsp";

        }
        
        return pagina;
    }

}
