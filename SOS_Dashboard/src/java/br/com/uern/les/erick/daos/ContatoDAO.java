/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class ContatoDAO {

    private Connection connection;

    public ContatoDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserindoChamado(Contato contato) {
        int idC = 0;

        try {
            String sql1 = "INSERT INTO contato "
                    + "(Tel,Cel,Email)"
                    + " values (?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, contato.getTelefone());
                stmt.setString(2, contato.getCel());
                stmt.setString(3, contato.getEmail());

                stmt.execute();

                String sql2 = "SELECT LAST_INSERT_ID() FROM contato";

                PreparedStatement ps = this.connection.prepareStatement(sql2);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    idC = rs.getInt("LAST_INSERT_ID()");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idC;
    }

    public Contato getContato(int idC) {

        Contato contato = null;

        try {
            String sql = "SELECT * FROM contato WHERE IdC = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idC);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    contato = new Contato();
                    contato.setIdC(rs.getInt("IdC"));
                    contato.setTelefone(rs.getString("Tel"));
                    contato.setCel(rs.getString("Cel"));
                    contato.setEmail(rs.getString("Email"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contato;
    }

    public int atualizarContato(Contato contato) {

        int confirmacao = 0;
        try {

            String sql = "UPDATE contato SET Tel = ?, Cel = ?, Email = ? "
                    + "WHERE IdC = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, contato.getTelefone());
                stmt.setString(2, contato.getCel());
                stmt.setString(3, contato.getEmail());
                stmt.setInt(4, contato.getIdC());
                stmt.execute();

                confirmacao++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confirmacao;
    }

}
