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
    
    public int inserirPaciente(Paciente paciente){
        
        int idPacient = 0;
        
        try {

            String sql1 = "INSERT INTO paciente "
                    + "(Nome,Idade)"
                    + " values (?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setString(1, paciente.getNome());
                stmt.setString(2, paciente.getIdade());

                stmt.execute();
            }

            String sql2 = "SELECT IdP FROM paciente WHERE Nome = ? AND Idade = ?";

            try (PreparedStatement ps = this.connection.prepareStatement(sql2)) {
                ps.setString(1, paciente.getNome());
                ps.setString(2, paciente.getIdade());

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    idPacient = rs.getInt("IdP");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idPacient;        
    }
}
