/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.teste;

import br.com.uern.les.erick.conexao.ConexaoBD;
import br.com.uern.les.erick.daos.MedicoDAO;
import br.com.uern.les.erick.modelos.MedicoRegulador;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class test {

    public List<MedicoRegulador> getMedicos() {
        //Teste MedicoDao
        List<MedicoRegulador> medicoReguladorsOn = new ArrayList<MedicoRegulador>();
        String tipoDeUsuario = "Médico";

        Connection connection;
        try {
            connection = new ConexaoBD().getConnection();
            MedicoDAO mdao = new MedicoDAO(connection);
            medicoReguladorsOn = mdao.getMedicoRegulador();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return medicoReguladorsOn;
    }
}
