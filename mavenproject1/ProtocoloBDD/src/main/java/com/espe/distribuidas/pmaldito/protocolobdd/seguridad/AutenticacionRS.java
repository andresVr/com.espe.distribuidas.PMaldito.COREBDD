/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.seguridad;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Construccion;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class AutenticacionRS implements Cuerpo, Construccion {

    private String mensaje;
    private String usuario;
    private String clave;
    private String nombreBdd;

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

    public String getNombreBdd() {
        return nombreBdd;
    }

    public void setNombreBdd(String nombreBdd) {
        this.nombreBdd = nombreBdd;
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
    public boolean validateHash(String cuerpo, String hash) {
        String md5Hex = DigestUtils.md5Hex(cuerpo);
        return md5Hex.equals(hash);
    }

    @Override
    public Boolean validate(String string, Integer caracteresInicio, Integer caracteresFin) {
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

    @Override
    public void buildInput(String string) {
        String partes[] = StringUtils.splitPreserveAllTokens("_");
        if (validate(string, 85, 0)) {
            this.setUsuario(string.substring(85, 95));
            this.setClave(string.substring(95, 105));
            this.setNombreBdd(partes[1]);
        }
    }

    @Override
    public void buildOutput(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
