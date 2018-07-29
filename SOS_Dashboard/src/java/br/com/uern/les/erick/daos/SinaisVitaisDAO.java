/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.SinaisVitais;
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
public class SinaisVitaisDAO {

    private Connection connection;

    public SinaisVitaisDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserindoSinaisVitais(SinaisVitais sinaisVitais) {
        int idV = 0;

        try {

            String sql1 = "INSERT INTO sinaisvitais "
                    + "(Pa,Fc,Fr,SatSemSuport,SatComSuport,Temperatura,HGT,Glasgow)"
                    + " values (?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setString(1, sinaisVitais.getPa());
                stmt.setString(2, sinaisVitais.getFc());
                stmt.setString(3, sinaisVitais.getFr());
                stmt.setString(4, sinaisVitais.getSatSemSuport());
                stmt.setString(5, sinaisVitais.getSatComSuport());
                stmt.setString(6, sinaisVitais.getTemperatura());
                stmt.setString(7, sinaisVitais.getHgt());
                stmt.setString(8, sinaisVitais.getGlasgow());

                stmt.execute();

                String sql2 = "SELECT LAST_INSERT_ID() FROM sinaisvitais";

                PreparedStatement ps = this.connection.prepareStatement(sql2);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    idV = rs.getInt("LAST_INSERT_ID()");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinaisVitaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idV;
    }

    public int atualizarSinaisVitais(SinaisVitais sinaisVitais) {
        int confirmacao = 0;

        try {

            String sql = "UPDATE regulacao SET Pa = ?, Fc = ?, Fr = ?, SatSemSuport = ?, SatComSuport = ?, "
                    + "Temperatura = ?, HGT = ?, Glasgow = ? WHERE IdV = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, sinaisVitais.getPa());
                stmt.setString(2, sinaisVitais.getFc());
                stmt.setString(3, sinaisVitais.getFr());
                stmt.setString(4, sinaisVitais.getSatSemSuport());
                stmt.setString(5, sinaisVitais.getSatComSuport());
                stmt.setString(6, sinaisVitais.getTemperatura());
                stmt.setString(7, sinaisVitais.getHgt());
                stmt.setString(8, sinaisVitais.getGlasgow());
                stmt.setInt(9, sinaisVitais.getIdV());
                stmt.execute();

                confirmacao++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinaisVitaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return confirmacao;
    }

    public SinaisVitais buscandoSinaisVitais(int idV) {
        SinaisVitais sinaisVitais = null;

        try {

            String sql = "SELECT * FROM sinaisvitais WHERE IdV = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idV);
                stmt.execute();

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    
                    //MODELO SINAIS VITAIS
                    sinaisVitais = new SinaisVitais();
                    sinaisVitais.setPa(rs.getString("Pa"));
                    sinaisVitais.setFc(rs.getString("Fc"));
                    sinaisVitais.setFr(rs.getString("Fr"));
                    sinaisVitais.setSatComSuport(rs.getString("SatSemSuport"));
                    sinaisVitais.setSatSemSuport(rs.getString("SatComSuport"));
                    sinaisVitais.setTemperatura(rs.getString("Temperatura"));
                    sinaisVitais.setHgt(rs.getString("HGT"));
                    sinaisVitais.setGlasgow(rs.getString("Glasgow"));
                                        
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinaisVitaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sinaisVitais;
    }

}
