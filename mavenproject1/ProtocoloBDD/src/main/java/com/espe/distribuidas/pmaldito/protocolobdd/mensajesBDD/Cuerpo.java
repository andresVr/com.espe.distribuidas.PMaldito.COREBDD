/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD;

/**
 *
 * @author Andrés
 */
public interface Cuerpo {
    String astexto();

    /**
     *
     * @param string
     * @param caracteresInicio
     * @param caracteresFin
     * @return
     */
    Boolean validate(String string,Integer caracteresInicio,Integer caracteresFin);
}
