/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Usuario;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Login implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        PrintWriter out = res.getWriter();

        if (usuario.equalsIgnoreCase("L") && senha.equalsIgnoreCase("S")) {
            return "login.jsp";
        } else {

            if ((((usuario.equalsIgnoreCase("")) && (senha.equalsIgnoreCase(""))) || usuario.equalsIgnoreCase("") || senha.equalsIgnoreCase(""))) {

                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("info");
                alerta.setMsnAlerta("Campos em Branco!");
                req.setAttribute("resultado", alerta);
                return "login.jsp";
            } else {

                Connection connection = (Connection) req.getAttribute("conexao");

                UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                Usuario usuarioB = usuarioDAO.getLogin(usuario, senha);

                if (usuarioB == null) {
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("error");
                    alerta.setMsnAlerta("Acesso Negado!");
                    req.setAttribute("resultado", alerta);
                    return "login.jsp";
                } else {

                    if (usuarioB.getTipoDeUsuario().equalsIgnoreCase("Tarm")) {

                        HttpSession session = req.getSession();
                        session.setAttribute("status", "logado");                        
                        session.setAttribute("tarm", usuarioB);
                        return "areaTarm.jsp";
                    }

                    if (usuarioB.getTipoDeUsuario().equalsIgnoreCase("Médico")) {

                        HttpSession session = req.getSession();
                        session.setAttribute("status", "logado");                        
                        session.setAttribute("medico", usuarioB);
                        return "areaMedico.jsp";
                    }

                    if (usuarioB.getTipoDeUsuario().equalsIgnoreCase("Admin")) {

                        HttpSession session = req.getSession();
                        session.setAttribute("status", "logado");                        
                        session.setAttribute("admin", usuarioB);
                        return "areaAdmin.jsp";
                    }

                }

            }

        }
        return "login.jsp";
    }

}
