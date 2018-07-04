/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.modelos.Alerta;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarRegulacao implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String pagina = null;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS MOTIVO
        String motivo = req.getParameter("motivo");

        if (motivo.equalsIgnoreCase("Informação")) {

            //CAMPOS REGULAÇÃO INFORMAÇÃO
            int idR = Integer.parseInt(req.getParameter("idR"));
            String tipoCaso = req.getParameter("tipoCaso");
            String justificativa = req.getParameter("justificativa");

            //INSTÂNCIA REGULAÇÃO E REALIZA A INSERÇÃO
            RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
            regulacaoDAO.atualizarRegulacao(idR, tipoCaso, justificativa);
            
            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("confirmacao", alerta);

            pagina = "listaRegulacao.jsp";

        }

        return pagina;
    }

}
