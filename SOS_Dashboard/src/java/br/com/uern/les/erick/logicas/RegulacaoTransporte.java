/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.PacienteDAO;
import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.modelos.ChamadoEspera;
import br.com.uern.les.erick.modelos.Chamado;
import br.com.uern.les.erick.modelos.Paciente;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class RegulacaoTransporte implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {                
        
        //PEGANDO DADOS DA REQUISIÇÃO
        int idR = Integer.parseInt(req.getParameter("idR"));
        
        //CONEXÃO COM BD
        Connection connection = (Connection) req.getAttribute("conexao");
                              
        //INSTÂNCIANDO REGULAÇÃODAO E REALIZANDO BUSCA
        RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
        int idRC = regulacaoDAO.getIdRegistroChamado(idR);
        
        //INSTÂNCIANDO CHAMADODAO E REALIZANDO BUSCA
        ChamadoDAO chamadoDAO =  new ChamadoDAO(connection);
        Chamado chamado = chamadoDAO.getChamado(idRC);
        
        //INSTÂNCIANDO PACIENTEDAO E REALIZANDO BUSCA
        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        Paciente paciente = pacienteDAO.getPacienteRegulacaoI(chamado.getIdP());
        
        //INSTÂNCIANDO MODELO E INSERINDO
        ChamadoEspera chamadoEspera = new ChamadoEspera();
        chamadoEspera.setIdR(idR);
        chamadoEspera.setNomePaciente(paciente.getNome());
        chamadoEspera.setIdade(paciente.getIdade());
        chamadoEspera.setMotivo(chamado.getMotivo());
        chamadoEspera.setQueixa(chamado.getQueixa());
        
        //INSTÂNCIANDO SESSÃO
        HttpSession session = req.getSession();
        session.setAttribute("dadosPacienteTrans", chamadoEspera);                
        
        return "regulacaoTransporte.jsp";
    }
    
}
