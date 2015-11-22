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
    private String valorCamposTabla;
    private String valorcuerpo;

    public InsertarRQ() {
    }

    public String getValorcuerpo() {
        return valorcuerpo;
    }

    public void setValorcuerpo(String valorcuerpo) {
        this.valorcuerpo = valorcuerpo;
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

    public String getValorCamposTabla() {
        return valorCamposTabla;
    }

    public void setValorCamposTabla(String valorCamposTabla) {
        this.valorCamposTabla = valorCamposTabla;
    }
    //METODOS

    @Override
    public String astexto() {
        if (this.getValorcuerpo() != null) {
            return this.getPalabraReservada() + "_" + this.getNombreTabla() + this.getValorCamposTabla() + this.getValorcuerpo();
        } else {
            return this.getPalabraReservada() + "_" + this.getNombreTabla() + this.getValorCamposTabla();
        }

    }

}
