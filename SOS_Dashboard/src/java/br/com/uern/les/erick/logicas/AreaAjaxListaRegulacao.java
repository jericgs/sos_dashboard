/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.PacienteDAO;
import br.com.uern.les.erick.daos.RegulacaoDAO;
import br.com.uern.les.erick.modelos.ChamadoEspera;
import br.com.uern.les.erick.modelos.ChamadoMedico;
import br.com.uern.les.erick.modelos.InformacaoDeTempo;
import br.com.uern.les.erick.modelos.Paciente;
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
public class AreaAjaxListaRegulacao implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {

        List<ChamadoEspera> chamadosEspera = new ArrayList<>();

        //PEGANDO DADOS DA REQUISIÇÃO
        String cpfm = req.getParameter("cpfm");

        //GERANDO DATA DESTE MOMENTO
        InformacaoDeTempo informacaoDeTempo = new InformacaoDeTempo();
        String dataMomento = informacaoDeTempo.getDate();

        //CONEXÃO COM BD
        Connection connection = (Connection) req.getAttribute("conexao");

        //INSTÂNCIANDO CHAMADODAO E REALIZANDO BUSCA
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        List<ChamadoMedico> chamadosMedico = chamadoDAO.getListaDeChamados(cpfm, dataMomento);

        for (int i = 0; i < chamadosMedico.size(); i++) {

            //INSTÂNCIANDO REGULACAODAO E REALIZANDO BUSCA
            RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
            int idR = regulacaoDAO.verificarStatusRegulacao(chamadosMedico.get(i).getIdRC());

            if (idR != 0) {

                //INSTÂNCIA MODULO PACIENTE
                Paciente paciente = new Paciente();

                //INSTÂNCIANDO PACIENTEDAO E REALIZANDO BUSCA
                PacienteDAO pacienteDAO = new PacienteDAO(connection);
                paciente = pacienteDAO.getPacienteRegulacao(chamadosMedico.get(i).getIdP());

                //INSTÂNCIA MODULO CHAMADOESPERA
                ChamadoEspera chamadoEspera = new ChamadoEspera();
                chamadoEspera.setIdR(idR);
                chamadoEspera.setNomePaciente(paciente.getNome());
                chamadoEspera.setIdade(paciente.getIdade());
                chamadoEspera.setMotivo(chamadosMedico.get(i).getMotivo());
                chamadoEspera.setQueixa(chamadosMedico.get(i).getQueixa());

                chamadosEspera.add(chamadoEspera);

            }

        }

        //INVERSÃO DE CONTROLE (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(chamadosEspera);

        return json;

    }

}
