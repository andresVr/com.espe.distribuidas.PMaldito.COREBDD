/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.operaciones;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class InsertarRQ implements Cuerpo {

    
    private String nombreTabla;
    private String camposTabla;
    private String valorCamposTabla;

    public InsertarRQ() {
    }

    public String getPalabraReservada() {
        return VocabularioBDD.insertar;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }
    

    public String getCamposTabla() {
        return camposTabla;
    }

    public void setCamposTabla(String camposTabla) {

        this.camposTabla = camposTabla;
    }

    public String getValorCamposTabla() {
        return valorCamposTabla;
    }

    public void setValorCamposTabla(String valorCamposTabla) {
        this.valorCamposTabla = valorCamposTabla;
    }
    //METODOS

    @Override
    public String astexto() {
        return this.getPalabraReservada() + "_" + this.getNombreTabla() + this.getCamposTabla() + this.getValorCamposTabla();
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
