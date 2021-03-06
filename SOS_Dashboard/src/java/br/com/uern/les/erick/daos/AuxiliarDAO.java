/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Auxiliar;
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
public class AuxiliarDAO {

    private Connection connection;

    public AuxiliarDAO(Connection connection) {
        this.connection = connection;
    }

    public String inserindoAuxiliar(Auxiliar auxiliar) {
        String idA = null;

        try {
            String sql1 = "INSERT INTO auxiliar "
                    + "(CPFA,IdC,IdE,Nascimento,RG,Nome,Genero,Situacao,Coren)"
                    + " values (?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, auxiliar.getCpfa());
                stmt.setInt(2, auxiliar.getIdC());
                stmt.setInt(3, auxiliar.getIdE());
                stmt.setString(4, auxiliar.getNascimento());
                stmt.setString(5, auxiliar.getRg());
                stmt.setString(6, auxiliar.getNome());
                stmt.setString(7, auxiliar.getGenero());
                stmt.setString(8, auxiliar.getSituacao());
                stmt.setString(9, auxiliar.getNumCoren());

                stmt.execute();

                String sql2 = "SELECT CPFA FROM auxiliar WHERE CPFA = ?";

                PreparedStatement ps = this.connection.prepareStatement(sql2);
                ps.setString(1, auxiliar.getCpfa());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    idA = rs.getString("CPFA");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(AuxiliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idA;
    }

    public String verificadoCpf(String cpf) {
        String cpfValidacao = null;

        try {

            String sql = "SELECT CPFA FROM auxiliar WHERE CPFA = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cpfValidacao = rs.getString("CPFA");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuxiliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpfValidacao;
    }

    public String getCpfaPadrao() {
        String cpfa = null;

        try {

            String sql = "SELECT CPFA FROM auxiliar";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    cpfa = rs.getString("CPFA");
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuxiliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cpfa;
    }

    public Auxiliar getAuxiliar(String cpf) {
        Auxiliar auxiliar = null;

        try {

            String sql = "SELECT * FROM auxiliar WHERE CPFA = ?";
            
            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpf);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {      
                    
                    auxiliar = new Auxiliar();
                    auxiliar.setCpfa(rs.getString("CPFA"));
                    auxiliar.setIdC(rs.getInt("IdC"));
                    auxiliar.setIdE(rs.getInt("IdE"));
                    auxiliar.setNascimento(rs.getString("Nascimento"));
                    auxiliar.setRg(rs.getString("RG"));
                    auxiliar.setNome(rs.getString("Nome"));
                    auxiliar.setGenero(rs.getString("Genero"));
                    auxiliar.setSituacao(rs.getString("Situacao"));
                    auxiliar.setNumCoren(rs.getString("Coren"));
                    
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AuxiliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return auxiliar;
    }
    
    public int atualizarAuxiliar(Auxiliar auxiliar, String cpf) {

        int confirmacao = 0;
        try {

            String sql = "UPDATE auxiliar SET CPFA = ?, IdC = ?, IdE = ?, Nascimento = ?, "
                    + "RG = ?, Nome = ?, Genero = ?, Situacao = ?, Coren = ? WHERE CPFA = ?";
                    
            
            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, auxiliar.getCpfa());
                stmt.setInt(2, auxiliar.getIdC());
                stmt.setInt(3, auxiliar.getIdE());
                stmt.setString(4, auxiliar.getNascimento());
                stmt.setString(5, auxiliar.getRg());
                stmt.setString(6, auxiliar.getNome());
                stmt.setString(7, auxiliar.getGenero());
                stmt.setString(8, auxiliar.getSituacao());
                stmt.setString(9, auxiliar.getNumCoren());
                stmt.setString(10, cpf);
                stmt.execute();

                confirmacao++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AuxiliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confirmacao;
    }

}
