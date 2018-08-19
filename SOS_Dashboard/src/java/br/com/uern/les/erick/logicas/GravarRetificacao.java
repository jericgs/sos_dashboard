/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.AuxiliarDAO;
import br.com.uern.les.erick.daos.ContatoDAO;
import br.com.uern.les.erick.daos.EnderecoDAO;
import br.com.uern.les.erick.daos.EnfermeiroDAO;
import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.daos.MotoristaDAO;
import br.com.uern.les.erick.daos.TarmDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Auxiliar;
import br.com.uern.les.erick.modelos.Contato;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.Enfermeiro;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import br.com.uern.les.erick.modelos.Motorista;
import br.com.uern.les.erick.modelos.Tarm;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarRetificacao implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //INSTÂNCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DE TELA
        String cpfI = req.getParameter("cpfI");
        String rg = req.getParameter("rg");
        String nascimento = req.getParameter("nascimento");
        String nome = req.getParameter("nome");
        String genero = req.getParameter("genero");
        String cargo = req.getParameter("cargo");
        String situacao = req.getParameter("situacao");

        int idC = Integer.parseInt(req.getParameter("idC"));
        String telefone = req.getParameter("telefone");
        String celular = req.getParameter("celular");
        String email = req.getParameter("email");

        int idE = Integer.parseInt(req.getParameter("idE"));
        String logradouro = req.getParameter("logradouro");
        String bairro = req.getParameter("bairro");
        int numero = Integer.parseInt(req.getParameter("numero"));
        String complemento = req.getParameter("complemento");
        String cidade = req.getParameter("cidade");
        String cep = req.getParameter("cep");
        String estado = req.getParameter("estado");
        String pais = req.getParameter("pais");

        //MODELO CONTATO
        Contato contato = new Contato();
        contato.setIdC(idC);
        contato.setTelefone(telefone);
        contato.setCel(celular);
        contato.setEmail(email);

        //MODELO ENDEREÇO
        Endereco endereco = new Endereco();
        endereco.setIdE(idE);
        endereco.setLogradouro(logradouro);
        endereco.setBairro(bairro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setCidade(cidade);
        endereco.setCep(cep);
        endereco.setEstado(estado);
        endereco.setPais(pais);

        //INSTÂNCIA CONTATODAO
        ContatoDAO contatoDAO = new ContatoDAO(connection);
        int confirmacaoContato = contatoDAO.atualizarContato(contato);

        //INSTÂNCIA CONTATODAO
        EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
        int confirmacaoEndereco = enderecoDAO.atualizarEndereco(endereco);

        if (cargo.equalsIgnoreCase("Auxiliar")) {

            //CAMPOS DE TELA
            String coren = req.getParameter("coren");

            //MODELO AUXILIAR
            Auxiliar auxiliar = new Auxiliar();
            auxiliar.setCpfa(cpfI);
            auxiliar.setIdC(idC);
            auxiliar.setIdE(idE);
            auxiliar.setNascimento(nascimento);
            auxiliar.setRg(rg);
            auxiliar.setNome(nome);
            auxiliar.setGenero(genero);
            auxiliar.setSituacao(situacao);
            auxiliar.setNumCoren(coren);

            //INSTÂNCIA AUXILIARDAO
            AuxiliarDAO auxiliarDAO = new AuxiliarDAO(connection);
            int confirmacaoAuxiliar = auxiliarDAO.atualizarAuxiliar(auxiliar);

            if ((confirmacaoContato != 0) && (confirmacaoEndereco != 0) && (confirmacaoAuxiliar != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("error");
                alerta.setMsnAlerta("Erro ao Gravar!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            }

        }

        if (cargo.equalsIgnoreCase("Enfermeiro")) {

            //CAMPOS DE TELA
            String coren = req.getParameter("coren");

            //MODELO ENFERMEIRO
            Enfermeiro enfermeiro = new Enfermeiro();
            enfermeiro.setCpfe(cpfI);
            enfermeiro.setIdC(idC);
            enfermeiro.setIdE(idE);
            enfermeiro.setNascimento(nascimento);
            enfermeiro.setRg(rg);
            enfermeiro.setNome(nome);
            enfermeiro.setGenero(genero);
            enfermeiro.setSituacao(situacao);
            enfermeiro.setNumCoren(coren);

            //INSTÂNCIA ENFERMEIRODAO
            EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO(connection);
            int confirmacaoEnfermeiro = enfermeiroDAO.atualizarEnfermeiro(enfermeiro);

            if ((confirmacaoContato != 0) && (confirmacaoEndereco != 0) && (confirmacaoEnfermeiro != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("error");
                alerta.setMsnAlerta("Erro ao Gravar!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            }

        }

        if (cargo.equalsIgnoreCase("Medico Regulador")) {

            //CAMPOS DE TELA
            String uf = req.getParameter("uf");
            String crm = req.getParameter("crm");

            //CONCATENANDO STRINGS
            String estadoCrm = uf + "/" + crm;

            //MODELO MEDICO
            MedicoRegulador medicoRegulador = new MedicoRegulador();
            medicoRegulador.setCPFM(cpfI);
            medicoRegulador.setIdC(idC);
            medicoRegulador.setIdE(idE);
            medicoRegulador.setCRM(estadoCrm);
            medicoRegulador.setNascimento(nascimento);
            medicoRegulador.setRG(rg);
            medicoRegulador.setNome(nome);
            medicoRegulador.setGenero(genero);
            medicoRegulador.setSituacao(situacao);

            //INSTÂNCIA MEDICODAO
            MedicoDAO medicoDAO = new MedicoDAO(connection);
            int confirmacaoMedico = medicoDAO.atualizarMedicoRegulador(medicoRegulador);

            if ((confirmacaoContato != 0) && (confirmacaoEndereco != 0) && (confirmacaoMedico != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("error");
                alerta.setMsnAlerta("Erro ao Gravar!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            }

        }

        if (cargo.equalsIgnoreCase("Motorista")) {

            //CAMPOS DE TELA
            String cnh = req.getParameter("cnh");

            //MODELO MOTORISTA
            Motorista motorista = new Motorista();
            motorista.setCnh(cnh);
            motorista.setIdC(idC);
            motorista.setIdE(idE);
            motorista.setCpfm(cpfI);
            motorista.setNascimento(nascimento);
            motorista.setRg(rg);
            motorista.setNome(nome);
            motorista.setGenero(genero);
            motorista.setSituacao(situacao);

            //INSTÂNCIA MOTORISTADAO
            MotoristaDAO motoristaDAO = new MotoristaDAO(connection);
            int confirmacaoMotorista = motoristaDAO.atualizarMotorista(motorista);

            if ((confirmacaoContato != 0) && (confirmacaoEndereco != 0) && (confirmacaoMotorista != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("error");
                alerta.setMsnAlerta("Erro ao Gravar!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            }

        }

        if (cargo.equalsIgnoreCase("Tarm")) {

            //MODELO TARM
            Tarm tarm = new Tarm();
            tarm.setCPFT(cpfI);
            tarm.setIdC(idC);
            tarm.setIdE(idE);
            tarm.setNascimento(nascimento);
            tarm.setRG(rg);
            tarm.setNome(nome);
            tarm.setGenero(genero);
            tarm.setSituacao(situacao);

            //INSTÂNCIA TARMDAO
            TarmDAO tarmDAO = new TarmDAO(connection);
            int confirmacaoTarm = tarmDAO.atualizarTarm(tarm);

            if ((confirmacaoContato != 0) && (confirmacaoEndereco != 0) && (confirmacaoTarm != 0)) {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("success");
                alerta.setMsnAlerta("Gravado com Sucesso!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("error");
                alerta.setMsnAlerta("Erro ao Gravar!");
                req.setAttribute("alerta", alerta);

                //SETANDO PÁGINA
                pagina = "atualizacaoCadastro.jsp";

            }

        }

        return pagina;
    }

}
