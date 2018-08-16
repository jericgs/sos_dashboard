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
public class AjaxValidacaoPlaca implements LogicaAjax{

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;
        
        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DA TELA
        String placa = req.getParameter("placa");
        
        //INSTÂNCIANDO UMSADAO
        UmsaDAO umsaDAO = new UmsaDAO(connection);
        int confirmacaoUMSA = umsaDAO.verificarSuport(placa);
        
        //INSTÂNCIANDO UMSBDAO
        UmsbDAO umsbDAO = new UmsbDAO(connection);
        int confirmacaoUMSB = umsbDAO.verificarSuport(placa);
        
        if ((confirmacaoUMSA == 0) && (confirmacaoUMSB == 0)) {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoPlaca", "true");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);

        } else {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoPlaca", "false");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);

        }
        
        return json;
    }
    
}
