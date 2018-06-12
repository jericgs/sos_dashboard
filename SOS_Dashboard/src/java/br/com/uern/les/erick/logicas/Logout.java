/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.UsuarioDAO;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Logout implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String status = req.getParameter("status");
        String nomeUsuario = req.getParameter("nomeUsuario");

        if (status.equalsIgnoreCase("logado")) {

            //invalida a sessão
            HttpSession sessao = req.getSession();
            sessao.invalidate();

            //muda o status para offline
            Connection connection = (Connection) req.getAttribute("conexao");

            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            usuarioDAO.getLogout(nomeUsuario);
            return "login.jsp";
        }
        return null;

    }

}
