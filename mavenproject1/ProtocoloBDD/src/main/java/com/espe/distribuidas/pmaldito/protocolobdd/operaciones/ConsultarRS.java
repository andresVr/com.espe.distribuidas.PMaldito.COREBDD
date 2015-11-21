/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.operaciones;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Cuerpo;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Mensaje;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class ConsultarRS implements Cuerpo {

    private String palabraReservada;
    private String nombreTabla;
    private ArrayList<String> campos = new ArrayList<>();
    private ArrayList<String> camposTabla = new ArrayList<>();
    private String codigoIdentificadorColumna;
    private String valorCodigoidentificadorColumna;
    private String camposTablaEspeciales;
    //rs
    private String resultado;
    private ArrayList<String> valoresConsulta = new ArrayList<>();
    private String numeroRecuperados;

    public ConsultarRS() {
    }

    public String getCamposTablaEspeciales() {
        return camposTablaEspeciales;
    }

    public void setCamposTablaEspeciales(String camposTablaEspeciales) {
        this.camposTablaEspeciales = camposTablaEspeciales;
    }
    
    public ArrayList<String> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<String> campos) {
        this.campos = campos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ArrayList<String> getValoresConsulta() {
        return valoresConsulta;
    }

    public void setValoresConsulta(ArrayList<String> valoresConsulta) {
        this.valoresConsulta = valoresConsulta;
    }

    public String getNumeroRecuperados() {
        return numeroRecuperados;
    }

    public void setNumeroRecuperados(String numeroRecuperados) {
        this.numeroRecuperados = numeroRecuperados;
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

    public ArrayList<String> getCamposTabla() {
        return camposTabla;
    }

    public void setCamposTabla(ArrayList<String> camposTabla) {
        this.camposTabla = camposTabla;
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

    @Override
    public String astexto() {
        if (resultado.equals("OKO")) {
            return this.getResultado() + "_" + Mensaje.unirCamposTabla(this.getValoresConsulta()) + "_" + this.getNumeroRecuperados();
        } else {
            return this.getResultado();
        }
    }

    public void buildInput(String string) {

        if (Mensaje.validateHash(string.substring(85), string.substring(53, 85)) && Mensaje.validate(string, 85, 0)) {
            this.setCampos(Mensaje.getLista(string, "_"));
            if (this.getCampos().get(3).equalsIgnoreCase("*")) {
                this.setPalabraReservada(this.getCampos().get(0).substring(85));
                this.setNombreTabla(this.getCampos().get(1));
            }
            else if(this.getCampos().get(3).equalsIgnoreCase("/"))
            {
                this.setPalabraReservada(this.getCampos().get(0).substring(85));
                this.setNombreTabla(this.getCampos().get(1));
                this.setCamposTablaEspeciales(this.getCampos().get(3));
                this.setCodigoIdentificadorColumna(this.getCampos().get(4));
                this.setValorCodigoidentificadorColumna(this.getCampos().get(5));

            }
            else {
                this.setPalabraReservada(this.getCampos().get(0).substring(85));
                this.setNombreTabla(this.getCampos().get(1));
                this.setCamposTabla(Mensaje.getLista(this.getCampos().get(3), "-"));
                this.setCodigoIdentificadorColumna(this.getCampos().get(4));
                this.setValorCodigoidentificadorColumna(this.getCampos().get(5));

            }
        }

    }

    public void buildOutput(String resultado, ArrayList<String> string, String recuperados) {
        if (resultado.equals("OKO")) {
            this.setResultado(resultado);
            this.setValoresConsulta(string);
            this.setNumeroRecuperados(recuperados);
        } else {
            this.setResultado(resultado);
        }

    }

}
