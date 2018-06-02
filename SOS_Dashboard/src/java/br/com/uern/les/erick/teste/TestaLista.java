/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.teste;

import br.com.uern.les.erick.dao.UsuarioDAO;
import br.com.uern.les.erick.modelo.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jerick.gs
 */
public class TestaLista {

    public static void main(String[] args) throws SQLException {

        String usuario = "wer";
        String senha = "444";
     
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario user = usuarioDAO.getLogin(usuario, senha);
        
        System.out.println(user);

    }
}
