/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.EnderecoDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Contato;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.PossuiTabela;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarCadastro implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DE TELA-SOBRE
        String cpf = req.getParameter("cpf");
        String rg = req.getParameter("rg");
        String nascimento = req.getParameter("nascimento");
        String nome = req.getParameter("nome");
        String genero = req.getParameter("genero");

        //CAMPOS DE TELA-ENDEREÇO
        String logradouro = req.getParameter("logradouro");
        String bairro = req.getParameter("bairro");
        int numero = Integer.parseInt(req.getParameter("numero"));
        String complemento = req.getParameter("complemento");
        String cidade = req.getParameter("cidade");
        String cep = req.getParameter("cep");
        String estado = req.getParameter("estado");
        String pais = req.getParameter("pais");

        //CAMPOS DE TELA-CONTATO       
        String telefone = req.getParameter("telefone");
        String celular = req.getParameter("celular");
        String email = req.getParameter("email");

        //MODELO CONTATO
        Contato contato = new Contato();
        contato.setTelefone(telefone);
        contato.setCel(celular);
        contato.setEmail(email);

        //MODELO ENDEREÇO
        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setBairro(bairro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setCidade(cidade);
        endereco.setCep(cep);
        endereco.setEstado(estado);
        endereco.setPais(pais);

        //INSTÂNCIA ENDERECODAO E VERIFICA SE O ENDEREÇO JÁ EXISTE NO BD
        EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
        int existe = enderecoDAO.seEnderecoExiste(endereco);

        if (existe == 0) {
            //REALIZA A INSERÇÃO
            int idE = enderecoDAO.inserindoEndereco(endereco);
            
        }
                
        //CAMPOS DE TELA-TRABALHO
        String cargo = req.getParameter("cargo");
        String situacao = req.getParameter("situacao");

        if (cargo.equalsIgnoreCase("Auxiliar/Enfermeiro")) {

            //CAMPOS DE TELA-TRABALHO-AUX/ENF
            String coren = req.getParameter("coren");
            String tipoCoren = req.getParameter("tipoCoren");

            if (tipoCoren.equalsIgnoreCase("Enfermeiro")) {

            }

            if (tipoCoren.equalsIgnoreCase("Técnico")) {

            }

        }

        if (cargo.equalsIgnoreCase("Médico")) {
            //CAMPOS DE TELA-TRABALHO-MÉDICO
            String uf = req.getParameter("uf");
            String crm = req.getParameter("crm");

            //CAMPOS DE TELA-CONTATO-MÉDICO  
            String login = req.getParameter("login");
            String senha = req.getParameter("senha");
            String senhaR = req.getParameter("senhaR");

            //INSTÂNCIANDO USUARIODAO
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            String confirmacao = usuarioDAO.verificadoNomeUsuario(login);

        }

        if (cargo.equalsIgnoreCase("Motorista")) {
            //CAMPOS DE TELA-TRABALHO-MOTORISTA
            String cnh = req.getParameter("cnh");

        }

        if (cargo.equalsIgnoreCase("Tarm")) {
            //CAMPOS DE TELA-CONTATO-TARM
            String login = req.getParameter("login");
            String senha = req.getParameter("senha");
            String senhaR = req.getParameter("senhaR");

            //INSTÂNCIANDO USUARIODAO
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            String confirmacao = usuarioDAO.verificadoNomeUsuario(login);
        }

        return pagina;
    }

}
