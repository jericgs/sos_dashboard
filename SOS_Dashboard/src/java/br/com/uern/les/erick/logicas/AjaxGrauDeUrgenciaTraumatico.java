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
public class AjaxGrauDeUrgenciaTraumatico implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;

        //VARIAVEIS
        float GSf = 0;
        float GEf = 0;
        float GUf = 0;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //VALORES PARA CALCULAR O GRAU DE URGÊNCIA
        int idR = Integer.parseInt(req.getParameter("idR"));
        String especificacao = req.getParameter("especificacao");

        //CAMPO QUE ESTARÁ EM TODAS OS TIPOS DE TRAUMA
        int gravidadeCaso = Integer.parseInt(req.getParameter("gravidadeCaso"));
        int valorSocial = Integer.parseInt(req.getParameter("valorSocial"));
        int valorRecursos = Integer.parseInt(req.getParameter("valorRecursos"));
        int valorTempo = Integer.parseInt(req.getParameter("valorTempo"));

        if (especificacao.equalsIgnoreCase("Trânsito")) {

            //ESPECIFICAÇÃO TRÂNSITO
            float local = Float.parseFloat(req.getParameter("local"));
            float equipamentoSeguranca = Float.parseFloat(req.getParameter("equipamentoSeguranca"));
            float vitimaMove = Float.parseFloat(req.getParameter("vitimaMove"));
            float acordado = Float.parseFloat(req.getParameter("acordado"));
            float falando = Float.parseFloat(req.getParameter("falando"));
            float sangramento = Float.parseFloat(req.getParameter("sangramento"));
            float ejetadaDoVeiculo = Float.parseFloat(req.getParameter("ejetadaDoVeiculo"));
            float presaFerragens = Float.parseFloat(req.getParameter("presaFerragens"));
            float respiracao = Float.parseFloat(req.getParameter("respiracao"));
            float morteOcupante = Float.parseFloat(req.getParameter("morteOcupante"));

            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = (vitimaMove + acordado + falando + sangramento + respiracao + morteOcupante) / 6;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = (gravidadeCaso + local + equipamentoSeguranca + ejetadaDoVeiculo + presaFerragens) / 5;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);

        }

        if (especificacao.equalsIgnoreCase("Queda")) {

            //ESPECIFICAÇÃO QUEDA
            float tipoQueda = Float.parseFloat(req.getParameter("tipoQueda"));
            float vitimas = Float.parseFloat(req.getParameter("vitimas"));
            float vitimaMove = Float.parseFloat(req.getParameter("vitimaMove"));
            float acordado = Float.parseFloat(req.getParameter("acordado"));
            float respiracao = Float.parseFloat(req.getParameter("respiracao"));
            float falando = Float.parseFloat(req.getParameter("falando"));
            float sangramento = Float.parseFloat(req.getParameter("sangramento"));

            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = (vitimaMove + acordado + respiracao + falando + sangramento) / 5;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = (gravidadeCaso + tipoQueda + vitimas) / 3;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);

        }

        if (especificacao.equalsIgnoreCase("Queimaduras")) {

            //ESPECIFICAÇÃO QUEIMADURAS
            float agenteCausador = Float.parseFloat(req.getParameter("agenteCausador"));
            float vitimas = Float.parseFloat(req.getParameter("vitimas"));
            float acordado = Float.parseFloat(req.getParameter("acordado"));
            float falando = Float.parseFloat(req.getParameter("falando"));
            float respiracao = Float.parseFloat(req.getParameter("respiracao"));
            float sangramento = Float.parseFloat(req.getParameter("sangramento"));
            float atingiuFace = Float.parseFloat(req.getParameter("atingiuFace"));
            float aspirouFumaca = Float.parseFloat(req.getParameter("aspirouFumaca"));

            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = (acordado + falando + respiracao + sangramento + atingiuFace + aspirouFumaca) / 6;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = (gravidadeCaso + agenteCausador + vitimas) / 3;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);

        }

        if (especificacao.equalsIgnoreCase("F.A.F/F.A.B")) {

            //ESPECIFICAÇÃO F.A.F/F.A.B
            float vitimas = Float.parseFloat(req.getParameter("vitimas"));
            float vitimaMove = Float.parseFloat(req.getParameter("vitimaMove"));
            float acordado = Float.parseFloat(req.getParameter("acordado"));
            float falando = Float.parseFloat(req.getParameter("falando"));
            float respiracao = Float.parseFloat(req.getParameter("respiracao"));
            float ferimento = Float.parseFloat(req.getParameter("ferimento"));

            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = (vitimaMove + acordado + falando + respiracao + ferimento) / 5;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = (gravidadeCaso + vitimas) / 2;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);

        }

        if (especificacao.equalsIgnoreCase("Desabamento/Soterramento")) {
            
            //ESPECIFICAÇÃO DESABAMENTO/SOTERRAMENTO
            float vitimas = Float.parseFloat(req.getParameter("vitimas"));
            
            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = 0;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = (gravidadeCaso + vitimas) / 2;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);
                        

        }

        if (especificacao.equalsIgnoreCase("Agressões Interpessoais")) {
            
            //ESPECIFICAÇÃO AGRESSÕES INTERPESSOAIS
            float houveBriga = Float.parseFloat(req.getParameter("houveBriga"));
            float vitimas = Float.parseFloat(req.getParameter("vitimas"));
            float vitimaMove = Float.parseFloat(req.getParameter("vitimaMove"));
            float acordado = Float.parseFloat(req.getParameter("acordado"));
            float respiracao = Float.parseFloat(req.getParameter("respiracao"));
            float falando = Float.parseFloat(req.getParameter("falando"));
            float sangramento = Float.parseFloat(req.getParameter("sangramento"));
            float agressaoSocos = Float.parseFloat(req.getParameter("agressaoSocos"));
            
            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = (vitimaMove + acordado + respiracao + falando  + sangramento) / 5;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = (gravidadeCaso + houveBriga + vitimas + agressaoSocos) / 4;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);

        }

        if (especificacao.equalsIgnoreCase("Outros Traumatismos")) {

            //CALCULANDO GRAVIDADE SEMIOLOGICA
            GSf = 0;

            //CALCULO GRAVIDADE ETIOLOGICA (MÉDICO)
            GEf = gravidadeCaso;

            //INTÂNCIANDO CLASS PARA CALCULAR A "G" E O "GU"
            GrauDeUrgencia grauDeUrgencia = new GrauDeUrgencia();
            float G = grauDeUrgencia.calculoGravidade(GEf, GSf);
            GUf = grauDeUrgencia.calculoGrauDeUrgencia(G, valorRecursos, valorSocial, valorTempo);
            
        }

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
