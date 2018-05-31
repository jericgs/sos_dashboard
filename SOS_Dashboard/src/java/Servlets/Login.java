/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Agente.DataBaseConnection;
import java.io.IOException;
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
                    //request.getRequestDispatcher("areaTarm.jsp").forward(request, response);  
                }

                if (resultadoLogin.equalsIgnoreCase("Admin")) {
                    //request.getRequestDispatcher("areaTarm.jsp").forward(request, response);  
                }

                if (resultadoLogin.equalsIgnoreCase("acessoNegado")) {
                    //request.getRequestDispatcher("areaTarm.jsp").forward(request, response);
                }
            }

        } catch (IOException | ServletException e) {
            System.out.println("Exception: " + e);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);*/
    }

}
