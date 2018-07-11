/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

/**
 *
 * @author jerick.gs
 */
class GrauDeUrgencia {   

    public float calculoGrauDeUrgencia(float G, float A, float V, float T) {

        float U = 0;
        
        U = (G * A * V) / T;

        return U;
    }       
    
    public float calculoGravidade(float GE, float GS) {

        float gravidade = 0;
        
        gravidade = (GE + GS) / 2;

        return gravidade;
    }

}
