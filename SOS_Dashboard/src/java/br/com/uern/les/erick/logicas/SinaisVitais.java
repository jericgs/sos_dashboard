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
public class SinaisVitais implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;
        
        //CAMPO DA TELA
        int idR = Integer.parseInt(req.getParameter("idR"));
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");
        
        //CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");
        
        

        //MODELO CHAMADOESPERA
        
        pagina = "sinaisVitais.jsp";
        
        return pagina;
    }
    
}
