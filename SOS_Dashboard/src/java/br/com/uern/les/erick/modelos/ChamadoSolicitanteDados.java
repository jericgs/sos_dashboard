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
public class ChamadoSolicitanteDados {

    private String numChamado;
    private String data;
    private String hora;
    private String nome;
    private String tel;
    private String medicoCPF;
    private String motivo;

    public String getNumChamado() {
        return numChamado;
    }

    public void setNumChamado(String numChamado) {
        this.numChamado = numChamado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMedicoCPF() {
        return medicoCPF;
    }

    public void setMedicoCPF(String medicoCPF) {
        this.medicoCPF = medicoCPF;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
