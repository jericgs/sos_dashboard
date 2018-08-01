/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Chamado;
import br.com.uern.les.erick.modelos.RegistroChamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class ChamadoDAO {

    private Connection connection;

    public ChamadoDAO(Connection connection) {
        this.connection = connection;
    }

    public int getNumeroDeChamado(String DataMomento) {

        int numChamado = 0;

        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE DataDeRegistro = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                numChamado = rs.getInt("COUNT('NumChamado')");
            }

            numChamado++;

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamado;

    }

    public int getNumChamadoSocorro(String DataMomento) {

        int numChamadoSocorro = 0;

        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE DataDeRegistro = ? AND Motivo = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);
            ps.setString(2, "Socorro");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                numChamadoSocorro = rs.getInt("COUNT('NumChamado')");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamadoSocorro;

    }

    public int getNumChamadoTransporte(String DataMomento) {

        int numChamadoTransporte = 0;

        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE DataDeRegistro = ? AND Motivo = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);
            ps.setString(2, "Transporte");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                numChamadoTransporte = rs.getInt("COUNT('NumChamado')");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamadoTransporte;

    }

    public int getNumChamadoInformacao(String DataMomento) {

        int numChamadoInformacao = 0;

        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE DataDeRegistro = ? AND Motivo = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);
            ps.setString(2, "Informação");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                numChamadoInformacao = rs.getInt("COUNT('NumChamado')");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamadoInformacao;

    }

    public int getNumChamadoMes(String DataMomento) {

        int numChamadoMes = 0;

        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE SUBSTRING(DataDeRegistro, 4, 10) = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                numChamadoMes = rs.getInt("COUNT('NumChamado')");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamadoMes;

    }

    public int inserindoChamado(RegistroChamado registroChamado) {

        int idRC = 0;

        try {
            String sql1 = "INSERT INTO registrodechamado "
                    + "(CPFT,CPFM,IdS,IdP,NumChamado,Hora,DataDeRegistro,Queixa,Motivo)"
                    + " values (?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1);) {

                stmt.setString(1, registroChamado.getCpft());
                stmt.setString(2, registroChamado.getCpfm());
                stmt.setInt(3, registroChamado.getIdS());
                stmt.setInt(4, registroChamado.getIdP());
                stmt.setInt(5, registroChamado.getNumChamado());
                stmt.setString(6, registroChamado.getHora());
                stmt.setString(7, registroChamado.getDataDeRegistro());
                stmt.setString(8, registroChamado.getQueixa());
                stmt.setString(9, registroChamado.getMotivo());

                stmt.execute();
                
                String sql2 = "SELECT LAST_INSERT_ID() FROM registrodechamado";
                
                PreparedStatement ps = this.connection.prepareStatement(sql2);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    idRC = rs.getInt("LAST_INSERT_ID()");
                }

            }                        

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idRC;
    }

    public int getNumDeChamado(String DataMomento) {

        int numChamado = 0;

        try {

            String sql = "SELECT COUNT('NumChamado') FROM registrodechamado WHERE DataDeRegistro = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, DataMomento);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                numChamado = rs.getInt("COUNT('NumChamado')");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numChamado;

    }

    public List<Chamado> getListaDeChamados(String cpfm) {

        List<Chamado> lisChamadosDoMedico = new ArrayList<>();

        try {
            String sql = "SELECT IdRC, IdP, Hora, Motivo, Queixa FROM registrodechamado WHERE CPFM = ? "
                    + "ORDER BY IdRC ASC";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpfm);                                                
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    
                    //INSTÂNCIO O MODELO E CRIO O CHAMADOMEDICO
                    Chamado chamadoMedico =  new Chamado();
                    chamadoMedico.setIdRC(rs.getInt("IdRC"));
                    chamadoMedico.setIdP(rs.getInt("IdP"));
                    chamadoMedico.setHora(rs.getString("Hora"));
                    chamadoMedico.setMotivo(rs.getString("Motivo"));
                    chamadoMedico.setQueixa(rs.getString("Queixa"));
                    
                    lisChamadosDoMedico.add(chamadoMedico);
                    
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lisChamadosDoMedico;
    }
    
    public Chamado getChamado(int idRC) {

        //INSTÂNCIO O MODELO E CRIO O CHAMADOMEDICO
        Chamado chamadoMedico = new Chamado();

        try {
            String sql = "SELECT IdP, Motivo, Queixa FROM registrodechamado WHERE IdRC = ?";                    

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setInt(1, idRC);                                              
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {                                        
                                        
                    chamadoMedico.setIdP(rs.getInt("IdP"));                    
                    chamadoMedico.setMotivo(rs.getString("Motivo"));
                    chamadoMedico.setQueixa(rs.getString("Queixa"));
                    
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chamadoMedico;
    }
    
    public List<Chamado> getListaDeChamadosTarm(String cpft) {

        List<Chamado> lisChamadosDoTarm = new ArrayList<>();

        try {
            String sql = "SELECT IdRC, IdP, Hora, Motivo, Queixa FROM registrodechamado WHERE CPFT = ? "
                    + "ORDER BY IdRC ASC";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                stmt.setString(1, cpft);                                                
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    
                    //INSTÂNCIO O MODELO E CRIO O CHAMADOMEDICO
                    Chamado chamadoTarm =  new Chamado();
                    chamadoTarm.setIdRC(rs.getInt("IdRC"));
                    chamadoTarm.setIdP(rs.getInt("IdP"));
                    chamadoTarm.setHora(rs.getString("Hora"));
                    chamadoTarm.setMotivo(rs.getString("Motivo"));
                    chamadoTarm.setQueixa(rs.getString("Queixa"));
                    
                    lisChamadosDoTarm.add(chamadoTarm);
                    
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lisChamadosDoTarm;
    }
    
}
