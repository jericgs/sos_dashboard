/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.UMSB;
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
public class UmsbDAO {

    private Connection connection;

    public UmsbDAO(Connection connection) {
        this.connection = connection;
    }

    public UMSB getUnidadeMovel(String nomeUsuario) {

        UMSB umsb = null;

        try {

            String sql = "SELECT * FROM umsb WHERE NomeUsuario = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, nomeUsuario);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {                                        
                    
                    //INSTÂNCIA
                    umsb = new UMSB();
                    umsb.setPlaca(rs.getString("Placa"));
                    umsb.setCnh(rs.getString("CNH"));
                    umsb.setCpfa(rs.getString("CPFA"));
                    umsb.setIdG(rs.getInt("IdG"));
                    umsb.setNomeUsuario(rs.getString("NomeUsuario"));
                    umsb.setNome(rs.getString("Nome"));
                                        
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsbDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return umsb;

    }
    
    public UMSB getUnidadeMovelP(String placa) {

        UMSB umsb = null;

        try {

            String sql = "SELECT * FROM umsb WHERE Placa = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, placa);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {                                        
                    
                    //INSTÂNCIA
                    umsb = new UMSB();
                    umsb.setPlaca(rs.getString("Placa"));
                    umsb.setCnh(rs.getString("CNH"));
                    umsb.setCpfa(rs.getString("CPFA"));
                    umsb.setIdG(rs.getInt("IdG"));
                    umsb.setNomeUsuario(rs.getString("NomeUsuario"));
                    umsb.setNome(rs.getString("Nome"));
                                        
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsbDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return umsb;

    }
    
    public int verificarSuport(String placa) {

        int existe = 0;

        try {

            String sql = "SELECT * FROM umsb WHERE Placa = ?";

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, placa);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                if(!rs.getString("Placa").isEmpty()){
                    existe++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsbDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

}
