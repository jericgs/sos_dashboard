/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Enfermeiro;
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
public class EnfermeiroDAO {
    
    private Connection connection;

    public EnfermeiroDAO(Connection connection) {
        this.connection = connection;
    }
    
    public String inserindoEnfermeiro(Enfermeiro enfermeiro){
        String idE = null;

        try {
            String sql1 = "INSERT INTO enfermeiro "
                    + "(CPFE,IdC,IdE,Nascimento,RG,Nome,Genero,Situacao,Coren)"
                    + " values (?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, enfermeiro.getCpfe());
                stmt.setInt(2, enfermeiro.getIdC());
                stmt.setInt(3, enfermeiro.getIdE());
                stmt.setString(4, enfermeiro.getNascimento());
                stmt.setString(5, enfermeiro.getRg());
                stmt.setString(6, enfermeiro.getNome());
                stmt.setString(7, enfermeiro.getGenero());
                stmt.setString(8, enfermeiro.getSituacao());
                stmt.setString(9, enfermeiro.getNumCoren());
                
                stmt.execute();
                
                String sql2 = "SELECT CPFE FROM enfermeiro WHERE CPFE = ?";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                ps.setString(1, enfermeiro.getCpfe());
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idE = rs.getString("CPFE");
                }

            }                        

        } catch (SQLException ex) {
            Logger.getLogger(EnfermeiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idE;
    }
    
    public String verificadoCpf(String cpf) {
        String cpfValidacao = null;

        try {

            String sql = "SELECT CPFE FROM enfermeiro WHERE CPFE = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cpfValidacao = rs.getString("CPFE");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnfermeiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpfValidacao;
    }
    
    public String getCpfePadrao() {
        String cpfe = null;

        try {

            String sql = "SELECT CPFE FROM enfermeiro";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cpfe = rs.getString("CPFE");
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnfermeiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpfe;
    }
    
}
