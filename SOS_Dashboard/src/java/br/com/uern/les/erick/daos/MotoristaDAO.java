/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Motorista;
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
public class MotoristaDAO {
    
    private Connection connection;

    public MotoristaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public String inserindoMotorista(Motorista motorista){
        String cnh = null;

        try {
            String sql1 = "INSERT INTO motorista "
                    + "(CNH,IdC,IdE,CPFM,Nascimento,RG,Nome,Genero,Situacao)"
                    + " values (?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, motorista.getCnh());               
                stmt.setInt(2, motorista.getIdC());
                stmt.setInt(3, motorista.getIdE());
                stmt.setString(4, motorista.getCpfm());
                stmt.setString(5, motorista.getNascimento());
                stmt.setString(6, motorista.getRg());
                stmt.setString(7, motorista.getNome());
                stmt.setString(8, motorista.getGenero());
                stmt.setString(9, motorista.getSituacao());
                
                
                stmt.execute();
                
                String sql2 = "SELECT CNH FROM motorista WHERE CNH = ?";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                ps.setString(1, motorista.getCnh());
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    cnh = rs.getString("CNH");
                }

            }                        

        } catch (SQLException ex) {
            Logger.getLogger(MotoristaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnh;
    }
    
}
