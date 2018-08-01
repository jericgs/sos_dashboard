/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class EditarChamado implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;
        
        //CAMPOS DE TELA
        int idR = Integer.parseInt(req.getParameter("idR"));
        int idRC = Integer.parseInt(req.getParameter("idRC"));
        int idP = Integer.parseInt(req.getParameter("idP"));
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");
        
        pagina = "editarChamado.jsp";
        
        return pagina;
    }
    
}
