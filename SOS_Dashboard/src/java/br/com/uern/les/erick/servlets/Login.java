/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.servlets;

import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        PrintWriter out = response.getWriter();

        if ((((usuario.equalsIgnoreCase("")) && (senha.equalsIgnoreCase(""))) || usuario.equalsIgnoreCase("") || senha.equalsIgnoreCase(""))) {

            out.println("<script src='https://unpkg.com/sweetalert2@7.21.1/dist/sweetalert2.all.js'></script>");
            out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal({type: 'warning', title: 'Oops...', text: 'Campos em Branco!', showConfirmButton: false, timer: 1500})");
            out.println("});");
            out.println("</script>");

            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.include(request, response);
        } else {

            Connection connection = (Connection) request.getAttribute("conexao");
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario usuarioB = usuarioDAO.getLogin(usuario, senha);

            if (usuarioB == null) {

                out.println("<script src='http://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal({type: 'error', title: 'Oops...', text: 'Acesso negado!', showConfirmButton: false, timer: 1500})");
                out.println("});");
                out.println("</script>");

                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            } else {

                if (usuarioB.getTipoDeUsuario().equalsIgnoreCase("Tarm")) {
                    request.setAttribute("resultado", usuarioB);
                    RequestDispatcher rd = request.getRequestDispatcher("areaTarm.jsp");
                    rd.forward(request, response);
                }

                if (usuarioB.getTipoDeUsuario().equalsIgnoreCase("Médico")) {
                    request.setAttribute("Resultado", usuarioB.getTipoDeUsuario());
                    request.getRequestDispatcher("areaMedico.jsp").forward(request, response);
                }

                if (usuarioB.getTipoDeUsuario().equalsIgnoreCase("Admin")) {
                    request.setAttribute("Resultado", usuarioB);
                    request.getRequestDispatcher("areaAdmin.jsp").forward(request, response);
                }

            }

        }

    }
}
