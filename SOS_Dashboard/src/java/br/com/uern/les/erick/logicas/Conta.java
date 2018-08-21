/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.daos.TarmDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import br.com.uern.les.erick.modelos.Tarm;
import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Conta implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        String nomeUsuario = req.getParameter("nomeUsuario");

        //CONEXÃO E SESSÃO
        Connection connection = (Connection) req.getAttribute("conexao");
        HttpSession session = req.getSession();

        //INSTÂNCIANDO USUARIODAO
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        Usuario usuario = usuarioDAO.getUsuario(nomeUsuario);

        if (usuario.getTipoDeUsuario().equalsIgnoreCase("Admin")) {           
            
            pagina = "contaAdmin.jsp";
            
        }

        if (usuario.getTipoDeUsuario().equalsIgnoreCase("Tarm")) {

            //INSTÂNCIA TARMDAO
            TarmDAO tarmDAO = new TarmDAO(connection);
            Tarm tarm = tarmDAO.getDadosTarm(nomeUsuario);
            session.setAttribute("dadosTarm", tarm);
            
            pagina = "contaTarm.jsp";

        }

        if (usuario.getTipoDeUsuario().equalsIgnoreCase("Médico")) {

            //INSTÂNCIA MEDICODAO
            MedicoDAO medicoDAO = new MedicoDAO(connection);
            MedicoRegulador medicoRegulador = medicoDAO.getDadosMedicoRegulador(nomeUsuario);
            session.setAttribute("dadosMedicoRegulador", medicoRegulador);
            
            pagina = "contaMedico.jsp";
            
        }

        return pagina;
    }

}
