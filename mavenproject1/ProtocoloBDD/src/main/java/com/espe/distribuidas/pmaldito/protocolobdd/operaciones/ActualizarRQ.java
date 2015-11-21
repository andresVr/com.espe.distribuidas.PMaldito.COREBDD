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
public class ActualizarRQ implements Cuerpo {

    private String nombreTabla;
    private String camposTabla;
    private String valorCamposTabla;
    private String codigoIdentificadorColumna;
    private String valorCodigoidentificadorColumna;

    public ActualizarRQ() {
    }

    public String getValorCamposTabla() {
        return valorCamposTabla;
    }

    public void setValorCamposTabla(String valorCamposTabla) {
        this.valorCamposTabla = valorCamposTabla;
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
        return VocabularioBDD.actualizar;
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
        return this.getPalabraReservada() + "_" + this.getNombreTabla() + this.getCamposTabla() + this.getValorCamposTabla() + "_" + this.getCodigoIdentificadorColumna() + "_" + this.getValorCodigoidentificadorColumna();
    }


}
