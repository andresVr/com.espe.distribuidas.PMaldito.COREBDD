/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class MensajeRS {
    private Cabecera cabecera;
	private Cuerpo cuerpo;

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}

	public Cuerpo getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(Cuerpo cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String asTexto() {

		Integer longitud = this.cuerpo.astexto().length();
		this.cabecera.setOriginador(StringUtils.leftPad(this.cabecera.getOriginador(), 20, '0'));
		this.cabecera.setLongitudDeCuerpo(longitud.toString());
		this.cabecera.setVerificacion(cifrarmd5());
		return this.cabecera.asTexto() + this.cuerpo.astexto();
	}

	public MensajeRS(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.idMensajeRS, originador, idMensaje);
	}

	public String cifrarmd5() {
		String rs1 = DigestUtils.md5Hex( this.cuerpo.astexto());
		return rs1;

	}

	
}
