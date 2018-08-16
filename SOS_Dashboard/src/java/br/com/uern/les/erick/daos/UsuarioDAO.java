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
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE  NomeUsuario = ? AND Senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            String sql = "UPDATE usuario SET Status = ? WHERE NomeUsuario = ? AND Senha = ?";
            // seta os valores
            try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
                // seta os valores
                ps.setString(1, "Online");
                ps.setString(2, usuario);
                ps.setString(3, senha);

                //fecha atualização
                ps.execute();
            }

            while (rs.next()) {
                // criando o objeto Usuario
                Usuario usuarioL = new Usuario();
                usuarioL.setNomeUsuario(rs.getString("NomeUsuario"));
                usuarioL.setSenha(rs.getString("Senha"));
                usuarioL.setTipoDeUsuario(rs.getString("TipoUsuario"));
                usuarioL.setStatus(rs.getString("Status"));

                //fecha busca
                rs.close();
                stmt.close();

                // adicionando o objeto à lista
                return usuarioL;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void getLogout(String nomeUsuario) {

        try {
            String sql = "UPDATE usuario SET Status = ? WHERE NomeUsuario = ?";
            // seta os valores
            try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
                // seta os valores
                ps.setString(1, "Offline");
                ps.setString(2, nomeUsuario);

                //fecha atualização
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String inserindoUsuario(Usuario usuario) {

        String nomeUsuario = null;

        try {
            String sql1 = "INSERT INTO usuario "
                    + "(NomeUsuario,Senha,TipoUsuario,Status) "
                    + "VALUES (?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, usuario.getNomeUsuario());
                stmt.setString(2, usuario.getSenha());
                stmt.setString(3, usuario.getTipoDeUsuario());
                stmt.setString(4, usuario.getStatus());

                stmt.execute();

                String sql2 = "SELECT NomeUsuario FROM usuario WHERE NomeUsuario = ?";

                PreparedStatement ps = this.connection.prepareStatement(sql2);
                ps.setString(1, usuario.getNomeUsuario());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    nomeUsuario = rs.getString("NomeUsuario");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nomeUsuario;                
    }

    public List<Usuario> getUsuario() {

        List<Usuario> usuarios = new ArrayList<>();

        try {
            try (PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario"); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // criando o objeto Usuario
                    Usuario usuarioB = new Usuario();
                    usuarioB.setNomeUsuario(rs.getString("NomeUsuario"));
                    usuarioB.setSenha(rs.getString("Senha"));
                    usuarioB.setTipoDeUsuario(rs.getString("TipoUsuario"));
                    usuarioB.setStatus(rs.getString("Status"));

                    // adicionando o objeto à lista
                    usuarios.add(usuarioB);

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;
    }

    public List<String> getUnidadesMoveis() {

        List<String> listUnidadesMoveis = new ArrayList<>();

        try {

            String sql = "SELECT NomeUsuario FROM "
                    + "usuario WHERE status = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, "Ativo");

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    String nomeUsuario;
                    nomeUsuario = rs.getString("NomeUsuario");

                    listUnidadesMoveis.add(nomeUsuario);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listUnidadesMoveis;
    }

    public String verificadoNomeUsuario(String nomeUsuario) {
        String usuario = null;

        try {

            String sql = "SELECT NomeUsuario FROM usuario WHERE NomeUsuario = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, nomeUsuario);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    usuario = rs.getString("NomeUsuario");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegulacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
        
}
