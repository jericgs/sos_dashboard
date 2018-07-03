/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class ListaRegulacoes implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        String nomeUsuario = req.getParameter("nomeUsuario");

        Connection connection = (Connection) req.getAttribute("conexao");
        HttpSession session = req.getSession();                
        
        MedicoDAO medicoDAO = new MedicoDAO(connection);        
        MedicoRegulador medicoRegulador = medicoDAO.getDadosMedicoRegulador(nomeUsuario);                        
        session.setAttribute("dadosMedicoRegulador", medicoRegulador);        
        
        return "listaRegulacao.jsp";
    }
    
}
