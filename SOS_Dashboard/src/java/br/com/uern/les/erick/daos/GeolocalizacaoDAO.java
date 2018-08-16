/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Geolocalizacao;
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
public class GeolocalizacaoDAO {
    
    private Connection connection;

    public GeolocalizacaoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public int inserindoGeolocalizacao(Geolocalizacao geolocalizacao){
        int idG = 0;

        try {
            String sql1 = "INSERT INTO geolocalizacao "
                    + "(Latitude,Longitude)"
                    + " values (?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setDouble(1, geolocalizacao.getLatitude()); 
                stmt.setDouble(2, geolocalizacao.getLongitude());                                                
                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM geolocalizacao";
                PreparedStatement ps = this.connection.prepareStatement(sql2);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    idG = rs.getInt("LAST_INSERT_ID()");
                }

            }                        

        } catch (SQLException ex) {
            Logger.getLogger(GeolocalizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idG;
    }
    
}
