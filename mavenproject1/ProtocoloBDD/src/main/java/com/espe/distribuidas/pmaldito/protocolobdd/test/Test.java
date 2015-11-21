/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.test;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Mensaje;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeRQ;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Originador;
import com.espe.distribuidas.pmaldito.protocolobdd.operaciones.InsertarRQ;
import com.espe.distribuidas.pmaldito.protocolobdd.seguridad.AutenticacionRQ;
import com.espe.distribuidas.pmaldito.protocolobdd.seguridad.AutenticacionRS;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class Test {

    //insertar
    public static void main(String[] args) {
        // AutenticacionRQ
        AutenticacionRQ au = new AutenticacionRQ();
        au.setUsuario("LUIG");
        au.setClave("ROCHA");
        au.setNombreBdd("ProyectoMaldito");
        MensajeRQ rq1 = new MensajeRQ(Originador.getOriginador(Originador.SRV_APLICACION), Mensaje.idMensajeInsertar);
        rq1.setCuerpo(au);
        System.out.println(rq1.asTexto());
        //Autenticacion RS
        AutenticacionRS aurs = new AutenticacionRS();
        aurs.buildInput("RQ10.0.1.104@A0000000020151120170242012INSERTABDD0026927823e05779ab30d1bbf0b41ab51d80LUIG_ROCHA_ProyectoMaldito");
        System.out.println(aurs.toString());
        MensajeRQ rq2 = new MensajeRQ(Originador.getOriginador(Originador.BASE_DATOS), Mensaje.idMensajeInsertar);
        aurs.buildOutput("OK");
        rq2.setCuerpo(aurs);
        System.out.println(rq2.asTexto());
        //InsertarRQ
        InsertarRQ ins = new InsertarRQ();
        ins.setNombreTabla("CLiente");
        ArrayList lista = new ArrayList();
        lista.add("codigo");
        lista.add("nombre");
        lista.add("apellido");
        lista.add("correo");
        ArrayList listaValor = new ArrayList();
        listaValor.add("12345");
        listaValor.add("juan");
        listaValor.add("perez");
        listaValor.add("12345@alguien.com");
        ins.setCamposTabla(ins.unirCamposTabla(lista));
        ins.setValorCamposTabla(ins.unirCamposTabla(listaValor));
        MensajeRQ ms = new MensajeRQ("12345", Mensaje.idMensajeInsertar);
        ms.setCuerpo(ins);
        System.out.println(ms.asTexto());
    }

}
