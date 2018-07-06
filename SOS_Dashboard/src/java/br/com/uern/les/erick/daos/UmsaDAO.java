/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.UMSA;
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
public class UmsaDAO {

    private Connection connection;

    public UmsaDAO(Connection connection) {
        this.connection = connection;
    }

    public UMSA getUnidadeMovel(String nomeUsuario) {

        UMSA umsa = null;

        try {

            String sql = "SELECT * FROM umsa WHERE NomeUsuario = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, nomeUsuario);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    //INSTÂNCIA
                    umsa = new UMSA();
                    umsa.setPlaca(rs.getString("Placa"));
                    umsa.setCnh(rs.getString("CNH"));
                    umsa.setCpfm(rs.getString("CPFM"));
                    umsa.setCpfe(rs.getString("CPFE"));
                    umsa.setCpfa(rs.getString("CPFA"));
                    umsa.setNomeUsuario(rs.getString("NomeUsuario"));
                    umsa.setIdG(rs.getInt("IdG"));
                    umsa.setNome(rs.getString("Nome"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return umsa;

    }
    
    public UMSA getUnidadeMovelP(String placa) {

        UMSA umsa = null;

        try {

            String sql = "SELECT * FROM umsa WHERE Placa = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, placa);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    //INSTÂNCIA
                    umsa = new UMSA();
                    umsa.setPlaca(rs.getString("Placa"));
                    umsa.setCnh(rs.getString("CNH"));
                    umsa.setCpfm(rs.getString("CPFM"));
                    umsa.setCpfe(rs.getString("CPFE"));
                    umsa.setCpfa(rs.getString("CPFA"));
                    umsa.setNomeUsuario(rs.getString("NomeUsuario"));
                    umsa.setIdG(rs.getInt("IdG"));
                    umsa.setNome(rs.getString("Nome"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return umsa;

    }

    public int verificarSuport(String placa) {

        int existe = 0;

        try {

            String sql = "SELECT * FROM umsa WHERE Placa = ?";

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, placa);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                if(!rs.getString("Placa").isEmpty()){
                    existe++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

}
