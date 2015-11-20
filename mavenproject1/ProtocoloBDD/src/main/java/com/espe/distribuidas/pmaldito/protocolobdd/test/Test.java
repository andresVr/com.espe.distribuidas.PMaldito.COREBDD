/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.test;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Mensaje;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeRQ;
import com.espe.distribuidas.pmaldito.protocolobdd.operaciones.InsertarRQ;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class Test {

    //insertar

    public static void main(String[] args) {
        // AutenticacionRQ
        InsertarRQ ins = new InsertarRQ();
        ins.setNombreTabla("CLiente");
        ArrayList lista=new ArrayList();
        lista.add("codigo");
        lista.add("nombre");
        lista.add("apellido");
        lista.add("correo");
        ArrayList listaValor=new ArrayList();
        listaValor.add("12345");
        listaValor.add("juan");
        listaValor.add("perez");
        listaValor.add("12345@alguien.com");
        ins.setCamposTabla(ins.unirCamposTabla(lista));
        ins.setValorCamposTabla(ins.unirCamposTabla(listaValor));
        MensajeRQ ms=new MensajeRQ("12345", Mensaje.idMensajeInsertar);
        ms.setCuerpo(ins);
        System.out.println(ms.asTexto());
    }

}
