/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.operaciones;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeBDD;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class ActualizarRS implements Cuerpo {

    private String palabraReservada;
    private String nombreTabla;
    private ArrayList<String> camposTabla = new ArrayList<>();
    private ArrayList<String> valorCamposTabla = new ArrayList<>();
    private String codigoIdentificadorColumna;
    private String valorCodigoidentificadorColumna;
    private ArrayList<String> campos = new ArrayList<>();
    //rs
    private String mensaje;

    public ActualizarRS() {
    }

    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<String> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<String> campos) {
        this.campos = campos;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public ArrayList<String> getCamposTabla() {
        return camposTabla;
    }

    public void setCamposTabla(ArrayList<String> camposTabla) {
        this.camposTabla = camposTabla;
    }

    public ArrayList<String> getValorCamposTabla() {
        return valorCamposTabla;
    }

    public void setValorCamposTabla(ArrayList<String> valorCamposTabla) {
        this.valorCamposTabla = valorCamposTabla;
    }

    public String getCodigoIdentificadorColumna() {
        return codigoIdentificadorColumna;
    }

    public void setCodigoIdentificadorColumna(String codigoIdentificadorColumna) {
        this.codigoIdentificadorColumna = codigoIdentificadorColumna;
    }

    public String getValorCodigoidentificadorColumna() {
        return valorCodigoidentificadorColumna;
    }

    public void setValorCodigoidentificadorColumna(String valorCodigoidentificadorColumna) {
        this.valorCodigoidentificadorColumna = valorCodigoidentificadorColumna;
    }

    public String getPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(String palabraReservada) {
        this.palabraReservada = palabraReservada;
    }

    @Override
    public String astexto() {
        return this.getMensaje();
    }

    public void buildInput(String string) {

        if (MensajeBDD.validate(string, 85, 0) && MensajeBDD.validateHash(string.substring(85), string.substring(53, 85))) {
            this.setCampos(MensajeBDD.getLista(string, "_"));
            this.setPalabraReservada(this.getCampos().get(0).substring(85));
            this.setNombreTabla(this.getCampos().get(1));
            this.setCamposTabla(MensajeBDD.getLista(this.getCampos().get(3), "-"));
            this.setValorCamposTabla(MensajeBDD.getLista(this.getCampos().get(4), "-"));
            this.setCodigoIdentificadorColumna(this.getCampos().get(5));
            this.setValorCodigoidentificadorColumna(this.getCampos().get(6));
        }

    }

    public void buildOutput(String string) {
        if (string.equalsIgnoreCase("OK") || string.equalsIgnoreCase("NO")) {
            this.setMensaje(string);
        }
    }

}
