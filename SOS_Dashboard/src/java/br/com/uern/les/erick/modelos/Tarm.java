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
public class Tarm {
    
    private String CPFT;
    private String usuario;
    private int IdC;
    private int IdE;
    private String nascimento;
    private String RG;
    private String nome;
    private String genero;
    private String situacao;

    public String getCPFT() {
        return CPFT;
    }

    public void setCPFT(String CPFT) {
        this.CPFT = CPFT;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdC() {
        return IdC;
    }

    public void setIdC(int contato) {
        this.IdC = contato;
    }

    public int getIdE() {
        return IdE;
    }

    public void setIdE(int endereco) {
        this.IdE = endereco;
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
