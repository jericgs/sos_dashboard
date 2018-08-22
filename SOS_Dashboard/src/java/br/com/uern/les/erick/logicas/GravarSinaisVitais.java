/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.OcorrenciasaDAO;
import br.com.uern.les.erick.daos.OcorrenciasbDAO;
import br.com.uern.les.erick.daos.SinaisVitaisDAO;
import br.com.uern.les.erick.modelos.Alerta;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.uern.les.erick.modelos.SinaisVitais;

/**
 *
 * @author jerick.gs
 */
public class GravarSinaisVitais implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //CAMPOS DA TELA
        int idR = Integer.parseInt(req.getParameter("idR"));
        String pa = req.getParameter("PA");
        String fc = req.getParameter("FC");
        String fr = req.getParameter("FR");
        String sats = req.getParameter("SATS");
        String satc = req.getParameter("SATC");
        String temperatura = req.getParameter("temperatura");
        String glasgow = req.getParameter("glasgow");
        String hgt = req.getParameter("HGT");
        String gravidadeComprovada = req.getParameter("gravidadeComprovada");

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //INSTÂNCIANDO OCORRENCIASADAO E REALIZANDO BUSCA
        OcorrenciasaDAO ocorrenciasaDAO = new OcorrenciasaDAO(connection);
        int idVsa = ocorrenciasaDAO.buscandoSinaisVitaisSA(idR);

        //INSTÂNCIANDO OCORRENCIASBDAO E REALIZANDO BUSCA       
        OcorrenciasbDAO ocorrenciasbDAO = new OcorrenciasbDAO(connection);
        int idVsb = ocorrenciasbDAO.buscandoSinaisVitaisSB(idR);

        if (idVsa != 0) {            
            
            //MODELO SINAIS VITAIS
            SinaisVitais sinaisVitais = new SinaisVitais();
            sinaisVitais.setIdV(idVsa);
            sinaisVitais.setPa(pa);
            sinaisVitais.setFc(fc);
            sinaisVitais.setFr(fr);
            sinaisVitais.setSatSemSuport(sats);
            sinaisVitais.setSatComSuport(satc);
            sinaisVitais.setTemperatura(temperatura);
            sinaisVitais.setGlasgow(glasgow);
            sinaisVitais.setHgt(hgt);

            //INSTÂNCIAR SINAISVITAISDAO E ATUALIZA
            SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
            int confirmacaoSinais = sinaisVitaisDAO.atualizarSinaisVitais(sinaisVitais);

            //INSTÂNCIAR OCORRENCIASADAO E ATUALIZAR GRAVIDADE COMPROVADA
            OcorrenciasaDAO odaoGC = new OcorrenciasaDAO(connection);
            int confirmacaoGravidade = odaoGC.atualizarGravidadeOcorrenciaSA(idR, gravidadeComprovada);                        

            if ((confirmacaoSinais != 0) && (confirmacaoGravidade != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("informe", alerta);

                pagina = "andamento.jsp";

            }

        }

        if (idVsb != 0) {

            //VERIFICAR SE TEM TROCA ANTES DE ATUALIZAR
            
            //MODELO SINAIS VITAIS
            SinaisVitais sinaisVitais = new SinaisVitais();
            sinaisVitais.setIdV(idVsb);
            sinaisVitais.setPa(pa);
            sinaisVitais.setFc(fc);
            sinaisVitais.setFr(fr);
            sinaisVitais.setSatSemSuport(sats);
            sinaisVitais.setSatComSuport(satc);
            sinaisVitais.setTemperatura(temperatura);
            sinaisVitais.setGlasgow(glasgow);
            sinaisVitais.setHgt(hgt);

            //INSTÂNCIAR SINAISVITAISDAO E ATUALIZA
            SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
            int confirmacaoSinais = sinaisVitaisDAO.atualizarSinaisVitais(sinaisVitais);

            //INSTÂNCIAR OCORRENCIASBDAO E ATUALIZAR GRAVIDADE COMPROVADA
            OcorrenciasbDAO odaoGC = new OcorrenciasbDAO(connection);
            int confirmacaoGravidade = odaoGC.atualizarGravidadeOcorrenciaSB(idR, gravidadeComprovada);

            if ((confirmacaoSinais != 0) && (confirmacaoGravidade != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("informe", alerta);

                pagina = "andamento.jsp";

            }

        }

        return pagina;
    }

}
