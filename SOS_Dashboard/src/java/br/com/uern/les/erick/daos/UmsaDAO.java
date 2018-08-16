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
    
    public String verificandoNomeAmbulancia(String nome) {
        String nomeConfirmacao = null;

        try {

            String sql = "SELECT Nome FROM umsa WHERE Nome = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, nome);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    nomeConfirmacao = rs.getString("Nome");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UmsaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nomeConfirmacao;
    }
    
    public String inserindoUmsa(UMSA umsa){
        String placa = null;

        try {
            String sql1 = "INSERT INTO umsa "
                    + "(Placa,CNH,CPFM,CPFE,CPFA,NomeUsuario,IdG,Nome)"
                    + " values (?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, umsa.getPlaca());
                stmt.setString(2, umsa.getCnh());
                stmt.setString(3, umsa.getCpfm());
                stmt.setString(4, umsa.getCpfe());                
                stmt.setString(5, umsa.getCpfa());
                stmt.setString(6, umsa.getNomeUsuario());
                stmt.setInt(7, umsa.getIdG());
                stmt.setString(8, umsa.getNome());
                                
                stmt.execute();
                
                String sql2 = "SELECT Placa FROM umsa WHERE Placa = ?";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                ps.setString(1, umsa.getPlaca());
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    placa = rs.getString("Placa");
                }

            }                        

        } catch (SQLException ex) {
            Logger.getLogger(UmsaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return placa;
    }

}
