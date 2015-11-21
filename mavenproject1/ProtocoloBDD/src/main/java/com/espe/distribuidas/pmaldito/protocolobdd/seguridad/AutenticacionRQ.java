/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.seguridad;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;


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
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     *
     * @return
     */
    @Override
    public String astexto() {
        return this.usuario +"_"+ this.clave +"_"+this.nombreBdd;
    }

    @Override
    public String toString() {
        return "AutenticacionRQ{" + "usuario=" + usuario + ", clave=" + clave + ", nombreBdd=" + nombreBdd + '}';
    }
}