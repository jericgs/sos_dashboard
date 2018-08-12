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
public class ModeloEmail {

    public StringBuilder Modelo1(String nome, String login, String senha) {

        //USO DE STRINGBUILDER PATA OTIMIZAZAR A CONCATENAÇÃO DE STRING
        StringBuilder texto = new StringBuilder();
        texto.append("<h2 align='center'>SOS DASHBOARD - Sistema de Gestão</h2>");
        texto.append("Prezado Sr/Srª. ").append(nome).append(".<br/>");
        texto.append("<br/>");
        texto.append("Esse e-mail consta os dados de acesso ao sistema de gestão do SAMU Mossoró/RN. Por meio desse e-mail confirmamos seu cadastro na plataforma SOS DASHBOARD.<br/>");
        texto.append("<br/>");
        texto.append("Dados de Acesso ao Sistema:<br/>");
        texto.append("Login: ");
        texto.append(login);
        texto.append("<br/>");
        texto.append("Senha: ");
        texto.append(senha);
        texto.append("<br/>");
        texto.append("<br/>");
        
        return texto;

    }
    
    public StringBuilder Modelo2(String nome){
        
        //USO DE STRINGBUILDER PATA OTIMIZAZAR A CONCATENAÇÃO DE STRING
        StringBuilder texto = new StringBuilder();
        texto.append("<h2 align='center'>SOS DASHBOARD - Sistema de Gestão</h2>");
        texto.append("Prezado Sr/Srª. ").append(nome).append(".<br/>");
        texto.append("<br/>");
        texto.append("Por meio desse e-mail confirmamos seu cadastro na plataforma SOS DASHBOARD.<br/>");               
        texto.append("<br/>");        
        
        return texto;
        
    }

}
