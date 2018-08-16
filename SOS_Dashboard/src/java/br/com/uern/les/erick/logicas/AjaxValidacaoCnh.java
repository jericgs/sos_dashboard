/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.MotoristaDAO;
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
public class AjaxValidacaoCnh implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DA TELA
        String cnh = req.getParameter("cnh");

        //INSTÂNCIANDO MOTORISTADAO
        MotoristaDAO motoristaDAO = new MotoristaDAO(connection);
        String cpfValidacaoMot = motoristaDAO.verificadoCnh(cnh);

        if (cpfValidacaoMot == null) {
            
            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoCnh", "true");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);
            
        } else {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoCnh", "false");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);
            
        }

        return json;
    }

}
