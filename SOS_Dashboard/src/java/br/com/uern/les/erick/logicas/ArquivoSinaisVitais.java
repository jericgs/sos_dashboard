/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.OcorrenciasaDAO;
import br.com.uern.les.erick.daos.OcorrenciasbDAO;
import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.daos.SinaisVitaisDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.SinaisVitais;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class ArquivoSinaisVitais implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //CAMPO DA TELA
        int idR = Integer.parseInt(req.getParameter("idR"));

        //CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //INSTÂNCIANDO OCORRENCIASADAO E REALIZANDO BUSCA
        OcorrenciasaDAO ocorrenciasaDAO = new OcorrenciasaDAO(connection);
        int idVsa = ocorrenciasaDAO.buscandoSinaisVitaisSA(idR);        
        
        //INSTÂNCIANDO OCORRENCIASBDAO E REALIZANDO BUSCA       
        OcorrenciasbDAO ocorrenciasbDAO = new OcorrenciasbDAO(connection);
        int idVsb = ocorrenciasbDAO.buscandoSinaisVitaisSB(idR);
                

        if (idVsa != 0) {
            
            
            //INSTÂNCIANDO SINAISVITAISDAO E REALIZANDO BUSCA
            SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
            SinaisVitais sv = sinaisVitaisDAO.buscandoSinaisVitais(idVsa);
                       
            if (!sv.getPa().equalsIgnoreCase("NH")) {                                 
                
                //INSTÂNCIANDO REGULACAODAO E ATUALIZA
                RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
                int confimacao = regulacaoDAO.atualizarStatusRegulacao(idR);

                if (confimacao != 0) {
                    //PARAMETROS PARA O ALERTA
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("success");
                    alerta.setMsnAlerta("Arquivado com Sucesso!");
                    req.setAttribute("informe", alerta);

                    pagina = "andamento.jsp";
                }
            }

            if (sv.getPa().equalsIgnoreCase("NH")) {                
                

            }
                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("info");
                alerta.setMsnAlerta("Adicione os sinais vitais!");
                req.setAttribute("informe", alerta);

                pagina = "andamento.jsp";
        }

        if (idVsb != 0) {
            //INSTÂNCIANDO SINAISVITAISDAO E REALIZANDO BUSCA
            SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
            SinaisVitais sv = sinaisVitaisDAO.buscandoSinaisVitais(idVsb);

            if (!sv.getPa().equalsIgnoreCase("NH")) {
                //INSTÂNCIANDO REGULACAODAO E ATUALIZA
                RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
                int confimacao = regulacaoDAO.atualizarStatusRegulacao(idR);

                if (confimacao != 0) {
                    //PARAMETROS PARA O ALERTA
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("success");
                    alerta.setMsnAlerta("Arquivado com Sucesso!");
                    req.setAttribute("informe", alerta);

                    pagina = "andamento.jsp";

                }
            }

            if (sv.getPa().equalsIgnoreCase("NH")) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("info");
                alerta.setMsnAlerta("Adicione os sinais vitais!");
                req.setAttribute("informe", alerta);

                pagina = "andamento.jsp";

            }

        }

        return pagina;
    }

}
