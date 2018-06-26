/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Endereco;
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
public class EnderecoDAO {

    private Connection connection;

    public EnderecoDAO(Connection connection) {
        this.connection = connection;
    }

    public int seEnderecoExiste(Endereco endereco) {

        int existe = 0;

        try {
            String sql = "SELECT IdE FROM endereco WHERE Logradouro = ? AND "
                    + "Numero = ? AND Complemento = ? AND Cidade = ? AND CEP = ? AND "
                    + "Estado = ? AND Pais = ? AND Bairro = ?";

            try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
                ps.setString(1, endereco.getLogradouro());
                ps.setInt(2, endereco.getNumero());
                ps.setString(3, endereco.getComplemento());
                ps.setString(4, endereco.getCidade());
                ps.setString(5, endereco.getCep());
                ps.setString(6, endereco.getEstado());
                ps.setString(7, endereco.getPais());
                ps.setString(8, endereco.getBairro());

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    existe = rs.getInt("IdE");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public int inserindoEndereco(Endereco endereco) {

        int idE = 0;
        try {

            String sql1 = "INSERT INTO endereco "
                    + "(Logradouro,Numero,Complemento,Cidade,CEP,Estado,Pais,Bairro)"
                    + " values (?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setString(1, endereco.getLogradouro());
                stmt.setInt(2, endereco.getNumero());
                stmt.setString(3, endereco.getComplemento());
                stmt.setString(4, endereco.getCidade());
                stmt.setString(5, endereco.getCep());
                stmt.setString(6, endereco.getEstado());
                stmt.setString(7, endereco.getPais());
                stmt.setString(8, endereco.getBairro());

                stmt.execute();
            }

            String sql2 = "SELECT IdE FROM endereco WHERE Logradouro = ? AND "
                    + "Numero = ? AND Complemento = ? AND Cidade = ? AND CEP = ? AND "
                    + "Estado = ? AND Pais = ? AND Bairro = ?";

            try (PreparedStatement ps = this.connection.prepareStatement(sql2)) {
                ps.setString(1, endereco.getLogradouro());
                ps.setInt(2, endereco.getNumero());
                ps.setString(3, endereco.getComplemento());
                ps.setString(4, endereco.getCidade());
                ps.setString(5, endereco.getCep());
                ps.setString(6, endereco.getEstado());
                ps.setString(7, endereco.getPais());
                ps.setString(8, endereco.getBairro());

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    idE = rs.getInt("IdE");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idE;
    }
}
