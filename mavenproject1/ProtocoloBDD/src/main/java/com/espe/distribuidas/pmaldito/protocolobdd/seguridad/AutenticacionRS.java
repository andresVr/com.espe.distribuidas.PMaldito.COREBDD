/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.seguridad;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeBDD;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class AutenticacionRS implements Cuerpo  {

    private String mensaje;
    private String usuario;
    private String clave;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean separarCabecera(String string) {
        return string.length() > 85;
    }

    public AutenticacionRS() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String astexto() {
        return this.getMensaje();
    }
    @Override
    public String toString() {
        return "AutenticacionRS{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }


    public void buildInput(String string) {
        if (MensajeBDD.validate(string, 85, 0) && MensajeBDD.validateHash(string.substring(85), string.substring(53, 85))) {
            String partes[] = StringUtils.splitPreserveAllTokens(string,"_");
            this.setUsuario(partes[0].substring(85));
            this.setClave(partes[1]);

        } else {
            this.mensaje = null;
        }
    }

    /**
     *
     * @param string
     */
    public void buildOutput(String string) {
        this.setMensaje(string);
    }

}
