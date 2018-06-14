/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class ChamadoSolicitante implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {       
        
        String nomeUsuario = req.getParameter("nomeUsuario");
        
        Connection connection = (Connection) req.getAttribute("conexao");
        return "chamadoSolicitante.jsp";
    }
    
}
