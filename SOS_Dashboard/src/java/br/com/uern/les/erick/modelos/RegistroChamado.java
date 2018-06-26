/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.modelos;

/**
 *
 * @author jerick.gs
 */
public class RegistroChamado {
    
    private String cpft;
    private String cpfm;
    private int idS;
    private int idP;
    private int numChamado;
    private String hora;
    private String dataDeRegistro;
    private String queixa;
    private String motivo;

    public String getCpft() {
        return cpft;
    }

    public void setCpft(String cpft) {
        this.cpft = cpft;
    }

    public String getCpfm() {
        return cpfm;
    }

    public void setCpfm(String cpfm) {
        this.cpfm = cpfm;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getNumChamado() {
        return numChamado;
    }

    public void setNumChamado(int numChamado) {
        this.numChamado = numChamado;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(String dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
        
}
