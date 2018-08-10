/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Cadastro implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;
        
        String nomeUsuario = req.getParameter("nomeUsuario");
        
        HttpSession session = req.getSession();
        session.setAttribute("dadosAdmin", nomeUsuario);
        
        pagina = "cadastro.jsp";
        
        return pagina;
    }
    
}
