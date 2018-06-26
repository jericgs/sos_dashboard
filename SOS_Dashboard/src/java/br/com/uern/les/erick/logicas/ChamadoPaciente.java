/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.modelos.ChamadoSolicitanteDados;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class ChamadoPaciente implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {          
                
        ChamadoSolicitanteDados solicitanteDados = new ChamadoSolicitanteDados();
        solicitanteDados.setNumChamado(req.getParameter("numChamado"));
        solicitanteDados.setData(req.getParameter("data"));
        solicitanteDados.setHora(req.getParameter("hora"));
        solicitanteDados.setNome(req.getParameter("solicitante"));
        solicitanteDados.setTel(req.getParameter("telefone"));
        solicitanteDados.setMedicoCPF(req.getParameter("medicoCPF"));
        solicitanteDados.setMotivo(req.getParameter("motivo"));

        HttpSession session = req.getSession();        
        session.setAttribute("dadosChamadoP1", solicitanteDados); 

        return "chamadoPaciente.jsp";
    }

}
