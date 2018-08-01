/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.PacienteDAO;
import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.daos.TarmDAO;
import br.com.uern.les.erick.modelos.Chamado;
import br.com.uern.les.erick.modelos.ListaAndamento;
import br.com.uern.les.erick.modelos.Paciente;
import br.com.uern.les.erick.modelos.Regulacao;
import br.com.uern.les.erick.modelos.Tarm;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Encaminhamento implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //CAMPOS DE TELAS
        String nomeUsuario = req.getParameter("nomeUsuario");
        
        //LISTA GLOBAL
        List<ListaAndamento> chamadosListaEncaminhamento = new ArrayList<>();

        //CONEXÂO E SESSÃO
        Connection connection = (Connection) req.getAttribute("conexao");
        HttpSession session = req.getSession();

        //INSTÂNCIANDO TARMDAO
        TarmDAO tarmDAO = new TarmDAO(connection);
        Tarm tarm = tarmDAO.getDadosTarm(nomeUsuario);

        //INSTÂNCIANDO CHAMADODAO E REALIZANDO BUSCA
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        List<Chamado> chamadosTarm = chamadoDAO.getListaDeChamadosTarm(tarm.getCPFT());

        for (int i = 0; i < chamadosTarm.size(); i++) {

            //INSTÂNCIANDO REGULACAODAO E REALIZANDO BUSCA
            RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
            Regulacao regulacao = regulacaoDAO.getRegulacaoEncaminhamento(chamadosTarm.get(i).getIdRC());

            if (regulacao != null) {

                //INSTÂNCIA MODULO PACIENTE
                Paciente paciente = new Paciente();

                //INSTÂNCIANDO PACIENTEDAO E REALIZANDO BUSCA
                PacienteDAO pacienteDAO = new PacienteDAO(connection);
                paciente = pacienteDAO.getPacienteRegulacaoI(chamadosTarm.get(i).getIdP());
                                
                //INSTÂNCIA MODULO CHAMADOESPERA
                ListaAndamento listaAndamento = new ListaAndamento();
                listaAndamento.setIdR(regulacao.getIdR());
                listaAndamento.setIdRC(regulacao.getIdRC());
                listaAndamento.setIdP(chamadosTarm.get(i).getIdP());
                listaAndamento.setNome(paciente.getNome());
                listaAndamento.setIdade(paciente.getIdade());

                chamadosListaEncaminhamento.add(listaAndamento);
            }

        }
        
        session.setAttribute("dadosEncaminhamento", chamadosListaEncaminhamento);

        pagina = "encaminhamento.jsp";

        return pagina;
    }

}
