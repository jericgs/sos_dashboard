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

    public List<MedicoRegulador> getMedicoRegulador() {

        List<String> usuariosLogados = new ArrayList<String>();
        List<MedicoRegulador> medicoReguladorsOn = new ArrayList<MedicoRegulador>();        

        try {

            String sql1 = "SELECT NomeUsuario FROM usuario WHERE Status = ? AND TipoDeUsuario = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql1);
            ps.setString(1, "Online");
            ps.setString(2, "Médico");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                usuariosLogados.add(rs.getString("NomeUsuario"));
            }

            System.out.println(usuariosLogados);
            //fecha busca
            rs.close();
            ps.close();
                        
            String sql2 = "SELECT * FROM medicoregulador WHERE NomeUsuario = ?";

            for (int i = 0; i < usuariosLogados.size(); i++) {
                                                
                MedicoRegulador medicoRegulador = new MedicoRegulador();
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql2);
                preparedStatement.setString(1, usuariosLogados.get(i));
                ResultSet resultSet = preparedStatement.executeQuery();

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
                resultSet.close();
                preparedStatement.close();
            }

            return medicoReguladorsOn;

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
