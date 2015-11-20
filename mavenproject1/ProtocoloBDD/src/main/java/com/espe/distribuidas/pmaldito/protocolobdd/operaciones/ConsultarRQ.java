/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.operaciones;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class ConsultarRQ implements Cuerpo {


    private String nombreTabla;
    private String camposTabla;
    private String codigoIdentificadorColumna;
    private String valorCodigoidentificadorColumna;

    public ConsultarRQ() {
    }

    public String getValorCodigoidentificadorColumna() {
        return valorCodigoidentificadorColumna;
    }

    public void setValorCodigoidentificadorColumna(String valorCodigoidentificadorColumna) {
        this.valorCodigoidentificadorColumna = valorCodigoidentificadorColumna;
    }

    public String getCodigoIdentificadorColumna() {
        return codigoIdentificadorColumna;
    }

    public void setCodigoIdentificadorColumna(String codigoIdentificadorColumna) {
        this.codigoIdentificadorColumna = codigoIdentificadorColumna;
    }

    public String getPalabraReservada() {
        return VocabularioBDD.insertar;
    }


    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = StringUtils.rightPad(nombreTabla, 15);
    }

    public String getCamposTabla() {
        return camposTabla;
    }

    public void setCamposTabla(String camposTabla) {

        this.camposTabla = camposTabla;
    }

    //METODOS
    @Override
    public String astexto() {
        if(this.getCodigoIdentificadorColumna().equals("*"))
        return this.getPalabraReservada()+"_"+this.getNombreTabla()+this.getCamposTabla()+"_"+this.getCodigoIdentificadorColumna();
        else
        return this.getPalabraReservada()+"_"+this.getNombreTabla()+this.getCamposTabla()+"_"+this.getCodigoIdentificadorColumna()+"_"+this.getValorCodigoidentificadorColumna();    
    }

    @Override
    public Boolean validate(String string, Integer caracteresInicio, Integer caracteresFin) {
        Boolean validador = false;
        if (caracteresFin == null) {
            if (string.length() == caracteresInicio) {
                validador = true;
            }
        } else {
            if (string.length() > caracteresInicio && string.length() < caracteresFin) {
                validador = true;
            }
        }
        return validador;

    }

    public String unirCamposTabla(ArrayList campos) {
        String campo = "_";
        for (Object campo1 : campos) {
            campo = campo + campo1 + "-";
        }
        return campo.substring(0, campo.length() - 1);
    }

}
