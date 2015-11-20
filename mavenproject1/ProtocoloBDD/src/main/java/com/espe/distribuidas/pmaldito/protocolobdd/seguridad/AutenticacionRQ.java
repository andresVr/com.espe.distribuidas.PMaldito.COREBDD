/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.seguridad;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class AutenticacionRQ implements Cuerpo {

    private String usuario;
    private String clave;
    private String nombreBdd;

    /**
     *
     */
    public AutenticacionRQ() {
        // TODO Auto-generated constructor stub
    }

    public AutenticacionRQ(String usuario, String clave, String nombreBdd) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombreBdd = nombreBdd;
    }

    public String getNombreBdd() {
        return nombreBdd;
    }

    public void setNombreBdd(String nombreBdd) {
        this.nombreBdd = nombreBdd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = StringUtils.rightPad(usuario, 10);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = StringUtils.rightPad(clave, 10);
    }

    /**
     *
     * @return
     */
    @Override
    public String astexto() {
        return this.usuario + this.clave +"_"+this.nombreBdd;
    }

    @Override
    public String toString() {
        return "AutenticacionRQ{" + "usuario=" + usuario + ", clave=" + clave + ", nombreBdd=" + nombreBdd + '}';
    }

    @Override
    public Boolean validate(String string, Integer caracteresInicio, Integer caracteresFin) {
        Boolean validador=false;
        if (caracteresFin == null) {
            if(string.length()==caracteresInicio)
                validador=true;
        }
        else 
        {
        if(string.length()>caracteresInicio&&string.length()<caracteresFin)
            validador=true;
        }
        return validador;
    }

}
