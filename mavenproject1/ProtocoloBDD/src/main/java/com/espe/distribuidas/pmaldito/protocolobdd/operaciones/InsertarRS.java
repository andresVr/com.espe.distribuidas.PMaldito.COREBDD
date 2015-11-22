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
public class InsertarRS implements Cuerpo {

    private String palabraReservada;
    private String nombreTabla;
    private ArrayList<String> campos = new ArrayList();
    private ArrayList<String> valosCamposTabla = new ArrayList();
    private ArrayList<String> valosCamposTablaCuerpoFact = new ArrayList();
    private String mensaje;

    public InsertarRS() {
    }

    public ArrayList<String> getValosCamposTablaCuerpoFact() {
        return valosCamposTablaCuerpoFact;
    }

    public void setValosCamposTablaCuerpoFact(ArrayList<String> valosCamposTablaCuerpoFact) {
        this.valosCamposTablaCuerpoFact = valosCamposTablaCuerpoFact;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(String palabraReservada) {
        this.palabraReservada = palabraReservada;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public ArrayList<String> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<String> campos) {
        this.campos = campos;
    }

    public ArrayList<String> getValosCamposTabla() {
        return valosCamposTabla;
    }

    public void setValosCamposTabla(ArrayList<String> valosCamposTabla) {
        this.valosCamposTabla = valosCamposTabla;
    }

    @Override
    public String astexto() {
        return this.getMensaje();
    }

    @Override
    public String toString() {
        return "InsertarRS{" + "palabraReservada=" + palabraReservada + ", nombreTabla=" + nombreTabla + ", campos=" + campos + ", valosCamposTabla=" + valosCamposTabla + ", mensaje=" + mensaje + '}';
    }

    public void buildInput(String string) {

        if (MensajeBDD.validate(string, 85, 0) && MensajeBDD.validateHash(string.substring(85), string.substring(53, 85)) && MensajeBDD.getLista(string, "_").size() == 3) {
            this.setCampos(MensajeBDD.getLista(string, "_"));
            this.setPalabraReservada(this.getCampos().get(0).substring(85));
            this.setNombreTabla(this.getCampos().get(1));
            this.setValosCamposTabla(MensajeBDD.getLista(this.getCampos().get(2), "-"));
        } else {
            this.setCampos(MensajeBDD.getLista(string, "_"));
            this.setPalabraReservada(this.getCampos().get(0).substring(85));
            this.setNombreTabla(this.getCampos().get(1));
            this.setValosCamposTabla(MensajeBDD.getLista(this.getCampos().get(2), "-"));
            this.setValosCamposTablaCuerpoFact(MensajeBDD.getLista(this.getCampos().get(3), "-"));
        }

    }

    public void buildOutput(String string) {
        if (string.equalsIgnoreCase("OK") || string.equalsIgnoreCase("NO")) {
            this.setMensaje(string);
        }
    }

}
