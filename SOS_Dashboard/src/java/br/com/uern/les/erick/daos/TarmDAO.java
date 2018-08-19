/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Tarm;
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
public class TarmDAO {

    private Connection connection;

    public TarmDAO(Connection connection) {
        this.connection = connection;
    }

    public Tarm getDadosTarm(String nomeUsuario) {

        try {
            String sql = "SELECT * FROM tarm WHERE NomeUsuario = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, nomeUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // criando o objeto Tarm
                Tarm tarmDados = new Tarm();
                tarmDados.setCPFT(rs.getString("CPFT"));
                tarmDados.setUsuario(rs.getString("NomeUsuario"));
                tarmDados.setIdC(rs.getInt("IdC"));
                tarmDados.setIdE(rs.getInt("IdE"));
                tarmDados.setNascimento(rs.getString("Nascimento"));
                tarmDados.setRG(rs.getString("RG"));
                tarmDados.setNome(rs.getString("Nome"));
                tarmDados.setGenero(rs.getString("Genero"));
                tarmDados.setSituacao(rs.getString("Situacao"));

                //fecha busca
                rs.close();
                ps.close();

                // adicionando o objeto à lista
                return tarmDados;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String inserindoTarm(Tarm tarm){
        String cpft = null;

        try {
            String sql1 = "INSERT INTO tarm "
                    + "(CPFT,NomeUsuario,IdC,IdE,Nascimento,RG,Nome,Genero,Situacao)"
                    + " values (?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, tarm.getCPFT());
                stmt.setString(2, tarm.getUsuario());
                stmt.setInt(3, tarm.getIdC());
                stmt.setInt(4, tarm.getIdE());                
                stmt.setString(5, tarm.getNascimento());
                stmt.setString(6, tarm.getRG());
                stmt.setString(7, tarm.getNome());
                stmt.setString(8, tarm.getGenero());
                stmt.setString(9, tarm.getSituacao());
                                
                stmt.execute();
                
                String sql2 = "SELECT CPFT FROM tarm WHERE CPFT = ?";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                ps.setString(1, tarm.getCPFT());
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    cpft = rs.getString("CPFT");
                }

            }                        

        } catch (SQLException ex) {
            Logger.getLogger(TarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpft;
    }
    
    public String verificadoCpf(String cpf) {
        String cpfValidacao = null;

        try {

            String sql = "SELECT CPFT FROM tarm WHERE CPFT = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cpfValidacao = rs.getString("CPFT");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpfValidacao;
    }
    
    public Tarm getTarm(String cpf) {
        Tarm tarm = null;

        try {

            String sql = "SELECT * FROM tarm WHERE CPFT = ?";
            
            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {      
                    
                    tarm = new Tarm();
                    tarm.setCPFT(rs.getString("CPFT")); 
                    tarm.setUsuario(rs.getString("NomeUsuario"));
                    tarm.setIdC(rs.getInt("IdC"));
                    tarm.setIdE(rs.getInt("IdE"));                    
                    tarm.setNascimento(rs.getString("Nascimento"));
                    tarm.setRG(rs.getString("RG"));
                    tarm.setNome(rs.getString("Nome"));
                    tarm.setGenero(rs.getString("Genero"));
                    tarm.setSituacao(rs.getString("Situacao"));                    
                    
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tarm;
    }
    
    public int atualizarTarm(Tarm tarm) {

        int confirmacao = 0;
        try {

            String sql = "UPDATE tarm SET CPFT = ?, IdC = ?, IdE = ?, Nascimento = ?, "
                    + "RG = ?, Nome = ?, Genero = ?, Situacao = ? WHERE CPFT = ?";
                    
            
            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, tarm.getCPFT());
                stmt.setInt(2, tarm.getIdC());
                stmt.setInt(3, tarm.getIdE());
                stmt.setString(4, tarm.getNascimento());
                stmt.setString(5, tarm.getRG());
                stmt.setString(6, tarm.getNome());
                stmt.setString(7, tarm.getGenero());
                stmt.setString(8, tarm.getSituacao());                
                stmt.setString(9, tarm.getCPFT());
                stmt.execute();

                confirmacao++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confirmacao;
    }
    
}
