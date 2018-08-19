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
    
    public String verificadoCpf(String cpf) {
        String cpfValidacao = null;

        try {

            String sql = "SELECT CPFM FROM motorista WHERE CPFM = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cpfValidacao = rs.getString("CPFM");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MotoristaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpfValidacao;
    }
    
    public String verificadoCnh(String cnh) {
        String cnhValidacao = null;

        try {

            String sql = "SELECT CNH FROM motorista WHERE CNH = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cnh);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cnhValidacao = rs.getString("CNH");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MotoristaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnhValidacao;
    }
    
    public String getCnhPadrao() {
        String cnh = null;

        try {

            String sql = "SELECT CNH FROM motorista";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {                

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cnh = rs.getString("CNH");
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MotoristaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnh;
    }
    
    public Motorista getMotorista(String cpf) {
        Motorista motorista = null;

        try {

            String sql = "SELECT * FROM motorista WHERE CPFM = ?";
            
            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {      
                    
                    motorista = new Motorista();
                    motorista.setCnh(rs.getString("CNH"));                                       
                    motorista.setIdC(rs.getInt("IdC"));
                    motorista.setIdE(rs.getInt("IdE"));
                    motorista.setCpfm(rs.getString("CPFM"));                    
                    motorista.setNascimento(rs.getString("Nascimento"));
                    motorista.setRg(rs.getString("RG"));
                    motorista.setNome(rs.getString("Nome"));
                    motorista.setGenero(rs.getString("Genero"));
                    motorista.setSituacao(rs.getString("Situacao"));                    
                    
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MotoristaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return motorista;
    }
    
    public int atualizarMotorista(Motorista motorista) {

        int confirmacao = 0;
        try {

            String sql = "UPDATE motorista SET CNH = ?, IdC = ?, IdE = ?, CPFM = ?, "
                    + "Nascimento = ?, RG = ?, Nome = ?, Genero = ?, Situacao = ? WHERE CPFM = ?";
                    
            
            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, motorista.getCnh());
                stmt.setInt(2, motorista.getIdC());
                stmt.setInt(3, motorista.getIdE());
                stmt.setString(4, motorista.getCpfm());
                stmt.setString(5, motorista.getNascimento());
                stmt.setString(6, motorista.getRg());
                stmt.setString(7, motorista.getNome());
                stmt.setString(8, motorista.getGenero());
                stmt.setString(9, motorista.getSituacao());
                stmt.setString(10, motorista.getCpfm());
                stmt.execute();

                confirmacao++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MotoristaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confirmacao;
    }
    
}
