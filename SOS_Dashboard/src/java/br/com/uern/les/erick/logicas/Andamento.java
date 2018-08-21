/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.daos.PacienteDAO;
import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.modelos.Chamado;
import br.com.uern.les.erick.modelos.InformacaoDeTempo;
import br.com.uern.les.erick.modelos.ListaAndamento;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import br.com.uern.les.erick.modelos.Paciente;
import br.com.uern.les.erick.modelos.Regulacao;
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
public class Andamento implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;        

        String nomeUsuario = req.getParameter("nomeUsuario");

        List<ListaAndamento> chamadosListaAndamento = new ArrayList<>();

        //CONEXÂO E SESSÃO
        Connection connection = (Connection) req.getAttribute("conexao");
        HttpSession session = req.getSession();

        MedicoDAO medicoDAO = new MedicoDAO(connection);
        MedicoRegulador medicoRegulador = medicoDAO.getDadosMedicoRegulador(nomeUsuario);
        
        //INTÂNCIANDO INFORMAÇÃO
        InformacaoDeTempo informacaoDeTempo = new InformacaoDeTempo();        
        String dataHoje = informacaoDeTempo.alterarData(0);
        String dataOntem = informacaoDeTempo.alterarData(-1);

        //INSTÂNCIANDO CHAMADODAO E REALIZANDO BUSCA
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        List<Chamado> chamadosMedico = chamadoDAO.getListaDeChamados(medicoRegulador.getCPFM(), dataOntem, dataHoje);

        for (int i = 0; i < chamadosMedico.size(); i++) {

            //INSTÂNCIANDO REGULACAODAO E REALIZANDO BUSCA
            RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
            Regulacao regulacao = regulacaoDAO.getRegulacaoAndamento(chamadosMedico.get(i).getIdRC());

            if (regulacao != null) {

                //INSTÂNCIA MODULO PACIENTE
                Paciente paciente = new Paciente();

                //INSTÂNCIANDO PACIENTEDAO E REALIZANDO BUSCA
                PacienteDAO pacienteDAO = new PacienteDAO(connection);
                paciente = pacienteDAO.getPacienteRegulacaoI(chamadosMedico.get(i).getIdP());

                //INSTÂNCIA MODULO CHAMADOESPERA
                ListaAndamento listaAndamento = new ListaAndamento();
                listaAndamento.setIdR(regulacao.getIdR());
                listaAndamento.setNome(paciente.getNome());
                listaAndamento.setIdade(paciente.getIdade());

                chamadosListaAndamento.add(listaAndamento);

            }            

        }

        session.setAttribute("dadosAndamento", chamadosListaAndamento);

        pagina = "andamento.jsp";

        return pagina;
    }

}
