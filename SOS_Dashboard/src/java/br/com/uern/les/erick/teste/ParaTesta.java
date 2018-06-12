/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.teste;

import br.com.uern.les.erick.conexao.ConexaoBD;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jerick.gs
 */
public class ParaTesta {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
        String usuario = "maria_clara";
        String senha = "87654321";
        String status = "Online";        

        Connection connection = new ConexaoBD().getConnection();
        UsuarioDAO dAO = new UsuarioDAO(connection);
        //dAO.getLogout(usuario);
        Usuario usuarioB = dAO.getLogin(usuario, senha, status);
        
        System.out.println(usuarioB.getStatus());
        */
    }
}
