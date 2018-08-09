/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.teste;

import br.com.uern.les.erick.conexao.ConexaoBD;
import br.com.uern.les.erick.daos.OcorrenciasaDAO;
import br.com.uern.les.erick.daos.OcorrenciasbDAO;
import br.com.uern.les.erick.daos.PossuiDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jerick.gs
 */
public class ParaTesta {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        String usuario = "maria_clara";
//        String senha = "87654321";               
//
//        Connection connection = new ConexaoBD().getConnection();
//        UsuarioDAO dAO = new UsuarioDAO(connection);
//        //dAO.getLogout(usuario);
//        Usuario usuarioB = dAO.getLogin(usuario, senha);
//        
//        System.out.println(usuarioB.getStatus());
//        //Teste MedicoDao
//        List<MedicoRegulador> medicoReguladorsOn = new ArrayList<MedicoRegulador>();
//        String tipoDeUsuario = "Médico";
//
//        Connection connection = new ConexaoBD().getConnection();
//        MedicoDAO mdao = new MedicoDAO(connection);
//        medicoReguladorsOn = mdao.getMedicoRegulador(tipoDeUsuario);
//
//        for (int i = 0; i < medicoReguladorsOn.size(); i++) {
//            System.out.println(medicoReguladorsOn.get(i).getCPFM());
//        }
//          String data = "18/05/2018";
//          int numchamdo = 0;
//          
//          Connection connection = new ConexaoBD().getConnection();
//          ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
//          numchamdo = chamadoDAO.getNumeroDeChamado(data);
//          
//          System.out.println(numchamdo);
//            InformacaoDeTempo informacaoDeTempo = new InformacaoDeTempo();
//            
//            System.out.println(informacaoDeTempo.getDate());
//            System.out.println(informacaoDeTempo.getHora());
//        Endereco endereco = new Endereco();
//        endereco.setLogradouro("João Marcelino");
//        endereco.setNumero(9);
//        endereco.setComplemento("Casa");
//        endereco.setCidade("Mossoró");
//        endereco.setCep("59918-730");
//        endereco.setEstado("RN");
//        endereco.setPais("Brasil");
//        endereco.setBairro("Bom Jardim");
//        
//        Connection connection = new ConexaoBD().getConnection();
//        EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
//        int num = enderecoDAO.seEnderecoExiste(endereco);
//        
//        System.out.println(num);
//          Solicitante s = new Solicitante();
//          s.setNome("Erick");
//          s.setTel("(84) 99636-9155");
//          
//          Connection connection = new ConexaoBD().getConnection();
//          SolicitanteDAO solicitanteDAO = new SolicitanteDAO(connection);
//          int resul = solicitanteDAO.inserirSolicitante(s);
//          
//          System.out.println(resul);
//            Paciente paciente = new Paciente();
//            paciente.setNome("Ana Eduarda Nunes");
//            paciente.setIdade("17");
//
//            Connection connection = new ConexaoBD().getConnection();
//            PacienteDAO pacienteDAO = new PacienteDAO(connection);
//            int result = pacienteDAO.inserirPaciente(paciente);
//            
//            System.out.println(result);
//              PossuiTabela pt = new PossuiTabela();
//              pt.setIdP(1);
//              pt.setIdE(4);
//              
//              Connection connection = new ConexaoBD().getConnection();
//              PossuiDAO pdao = new PossuiDAO(connection);
//              int num = pdao.inserirPaciente(pt);
//              
//              System.out.println(num);
//        Connection connection = new ConexaoBD().getConnection();
//        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
//        int num = chamadoDAO.getNumChamadoSocorro("27/06/2018");
//
//        System.out.println(num);
//          Connection connection = new ConexaoBD().getConnection();
//          ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
//          int num = chamadoDAO.getNumChamadoInformacao("27/06/2018");
//          
//          System.out.println(num);
//          Connection connection = new ConexaoBD().getConnection();
//          ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
//          int num = chamadoDAO.getNumChamadoMes("06/2018");
//          
//          System.out.println(num);
//          Connection connection = new ConexaoBD().getConnection();
//          RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
//          Regulacao regulacao = new Regulacao();
//          
//          regulacao.setIdRC(2);
//          regulacao.setGe(0);
//          regulacao.setGs(0);
//          regulacao.setAtencao(0);
//          regulacao.setSocial(0);
//          regulacao.setTempo(0);
//          regulacao.setGu(0);
//          regulacao.setStatus("Andamento");          
//                  
//          int num = regulacaoDAO.inserindoRegulacao(regulacao);
//          
//          System.out.println(num);
//        Connection connection = new ConexaoBD().getConnection();
//        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
//        List<ChamadoMedico> chamadosMedico = chamadoDAO.getListaDeChamados("999.446.765-01", "02/07/2018");
//        
//        for(int i = 0; i < chamadosMedico.size(); i++){
//            
//            System.out.println(chamadosMedico.get(i).getIdRC());
//            System.out.println(chamadosMedico.get(i).getIdP());
//            System.out.println(chamadosMedico.get(i).getHora());
//            System.out.println(chamadosMedico.get(i).getMotivo());
//            System.out.println(chamadosMedico.get(i).getQueixa()+ "\n\n");
//                                    
//        }
//        
//        if(chamadosMedico.isEmpty()){
//            System.out.println("Vazio");
//        }
//        Connection connection = new ConexaoBD().getConnection();
//        RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
//        
//        int idR = regulacaoDAO.verificarStatusRegulacao(32);
//        
//        System.out.println(idR);
//        Connection connection = new ConexaoBD().getConnection();
//        PacienteDAO pacienteDAO = new PacienteDAO(connection);
//        Paciente p = pacienteDAO.getPacienteRegulacao(1); //se 0 vem null.
//        
//        System.out.println(p.getNome());
//        System.out.println(p.getIdade());
//        Connection connection = new ConexaoBD().getConnection();  
//        MedicoDAO medicoDAO = new MedicoDAO(connection);
//        MedicoRegulador mr = medicoDAO.getDadosMedicoRegulador("carlos.edu");
//        
//        System.out.println(mr.getCPFM());
//        Connection connection = new ConexaoBD().getConnection();
//        RegulacaoDAO rdao = new RegulacaoDAO(connection);
//        int i = rdao.atualizarRegulacao(1, "Andamento", "Nenhum");
//        
//        System.out.println(i);
//        Connection connection = new ConexaoBD().getConnection();
//        UsuarioDAO usuarioDAO =  new UsuarioDAO(connection);
//        List<String> list = usuarioDAO.getUnidadesMoveis();
//
//        list.forEach((list1) -> {
//            System.out.println(list1);
//        });
//        Connection connection = new ConexaoBD().getConnection();
//        UmsbDAO umsbDAO = new UmsbDAO(connection);
//        UMSB umsb = umsbDAO.getUnidadeMovel("bravo1");
//        
//        System.out.println(umsb.getPlaca());
//        System.out.println(umsb.getCnh());
//        System.out.println(umsb.getCpfa());
//        System.out.println(umsb.getIdG());
//        System.out.println(umsb.getNomeUsuario());
//        System.out.println(umsb.getNome());
//        Connection connection = new ConexaoBD().getConnection();
//        UmsaDAO umsaDAO =  new UmsaDAO(connection);
//        UMSA umsa = umsaDAO.getUnidadeMovel("alfa2");
//        
//        System.out.println(umsa);
//        
//        System.out.println(umsa.getPlaca());        
//        System.out.println(umsa.getCnh());
//        System.out.println(umsa.getCpfm());
//        System.out.println(umsa.getCpfe());
//        System.out.println(umsa.getCpfa());
//        System.out.println(umsa.getNomeUsuario());
//        System.out.println(umsa.getIdG());        
//        System.out.println(umsa.getNome());
//        Connection connection = new ConexaoBD().getConnection();
//        UmsaDAO umsaDAO = new UmsaDAO(connection);
//        int existe = umsaDAO.verificarSuportA("KEX-4250");
//        
//        System.out.println(existe);
        
//        Connection connection = new ConexaoBD().getConnection();
//        SinaisVitais sinaisVitais = new SinaisVitais();
//        sinaisVitais.setPa("NH");
//        sinaisVitais.setFc("NH");
//        sinaisVitais.setFr("NH");
//        sinaisVitais.setSatSemSuport("NH");
//        sinaisVitais.setSatComSuport("NH");
//        sinaisVitais.setTemperatura("NH");
//        sinaisVitais.setHgt("NH");
//        sinaisVitais.setGlasgow("NH");
//        
//        SinaisVitaisDAO aO = new SinaisVitaisDAO(connection);
//        int idV = aO.inserindoSinaisVitais(sinaisVitais);
//        
//        System.out.println(idV);

        
//        Connection connection = new ConexaoBD().getConnection();
//        RegulacaoDAO regulacaoDAO = new RegulacaoDAO(connection);
//        Regulacao regulacao = regulacaoDAO.getRegulacaoAndamento(78);
//        
//        System.out.println("Aqui: " + regulacao.getIdR());
//        
//        if(regulacao != null){
//            System.out.println("Passou");
//        }
//        
//        //INSTÂNCIANDO CHAMADODAO E REALIZANDO BUSCA
//        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
//        List<ChamadoMedico> chamadosMedico = chamadoDAO.getListaDeChamados("999.446.765-01");                
//                        
//        System.out.println("ID Paciente: " + chamadosMedico.get(0).getIdRC());
    
//        Connection connection = new ConexaoBD().getConnection();
//        OcorrenciasaDAO aO = new OcorrenciasaDAO(connection);
//        OcorrenciasbDAO dAO  = new OcorrenciasbDAO(connection);
//        
//        int r = aO.buscandoSinaisVitaisSA(40);
//        int r2 = dAO.buscandoSinaisVitaisSB(44);
//        
//        System.out.println("Aqui: " + r + " Aqui: " + r2);
    
        Connection connection = new ConexaoBD().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        String confirmacao =  usuarioDAO.verificadoNomeUsuario("carlos.edu");                
        
        if(confirmacao == null){
            System.out.println("Valor: " + confirmacao);
        }
        
        if(confirmacao != null){
            System.out.println("Valor: " + confirmacao);
        }
    }
}
