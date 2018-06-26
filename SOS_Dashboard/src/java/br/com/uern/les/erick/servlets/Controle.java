/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.servlets;

import br.com.uern.les.erick.logicas.Logica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
@WebServlet(name = "controle", urlPatterns = {"/controle"})
public class Controle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parametro = request.getParameter("logica");
        String nomeDaClasse = "br.com.uern.les.erick.logicas." + parametro;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(request, response);            
            request.getRequestDispatcher(pagina).forward(request, response);
        } catch (Exception e) {
            throw new ServletException(
                    "A lógica de negócios causou uma exceção", e);
        }        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parametro = request.getParameter("logica");
        String nomeDaClasse = "br.com.uern.les.erick.logicas." + parametro;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(request, response);            
            request.getRequestDispatcher(pagina).forward(request, response);
        } catch (Exception e) {
            throw new ServletException(
                    "A lógica de negócios causou uma exceção", e);
        }
    }

}
