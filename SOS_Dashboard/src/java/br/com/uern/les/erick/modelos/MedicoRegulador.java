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
public class MedicoRegulador {
    private String CPFM;
    private String usuario;
    private int idC;
    private int idE;
    private String CRM;
    private String nascimento;
    private String RG;
    private String nome;
    private String genero;
    private String situacao;

    public String getCPFM() {
        return CPFM;
    }

    public void setCPFM(String CPFM) {
        this.CPFM = CPFM;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int contato) {
        this.idC = contato;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int endereco) {
        this.idE = endereco;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
}
