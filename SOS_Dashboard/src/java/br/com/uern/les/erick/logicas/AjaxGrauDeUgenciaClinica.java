/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.modelos.Regulacao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class AjaxGrauDeUgenciaClinica implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String json = null;
       
        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //VALORES PARA CALCULAR O GRAU DE URGÊNCIA
        int idR = Integer.parseInt(req.getParameter("idR"));

        float nivelConsciencia = Float.parseFloat(req.getParameter("nivelConsciencia"));
        float estadoGeralVitima = Float.parseFloat(req.getParameter("estadoGeralVitima"));
        float respiracao = Float.parseFloat(req.getParameter("respiracao"));
        float corVitima = Float.parseFloat(req.getParameter("corVitima"));
        float dorIntensidade = Float.parseFloat(req.getParameter("dorIntensidade"));
        float aparecimentoDor = Float.parseFloat(req.getParameter("aparecimentoDor"));

        int gravidadeCaso = Integer.parseInt(req.getParameter("gravidadeCaso"));
        int valorSocial = Integer.parseInt(req.getParameter("valorSocial"));
        int valorRecursos = Integer.parseInt(req.getParameter("valorRecursos"));
        int valorTempo = Integer.parseInt(req.getParameter("valorTempo"));

        //CALCULANDO GRAVIDADE SEMIOLOGICA
        float GSf = (nivelConsciencia + estadoGeralVitima + respiracao + corVitima + dorIntensidade + aparecimentoDor) / 6;

        //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
        float GEf = gravidadeCaso;

        //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
        GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
        float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
        float GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);

        //AREDONDADNDO VALORES
        int GS = Math.round(GSf);
        int GE = Math.round(GEf);
        int GU = Math.round(GUf);

        //MODELO REGULACAO
        Regulacao regulacao = new Regulacao();
        regulacao.setIdR(idR);
        regulacao.setGe(GE);
        regulacao.setGs(GS);
        regulacao.setAtencao(valorRecursos);
        regulacao.setSocial(valorSocial);
        regulacao.setTempo(valorTempo);
        regulacao.setGu(GU);

        //INSTÂNCIANDO E ATUALIZANDO REGULAÇÃO
        RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
        regulacaoDAO.atualizarRegulacaoInteligencia(regulacao); 
                         
        return json;
    }

}
