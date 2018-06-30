/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.modelos.GraficoSemana;
import br.com.uern.les.erick.modelos.InformacaoDeTempo;
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
public class AreaAjaxGraficoCD implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {

        InformacaoDeTempo diaDaSemana = new InformacaoDeTempo();
        Connection connection = (Connection) req.getAttribute("conexao");

        InformacaoDeTempo alterarData = new InformacaoDeTempo();
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        GraficoSemana graficoSemana = new GraficoSemana();
        List<GraficoSemana> listDadosGraficoSemana = new ArrayList<>();

        String domingoData = null;
        String segundaData = null;
        String tercaData = null;
        String quartaData = null;
        String quintaData = null;
        String sextaData = null;
        String sabadoData = null;

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Domingo")) {

            domingoData = alterarData.alterarData(0);
            segundaData = alterarData.alterarData(+1);
            tercaData = alterarData.alterarData(+2);
            quartaData = alterarData.alterarData(+3);
            quintaData = alterarData.alterarData(+4);
            sextaData = alterarData.alterarData(+5);
            sabadoData = alterarData.alterarData(+6);

        }

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Segunda")) {
            
            domingoData = alterarData.alterarData(-1);
            segundaData = alterarData.alterarData(0);
            tercaData = alterarData.alterarData(+1);
            quartaData = alterarData.alterarData(+2);
            quintaData = alterarData.alterarData(+3);
            sextaData = alterarData.alterarData(+4);
            sabadoData = alterarData.alterarData(+5);
           
        }

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Terça")) {            

            domingoData = alterarData.alterarData(-2);
            segundaData = alterarData.alterarData(-1);
            tercaData = alterarData.alterarData(0);
            quartaData = alterarData.alterarData(+1);
            quintaData = alterarData.alterarData(+2);
            sextaData = alterarData.alterarData(+3);
            sabadoData = alterarData.alterarData(+4);
            
        }

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Quarta")) {
            
            domingoData = alterarData.alterarData(-3);
            segundaData = alterarData.alterarData(-2);
            tercaData = alterarData.alterarData(-1);
            quartaData = alterarData.alterarData(0);
            quintaData = alterarData.alterarData(+1);
            sextaData = alterarData.alterarData(+2);
            sabadoData = alterarData.alterarData(+3);
            
        }

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Quinta")) {
            
            domingoData = alterarData.alterarData(-4);
            segundaData = alterarData.alterarData(-3);
            tercaData = alterarData.alterarData(-2);
            quartaData = alterarData.alterarData(-1);
            quintaData = alterarData.alterarData(0);
            sextaData = alterarData.alterarData(+1);
            sabadoData = alterarData.alterarData(+2);
            
        }

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Sexta")) {            

            domingoData = alterarData.alterarData(-5);
            segundaData = alterarData.alterarData(-4);
            tercaData = alterarData.alterarData(-3);
            quartaData = alterarData.alterarData(-2);
            quintaData = alterarData.alterarData(-1);
            sextaData = alterarData.alterarData(0);
            sabadoData = alterarData.alterarData(+1);            

        }

        if (diaDaSemana.getDiaDaSemana().equalsIgnoreCase("Sábado")) {
            
            domingoData = alterarData.alterarData(-6);
            segundaData = alterarData.alterarData(-5);
            tercaData = alterarData.alterarData(-4);
            quartaData = alterarData.alterarData(-3);
            quintaData = alterarData.alterarData(-2);
            sextaData = alterarData.alterarData(-1);
            sabadoData = alterarData.alterarData(0);
            
        }

        String chamadosDomingo = Integer.toString(chamadoDAO.getNumDeChamado(domingoData));
        String chamadosSegunda = Integer.toString(chamadoDAO.getNumDeChamado(segundaData));
        String chamadosTerca = Integer.toString(chamadoDAO.getNumDeChamado(tercaData));
        String chamadosQuarta = Integer.toString(chamadoDAO.getNumDeChamado(quartaData));
        String chamadosQuinta = Integer.toString(chamadoDAO.getNumDeChamado(quintaData));
        String chamadosSexta = Integer.toString(chamadoDAO.getNumDeChamado(sextaData));
        String chamadosSabado = Integer.toString(chamadoDAO.getNumDeChamado(sabadoData));

        graficoSemana.setChamadosDomingo(chamadosDomingo);
        graficoSemana.setChamadosSegunda(chamadosSegunda);
        graficoSemana.setChamadosTerca(chamadosTerca);
        graficoSemana.setChamadosQuarta(chamadosQuarta);
        graficoSemana.setChamadosQuinta(chamadosQuinta);
        graficoSemana.setChamadosSexta(chamadosSexta);
        graficoSemana.setChamadosSabado(chamadosSabado);

        listDadosGraficoSemana.add(graficoSemana);

        //INVERSÃO DE CONTROLE (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(listDadosGraficoSemana);

        return json;

    }

}
