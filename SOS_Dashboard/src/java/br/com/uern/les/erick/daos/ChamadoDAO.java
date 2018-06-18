/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

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
public class ChamadoDAO {

    private Connection connection;

    public ChamadoDAO(Connection connection) {
        this.connection = connection;
    }

    public int getNumeroDeChamado(String DataMomento) {

        int numChamado = 0;
        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE DataDeRegistro = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);

            ResultSet rs = ps.executeQuery();            

            while (rs.next()) {
                numChamado = rs.getInt("COUNT('NumChamado')");                
            }
            
            numChamado++;
                        

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamado;

    }
}
