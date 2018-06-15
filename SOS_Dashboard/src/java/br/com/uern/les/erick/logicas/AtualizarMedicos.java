/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class AtualizarMedicos implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Connection connection = (Connection) req.getAttribute("conexao");
        HttpSession session = req.getSession();
        
        MedicoDAO mdao = new MedicoDAO(connection);
        List<MedicoRegulador> medicoReguladors = mdao.getMedicoRegulador();        
        session.setAttribute("medicosOn", medicoReguladors);
        
        return null;
    }
    
}
