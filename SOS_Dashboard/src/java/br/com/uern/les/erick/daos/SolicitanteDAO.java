/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Solicitante;
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
public class SolicitanteDAO {

    private Connection connection;

    public SolicitanteDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserirSolicitante(Solicitante solicitante) {

        int idSol = 0;

        try {

            String sql1 = "INSERT INTO solicitante "
                    + "(Nome,Tel)"
                    + " values (?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setString(1, solicitante.getNome());
                stmt.setString(2, solicitante.getTel());

                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM solicitante";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idSol = rs.getInt("LAST_INSERT_ID()");
                }
                
            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(SolicitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idSol;
    }
    
    public Solicitante getSolicitante(int idS) {

        Solicitante solicitante = null;

        try {

            String sql = "SELECT * FROM solicitante WHERE IdS = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idS);                

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //MODELO
                    solicitante = new Solicitante();
                    solicitante.setNome(rs.getString("Nome"));
                    solicitante.setTel(rs.getString("Tel"));                    
                }
            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(SolicitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return solicitante;
    }
    
    public int atualizarSolicitante(Solicitante solicitante) {

        int confirmacao = 0;
        try {

            String sql = "UPDATE solicitante SET Nome = ?, Tel = ? "
                    + "WHERE IdS = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, solicitante.getNome());
                stmt.setString(2, solicitante.getTel());
                stmt.setInt(3, solicitante.getIdS());
                stmt.execute();

                confirmacao++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SolicitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confirmacao;
    }
    
}
