/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.SinaisVitais;
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
public class SinaisVitaisDAO {

    private Connection connection;

    public SinaisVitaisDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserindoSinaisVitais(SinaisVitais sinaisVitais) {
        int idV = 0;

        try {

            String sql1 = "INSERT INTO sinaisvitais "
                    + "(Pa,Fc,Fr,SatSemSuport,SatComSuport,Temperatura,HGT,Glasgow)"
                    + " values (?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setString(1, sinaisVitais.getPa());
                stmt.setString(2, sinaisVitais.getFc());
                stmt.setString(3, sinaisVitais.getFr());
                stmt.setString(4, sinaisVitais.getSatSemSuport());
                stmt.setString(5, sinaisVitais.getSatComSuport());
                stmt.setString(6, sinaisVitais.getTemperatura());
                stmt.setString(7, sinaisVitais.getHgt());
                stmt.setString(8, sinaisVitais.getGlasgow());
                
                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM sinaisvitais";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idV = rs.getInt("LAST_INSERT_ID()");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinaisVitaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idV;
    }

}
