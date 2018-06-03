/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.filtro;

import br.com.uern.les.erick.conexao.ConexaoBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author jerick.gs
 */
@WebFilter(filterName = "FiltroConexao", urlPatterns = {"/*"})
public class FiltroConexaoBD implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        try {
            Connection connection = new ConexaoBD().getConnection();
            // pendurando a connection na requisição
            request.setAttribute("conexao", connection);
            chain.doFilter(request, response);
            connection.close();
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FiltroConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    public void init(FilterConfig filterConfig) {

    }
}
