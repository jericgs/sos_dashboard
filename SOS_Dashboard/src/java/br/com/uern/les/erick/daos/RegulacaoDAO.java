/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Regulacao;
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
public class RegulacaoDAO {

    private Connection connection;

    public RegulacaoDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserindoRegulacao(Regulacao regulacao) {
        int idR = 0;

        try {

            String sql1 = "INSERT INTO regulacao "
                    + "(IdRC,GE,GS,Atencao,Social,Tempo,GU,Status,TipoDeCaso,Mensagem)"
                    + " values (?,?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setInt(1, regulacao.getIdRC());
                stmt.setInt(2, regulacao.getGe());
                stmt.setInt(3, regulacao.getGs());
                stmt.setInt(4, regulacao.getAtencao());
                stmt.setInt(5, regulacao.getSocial());
                stmt.setInt(6, regulacao.getTempo());
                stmt.setInt(7, regulacao.getGu());
                stmt.setString(8, regulacao.getStatus());
                stmt.setString(9, regulacao.getTipoDeCaso());
                stmt.setString(10, regulacao.getMensagem());

                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM regulacao";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idR = rs.getInt("LAST_INSERT_ID()");
                }
            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(RegulacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idR;
    }

    public int verificarStatusRegulacao(int idRC) {

        int idR = 0;

        try {

            String sql = "SELECT IdR FROM regulacao WHERE IdRC = ? AND Status = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idRC);
                stmt.setString(2, "Andamento");

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    idR = rs.getInt("IdR");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegulacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idR;
    }

    public int getIdRegistroChamado(int idR) {

        int idRC = 0;

        try {

            String sql = "SELECT IdRC FROM regulacao WHERE IdR = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idR);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    idRC = rs.getInt("IdRC");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegulacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idRC;
    }

    public int atualizarRegulacao(int idR, String status, String tipoDeCaso, String mensagem) {        

        int confirmacao = 0;

        try {

            String sql = "UPDATE regulacao SET Status = ?, TipoDeCaso = ?, Mensagem = ? "
                    + "WHERE IdR = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, status);
                stmt.setString(2, tipoDeCaso);
                stmt.setString(3, mensagem);
                stmt.setInt(4, idR);

                stmt.execute();
                confirmacao++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegulacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return confirmacao;
    }
    
    public int atualizarRegulacaoInteligencia(Regulacao regulacao) {        

        int confirmacao = 0;

        try {

            String sql = "UPDATE regulacao SET GE = ?, GS = ?, Atencao = ?, Social = ?, Tempo = ?, GU = ? "
                    + "WHERE IdR = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, regulacao.getGe());
                stmt.setInt(2, regulacao.getGs());
                stmt.setInt(3, regulacao.getAtencao());
                stmt.setInt(4, regulacao.getSocial());
                stmt.setInt(5, regulacao.getTempo());
                stmt.setInt(6, regulacao.getGu());
                stmt.setInt(7, regulacao.getIdR());

                stmt.execute();
                confirmacao++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegulacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return confirmacao;
    }

}
