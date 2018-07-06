/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.logicas;

import br.com.uern.les.erick.daos.UmsaDAO;
import br.com.uern.les.erick.daos.UmsbDAO;
import br.com.uern.les.erick.daos.UsuarioDAO;
import br.com.uern.les.erick.modelos.TipoSuporte;
import br.com.uern.les.erick.modelos.UMSA;
import br.com.uern.les.erick.modelos.UMSB;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class AreaAjaxSuport implements LogicaAjax {

    @Override
    public String executaAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {

        //VARIAVEL DE RETORNO
        String jason = null;

        //LISTA TIPODEUSUARIO
        List<TipoSuporte> tipoSuportes = new ArrayList<>();

        //CONEXÃO COM BD
        Connection connection = (Connection) req.getAttribute("conexao");

        //INSTÂNCIANDO USUARIODAO E REALIZANDO BUSCA
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        List<String> lUnidadesMoveisAtivas = usuarioDAO.getUnidadesMoveis();

        for (int i = 0; i < lUnidadesMoveisAtivas.size(); i++) {

            UmsbDAO umsbDAO = new UmsbDAO(connection);
            UMSB umsb = umsbDAO.getUnidadeMovel(lUnidadesMoveisAtivas.get(i));

            UmsaDAO umsaDAO = new UmsaDAO(connection);
            UMSA umsa = umsaDAO.getUnidadeMovel(lUnidadesMoveisAtivas.get(i));

            if (umsb != null) {

                //INSTÂNCIANDO MODELO
                TipoSuporte tipoSuporte = new TipoSuporte();

                tipoSuporte.setNome(umsb.getNome());
                tipoSuporte.setPlaca(umsb.getPlaca());

                tipoSuportes.add(tipoSuporte);

            }

            if (umsa != null) {

                //INSTÂNCIANDO MODELO
                TipoSuporte tipoSuporte = new TipoSuporte();

                tipoSuporte.setNome(umsa.getNome());
                tipoSuporte.setPlaca(umsa.getPlaca());

                tipoSuportes.add(tipoSuporte);

            }

        }

        //INVERSÃO DE CONTROLE (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(tipoSuportes);

        return json;    
        
    }

}
