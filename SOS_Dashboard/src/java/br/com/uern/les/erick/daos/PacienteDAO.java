/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Paciente;
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
public class PacienteDAO {

    private Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserirPaciente(Paciente paciente) {

        int idPacient = 0;

        try {

            String sql1 = "INSERT INTO paciente "
                    + "(Nome,Idade)"
                    + " values (?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setString(1, paciente.getNome());
                stmt.setString(2, paciente.getIdade());

                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM paciente";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idPacient = rs.getInt("LAST_INSERT_ID()");
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idPacient;
    }

    public Paciente getPacienteRegulacao(int idP) {

        Paciente paciente = new Paciente();

        try {

            String sql = "SELECT SUBSTRING_INDEX(SUBSTRING_INDEX(Nome, ' ', 1), ' ', -1) AS "
                    + "PrimeiroNome, Idade FROM paciente WHERE IdP = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idP);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    paciente.setNome(rs.getString("PrimeiroNome"));
                    paciente.setIdade(rs.getString("Idade"));                
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paciente;

    }
    
    public Paciente getPacienteRegulacaoI(int idP) {

        Paciente paciente = new Paciente();

        try {

            String sql = "SELECT Nome, Idade FROM paciente WHERE IdP = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idP);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    paciente.setNome(rs.getString("Nome"));
                    paciente.setIdade(rs.getString("Idade"));                
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paciente;

    }
    
    public int atualizarPaciente(Paciente paciente) {

        int confirmacao = 0;
        try {

            String sql = "UPDATE paciente SET Nome = ?, Idade = ? "
                    + "WHERE IdP = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, paciente.getNome());
                stmt.setString(2, paciente.getIdade());
                stmt.setInt(3, paciente.getIdP());
                stmt.execute();

                confirmacao++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confirmacao;
    }

}
