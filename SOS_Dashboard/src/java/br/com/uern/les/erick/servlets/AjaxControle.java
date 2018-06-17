/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.servlets;

import br.com.uern.les.erick.logicas.LogicaAjax;
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
@WebServlet(name = "AjaxControle", urlPatterns = {"/AjaxControle"})
public class AjaxControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String dados = "{\"clientes\": [{\"id\":\"1\", \"nome\":\"Erick g\", \"email\":\"jerick.gs@gmail.com\"}, {\"id\":\"2\", \"nome\":\"Marcos\", \"email\":\"marcos.gs@gmail.com\"}, {\"id\":\"3\", \"nome\":\"José\", \"email\":\"jose.gs@gmail.com\"}]}";
        
        String parametro = request.getParameter("logicaAjax");
        String nomeDaClasse = "br.com.uern.les.erick.logicas." + parametro;
        
        try {
            Class classe = Class.forName(nomeDaClasse);
            LogicaAjax logicaAjax = (LogicaAjax) classe.newInstance();
            String json = logicaAjax.executaAjax(request, response);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(json);
        } catch (Exception e) {
            throw new ServletException(
                    "A lógica de negócios causou uma exceção", e);
        }      

    }

}
