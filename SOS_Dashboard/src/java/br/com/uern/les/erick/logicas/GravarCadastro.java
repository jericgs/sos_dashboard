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
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Auxiliar;
import br.com.uern.les.erick.modelos.Contato;
import br.com.uern.les.erick.modelos.Endereco;
import br.com.uern.les.erick.modelos.Enfermeiro;
import br.com.uern.les.erick.modelos.ModeloEmail;
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

        //INSTÂNCIA CONTATODAO E INSERIR
        ContatoDAO contatoDAO = new ContatoDAO(connection);
        int idC = contatoDAO.InserindoChamado(contato);

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
        int idE = enderecoDAO.seEnderecoExiste(endereco);

        if (idE == 0) {
            //REALIZA A INSERÇÃO
            idE = enderecoDAO.inserindoEndereco(endereco);

        }

        //CAMPOS DE TELA-TRABALHO
        String cargo = req.getParameter("cargo");
        String situacao = req.getParameter("situacao");

        if (cargo.equalsIgnoreCase("Auxiliar/Enfermeiro")) {

            //CAMPOS DE TELA-TRABALHO-AUX/ENF
            String coren = req.getParameter("coren");
            String tipoCoren = req.getParameter("tipoCoren");

            if (tipoCoren.equalsIgnoreCase("Enfermeiro")) {

                //MODELO ENFERMEIRO
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setCpfe(cpf);
                enfermeiro.setRg(rg);
                enfermeiro.setNascimento(nascimento);
                enfermeiro.setNome(nome);
                enfermeiro.setGenero(genero);
                enfermeiro.setIdC(idC);
                enfermeiro.setIdE(idE);
                enfermeiro.setNumCoren(coren);

                //INSTÂNCIA ENFERMEIRODAO E INSERIR
                EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO(connection);
                String idEnfermeiro = enfermeiroDAO.InserindoEnfermeiro(enfermeiro);

                if (idEnfermeiro != null) {

                    //INSTÂNCIANDO CLASSE DE E-MAIL
                    EnviarEmail enviar = new EnviarEmail();
                    enviar.setEmailDestinatario(email);
                    enviar.setAssunto("Contato - SAMU MOSSORÓ");

                    //CHAMO MODELO DO E-MAIL
                    ModeloEmail modeloEmail = new ModeloEmail();
                    StringBuilder texto = modeloEmail.Modelo2(nome);

                    //ENVIANDO MENSAGEM
                    enviar.setMsg(texto.toString());
                    boolean enviou = enviar.enviarGmail();

                    if (enviou) {

                        //PARAMETROS PARA O ALERTA
                        Alerta alerta = new Alerta();
                        alerta.setTipoAlerta("success");
                        alerta.setMsnAlerta("Gravado com Sucesso!");
                        req.setAttribute("alerta", alerta);

                        //SETANDO PÁGINA
                        pagina = "cadastro.jsp";

                    } else {

                        //PARAMETROS PARA O ALERTA
                        Alerta alerta = new Alerta();
                        alerta.setTipoAlerta("error");
                        alerta.setMsnAlerta("Erro ao Gravar!");
                        req.setAttribute("alerta", alerta);

                        //SETANDO PÁGINA
                        pagina = "cadastro.jsp";

                    }

                }

            }

            if (tipoCoren.equalsIgnoreCase("Técnico")) {
                
                //MODELO AUXILIAR
                Auxiliar auxiliar = new Auxiliar();
                auxiliar.setCpfa(cpf);
                auxiliar.setIdC(idC);
                auxiliar.setIdE(idE);
                auxiliar.setNascimento(nascimento);
                auxiliar.setRg(rg);
                auxiliar.setNome(nome);
                auxiliar.setGenero(genero);
                auxiliar.setSituacao(situacao);
                auxiliar.setNumCoren(coren);
                
                //INSTÂNCIA ENFERMEIRODAO E INSERIR
                AuxiliarDAO auxiliarDAO = new AuxiliarDAO(connection);
                String idAuxiliar = auxiliarDAO.InserindoAuxiliar(auxiliar);
                
                if (idAuxiliar != null) {
                    
                    //INSTÂNCIANDO CLASSE DE E-MAIL
                    EnviarEmail enviar = new EnviarEmail();
                    enviar.setEmailDestinatario(email);
                    enviar.setAssunto("Contato - SAMU MOSSORÓ");
                    
                    //CHAMO MODELO DO E-MAIL
                    ModeloEmail modeloEmail = new ModeloEmail();
                    StringBuilder texto = modeloEmail.Modelo2(nome);
                    
                    //ENVIANDO MENSAGEM
                    enviar.setMsg(texto.toString());
                    boolean enviou = enviar.enviarGmail();

                    if (enviou) {

                        //PARAMETROS PARA O ALERTA
                        Alerta alerta = new Alerta();
                        alerta.setTipoAlerta("success");
                        alerta.setMsnAlerta("Gravado com Sucesso!");
                        req.setAttribute("alerta", alerta);

                        //SETANDO PÁGINA
                        pagina = "cadastro.jsp";

                    } else {

                        //PARAMETROS PARA O ALERTA
                        Alerta alerta = new Alerta();
                        alerta.setTipoAlerta("error");
                        alerta.setMsnAlerta("Erro ao Gravar!");
                        req.setAttribute("alerta", alerta);

                        //SETANDO PÁGINA
                        pagina = "cadastro.jsp";

                    }
                    
                }                                
                
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
