/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.modelos.InformacaoDeTempo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class AreaAjaxInformacao implements LogicaAjax{

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        String dataInformacao = req.getParameter("dataInformacao");
        InformacaoDeTempo informacaoDeTempo = new InformacaoDeTempo();
        
        if(dataInformacao.equalsIgnoreCase(informacaoDeTempo.getDate())){
            
            Connection connection = (Connection) req.getAttribute("conexao");
            ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
            String numChamadoInformacao = Integer.toString(chamadoDAO.getNumChamadoInformacao(dataInformacao));
            
            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();
            
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("numChamadoInformacao", numChamadoInformacao);
            arrayNode.add(objectNode);
            
            String json = mapper.writeValueAsString(arrayNode);
            return json;
            
        }
        
        return null;
        
    }
    
}
