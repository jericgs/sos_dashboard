/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.daos;

import br.com.uern.les.erick.modelos.PossuiTabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class PossuiDAO {

    private Connection connection;

    public PossuiDAO(Connection connection) {
        this.connection = connection;
    }

    public int inserirPossui(PossuiTabela pt) {

        int result = 0;

        try {

            String sql1 = "INSERT INTO possui "
                    + "(IdP,IdE)"
                    + " values (?,?)";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setInt(1, pt.getIdP());
                stmt.setInt(2, pt.getIdE());

                stmt.execute();
                result = 1;
            }                        

        } catch (SQLException ex) {
            Logger.getLogger(PossuiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    public List<String> buscandoEnderecos(int idP) {

        List<String> listDeIdEs = null;

        try {

            listDeIdEs = new ArrayList<>();            
            String sql1 = "SELECT IdE FROM possui WHERE IdP = ?";

            try (PreparedStatement stmt = this.connection.prepareStatement(sql1)) {
                stmt.setInt(1, idP);                

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                                                                                
                    listDeIdEs.add(String.valueOf(rs.getInt("IdE")));

                }
            }                        

        } catch (SQLException ex) {
            Logger.getLogger(PossuiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDeIdEs;
    }
}
