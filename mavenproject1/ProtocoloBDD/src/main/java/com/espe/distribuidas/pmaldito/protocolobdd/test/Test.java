/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.test;

import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeBDD;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeRQ;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.MensajeRS;
import com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD.Originador;
import com.espe.distribuidas.pmaldito.protocolobdd.operaciones.ConsultarRQ;
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
        MensajeRQ rq1 = new MensajeRQ(Originador.getOriginador(Originador.SRV_APLICACION), MensajeBDD.idMensajeAutenticacion);
        rq1.setCuerpo(au);
        System.out.println(rq1.asTexto());
        //Autenticacion RS
        AutenticacionRS aurs = new AutenticacionRS();
        aurs.buildInput("RQ10.0.1.104@A0000000020151120170242012INSERTABDD0026927823e05779ab30d1bbf0b41ab51d80LUIG_ROCHA");
        System.out.println(aurs.toString());
        MensajeRQ rq2 = new MensajeRQ(Originador.getOriginador(Originador.BASE_DATOS), MensajeBDD.idMensajeInsertar);
        aurs.buildOutput("OK");
        rq2.setCuerpo(aurs);
        System.out.println(rq2.asTexto());
        //InsertarRQ
        InsertarRQ ins = new InsertarRQ();
        ins.setNombreTabla("CLIENTE");
        ArrayList lista = new ArrayList();
        lista.add("codigo");
        lista.add("nombre");
        lista.add("apellido");
        lista.add("correo");
        ArrayList listaValor = new ArrayList();
        listaValor.add("CEDUL");
        listaValor.add("1796247945");
        listaValor.add("Luis");
        listaValor.add("paez");
        listaValor.add("conocoto");
        listaValor.add("0923347860");
        listaValor.add("022614234");
        listaValor.add("12203@alguien.com");
        listaValor.add("19800701");
        ins.setValorCamposTabla(MensajeBDD.unirCamposTabla(listaValor));
        MensajeRQ ms = new MensajeRQ(Originador.getOriginador(Originador.SRV_APLICACION), MensajeBDD.idMensajeInsertar);
        ms.setCuerpo(ins);
        System.out.println(ms.asTexto());
        //inserrtar factura
        ArrayList<String> cabeceraFact = new ArrayList<>();
        cabeceraFact.add("12346");
        cabeceraFact.add("1726247958");
        cabeceraFact.add("20151122113800");
        cabeceraFact.add("50.20");
        ArrayList<String> cuerpoFact = new ArrayList<>();
        cuerpoFact.add("1234");
        cuerpoFact.add("12346");
        cuerpoFact.add("cocacola");
        cuerpoFact.add("5");
        cuerpoFact.add("2.50");
        cuerpoFact.add("1235");
        cuerpoFact.add("12346");
        cuerpoFact.add("pollo");
        cuerpoFact.add("5");
        cuerpoFact.add("15");
        InsertarRQ rq = new InsertarRQ();
        rq.setNombreTabla("FACTURA");
        rq.setValorCamposTabla(MensajeBDD.unirCamposTabla(cabeceraFact));
        rq.setValorcuerpo(MensajeBDD.unirCamposTabla(cuerpoFact));
        MensajeRQ rs = new MensajeRQ(Originador.getOriginador(Originador.SRV_APLICACION), MensajeBDD.idMensajeInsertar);
        rs.setCuerpo(rq);
        System.out.println(rs.asTexto());
        ///rq info cliente
        ConsultarRQ crq = new ConsultarRQ();
        crq.setNombreTabla("CLIENTE");
        crq.setCamposTabla("/");
        crq.setCodigoIdentificadorColumna("1");
        crq.setValorCodigoidentificadorColumna("1707412548");
        MensajeRQ rqd = new MensajeRQ(Originador.getOriginador(Originador.SRV_APLICACION), MensajeBDD.idMensajeConsultar);
        rqd.setCuerpo(crq);
        System.out.println(rqd.asTexto());
        //rq producto
        ConsultarRQ crq1 = new ConsultarRQ();
        crq.setNombreTabla("PRODUCTO");
        crq.setCamposTabla("/");
        crq.setCodigoIdentificadorColumna("0");
        crq.setValorCodigoidentificadorColumna("1235");
        MensajeRQ rqd1 = new MensajeRQ(Originador.getOriginador(Originador.SRV_APLICACION), MensajeBDD.idMensajeConsultar);
        rqd.setCuerpo(crq);
        System.out.println(rqd.asTexto());

    }

}
