/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.modelos.ChamadoEspera;
import br.com.uern.les.erick.modelos.Regulacao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class SinaisVitais implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;
        
        //CAMPO DA TELA
        int idR = Integer.parseInt(req.getParameter("idR"));
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");
        
        //CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");
        
        //INSTÂNCIANDO REGULACAODAO E BUSCAR REGULAÇÃO
        RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
        Regulacao regulacao = regulacaoDAO.buscandoRegulacao(idR);                

        //MODELO CHAMADOESPERA
        ChamadoEspera chamadoEspera = new ChamadoEspera();
        chamadoEspera.setIdR(idR);
        chamadoEspera.setNomePaciente(nomePaciente);
        chamadoEspera.setIdade(idadePaciente);
        chamadoEspera.setTipoDeCaso(regulacao.getTipoDeCaso());
        chamadoEspera.setQueixa(regulacao.getMensagem());
        
        //SESSÃO
        HttpSession session = req.getSession();
        session.setAttribute("dadosSinaisVitais", chamadoEspera);
        
        pagina = "sinaisVitais.jsp";
        
        return pagina;
    }
    
}
