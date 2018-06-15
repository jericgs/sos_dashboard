/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Tarm;
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
public class TarmDAO {

    private Connection connection;

    public TarmDAO(Connection connection) {
        this.connection = connection;
    }

    public Tarm getDadosTarm(String nomeUsuario) {

        try {
            String sql = "SELECT * FROM tarm WHERE NomeUsuario = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, nomeUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // criando o objeto Tarm
                Tarm tarmDados = new Tarm();
                tarmDados.setCPFT(rs.getString("CPFT"));
                tarmDados.setUsuario(rs.getString("NomeUsuario"));
                tarmDados.setContato(rs.getInt("IdC"));
                tarmDados.setEndereco(rs.getInt("IdE"));
                tarmDados.setNascimento(rs.getString("Nascimento"));
                tarmDados.setRG(rs.getString("RG"));
                tarmDados.setNome(rs.getString("Nome"));
                tarmDados.setGenero(rs.getString("Genero"));
                tarmDados.setSituacao(rs.getString("Situacao"));

                //fecha busca
                rs.close();
                ps.close();

                // adicionando o objeto à lista
                return tarmDados;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
