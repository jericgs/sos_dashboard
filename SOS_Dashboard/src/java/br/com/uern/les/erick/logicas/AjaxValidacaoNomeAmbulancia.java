/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.UmsaDAO;
import br.com.uern.les.erick.daos.UmsbDAO;
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
public class AjaxValidacaoNomeAmbulancia implements LogicaAjax{

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;
        
        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");
        
        //CAMPOS DA TELA
        String tipoAmbulancia = req.getParameter("tipoAmbulancia");
        String numeroAmbulancia = req.getParameter("numeroAmbulancia");
        
        //CONCATENANDO STRINGS
        String nomeAmbulancia = tipoAmbulancia + " " + numeroAmbulancia;
        
        //INSTÂNCIANDO UMSADAO
        UmsaDAO umsaDAO = new UmsaDAO(connection);
        String confirmacaoNomeUMSA = umsaDAO.verificandoNomeAmbulancia(nomeAmbulancia);
        
        //INSTÂNCIANDO UMSBDAO
        UmsbDAO umsbDAO = new UmsbDAO(connection);
        String confirmacaoNomeUMSB = umsbDAO.verificandoNomeAmbulancia(nomeAmbulancia);
        
        if ((confirmacaoNomeUMSA == null) && (confirmacaoNomeUMSB == null)) {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoNomeAmbulancia", "true");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);

        } else {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoNomeAmbulancia", "false");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);

        }
        
        return json;
    }
    
}
