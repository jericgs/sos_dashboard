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
                stmt.setDouble(7, regulacao.getGu());
                stmt.setString(8, regulacao.getStatus());
                stmt.setString(9, regulacao.getTipoDeCaso());
                stmt.setString(10, regulacao.getMensagem());

                stmt.execute();
            }

            String sql2 = "SELECT IdR FROM regulacao WHERE IdRC = ? AND "
                    + "GE = ? AND GS = ? AND Atencao = ? AND Social = ? AND "
                    + "Tempo = ? AND GU = ? AND Status = ? AND TipoDeCaso = ? AND "
                    + "Mensagem = ?";

            try (PreparedStatement ps = this.connection.prepareStatement(sql2)) {
                ps.setInt(1, regulacao.getIdRC());
                ps.setInt(2, regulacao.getGe());
                ps.setInt(3, regulacao.getGs());
                ps.setInt(4, regulacao.getAtencao());
                ps.setInt(5, regulacao.getSocial());
                ps.setInt(6, regulacao.getTempo());
                ps.setDouble(7, regulacao.getGu());
                ps.setString(8, regulacao.getStatus());
                ps.setString(9, regulacao.getTipoDeCaso());
                ps.setString(10, regulacao.getMensagem());

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    idR = rs.getInt("IdR");
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

    public int atualizarRegulacao(int idR, String tipoDeCaso, String mensagem) {        

        int confirmacao = 0;

        try {

            String sql = "UPDATE regulacao SET Status = ?, TipoDeCaso = ?, Mensagem = ? "
                    + "WHERE IdR = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, "Concluído");
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

}
