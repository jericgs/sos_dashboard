/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.EnderecoDAO;
import br.com.uern.les.erick.daos.PacienteDAO;
import br.com.uern.les.erick.daos.SolicitanteDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Chamado;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.Paciente;
import br.com.uern.les.erick.modelos.Solicitante;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarAtualizacao implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //GLOBAL
        int confirmacao1 = 0;
        int confirmacao2 = 0;

        //CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DE TELA                
        int idRC = Integer.parseInt(req.getParameter("idRC"));
        String queixa = req.getParameter("queixa");
        int quantEndereco = Integer.parseInt(req.getParameter("quantEndereco"));

        int idS = Integer.parseInt(req.getParameter("idS"));
        String nomeSolicitante = req.getParameter("solicitante");
        String telefoneSolicitante = req.getParameter("telefone");

        int idP = Integer.parseInt(req.getParameter("idP"));
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");

        String logradouro = req.getParameter("logradouro");
        String bairro = req.getParameter("bairro");
        int numero = Integer.parseInt(req.getParameter("numero"));
        String complemento = req.getParameter("complemento");
        String cidade = req.getParameter("cidade");
        String cep = req.getParameter("cep");
        String estado = req.getParameter("estado");
        String pais = req.getParameter("pais");

        if (quantEndereco == 1) {

            //CAMPOS DE TELA
            int idE1 = Integer.parseInt(req.getParameter("idE1"));

            //MODELO ENDERECO
            Endereco endereco1 = new Endereco();
            endereco1.setIdE(idE1);
            endereco1.setLogradouro(logradouro);
            endereco1.setBairro(bairro);
            endereco1.setNumero(numero);
            endereco1.setComplemento(complemento);
            endereco1.setCidade(cidade);
            endereco1.setCep(cep);
            endereco1.setEstado(estado);
            endereco1.setPais(pais);

            //INSTÂNCIANDO ENDERECODAO E ATUALIZANDO
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            confirmacao1 = enderecoDAO.atualizarEndereco(endereco1);

        }

        if (quantEndereco == 2) {

            //CAMPOS DE TELA
            int idE1 = Integer.parseInt(req.getParameter("idE1"));
            int idE2 = Integer.parseInt(req.getParameter("idE2"));
            String logradouroD = req.getParameter("logradouroD");
            String bairroD = req.getParameter("bairroD");
            int numeroD = Integer.parseInt(req.getParameter("numeroD"));
            String complementoD = req.getParameter("complementoD");
            String cidadeD = req.getParameter("cidadeD");
            String cepD = req.getParameter("cepD");
            String estadoD = req.getParameter("estadoD");
            String paisD = req.getParameter("paisD");

            //MODELO ENDERECO
            Endereco endereco1 = new Endereco();
            endereco1.setIdE(idE1);
            endereco1.setLogradouro(logradouro);
            endereco1.setBairro(bairro);
            endereco1.setNumero(numero);
            endereco1.setComplemento(complemento);
            endereco1.setCidade(cidade);
            endereco1.setCep(cep);
            endereco1.setEstado(estado);
            endereco1.setPais(pais);

            //MODELO ENDERECO
            Endereco endereco2 = new Endereco();
            endereco2.setIdE(idE2);
            endereco2.setLogradouro(logradouroD);
            endereco2.setBairro(bairroD);
            endereco2.setNumero(numeroD);
            endereco2.setComplemento(complementoD);
            endereco2.setCidade(cidadeD);
            endereco2.setCep(cepD);
            endereco2.setEstado(estadoD);
            endereco2.setPais(paisD);

            //INSTÂNCIANDO ENDERECODAO E ATUALIZANDO
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
            confirmacao1 = enderecoDAO.atualizarEndereco(endereco1);
            confirmacao2 = enderecoDAO.atualizarEndereco(endereco2);

        }

        //MODELO PACIENTE
        Paciente paciente = new Paciente();
        paciente.setIdP(idP);
        paciente.setNome(nomePaciente);
        paciente.setIdade(idadePaciente);

        //INSTÂNCIANDO PACIENTEDAO E ATUALIZANDO
        PacienteDAO pacienteDAO = new PacienteDAO(connection);
        int confirmacaoPaciente = pacienteDAO.atualizarPaciente(paciente);

        //MODELO SOLICITANTE
        Solicitante solicitante = new Solicitante();
        solicitante.setIdS(idS);
        solicitante.setNome(nomeSolicitante);
        solicitante.setTel(telefoneSolicitante);

        //INSTÂNCIANDO SOLICITANTEDAO E ATUALIZANDO
        SolicitanteDAO solicitanteDAO = new SolicitanteDAO(connection);
        int confirmacaoSolicitante = solicitanteDAO.atualizarSolicitante(solicitante);

        //MODELO CMAMADO
        Chamado chamado = new Chamado();
        chamado.setIdRC(idRC);
        chamado.setQueixa(queixa);

        //INSTÂNCIANDO CHAMADODAO E ATUALIZANDO
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        int confirmacaoChamado = chamadoDAO.atualizarChamado(chamado);

        if (((confirmacao1 != 0) || (confirmacao2 != 0)) && (confirmacaoPaciente != 0) && (confirmacaoSolicitante != 0) && (confirmacaoChamado != 0)) {
            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Atualizado com Sucesso!");
            req.setAttribute("alerta", alerta);

            pagina = "encaminhamento.jsp";
        } else {
            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("error");
            alerta.setMsnAlerta("Erro ao Atualizar!");
            req.setAttribute("alerta", alerta);

            pagina = "encaminhamento.jsp";
        }

        return pagina;
    }

}
