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
public class OcorrenciaSB {
    
    private int idOB;
    private int idR;
    private int idV;
    private String placa;
    private String auxiliar;
    private String motorista;
    private String gravComprovada;

    public int getIdOB() {
        return idOB;
    }

    public void setIdOB(int idOB) {
        this.idOB = idOB;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getGravComprovada() {
        return gravComprovada;
    }

    public void setGravComprovada(String gravComprovada) {
        this.gravComprovada = gravComprovada;
    }
            
}
