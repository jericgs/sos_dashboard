/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.AuxiliarDAO;
import br.com.uern.les.erick.daos.EnfermeiroDAO;
import br.com.uern.les.erick.daos.GeolocalizacaoDAO;
import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.daos.MotoristaDAO;
import br.com.uern.les.erick.daos.UmsaDAO;
import br.com.uern.les.erick.daos.UmsbDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Alerta;
import br.com.uern.les.erick.modelos.Geolocalizacao;
import br.com.uern.les.erick.modelos.UMSA;
import br.com.uern.les.erick.modelos.UMSB;
import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class GravarCadastroAmbulancia implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //INSTANCIANDO CONEXÃO
        Connection connection = (Connection) req.getAttribute("conexao");

        //CAMPOS DE TELA-SOBRE
        String placa = req.getParameter("placa");
        String tipoAmbulancia = req.getParameter("tipoAmbulancia");
        String numeroAmbulancia = req.getParameter("numeroAmbulancia");

        //CAMPOS DE TELA-CREDENCIAR
        String senha = req.getParameter("senha");
        String senhaR = req.getParameter("senhaR");
        String tipoStatus = req.getParameter("tipoStatus");

        //CONCATENANDO STRINGS
        String nomeUsuario = tipoAmbulancia.toLowerCase() + numeroAmbulancia;

        //CONCATENANDO STRINGS        
        String nomeAmbulancia = tipoAmbulancia + " " + numeroAmbulancia;

        //MODELO USUARIO
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setStatus(tipoStatus);
        usuario.setTipoDeUsuario("UM");

        //INSTÂNCIA USUARIODAO E INSERIR
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        String nomeUsuarioId = usuarioDAO.inserindoUsuario(usuario);

        //MODELO GEOLOCALIZAÇÃO
        Geolocalizacao geolocalizacao = new Geolocalizacao();
        geolocalizacao.setLatitude(0.000000);
        geolocalizacao.setLongitude(0.000000);

        //INSTÂNCIA GEOLOCALIZACAODAO E INSERIR
        GeolocalizacaoDAO geolocalizacaoDAO = new GeolocalizacaoDAO(connection);
        int comfirmacaoIdG = geolocalizacaoDAO.inserindoGeolocalizacao(geolocalizacao);

        if ((tipoAmbulancia.equalsIgnoreCase("Alfa")) && (nomeUsuarioId != null) && (comfirmacaoIdG != 0)) {

            //INSTÂNCIA MOTORISTADAO E BUSCA
            MotoristaDAO motoristaDAO = new MotoristaDAO(connection);
            String cnh = motoristaDAO.getCnhPadrao();

            //INSTÂNCIA MEDICODAO E BUSCA
            MedicoDAO medicoDAO = new MedicoDAO(connection);
            String cpfm = medicoDAO.getCpfmPadrao();

            //INSTÂNCIA ENFERMEIRODAO E BUSCA
            EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO(connection);
            String cpfe = enfermeiroDAO.getCpfePadrao();

            //INSTÂNCIA AUXILIARDAO E BUSCA
            AuxiliarDAO auxiliarDAO = new AuxiliarDAO(connection);
            String cpfa = auxiliarDAO.getCpfaPadrao();

            if ((cnh != null) && (cpfm != null) && (cpfe != null) && (cpfa != null)) {

                //MODELO UMSA
                UMSA umsa = new UMSA();
                umsa.setPlaca(placa);
                umsa.setCnh(cnh);
                umsa.setCpfm(cpfm);
                umsa.setCpfe(cpfe);
                umsa.setCpfa(cpfa);
                umsa.setNomeUsuario(nomeUsuario);
                umsa.setIdG(comfirmacaoIdG);
                umsa.setNome(nomeAmbulancia);

                //INSTÂNCIA UMSADAO E INSERIR
                UmsaDAO umsaDAO = new UmsaDAO(connection);
                String placaId = umsaDAO.inserindoUmsa(umsa);

                if (placaId != null) {

                    //PARAMETROS PARA O ALERTA
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("success");
                    alerta.setMsnAlerta("Gravado com Sucesso!");
                    req.setAttribute("alertaM", alerta);

                    //SETANDO PÁGINA
                    pagina = "cadastroUnidadeMovel.jsp";

                } else {
                    //PARAMETROS PARA O ALERTA
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("error");
                    alerta.setMsnAlerta("Erro ao Gravar!");
                    req.setAttribute("alertaM", alerta);

                    //SETANDO PÁGINA
                    pagina = "cadastroUnidadeMovel.jsp";
                }

            } else {

                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("info");
                alerta.setMsnAlerta("É necessário adicinar primeiro os profissionais.");
                req.setAttribute("alertaM", alerta);

                //SETANDO PÁGINA
                pagina = "cadastroUnidadeMovel.jsp";

            }

        }

        if ((tipoAmbulancia.equalsIgnoreCase("Bravo")) && (nomeUsuarioId != null) && (comfirmacaoIdG != 0)) {

            //INSTÂNCIA MOTORISTADAO E BUSCA
            MotoristaDAO motoristaDAO = new MotoristaDAO(connection);
            String cnh = motoristaDAO.getCnhPadrao();

            //INSTÂNCIA AUXILIARDAO E BUSCA
            AuxiliarDAO auxiliarDAO = new AuxiliarDAO(connection);
            String cpfa = auxiliarDAO.getCpfaPadrao();

            if ((cnh != null) && (cpfa != null)) {

                //MODELO UMSB
                UMSB umsb = new UMSB();
                umsb.setPlaca(placa);
                umsb.setCnh(cnh);
                umsb.setCpfa(cpfa);
                umsb.setNomeUsuario(nomeUsuario);
                umsb.setIdG(comfirmacaoIdG);
                umsb.setNome(nomeAmbulancia);

                //INSTÂNCIA UMSBDAO E INSERIR
                UmsbDAO umsbDAO = new UmsbDAO(connection);
                String placaId = umsbDAO.inserindoUmsb(umsb);

                if (placaId != null) {

                    //PARAMETROS PARA O ALERTA
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("success");
                    alerta.setMsnAlerta("Gravado com Sucesso!");
                    req.setAttribute("alertaM", alerta);

                    //SETANDO PÁGINA
                    pagina = "cadastroUnidadeMovel.jsp";

                } else {
                    //PARAMETROS PARA O ALERTA
                    Alerta alerta = new Alerta();
                    alerta.setTipoAlerta("error");
                    alerta.setMsnAlerta("Erro ao Gravar!");
                    req.setAttribute("alertaM", alerta);

                    //SETANDO PÁGINA
                    pagina = "cadastroUnidadeMovel.jsp";
                }

            } else {
                //PARAMETROS PARA O ALERTA
                Alerta alerta = new Alerta();
                alerta.setTipoAlerta("info");
                alerta.setMsnAlerta("É necessário adicinar primeiro os profissionais.");
                req.setAttribute("alertaM", alerta);

                //SETANDO PÁGINA
                pagina = "cadastroUnidadeMovel.jsp";
            }

        }

        return pagina;
    }

}
