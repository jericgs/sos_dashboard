/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.UsuarioDAO;
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
public class AjaxValidacaoUserName implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DA TELA
        String usuario = req.getParameter("login");

        //INSTÂNCIANDO USUARIODAO
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        String confirmacao = usuarioDAO.verificadoNomeUsuario(usuario);

        if (confirmacao == null) {
            
            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacao", "true");
            arrayNode.add(objectNode);
            
            json = mapper.writeValueAsString(arrayNode);
            
        }

        if (confirmacao != null) {
            
            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacao", "false");
            arrayNode.add(objectNode);
            
            json = mapper.writeValueAsString(arrayNode);

        }

        return json;
    }

}
