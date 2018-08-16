/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.AuxiliarDAO;
import br.com.uern.les.erick.daos.EnfermeiroDAO;
import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.daos.MotoristaDAO;
import br.com.uern.les.erick.daos.TarmDAO;
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
public class AjaxValidacaoCpf implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DA TELA
        String cpf = req.getParameter("cpf");

        //INSTÂNCIANDO AUXILIARDAO
        AuxiliarDAO auxiliarDAO = new AuxiliarDAO(connection);
        String cpfValidacaoAux = auxiliarDAO.verificadoCpf(cpf);

        //INSTÂNCIANDO ENFERMEIRODAO
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO(connection);
        String cpfValidacaoEnf = enfermeiroDAO.verificadoCpf(cpf);

        //INSTÂNCIANDO MEDICODAO
        MedicoDAO medicoDAO = new MedicoDAO(connection);
        String cpfValidacaoMed = medicoDAO.verificadoCpf(cpf);

        //INSTÂNCIANDO MOTORISTADAO
        MotoristaDAO motoristaDAO = new MotoristaDAO(connection);
        String cpfValidacaoMot = motoristaDAO.verificadoCpf(cpf);

        //INSTÂNCIANDO TARMDAO
        TarmDAO tarmDAO = new TarmDAO(connection);
        String cpfValidacaoTar = tarmDAO.verificadoCpf(cpf);

        if ((cpfValidacaoAux == null) && (cpfValidacaoEnf == null) && (cpfValidacaoMed == null)
                && (cpfValidacaoMot == null) && (cpfValidacaoTar == null)) {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoCpf", "true");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);

        } else {

            //INVERSÃO DE CONTROLE (IOC) - JACKSON
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("confirmacaoCpf", "false");
            arrayNode.add(objectNode);

            json = mapper.writeValueAsString(arrayNode);

        }

        return json;
    }

}
