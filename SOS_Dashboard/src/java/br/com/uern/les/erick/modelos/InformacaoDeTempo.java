/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jerick.gs
 */
 

public class InformacaoDeTempo {

    public String getDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getHora(){
        
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");        
        Date hora = new Date();       
        return dateFormat.format(hora);

    }
}
