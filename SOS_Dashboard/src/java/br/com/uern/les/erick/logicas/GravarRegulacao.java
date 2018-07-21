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
import br.com.uern.les.erick.daos.UmsaDAO;
import br.com.uern.les.erick.daos.UmsbDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.OcorrenciaSA;
import br.com.uern.les.erick.modelos.OcorrenciaSB;
import br.com.uern.les.erick.modelos.SinaisVitais;
import br.com.uern.les.erick.modelos.UMSA;
import br.com.uern.les.erick.modelos.UMSB;
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
            regulacaoDAO.atualizarRegulacao(idR, "Concluído", tipoCaso, justificativa);

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("confirmacao", alerta);

            pagina = "listaRegulacao.jsp";

        }

        if (motivo.equalsIgnoreCase("Transporte")) {

            //CAMPOS REGULAÇÃO TRANSPORTE
            int idR = Integer.parseInt(req.getParameter("idR"));
            String tipoCaso = req.getParameter("tipoCaso");
            String justificativa = req.getParameter("justificativa");
            String parecer = req.getParameter("parecer");
            String placa = req.getParameter("suporte");

            //INSTÂNCIA REGULAÇÃODAO E REALIZA A INSERÇÃO
            RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
            regulacaoDAO.atualizarRegulacao(idR, parecer, tipoCaso, justificativa);

            //INSTÂNCIA UMSBDAO E REALIZA BUSCA
            UmsbDAO umsbDAO = new UmsbDAO(connection);
            int existeB = umsbDAO.verificarSuport(placa);

            //INSTÂNCIA UMSBDAO E REALIZA BUSCA
            umsbDAO = new UmsbDAO(connection);
            UMSB umsb = umsbDAO.getUnidadeMovelP(placa);

            //INSTÂNCIA UMSADAO E REALIZA BUSCA
            UmsaDAO umsaDAO = new UmsaDAO(connection);
            int existeA = umsaDAO.verificarSuport(placa);

            //INSTÂNCIA UMSADAO E REALIZA BUSCA
            umsaDAO = new UmsaDAO(connection);
            UMSA umsa = umsaDAO.getUnidadeMovelP(placa);

            if ((existeB != 0) && (parecer.equalsIgnoreCase("Aprovado"))) {

                //INSTÂNCIA MODELO SINALVITAL
                SinaisVitais sinaisVitais = new SinaisVitais();
                sinaisVitais.setPa("NH");
                sinaisVitais.setFc("NH");
                sinaisVitais.setFr("NH");
                sinaisVitais.setSatSemSuport("NH");
                sinaisVitais.setSatComSuport("NH");
                sinaisVitais.setTemperatura("NH");
                sinaisVitais.setHgt("NH");
                sinaisVitais.setGlasgow("NH");

                //INSTÂNCIA SINALVITALDAO E REALIZA A INSERÇÃO
                SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
                int idV = sinaisVitaisDAO.inserindoSinaisVitais(sinaisVitais);

                //INSTÂNCIA MODELO OCORRENCIASB
                OcorrenciaSB ocorrenciaSB = new OcorrenciaSB();
                ocorrenciaSB.setIdR(idR);
                ocorrenciaSB.setIdV(idV);
                ocorrenciaSB.setPlaca(placa);
                ocorrenciaSB.setAuxiliar(umsb.getCpfa());
                ocorrenciaSB.setMotorista(umsb.getCnh());
                ocorrenciaSB.setGravComprovada("NH");

                //INSTÂNCIA OCORRENCIASBDAO E REALIZA A INSERÇÃO
                OcorrenciasbDAO ocorrenciasbDAO = new OcorrenciasbDAO(connection);
                ocorrenciasbDAO.inserindoOcorrencia(ocorrenciaSB);

            }

            if ((existeA != 0) && (parecer.equalsIgnoreCase("Aprovado"))) {

                //INSTÂNCIA MODELO SINALVITAL
                SinaisVitais sinaisVitais = new SinaisVitais();
                sinaisVitais.setPa("NH");
                sinaisVitais.setFc("NH");
                sinaisVitais.setFr("NH");
                sinaisVitais.setSatSemSuport("NH");
                sinaisVitais.setSatComSuport("NH");
                sinaisVitais.setTemperatura("NH");
                sinaisVitais.setHgt("NH");
                sinaisVitais.setGlasgow("NH");

                //INSTÂNCIA SINALVITALDAO E REALIZA A INSERÇÃO
                SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
                int idV = sinaisVitaisDAO.inserindoSinaisVitais(sinaisVitais);

                //INSTÂNCIA MODELO OCORRENCIASA
                OcorrenciaSA ocorrenciaSA = new OcorrenciaSA();
                ocorrenciaSA.setIdR(idR);
                ocorrenciaSA.setIdV(idV);
                ocorrenciaSA.setPlaca(placa);
                ocorrenciaSA.setMedico(umsa.getCpfm());
                ocorrenciaSA.setEnfermeiro(umsa.getCpfe());
                ocorrenciaSA.setAuxiliar(umsa.getCpfa());
                ocorrenciaSA.setMotorista(umsa.getCnh());
                ocorrenciaSA.setGravComprovada("NH");

                //INSTÂNCIA OCORRENCIASADAO E REALIZA A INSERÇÃO
                OcorrenciasaDAO ocorrenciasaDAO = new OcorrenciasaDAO(connection);
                ocorrenciasaDAO.inserindoOcorrencia(ocorrenciaSA);

            }

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("confirmacao", alerta);

            pagina = "listaRegulacao.jsp";

        }

        if (motivo.equalsIgnoreCase("Socorro")) {

            //CAMPOS REGULAÇÃO SOCORRO
            int idR = Integer.parseInt(req.getParameter("idR"));
            String tipoDeCaso = req.getParameter("tipoDeCaso");
            String placa = req.getParameter("suporte");
            String mensagem = req.getParameter("mensagem");

            //INSTÂNCIA UMSBDAO E REALIZA BUSCA
            UmsbDAO umsbDAO = new UmsbDAO(connection);
            int existeB = umsbDAO.verificarSuport(placa);

            //INSTÂNCIA UMSBDAO E REALIZA BUSCA
            umsbDAO = new UmsbDAO(connection);
            UMSB umsb = umsbDAO.getUnidadeMovelP(placa);

            //INSTÂNCIA UMSADAO E REALIZA BUSCA
            UmsaDAO umsaDAO = new UmsaDAO(connection);
            int existeA = umsaDAO.verificarSuport(placa);

            //INSTÂNCIA UMSADAO E REALIZA BUSCA
            umsaDAO = new UmsaDAO(connection);
            UMSA umsa = umsaDAO.getUnidadeMovelP(placa);

            if (existeA != 0) {

                //INSTÂNCIA REGULAÇÃODAO E REALIZA A INSERÇÃO
                RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
                regulacaoDAO.atualizarRegulacao(idR, "AndamentoOA", tipoDeCaso, mensagem);

                //INSTÂNCIA MODELO SINALVITAL
                SinaisVitais sinaisVitais = new SinaisVitais();
                sinaisVitais.setPa("NH");
                sinaisVitais.setFc("NH");
                sinaisVitais.setFr("NH");
                sinaisVitais.setSatSemSuport("NH");
                sinaisVitais.setSatComSuport("NH");
                sinaisVitais.setTemperatura("NH");
                sinaisVitais.setHgt("NH");
                sinaisVitais.setGlasgow("NH");

                //INSTÂNCIA SINALVITALDAO E REALIZA A INSERÇÃO
                SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
                int idV = sinaisVitaisDAO.inserindoSinaisVitais(sinaisVitais);

                //INSTÂNCIA MODELO OCORRENCIASA
                OcorrenciaSA ocorrenciaSA = new OcorrenciaSA();
                ocorrenciaSA.setIdR(idR);
                ocorrenciaSA.setIdV(idV);
                ocorrenciaSA.setPlaca(placa);
                ocorrenciaSA.setMedico(umsa.getCpfm());
                ocorrenciaSA.setEnfermeiro(umsa.getCpfe());
                ocorrenciaSA.setAuxiliar(umsa.getCpfa());
                ocorrenciaSA.setMotorista(umsa.getCnh());
                ocorrenciaSA.setGravComprovada("NH");

                //INSTÂNCIA OCORRENCIASADAO E REALIZA A INSERÇÃO
                OcorrenciasaDAO ocorrenciasaDAO = new OcorrenciasaDAO(connection);
                ocorrenciasaDAO.inserindoOcorrencia(ocorrenciaSA);

            }

            if (existeB != 0) {

                //INSTÂNCIA REGULAÇÃODAO E REALIZA A INSERÇÃO
                RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
                regulacaoDAO.atualizarRegulacao(idR, "AndamentoOB", tipoDeCaso, mensagem);

                //INSTÂNCIA MODELO SINALVITAL
                SinaisVitais sinaisVitais = new SinaisVitais();
                sinaisVitais.setPa("NH");
                sinaisVitais.setFc("200");
                sinaisVitais.setFr("NH");
                sinaisVitais.setSatSemSuport("NH");
                sinaisVitais.setSatComSuport("95");
                sinaisVitais.setTemperatura("NH");
                sinaisVitais.setHgt("NH");
                sinaisVitais.setGlasgow("NH");

                //INSTÂNCIA SINALVITALDAO E REALIZA A INSERÇÃO
                SinaisVitaisDAO sinaisVitaisDAO = new SinaisVitaisDAO(connection);
                int idV = sinaisVitaisDAO.inserindoSinaisVitais(sinaisVitais);

                //INSTÂNCIA MODELO OCORRENCIASB
                OcorrenciaSB ocorrenciaSB = new OcorrenciaSB();
                ocorrenciaSB.setIdR(idR);
                ocorrenciaSB.setIdV(idV);
                ocorrenciaSB.setPlaca(placa);
                ocorrenciaSB.setAuxiliar(umsb.getCpfa());
                ocorrenciaSB.setMotorista(umsb.getCnh());
                ocorrenciaSB.setGravComprovada("NH");

                //INSTÂNCIA OCORRENCIASBDAO E REALIZA A INSERÇÃO
                OcorrenciasbDAO ocorrenciasbDAO = new OcorrenciasbDAO(connection);
                ocorrenciasbDAO.inserindoOcorrencia(ocorrenciaSB);

            }

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
