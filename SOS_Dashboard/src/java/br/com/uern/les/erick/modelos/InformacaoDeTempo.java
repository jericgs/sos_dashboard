/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uern.les.erick.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public String getHora() {

        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        Date hora = new Date();
        return dateFormat.format(hora);

    }

    public String getDiaDaSemana() {

        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        int dia = c.get(Calendar.DAY_OF_WEEK);
        switch (dia) {
            case Calendar.SUNDAY:
                nome = "Domingo";
                break;
            case Calendar.MONDAY:
                nome = "Segunda";
                break;
            case Calendar.TUESDAY:
                nome = "Terça";
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta";
                break;
            case Calendar.THURSDAY:
                nome = "Quinta";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta";
                break;
            case Calendar.SATURDAY:
                nome = "Sábado";
                break;
        }
        return nome;
    }

    public String getMesDoAno() {

        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        int mes = c.get(Calendar.MONTH);
        switch (mes) {
            case Calendar.JANUARY:
                nome = "Janeiro";
                break;
            case Calendar.FEBRUARY:
                nome = "Fevereiro";
                break;
            case Calendar.MARCH:
                nome = "Março";
                break;
            case Calendar.APRIL:
                nome = "Abril";
                break;
            case Calendar.MAY:
                nome = "Maio";
                break;
            case Calendar.JUNE:
                nome = "Junho";
                break;
            case Calendar.JULY:
                nome = "Julho";
                break;
            case Calendar.AUGUST:
                nome = "Agosto";
                break;
            case Calendar.SEPTEMBER:
                nome = "Setembro";
                break;
            case Calendar.OCTOBER:
                nome = "Outubro";
                break;
            case Calendar.NOVEMBER:
                nome = "Novembro";
                break;
            case Calendar.DECEMBER:
                nome = "Dezembro";
                break;
        }
        return nome;
    }

    public String alterarData(int numDoDia) {

        // Usuário informa uma data
        Date dataAlterada = new Date();
        String dataAlteradaSt;

        // Através do Calendar, trabalhamos a data informada e adicionamos 1 dia nela
        Calendar c = Calendar.getInstance();
        c.setTime(dataAlterada);
        c.add(Calendar.DATE, numDoDia);

        // Obtemos a data alterada
        dataAlterada = c.getTime();

        //Formatar
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataAlteradaSt = dateFormat.format(dataAlterada);

        return dataAlteradaSt;
    }
    
    public String alterarMes(int numDoMes) {

        // Usuário informa uma data
        Date dataAlterada = new Date();
        String dataAlteradaSt;

        // Através do Calendar, trabalhamos o mês informado e adicionamos 1 mês nela
        Calendar c = Calendar.getInstance();
        c.setTime(dataAlterada);
        c.add(Calendar.MONTH, numDoMes);

        // Obtemos o data alterada
        dataAlterada = c.getTime();

        //Formatar
        DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dataAlteradaSt = dateFormat.format(dataAlterada);

        return dataAlteradaSt;
    }

}
