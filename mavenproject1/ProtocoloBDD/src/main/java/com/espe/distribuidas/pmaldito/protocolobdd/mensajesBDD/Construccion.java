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
public interface Construccion {

    void buildInput(String string);
    void buildOutput(String string);
    boolean validateHash(String cuerpo, String hash);
}
