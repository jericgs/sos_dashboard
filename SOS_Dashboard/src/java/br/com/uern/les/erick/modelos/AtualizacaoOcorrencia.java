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
public class AtualizacaoOcorrencia extends RegistroChamado{
    
    private int idR;
    private int idRC;    
    private String nomePaciente;
    private String idadePaciente;    
    private String nomeSolicitante;
    private String telSolicitante;
    private int quantEndereco;
    private Endereco endereco1;
    private Endereco endereco2;

    public int getQuantEndereco() {
        return quantEndereco;
    }

    public void setQuantEndereco(int quantEndereco) {
        this.quantEndereco = quantEndereco;
    }
       
    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public int getIdRC() {
        return idRC;
    }

    public void setIdRC(int idRC) {
        this.idRC = idRC;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getIdadePaciente() {
        return idadePaciente;
    }

    public void setIdadePaciente(String idadePaciente) {
        this.idadePaciente = idadePaciente;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getTelSolicitante() {
        return telSolicitante;
    }

    public void setTelSolicitante(String telSolicitante) {
        this.telSolicitante = telSolicitante;
    }

    public Endereco getEndereco1() {
        return endereco1;
    }

    public void setEndereco1(Endereco endereco1) {
        this.endereco1 = endereco1;
    }

    public Endereco getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(Endereco endereco2) {
        this.endereco2 = endereco2;
    }
            
}
