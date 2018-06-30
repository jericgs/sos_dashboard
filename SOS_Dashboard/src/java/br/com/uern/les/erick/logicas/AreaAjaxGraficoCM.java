/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.modelos.GraficoMeses;
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
public class AreaAjaxGraficoCM implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {

        InformacaoDeTempo mesDoAno = new InformacaoDeTempo();
        Connection connection = (Connection) req.getAttribute("conexao");

        InformacaoDeTempo alterarMes = new InformacaoDeTempo();
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        GraficoMeses graficoMeses = new GraficoMeses();
        List<GraficoMeses> listDadosGraficoMeses = new ArrayList<>();

        String jan = null;
        String fev = null;
        String mar = null;
        String abr = null;
        String mai = null;
        String jun = null;
        String jul = null;
        String ago = null;
        String set = null;
        String out = null;
        String nov = null;
        String dez = null;

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Janeiro")) {

            jan = alterarMes.alterarMes(0);
            fev = alterarMes.alterarMes(+1);
            mar = alterarMes.alterarMes(+2);
            abr = alterarMes.alterarMes(+3);
            mai = alterarMes.alterarMes(+4);
            jun = alterarMes.alterarMes(+5);
            jul = alterarMes.alterarMes(+6);
            ago = alterarMes.alterarMes(+7);
            set = alterarMes.alterarMes(+8);
            out = alterarMes.alterarMes(+9);
            nov = alterarMes.alterarMes(+10);
            dez = alterarMes.alterarMes(+11);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Fevereiro")) {

            jan = alterarMes.alterarMes(-1);
            fev = alterarMes.alterarMes(0);
            mar = alterarMes.alterarMes(+1);
            abr = alterarMes.alterarMes(+2);
            mai = alterarMes.alterarMes(+3);
            jun = alterarMes.alterarMes(+4);
            jul = alterarMes.alterarMes(+5);
            ago = alterarMes.alterarMes(+6);
            set = alterarMes.alterarMes(+7);
            out = alterarMes.alterarMes(+8);
            nov = alterarMes.alterarMes(+9);
            dez = alterarMes.alterarMes(+10);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Março")) {

            jan = alterarMes.alterarMes(-2);
            fev = alterarMes.alterarMes(-1);
            mar = alterarMes.alterarMes(0);
            abr = alterarMes.alterarMes(+1);
            mai = alterarMes.alterarMes(+2);
            jun = alterarMes.alterarMes(+3);
            jul = alterarMes.alterarMes(+4);
            ago = alterarMes.alterarMes(+5);
            set = alterarMes.alterarMes(+6);
            out = alterarMes.alterarMes(+7);
            nov = alterarMes.alterarMes(+8);
            dez = alterarMes.alterarMes(+9);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Abril")) {

            jan = alterarMes.alterarMes(-3);
            fev = alterarMes.alterarMes(-2);
            mar = alterarMes.alterarMes(-1);
            abr = alterarMes.alterarMes(0);
            mai = alterarMes.alterarMes(+1);
            jun = alterarMes.alterarMes(+2);
            jul = alterarMes.alterarMes(+3);
            ago = alterarMes.alterarMes(+4);
            set = alterarMes.alterarMes(+5);
            out = alterarMes.alterarMes(+6);
            nov = alterarMes.alterarMes(+7);
            dez = alterarMes.alterarMes(+8);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Maio")) {

            jan = alterarMes.alterarMes(-4);
            fev = alterarMes.alterarMes(-3);
            mar = alterarMes.alterarMes(-2);
            abr = alterarMes.alterarMes(-1);
            mai = alterarMes.alterarMes(0);
            jun = alterarMes.alterarMes(+1);
            jul = alterarMes.alterarMes(+2);
            ago = alterarMes.alterarMes(+3);
            set = alterarMes.alterarMes(+4);
            out = alterarMes.alterarMes(+5);
            nov = alterarMes.alterarMes(+6);
            dez = alterarMes.alterarMes(+7);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Junho")) {

            jan = alterarMes.alterarMes(-5);
            fev = alterarMes.alterarMes(-4);
            mar = alterarMes.alterarMes(-3);
            abr = alterarMes.alterarMes(-2);
            mai = alterarMes.alterarMes(-1);
            jun = alterarMes.alterarMes(0);
            jul = alterarMes.alterarMes(+1);
            ago = alterarMes.alterarMes(+2);
            set = alterarMes.alterarMes(+3);
            out = alterarMes.alterarMes(+4);
            nov = alterarMes.alterarMes(+5);
            dez = alterarMes.alterarMes(+6);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Julho")) {

            jan = alterarMes.alterarMes(-6);
            fev = alterarMes.alterarMes(-5);
            mar = alterarMes.alterarMes(-4);
            abr = alterarMes.alterarMes(-3);
            mai = alterarMes.alterarMes(-2);
            jun = alterarMes.alterarMes(-1);
            jul = alterarMes.alterarMes(0);
            ago = alterarMes.alterarMes(+1);
            set = alterarMes.alterarMes(+2);
            out = alterarMes.alterarMes(+3);
            nov = alterarMes.alterarMes(+4);
            dez = alterarMes.alterarMes(+5);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Agosto")) {

