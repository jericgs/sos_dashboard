/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.EnderecoDAO;
import br.com.uern.les.erick.daos.PossuiDAO;
import br.com.uern.les.erick.daos.SolicitanteDAO;
import br.com.uern.les.erick.modelos.AtualizacaoOcorrencia;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.RegistroChamado;
import br.com.uern.les.erick.modelos.Solicitante;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class EditarChamado implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //CAMPOS DE TELA
        int idR = Integer.parseInt(req.getParameter("idR"));
        int idRC = Integer.parseInt(req.getParameter("idRC"));
        int idP = Integer.parseInt(req.getParameter("idP"));
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");

        //CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //GLOBAL
        AtualizacaoOcorrencia atualizacaoOcorrencia = new AtualizacaoOcorrencia();

        //INSTÂNCIA CHAMADODAO E PEGA O REGISTRO
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        RegistroChamado registroChamado = chamadoDAO.getRegistroDeChamado(idRC);

        //INSTÂNCIA SOLICITANTEDAO E PEGA O REGISTRO
        SolicitanteDAO solicitanteDAO = new SolicitanteDAO(connection);
        Solicitante solicitante = solicitanteDAO.getSolicitante(registroChamado.getIdS());

        //INSTÂNCIANDO POSSUIDAO E BUSCANDO ENDEREÇOS
        PossuiDAO possuiDAO = new PossuiDAO(connection);
        List<String> listEnderecos = possuiDAO.buscandoEnderecos(idP);

        if (listEnderecos.size() == 1) {

            //INSTÂNCIANDO ENDERECODAO
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            Endereco endereco1 = enderecoDAO.getEndereco(Integer.parseInt(listEnderecos.get(0)));

            //MODELO ATUALIZAROCORRENCIA
            atualizacaoOcorrencia = new AtualizacaoOcorrencia();
            atualizacaoOcorrencia.setIdR(idR);
            atualizacaoOcorrencia.setIdRC(idRC);
            atualizacaoOcorrencia.setIdP(idP);
            atualizacaoOcorrencia.setNomePaciente(nomePaciente);
            atualizacaoOcorrencia.setIdadePaciente(idadePaciente);
            atualizacaoOcorrencia.setIdS(solicitante.getIdS());
            atualizacaoOcorrencia.setNomeSolicitante(solicitante.getNome());
            atualizacaoOcorrencia.setTelSolicitante(solicitante.getTel());
            atualizacaoOcorrencia.setQueixa(registroChamado.getQueixa());
            atualizacaoOcorrencia.setQuantEndereco(1);
            atualizacaoOcorrencia.setEndereco1(endereco1);

        }

        if (listEnderecos.size() == 2) {

            //INSTÂNCIANDO ENDERECODAO
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            Endereco endereco1 = enderecoDAO.getEndereco(Integer.parseInt(listEnderecos.get(0)));
            Endereco endereco2 = enderecoDAO.getEndereco(Integer.parseInt(listEnderecos.get(1)));
         
            //MODELO ATUALIZAROCORRENCIA
            atualizacaoOcorrencia = new AtualizacaoOcorrencia();
            atualizacaoOcorrencia.setIdR(idR);
            atualizacaoOcorrencia.setIdRC(idRC);
            atualizacaoOcorrencia.setIdP(idP);
            atualizacaoOcorrencia.setNomePaciente(nomePaciente);
            atualizacaoOcorrencia.setIdadePaciente(idadePaciente);
            atualizacaoOcorrencia.setIdS(solicitante.getIdS());
            atualizacaoOcorrencia.setNomeSolicitante(solicitante.getNome());
            atualizacaoOcorrencia.setTelSolicitante(solicitante.getTel());
            atualizacaoOcorrencia.setQueixa(registroChamado.getQueixa());
            atualizacaoOcorrencia.setQuantEndereco(2);
            atualizacaoOcorrencia.setEndereco1(endereco1);
            atualizacaoOcorrencia.setEndereco2(endereco2);
            
        }

        //SESSÃO
        HttpSession session = req.getSession();
        session.setAttribute("dadosOcorrencia", atualizacaoOcorrencia);

        pagina = "editarChamado.jsp";

        return pagina;
    }

}
