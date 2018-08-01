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
public class ListaAndamento {
    private int idR;
    private int idRC;
    private int idP;
    private String nome;
    private String idade;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }        

    public int getIdRC() {
        return idRC;
    }

    public void setIdRC(int idRC) {
        this.idRC = idRC;
    }        

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
    
    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
            
}