            jan = alterarMes.alterarMes(-7);
            fev = alterarMes.alterarMes(-6);
            mar = alterarMes.alterarMes(-5);
            abr = alterarMes.alterarMes(-4);
            mai = alterarMes.alterarMes(-3);
            jun = alterarMes.alterarMes(-2);
            jul = alterarMes.alterarMes(-1);
            ago = alterarMes.alterarMes(0);
            set = alterarMes.alterarMes(+1);
            out = alterarMes.alterarMes(+2);
            nov = alterarMes.alterarMes(+3);
            dez = alterarMes.alterarMes(+4);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Setembro")) {

            jan = alterarMes.alterarMes(-8);
            fev = alterarMes.alterarMes(-7);
            mar = alterarMes.alterarMes(-6);
            abr = alterarMes.alterarMes(-5);
            mai = alterarMes.alterarMes(-4);
            jun = alterarMes.alterarMes(-3);
            jul = alterarMes.alterarMes(-2);
            ago = alterarMes.alterarMes(-1);
            set = alterarMes.alterarMes(0);
            out = alterarMes.alterarMes(+1);
            nov = alterarMes.alterarMes(+2);
            dez = alterarMes.alterarMes(+3);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Outubro")) {

            jan = alterarMes.alterarMes(-9);
            fev = alterarMes.alterarMes(-8);
            mar = alterarMes.alterarMes(-7);
            abr = alterarMes.alterarMes(-6);
            mai = alterarMes.alterarMes(-5);
            jun = alterarMes.alterarMes(-4);
            jul = alterarMes.alterarMes(-3);
            ago = alterarMes.alterarMes(-2);
            set = alterarMes.alterarMes(-1);
            out = alterarMes.alterarMes(0);
            nov = alterarMes.alterarMes(+1);
            dez = alterarMes.alterarMes(+2);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Novembro")) {

            jan = alterarMes.alterarMes(-10);
            fev = alterarMes.alterarMes(-9);
            mar = alterarMes.alterarMes(-8);
            abr = alterarMes.alterarMes(-7);
            mai = alterarMes.alterarMes(-6);
            jun = alterarMes.alterarMes(-5);
            jul = alterarMes.alterarMes(-4);
            ago = alterarMes.alterarMes(-3);
            set = alterarMes.alterarMes(-2);
            out = alterarMes.alterarMes(-1);
            nov = alterarMes.alterarMes(0);
            dez = alterarMes.alterarMes(+1);

        }

        if (mesDoAno.getMesDoAno().equalsIgnoreCase("Dezembro")) {

            jan = alterarMes.alterarMes(-11);
            fev = alterarMes.alterarMes(-10);
            mar = alterarMes.alterarMes(-9);
            abr = alterarMes.alterarMes(-8);
            mai = alterarMes.alterarMes(-7);
            jun = alterarMes.alterarMes(-6);
            jul = alterarMes.alterarMes(-5);
            ago = alterarMes.alterarMes(-4);
            set = alterarMes.alterarMes(-3);
            out = alterarMes.alterarMes(-2);
            nov = alterarMes.alterarMes(-1);
            dez = alterarMes.alterarMes(0);

        }

        String chamadosJan = Integer.toString(chamadoDAO.getNumChamadoMes(jan));
        String chamadosFev = Integer.toString(chamadoDAO.getNumChamadoMes(fev));
        String chamadosMar = Integer.toString(chamadoDAO.getNumChamadoMes(mar));
        String chamadosAbr = Integer.toString(chamadoDAO.getNumChamadoMes(abr));
        String chamadosMai = Integer.toString(chamadoDAO.getNumChamadoMes(mai));
        String chamadosJun = Integer.toString(chamadoDAO.getNumChamadoMes(jun));
        String chamadosJul = Integer.toString(chamadoDAO.getNumChamadoMes(jul));
        String chamadosAgo = Integer.toString(chamadoDAO.getNumChamadoMes(ago));
        String chamadosSet = Integer.toString(chamadoDAO.getNumChamadoMes(set));
        String chamadosOut = Integer.toString(chamadoDAO.getNumChamadoMes(out));
        String chamadosNov = Integer.toString(chamadoDAO.getNumChamadoMes(nov));
        String chamadosDez = Integer.toString(chamadoDAO.getNumChamadoMes(dez));

        graficoMeses.setChamadosJan(chamadosJan);
        graficoMeses.setChamadosFev(chamadosFev);
        graficoMeses.setChamadosMar(chamadosMar);
        graficoMeses.setChamadosAbr(chamadosAbr);
        graficoMeses.setChamadosMai(chamadosMai);
        graficoMeses.setChamadosJun(chamadosJun);
        graficoMeses.setChamadosJul(chamadosJul);
        graficoMeses.setChamadosAgo(chamadosAgo);
        graficoMeses.setChamadosSet(chamadosSet);
        graficoMeses.setChamadosOut(chamadosOut);
        graficoMeses.setChamadosNov(chamadosNov);
        graficoMeses.setChamadosDez(chamadosDez);        

        listDadosGraficoMeses.add(graficoMeses);

        //INVERSÃO DE CONTROLE (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(listDadosGraficoMeses);

        return json;

    }

}
