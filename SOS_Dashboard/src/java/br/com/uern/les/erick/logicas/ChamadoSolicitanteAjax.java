/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class ChamadoSolicitanteAjax implements LogicaAjax{

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Connection connection = (Connection) req.getAttribute("conexao");
        MedicoDAO mdao = new MedicoDAO(connection);
        List<MedicoRegulador> medicoReguladors = mdao.getMedicoRegulador();                               
        
        //INVERSÃO DE CONTROLE (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(medicoReguladors);               
        
        return json;
    }
    
}
