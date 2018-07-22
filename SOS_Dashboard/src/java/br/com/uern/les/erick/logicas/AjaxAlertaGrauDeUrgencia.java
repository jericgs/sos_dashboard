/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ClassificadaDAO;
import br.com.uern.les.erick.modelos.Classificada;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class AjaxAlertaGrauDeUrgencia implements LogicaAjax{

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        String json = null;
        
        Thread.sleep(1600);
        
        //LISTA CLASSIFICADA        
        List<Classificada> classificadas = new ArrayList<>();
        
        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //VALORES PARA CALCULAR O GRAU DE URGÊNCIA
        int idR = Integer.parseInt(req.getParameter("idR"));
        
        //INSTÂNCIANDO CLASSIFICADADAO E PEGANDO A INFERÊNCIA
        ClassificadaDAO classificadaDAO = new ClassificadaDAO(connection);
        Classificada classificada = classificadaDAO.buscandoClassificacao(idR);

        //ADD CLASSIFICADA NA LISTA
        classificadas.add(classificada);

        //INVERSÃO DE CONTROLE (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        json = mapper.writeValueAsString(classificadas);
        
        return json;
    }
    
}
