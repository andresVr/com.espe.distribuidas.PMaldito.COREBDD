/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class MensajeBDD {

    public static final String idMensajeRQ = "RQ";
    public static final String idMensajeRS = "RS";
    public static final String idMensajeAutenticacion = "AUTENTIBDD";
    public static final String idMensajeInsertar = "INSERTABDD";
    public static final String idMensajeConsultar = "CONSULTBDD";
    public static final String idMensajeActualizar = "ACTUALIBDD";
//metodos staticos

    /**
     *
     * @param string
     * @param caracteresInicio
     * @param caracteresFin
     * @return
     */
        public static Boolean validate(String string, Integer caracteresInicio, Integer caracteresFin) {
        Boolean validador = false;
        if (caracteresFin == null) {
            if (string.length() == caracteresInicio) {
                validador = true;
            }
        } else if (caracteresFin == 0) {
            if (string.length() > caracteresInicio) {
                validador = true;
            }

        } else {
            if (string.length() > caracteresInicio && string.length() < caracteresFin) {
                validador = true;
            }
        }
        return validador;
    }

    /**
     *
     * @param cuerpo
     * @param hash
     * @return
     */
    public static boolean validateHash(String cuerpo, String hash) {
        String md5Hex = DigestUtils.md5Hex(cuerpo);
        return md5Hex.equals(hash);
    }

    /**
     *
     * @param string
     * @param separador
     * @return
     */
    public static ArrayList getLista(String string,String separador)
    {
        ArrayList resultado=new ArrayList();
        String partes[]=StringUtils.splitPreserveAllTokens(string,separador);
        resultado.addAll(Arrays.asList(partes));
        return resultado;
    }
    

    /**
     *
     * @param campos
     * @return
     */
    public static String unirCamposTabla(ArrayList campos) {
        String campo = "_";
        for (Object campo1 : campos) {
            campo = campo + campo1 + "-";
        }
        return campo.substring(0, campo.length() - 1);
    }
    
}
