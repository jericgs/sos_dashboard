/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.OcorrenciaSA;
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
public class OcorrenciasaDAO {

    private Connection connection;

    public OcorrenciasaDAO(Connection connection) {
        this.connection = connection;
    }

    
    public int inserindoOcorrencia(OcorrenciaSA ocorrencia) {
        int idOA = 0;

        try {

            String sql1 = "INSERT INTO ocorrenciasa "
                    + "(IdR,IdV,Placa,Medico,Enfermeiro,Auxiliar,Motorista,GravComprovada)"
                    + " values (?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setInt(1, ocorrencia.getIdR());
                stmt.setInt(2, ocorrencia.getIdV());
                stmt.setString(3, ocorrencia.getPlaca());
                stmt.setString(4, ocorrencia.getMedico());
                stmt.setString(5, ocorrencia.getEnfermeiro());
                stmt.setString(6, ocorrencia.getAuxiliar());
                stmt.setString(7, ocorrencia.getMotorista());
                stmt.setString(8, ocorrencia.getGravComprovada());                
                
                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM ocorrenciasa";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idOA = rs.getInt("LAST_INSERT_ID()");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idOA;
    }
    
}
