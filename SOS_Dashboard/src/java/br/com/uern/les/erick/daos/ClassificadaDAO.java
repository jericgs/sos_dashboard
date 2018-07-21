/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Classificada;
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
public class ClassificadaDAO {
    
    private Connection connection;

    public ClassificadaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Classificada buscandoClassificacao(int idR) {
        
        Classificada classificada = new Classificada();

        try {

            String sql = "SELECT * FROM classificada WHERE IdR = ?";
            try (PreparedStatement ps = this.connection.prepareStatement(sql)) {

                ps.setInt(1, idR);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    classificada.setIdC(rs.getInt("IdC"));                    
                    classificada.setIdR(rs.getInt("IdR"));
                    classificada.setTipoDeSuporte(rs.getString("TipoDeSuporte"));
                    classificada.setGrupoSindromico(rs.getString("GrupoSindromico"));
                    classificada.setNivelGravidade(rs.getString("NivelGravidade"));
                    
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassificadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return classificada;
    }
    
}
