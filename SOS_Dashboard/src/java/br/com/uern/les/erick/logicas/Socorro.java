/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.modelos.ChamadoEspera;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Socorro implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = null;

        //CAMPOS RECEBIDOS
        int idR = Integer.parseInt(req.getParameter("idR"));
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePaciente = req.getParameter("idadePaciente");
        String motivo = req.getParameter("motivo");
        String queixa = req.getParameter("queixa");
        String tipoCaso = req.getParameter("tipoCaso");

        //INSTÂNCIANDO MODELO E INSERI
        ChamadoEspera ce = new ChamadoEspera();
        ce.setIdR(idR);
        ce.setNomePaciente(nomePaciente);
        ce.setIdade(idadePaciente);
        ce.setMotivo(motivo);
        ce.setQueixa(queixa);
        ce.setTipoDeCaso(tipoCaso);

        //INSTÂNCIANDO SESSÃO ADD ATRIBUTO
        HttpSession session = req.getSession();
        session.setAttribute("dadosPaciente", ce);

        if (tipoCaso.equalsIgnoreCase("Clínico")) {
            
            pagina = "socorroClinico.jsp";
            
        }

        if (tipoCaso.equalsIgnoreCase("Traumático")) {

            pagina = "socorroTraumatico.jsp";

        }

        if (tipoCaso.equalsIgnoreCase("Psiquiátrico")) {

            pagina = "socorroPsiquiatrico.jsp";
            
        }

        if (tipoCaso.equalsIgnoreCase("Obstétrico")) {

            pagina = "socorroObstetrico.jsp";
            
        }

        return pagina;
    }

}
