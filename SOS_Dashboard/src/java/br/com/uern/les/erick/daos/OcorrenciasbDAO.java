/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.OcorrenciaSB;
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
public class OcorrenciasbDAO {
    
    private Connection connection;

    public OcorrenciasbDAO(Connection connection) {
        this.connection = connection;
    }
    
    public int inserindoOcorrencia(OcorrenciaSB ocorrencia) {
        int idOB = 0;

        try {

            String sql1 = "INSERT INTO ocorrenciasb "
                    + "(IdR,IdV,Placa,Auxiliar,Motorista,GravComprovada)"
                    + " values (?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setInt(1, ocorrencia.getIdR());
                stmt.setInt(2, ocorrencia.getIdV());
                stmt.setString(3, ocorrencia.getPlaca());
                stmt.setString(4, ocorrencia.getAuxiliar());
                stmt.setString(5, ocorrencia.getMotorista());
                stmt.setString(6, ocorrencia.getGravComprovada());                
                
                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM ocorrenciasb";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idOB = rs.getInt("LAST_INSERT_ID()");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciasbDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idOB;
    }
}
