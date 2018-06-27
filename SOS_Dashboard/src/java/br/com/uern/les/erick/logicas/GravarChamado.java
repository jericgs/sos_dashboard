/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.ChamadoDAO;
import br.com.uern.les.erick.daos.EnderecoDAO;
import br.com.uern.les.erick.daos.PacienteDAO;
import br.com.uern.les.erick.daos.PossuiDAO;
import br.com.uern.les.erick.daos.SolicitanteDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.Paciente;
import br.com.uern.les.erick.modelos.PossuiTabela;
import br.com.uern.les.erick.modelos.RegistroChamado;
import br.com.uern.les.erick.modelos.Solicitante;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarChamado implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS FORMULÁRIO PART1
        String tarmCPF = req.getParameter("tarmCPF");
        int numChamado = Integer.parseInt(req.getParameter("numChamado"));
        String data = req.getParameter("data");
        String hora = req.getParameter("hora");
        String nomeSolicitante = req.getParameter("nomeSolicitante");
        String telefoneSolicitante = req.getParameter("telefoneSolicitante");
        String medicoCPF = req.getParameter("medicoCPF");
        String motivo = req.getParameter("motivo");

        //CAMPOS FORMULÁRIO PART2
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");
        String queixa = req.getParameter("queixa");                        

        if (motivo.equalsIgnoreCase("Socorro") || motivo.equalsIgnoreCase("Informação")) {

            //CAMPOS FORMULÁRIO PART2
            String logradouro = req.getParameter("logradouro");
            int numero = Integer.parseInt(req.getParameter("numero"));
            String complemento = req.getParameter("complemento");
            String bairro = req.getParameter("bairro");
            String cidade = req.getParameter("cidade");
            String cep = req.getParameter("cep");
            String estado = req.getParameter("estado");
            String pais = req.getParameter("pais");

            //PACIENTE MODELO
            Paciente paciente = new Paciente();
            paciente.setNome(nomePaciente);
            paciente.setIdade(idadePaciente);

            //INSTÂNCIA PACIENTEDAO E REALIZA A INSERÇÃO
            PacienteDAO pacienteDAO = new PacienteDAO(connection);
            int idP = pacienteDAO.inserirPaciente(paciente);

            //MODELO SOLICITANTE
            Solicitante solicitante = new Solicitante();
            solicitante.setNome(nomeSolicitante);
            solicitante.setTel(telefoneSolicitante);

            //INSTÂNCIA SOLICITANTEDAO E REALIZA A INSERÇÃO
            SolicitanteDAO solicitanteDAO = new SolicitanteDAO(connection);
            int idS = solicitanteDAO.inserirSolicitante(solicitante);

            //ENDEREÇO MODELO
            Endereco endereco = new Endereco();
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setCep(cep);
            endereco.setEstado(estado);
            endereco.setPais(pais);

            //INSTÂNCIA ENDERECODAO
            EnderecoDAO enderecoDAO = new EnderecoDAO(connection);

            //VERIFICA SE O ENDEREÇO JÁ EXISTE NO BD
            int existe = enderecoDAO.seEnderecoExiste(endereco);

            if (existe == 0) {

                //REALIZA A INSERÇÃO
                int idE = enderecoDAO.inserindoEndereco(endereco);

                //MODELO POSSUI
                PossuiTabela pt = new PossuiTabela();
                pt.setIdE(idE);
                pt.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao = new PossuiDAO(connection);
                pdao.inserirPossui(pt);

            }

            if (existe != 0) {

                //MODELO POSSUI
                PossuiTabela pt = new PossuiTabela();
                pt.setIdE(existe);
                pt.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao = new PossuiDAO(connection);
                pdao.inserirPossui(pt);

            }

            //MODELO REGISTRO DE CHAMADO
            RegistroChamado registroChamado = new RegistroChamado();
            registroChamado.setCpft(tarmCPF);
            registroChamado.setCpfm(medicoCPF);
            registroChamado.setIdS(idS);
            registroChamado.setIdP(idP);
            registroChamado.setNumChamado(numChamado);
            registroChamado.setHora(hora);
            registroChamado.setDataDeRegistro(data);
            registroChamado.setQueixa(queixa);
            registroChamado.setMotivo(motivo);

            //INSTÂNCIA CHAMADODAO E REALIZA A INSERÇÃO
            ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
            chamadoDAO.inserindoChamado(registroChamado);

            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("confirmacao", alerta);

            return "chamadoSolicitante.jsp";

        } else {

            //CAMPOS FORMULÁRIO PART2
            String logradouro = req.getParameter("logradouro");
            int numero = Integer.parseInt(req.getParameter("numero"));
            String complemento = req.getParameter("complemento");
            String bairro = req.getParameter("bairro");
            String cidade = req.getParameter("cidade");
            String cep = req.getParameter("cep");
            String estado = req.getParameter("estado");
            String pais = req.getParameter("pais");

            String logradouroD = req.getParameter("logradouroD");
            int numeroD = Integer.parseInt(req.getParameter("numeroD"));
            String complementoD = req.getParameter("complementoD");
            String bairroD = req.getParameter("bairroD");
            String cidadeD = req.getParameter("cidadeD");
            String cepD = req.getParameter("cepD");
            String estadoD = req.getParameter("estadoD");
            String paisD = req.getParameter("paisD");

            //PACIENTE MODELO
            Paciente paciente = new Paciente();
            paciente.setNome(nomePaciente);
            paciente.setIdade(idadePaciente);

            //INSTÂNCIA PACIENTEDAO E REALIZA A INSERÇÃO
            PacienteDAO pacienteDAO = new PacienteDAO(connection);
            int idP = pacienteDAO.inserirPaciente(paciente);

            //MODELO SOLICITANTE
            Solicitante solicitante = new Solicitante();
            solicitante.setNome(nomeSolicitante);
            solicitante.setTel(telefoneSolicitante);

            //INSTÂNCIA SOLICITANTEDAO E REALIZA A INSERÇÃO
            SolicitanteDAO solicitanteDAO = new SolicitanteDAO(connection);
            int idS = solicitanteDAO.inserirSolicitante(solicitante);

            //ENDEREÇO MODELO
            Endereco enderecoOri = new Endereco();
            enderecoOri.setLogradouro(logradouro);
            enderecoOri.setNumero(numero);
            enderecoOri.setComplemento(complemento);
            enderecoOri.setBairro(bairro);
            enderecoOri.setCidade(cidade);
            enderecoOri.setCep(cep);
            enderecoOri.setEstado(estado);
            enderecoOri.setPais(pais);

            Endereco enderecoD = new Endereco();
            enderecoD.setLogradouro(logradouroD);
            enderecoD.setNumero(numeroD);
            enderecoD.setComplemento(complementoD);
            enderecoD.setBairro(bairroD);
            enderecoD.setCidade(cidadeD);
            enderecoD.setCep(cepD);
            enderecoD.setEstado(estadoD);
            enderecoD.setPais(paisD);

            //INSTÂNCIA ENDERECODAO
            EnderecoDAO enderecoDAOOri = new EnderecoDAO(connection);
            EnderecoDAO enderecoDAOD = new EnderecoDAO(connection);

            //VERIFICA SE O ENDEREÇO JÁ EXISTE NO BD
            int existeOri = enderecoDAOOri.seEnderecoExiste(enderecoOri);
            int existeD = enderecoDAOD.seEnderecoExiste(enderecoD);

            if (existeOri == 0 && existeD == 0) {

                //REALIZA A INSERÇÃO
                int idEOri = enderecoDAOOri.inserindoEndereco(enderecoOri);
                int idED = enderecoDAOD.inserindoEndereco(enderecoD);

                //MODELO POSSUI
                PossuiTabela pt1 = new PossuiTabela();
                pt1.setIdE(idEOri);
                pt1.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao1 = new PossuiDAO(connection);
                pdao1.inserirPossui(pt1);

                //MODELO POSSUI
                PossuiTabela pt2 = new PossuiTabela();
                pt2.setIdE(idED);
                pt2.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao2 = new PossuiDAO(connection);
                pdao2.inserirPossui(pt2);

            }

            if (existeOri != 0 && existeD != 0) {

                //MODELO POSSUI
                PossuiTabela pt1 = new PossuiTabela();
                pt1.setIdE(existeOri);
                pt1.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao1 = new PossuiDAO(connection);
                pdao1.inserirPossui(pt1);

                //MODELO POSSUI
                PossuiTabela pt2 = new PossuiTabela();
                pt2.setIdE(existeD);
                pt2.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao2 = new PossuiDAO(connection);
                pdao2.inserirPossui(pt2);
            }

            if (existeOri == 0 && existeD != 0) {

                //REALIZA A INSERÇÃO
                int idEOri = enderecoDAOOri.inserindoEndereco(enderecoOri);

                //MODELO POSSUI
                PossuiTabela pt1 = new PossuiTabela();
                pt1.setIdE(idEOri);
                pt1.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao1 = new PossuiDAO(connection);
                pdao1.inserirPossui(pt1);

                //MODELO POSSUI
                PossuiTabela pt2 = new PossuiTabela();
                pt2.setIdE(existeD);
                pt2.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao2 = new PossuiDAO(connection);
                pdao2.inserirPossui(pt2);
            }

            if (existeOri != 0 && existeD == 0) {

                //REALIZA A INSERÇÃO
                int idED = enderecoDAOD.inserindoEndereco(enderecoD);

                //MODELO POSSUI
                PossuiTabela pt1 = new PossuiTabela();
                pt1.setIdE(existeOri);
                pt1.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao1 = new PossuiDAO(connection);
                pdao1.inserirPossui(pt1);

                //MODELO POSSUI
                PossuiTabela pt2 = new PossuiTabela();
                pt2.setIdE(idED);
                pt2.setIdP(idP);

                //INSTÂNCIA POSSUIDAO E REALIZA A INSERÇÃO
                PossuiDAO pdao2 = new PossuiDAO(connection);
                pdao2.inserirPossui(pt2);
            }

            //MODELO REGISTRO DE CHAMADO
            RegistroChamado registroChamado = new RegistroChamado();
            registroChamado.setCpft(tarmCPF);
            registroChamado.setCpfm(medicoCPF);
            registroChamado.setIdS(idS);
            registroChamado.setIdP(idP);
            registroChamado.setNumChamado(numChamado);
            registroChamado.setHora(hora);
            registroChamado.setDataDeRegistro(data);
            registroChamado.setQueixa(queixa);
            registroChamado.setMotivo(motivo);
            
            //INSTÂNCIA CHAMADODAO E REALIZA A INSERÇÃO
            ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
            chamadoDAO.inserindoChamado(registroChamado);
            
            //PARAMETROS PARA O ALERTA
            Alerta alerta = new Alerta();
            alerta.setTipoAlerta("success");
            alerta.setMsnAlerta("Gravado com Sucesso!");
            req.setAttribute("confirmacao", alerta);

            return "chamadoSolicitante.jsp";
        }
    }
}
