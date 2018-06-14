/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.Tarm;
import java.sql.Connection;

/**
 *
 * @author jerick.gs
 */
public class TarmDAO {
    
    private Connection connection;
    
    public TarmDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Tarm getDadosTarm(String nomeUsuario){
        
        String sql = "";
        
        return null;
    }
}
