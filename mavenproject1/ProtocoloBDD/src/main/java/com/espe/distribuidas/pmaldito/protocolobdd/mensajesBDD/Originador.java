/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author david
 */
public class Originador {

    public static final String CLIENTE = "C";
    public static final String SRV_APLICACION = "A";
    public static final String BASE_DATOS = "B";

    public static String getOriginador(String c) {
        String origen = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            origen = localHost.getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Originador.class.getName()).log(Level.SEVERE, null, ex);
        }
        origen = origen + "@" + c;
        origen = StringUtils.rightPad(origen, 20,'0');
        return origen;
    }

}