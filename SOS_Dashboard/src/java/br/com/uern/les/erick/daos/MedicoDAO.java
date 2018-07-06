/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.MedicoRegulador;
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
public class MedicoDAO {

    private Connection connection;

    public MedicoDAO(Connection connection) {
        this.connection = connection;
    }

    public MedicoRegulador getDadosMedicoRegulador(String nomeUsuario) {

        MedicoRegulador medicoRegulador = new MedicoRegulador();
        
        try {
            String sql = "SELECT * FROM medicoregulador WHERE NomeUsuario = ?";
            try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
                ps.setString(1, nomeUsuario);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        
                        medicoRegulador.setCPFM(rs.getString("CPFM"));
                        medicoRegulador.setUsuario(rs.getString("NomeUsuario"));
                        medicoRegulador.setContato(rs.getInt("IdC"));
                        medicoRegulador.setEndereco(rs.getInt("IdE"));
                        medicoRegulador.setCRM(rs.getString("CRM"));
                        medicoRegulador.setNascimento(rs.getString("Nascimento"));
                        medicoRegulador.setRG(rs.getString("RG"));
                        medicoRegulador.setNome(rs.getString("Nome"));
                        medicoRegulador.setGenero(rs.getString("Genero"));
                        medicoRegulador.setSituacao(rs.getString("Situacao"));
                        
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medicoRegulador;
    }

    public List<MedicoRegulador> getMedicoRegulador() {

        List<String> usuariosLogados = new ArrayList<>();
        List<MedicoRegulador> medicoReguladorsOn = new ArrayList<>();

        try {

            String sql1 = "SELECT NomeUsuario FROM usuario WHERE Status = ? AND TipoUsuario = ?";
            try (PreparedStatement ps = this.connection.prepareStatement(sql1)) {
                ps.setString(1, "Online");
                ps.setString(2, "Médico");

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {

                        usuariosLogados.add(rs.getString("NomeUsuario"));
                    }
                    System.out.println(usuariosLogados);
                    //fecha busca
                }
            }

            String sql2 = "SELECT * FROM medicoregulador WHERE NomeUsuario = ?";

            for (int i = 0; i < usuariosLogados.size(); i++) {

                MedicoRegulador medicoRegulador = new MedicoRegulador();
                try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql2)) {
                    preparedStatement.setString(1, usuariosLogados.get(i));
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            medicoRegulador.setCPFM(resultSet.getString("CPFM"));
                            medicoRegulador.setUsuario(resultSet.getString("NomeUsuario"));
                            medicoRegulador.setContato(resultSet.getInt("IdC"));
                            medicoRegulador.setEndereco(resultSet.getInt("IdE"));
                            medicoRegulador.setCRM(resultSet.getString("CRM"));
                            medicoRegulador.setNascimento(resultSet.getString("Nascimento"));
                            medicoRegulador.setRG(resultSet.getString("RG"));
                            medicoRegulador.setNome(resultSet.getString("Nome"));
                            medicoRegulador.setGenero(resultSet.getString("Genero"));
                            medicoRegulador.setSituacao(resultSet.getString("Situacao"));

                            medicoReguladorsOn.add(medicoRegulador);
                        }
                        //fecha busca
                    }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return medicoReguladorsOn;
    }
}
