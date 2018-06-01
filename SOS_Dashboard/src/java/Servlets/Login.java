/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Agente.DataBaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private String usuario;
    private String senha;
    private String queryLogin;
    private String resultadoLogin = "acessoNegado";
    private ResultSet retornoBD;    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuario = request.getParameter("usuario");
        senha = request.getParameter("senha");
        PrintWriter out = response.getWriter();
        

        try {

            DataBaseConnection dbc = new DataBaseConnection();
            dbc.connectDataBase();

            if (dbc.isConnected()) {

                queryLogin = "SELECT TipoDeUsuario FROM usuario WHERE NomeUsuario = '" + usuario + "' AND Senha = '" + senha + "'";
                retornoBD = dbc.executeQuery(queryLogin);

                while (retornoBD.next()) {

                    resultadoLogin = retornoBD.getString("TipoDeUsuario");

                }

                if (resultadoLogin.equalsIgnoreCase("Tarm")) {
                    request.setAttribute("Resultado", resultadoLogin);  
                    request.getRequestDispatcher("areaTarm.jsp").forward(request, response);                                      
                }

                if (resultadoLogin.equalsIgnoreCase("Médico")) {
                    request.setAttribute("Resultado", resultadoLogin);
                    request.getRequestDispatcher("areaMedico.jsp").forward(request, response);  
                }
                
                if (resultadoLogin.equalsIgnoreCase("Admin")) {
                    request.setAttribute("Resultado", resultadoLogin);
                    request.getRequestDispatcher("areaAdmin.jsp").forward(request, response);  
                }

                if (resultadoLogin.equalsIgnoreCase("acessoNegado")) {
                    
                    
                    out.println("<script src='http://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal({type: 'error', title: 'Oops...', text: 'Acesso negado!', showConfirmButton: false, timer: 2000})");
                    out.println("});");
                    out.println("</script>");
                    
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.include(request, response);
                                        
                }
            }

        } catch (IOException | ServletException e) {
            System.out.println("Exception: " + e);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
