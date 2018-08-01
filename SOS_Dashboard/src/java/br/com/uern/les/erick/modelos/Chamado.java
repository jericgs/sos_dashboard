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
public class Chamado {
    
    private int idRC;
    private int idP;
    private String hora;
    private String motivo;
    private String queixa;

    public int getIdRC() {
        return idRC;
    }

    public void setIdRC(int idRC) {
        this.idRC = idRC;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }
                
}
