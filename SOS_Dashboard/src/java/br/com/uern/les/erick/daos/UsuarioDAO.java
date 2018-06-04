/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class UsuarioDAO {

    private Connection connection;

    /*public UsuarioDAO() {
        try {
            this.connection = new ConexaoBD().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Usuario getLogin(String usuario, String senha) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE  NomeUsuario= ? and Senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Usuario
                Usuario usuarioL = new Usuario();
                usuarioL.setNomeUsuario(rs.getString("NomeUsuario"));
                usuarioL.setSenha(rs.getString("Senha"));
                usuarioL.setStatus(rs.getString("Status"));
                usuarioL.setTipoDeUsuario(rs.getString("TipoDeUsuario"));

                // adicionando o objeto à lista
                return usuarioL;
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void adiciona(Usuario usuario) {

        // cria um preparedStatement
        String sql = "insert into usuario "
                + "(NomeUsuario,Senha,Status,TipoDeUsuario) "
                + "values (?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getStatus());
            stmt.setString(4, usuario.getTipoDeUsuario());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getUsuario() {

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Usuario
                Usuario usuarioB = new Usuario();
                usuarioB.setNomeUsuario(rs.getString("NomeUsuario"));
                usuarioB.setSenha(rs.getString("Senha"));
                usuarioB.setStatus(rs.getString("Status"));
                usuarioB.setTipoDeUsuario(rs.getString("TipoDeUsuario"));

                // adicionando o objeto à lista
                usuarios.add(usuarioB);

            }

            rs.close();
            stmt.close();
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
