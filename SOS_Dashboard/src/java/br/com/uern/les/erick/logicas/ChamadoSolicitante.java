/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.TarmDAO;
import br.com.uern.les.erick.modelos.Tarm;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class ChamadoSolicitante implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String nomeUsuario = req.getParameter("nomeUsuario");

        Connection connection = (Connection) req.getAttribute("conexao");
        HttpSession session = req.getSession();
        
        TarmDAO tarmDAO = new TarmDAO(connection);
        Tarm tarm = tarmDAO.getDadosTarm(nomeUsuario);        
        session.setAttribute("dadosTarm", tarm);

        return "chamadoSolicitante.jsp";
    }
    
}
