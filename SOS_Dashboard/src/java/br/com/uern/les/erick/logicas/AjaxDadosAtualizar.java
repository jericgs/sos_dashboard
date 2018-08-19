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
import br.com.uern.les.erick.modelos.Auxiliar;
import br.com.uern.les.erick.modelos.Contato;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.Enfermeiro;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import br.com.uern.les.erick.modelos.ModeloAtualizar1;
import br.com.uern.les.erick.modelos.ModeloAtualizar2;
import br.com.uern.les.erick.modelos.ModeloAtualizar3;
import br.com.uern.les.erick.modelos.ModeloAtualizar4;
import br.com.uern.les.erick.modelos.Motorista;
import br.com.uern.les.erick.modelos.Tarm;
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
public class AjaxDadosAtualizar implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String json = null;

        //VALOR RECEBIDO
        String cpf = req.getParameter("cpf");

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //INSTÂNCIAR AUXILIARDAO E BUSCAR
        AuxiliarDAO auxiliarDAO = new AuxiliarDAO(connection);
        Auxiliar auxiliar = auxiliarDAO.getAuxiliar(cpf);

        //INSTÂNCIAR ENFERMEIRODAO E BUSCAR
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO(connection);
        Enfermeiro enfermeiro = enfermeiroDAO.getEnfermeiro(cpf);

        //INSTÂNCIAR MEDICODAO E BUSCAR
        MedicoDAO medicoDAO = new MedicoDAO(connection);
        MedicoRegulador medicoRegulador = medicoDAO.getMedicoRegulador(cpf);

        //INSTÂNCIAR MOTORISTADAO E BUSCAR
        MotoristaDAO motoristaDAO = new MotoristaDAO(connection);
        Motorista motorista = motoristaDAO.getMotorista(cpf);

        //INSTÂNCIAR TARMDAO E BUSCAR
        TarmDAO tarmDAO = new TarmDAO(connection);
        Tarm tarm = tarmDAO.getTarm(cpf);

        //INSTÂNCIAR CONTATODAO
        ContatoDAO contatoDAO = new ContatoDAO(connection);

        //INSTÂNCIAR CONTATODAO
        EnderecoDAO enderecoDAO = new EnderecoDAO(connection);

        if (auxiliar != null) {

            //LISTA TIPODEUSUARIO
            List<ModeloAtualizar1> modeloAtualizar1s = new ArrayList<>();

            //BUSCANDO CONTATO
            Contato contato = contatoDAO.getContato(auxiliar.getIdC());

            //BUSCANDO ENDEREÇO
            Endereco endereco = enderecoDAO.getEndereco(auxiliar.getIdE());

            if ((contato != null) && (endereco != null)) {

                //MODELO ATUALIZAR1
                ModeloAtualizar1 modeloAtualizar1 = new ModeloAtualizar1();
                modeloAtualizar1.setCpf(auxiliar.getCpfa());
                modeloAtualizar1.setIdC(auxiliar.getIdC());
                modeloAtualizar1.setIdE(auxiliar.getIdE());
                modeloAtualizar1.setNascimento(auxiliar.getNascimento());
                modeloAtualizar1.setRg(auxiliar.getRg());
                modeloAtualizar1.setNome(auxiliar.getNome());
                modeloAtualizar1.setGenero(auxiliar.getGenero());
                modeloAtualizar1.setSituacao(auxiliar.getSituacao());
                modeloAtualizar1.setNumCoren(auxiliar.getNumCoren());
                modeloAtualizar1.setCargo("Auxiliar");

                modeloAtualizar1.setTelefone(contato.getTelefone());
                modeloAtualizar1.setCel(contato.getCel());
                modeloAtualizar1.setEmail(contato.getEmail());

                modeloAtualizar1.setLogradouro(endereco.getLogradouro());
                modeloAtualizar1.setNumero(endereco.getNumero());
                modeloAtualizar1.setComplemento(endereco.getComplemento());
                modeloAtualizar1.setCidade(endereco.getCidade());
                modeloAtualizar1.setCep(endereco.getCep());
                modeloAtualizar1.setBairro(endereco.getBairro());
                modeloAtualizar1.setEstado(endereco.getEstado());
                modeloAtualizar1.setPais(endereco.getPais());

                modeloAtualizar1s.add(modeloAtualizar1);

                //INVERSÃO DE CONTROLE (IOC) - JACKSON
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writeValueAsString(modeloAtualizar1s);

            }

        }

        if (enfermeiro != null) {

            //LISTA TIPODEUSUARIO
            List<ModeloAtualizar1> modeloAtualizar1s = new ArrayList<>();

            //BUSCANDO CONTATO
            Contato contato = contatoDAO.getContato(enfermeiro.getIdC());

            //BUSCANDO ENDEREÇO
            Endereco endereco = enderecoDAO.getEndereco(enfermeiro.getIdE());

            if ((contato != null) && (endereco != null)) {

                //MODELO ATUALIZAR1
                ModeloAtualizar1 modeloAtualizar1 = new ModeloAtualizar1();
                modeloAtualizar1.setCpf(enfermeiro.getCpfe());
                modeloAtualizar1.setIdC(enfermeiro.getIdC());
                modeloAtualizar1.setIdE(enfermeiro.getIdE());
                modeloAtualizar1.setNascimento(enfermeiro.getNascimento());
                modeloAtualizar1.setRg(enfermeiro.getRg());
                modeloAtualizar1.setNome(enfermeiro.getNome());
                modeloAtualizar1.setGenero(enfermeiro.getGenero());
                modeloAtualizar1.setSituacao(enfermeiro.getSituacao());
                modeloAtualizar1.setNumCoren(enfermeiro.getNumCoren());
                modeloAtualizar1.setCargo("Enfermeiro");

                modeloAtualizar1.setTelefone(contato.getTelefone());
                modeloAtualizar1.setCel(contato.getCel());
                modeloAtualizar1.setEmail(contato.getEmail());

                modeloAtualizar1.setLogradouro(endereco.getLogradouro());
                modeloAtualizar1.setNumero(endereco.getNumero());
                modeloAtualizar1.setComplemento(endereco.getComplemento());
                modeloAtualizar1.setCidade(endereco.getCidade());
                modeloAtualizar1.setCep(endereco.getCep());
                modeloAtualizar1.setBairro(endereco.getBairro());
                modeloAtualizar1.setEstado(endereco.getEstado());
                modeloAtualizar1.setPais(endereco.getPais());

                modeloAtualizar1s.add(modeloAtualizar1);

                //INVERSÃO DE CONTROLE (IOC) - JACKSON
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writeValueAsString(modeloAtualizar1s);

            }

        }

        if (medicoRegulador != null) {

            //LISTA TIPODEUSUARIO
            List<ModeloAtualizar2> modeloAtualizar2s = new ArrayList<>();

            //BUSCANDO CONTATO
            Contato contato = contatoDAO.getContato(medicoRegulador.getIdC());

            //BUSCANDO ENDEREÇO
            Endereco endereco = enderecoDAO.getEndereco(medicoRegulador.getIdE());

            if ((contato != null) && (endereco != null)) {

                //MODELO ATUALIZAR2
                ModeloAtualizar2 modeloAtualizar2 = new ModeloAtualizar2();
                modeloAtualizar2.setCpf(medicoRegulador.getCPFM());
                modeloAtualizar2.setIdC(medicoRegulador.getIdC());
                modeloAtualizar2.setIdE(medicoRegulador.getIdE());
                modeloAtualizar2.setNascimento(medicoRegulador.getNascimento());
                modeloAtualizar2.setRG(medicoRegulador.getRG());
                modeloAtualizar2.setNome(medicoRegulador.getNome());
                modeloAtualizar2.setGenero(medicoRegulador.getGenero());
                modeloAtualizar2.setSituacao(medicoRegulador.getSituacao());
                modeloAtualizar2.setCRM(medicoRegulador.getCRM());
                modeloAtualizar2.setCargo("Medico Regulador");

                modeloAtualizar2.setTelefone(contato.getTelefone());
                modeloAtualizar2.setCel(contato.getCel());
                modeloAtualizar2.setEmail(contato.getEmail());

                modeloAtualizar2.setLogradouro(endereco.getLogradouro());
                modeloAtualizar2.setNumero(endereco.getNumero());
                modeloAtualizar2.setComplemento(endereco.getComplemento());
                modeloAtualizar2.setCidade(endereco.getCidade());
                modeloAtualizar2.setCep(endereco.getCep());
                modeloAtualizar2.setBairro(endereco.getBairro());
                modeloAtualizar2.setEstado(endereco.getEstado());
                modeloAtualizar2.setPais(endereco.getPais());

                modeloAtualizar2s.add(modeloAtualizar2);

                //INVERSÃO DE CONTROLE (IOC) - JACKSON
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writeValueAsString(modeloAtualizar2s);

            }

        }

        if (motorista != null) {

            //LISTA TIPODEUSUARIO
            List<ModeloAtualizar3> modeloAtualizar3s = new ArrayList<>();

            //BUSCANDO CONTATO
            Contato contato = contatoDAO.getContato(motorista.getIdC());

            //BUSCANDO ENDEREÇO
            Endereco endereco = enderecoDAO.getEndereco(motorista.getIdE());

            if ((contato != null) && (endereco != null)) {

                //MODELO ATUALIZAR3
                ModeloAtualizar3 modeloAtualizar3 = new ModeloAtualizar3();
                modeloAtualizar3.setCnh(motorista.getCnh());
                modeloAtualizar3.setIdC(motorista.getIdC());
                modeloAtualizar3.setIdE(motorista.getIdE());
                modeloAtualizar3.setCpf(motorista.getCpfm());
                modeloAtualizar3.setNascimento(motorista.getNascimento());
                modeloAtualizar3.setRg(motorista.getRg());
                modeloAtualizar3.setNome(motorista.getNome());
                modeloAtualizar3.setGenero(motorista.getGenero());
                modeloAtualizar3.setSituacao(motorista.getSituacao());
                modeloAtualizar3.setCargo("Motorista");

                modeloAtualizar3.setTelefone(contato.getTelefone());
                modeloAtualizar3.setCel(contato.getCel());
                modeloAtualizar3.setEmail(contato.getEmail());

                modeloAtualizar3.setLogradouro(endereco.getLogradouro());
                modeloAtualizar3.setNumero(endereco.getNumero());
                modeloAtualizar3.setComplemento(endereco.getComplemento());
                modeloAtualizar3.setCidade(endereco.getCidade());
                modeloAtualizar3.setCep(endereco.getCep());
                modeloAtualizar3.setBairro(endereco.getBairro());
                modeloAtualizar3.setEstado(endereco.getEstado());
                modeloAtualizar3.setPais(endereco.getPais());

                modeloAtualizar3s.add(modeloAtualizar3);

                //INVERSÃO DE CONTROLE (IOC) - JACKSON
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writeValueAsString(modeloAtualizar3s);

            }

        }

        if (tarm != null) {

            //LISTA TIPODEUSUARIO
            List<ModeloAtualizar4> modeloAtualizar4s = new ArrayList<>();

            //BUSCANDO CONTATO
            Contato contato = contatoDAO.getContato(tarm.getIdC());

            //BUSCANDO ENDEREÇO
            Endereco endereco = enderecoDAO.getEndereco(tarm.getIdE());

            if ((contato != null) && (endereco != null)) {

                //MODELO ATUALIZAR4
                ModeloAtualizar4 modeloAtualizar4 = new ModeloAtualizar4(); 
                modeloAtualizar4.setCpf(tarm.getCPFT());
                modeloAtualizar4.setIdC(tarm.getIdC());
                modeloAtualizar4.setIdE(tarm.getIdE());                
                modeloAtualizar4.setNascimento(tarm.getNascimento());
                modeloAtualizar4.setRG(tarm.getRG());
                modeloAtualizar4.setNome(tarm.getNome());
                modeloAtualizar4.setGenero(tarm.getGenero());
                modeloAtualizar4.setSituacao(tarm.getSituacao());
                modeloAtualizar4.setCargo("Tarm");
                
                modeloAtualizar4.setTelefone(contato.getTelefone());
                modeloAtualizar4.setCel(contato.getCel());
                modeloAtualizar4.setEmail(contato.getEmail());

                modeloAtualizar4.setLogradouro(endereco.getLogradouro());
                modeloAtualizar4.setNumero(endereco.getNumero());
                modeloAtualizar4.setComplemento(endereco.getComplemento());
                modeloAtualizar4.setCidade(endereco.getCidade());
                modeloAtualizar4.setCep(endereco.getCep());
                modeloAtualizar4.setBairro(endereco.getBairro());
                modeloAtualizar4.setEstado(endereco.getEstado());
                modeloAtualizar4.setPais(endereco.getPais());
                
                modeloAtualizar4s.add(modeloAtualizar4);

                //INVERSÃO DE CONTROLE (IOC) - JACKSON
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writeValueAsString(modeloAtualizar4s);
                
            }

        }

        return json;
    }

}
