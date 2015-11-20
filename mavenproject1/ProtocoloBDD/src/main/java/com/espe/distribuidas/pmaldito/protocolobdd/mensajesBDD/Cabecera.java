/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.protocolobdd.mensajesBDD;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Andrés
 */
public class Cabecera {

	private String tipoMensaje;
	private String originador;
	private String fecha;
	private String idMensaje;
	private String longitudDeCuerpo;
	private String verificacion;

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public Cabecera(String tipoMensaje, String originador, String idMensaje) {
		if (this.validateTipoMensaje(tipoMensaje)) {
			this.tipoMensaje = tipoMensaje;
			this.originador = originador;
			this.idMensaje = idMensaje;
			SimpleDateFormat sof = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			this.fecha = sof.format(new Date());
		}
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getOriginador() {
		return originador;
	}

	public void setOriginador(String originador) {
		this.originador = originador;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = StringUtils.leftPad(idMensaje,10,'0');
	}

	public String getLongitudDeCuerpo() {
		return longitudDeCuerpo;
	}

	public void setLongitudDeCuerpo(String longitudDeCuerpo) {
		this.longitudDeCuerpo = StringUtils.leftPad(longitudDeCuerpo, 4, '0');
	}

	public String getVerificacion() {
		return verificacion;
	}

	public void setVerificacion(String verificacion) {
		this.verificacion = verificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificacion == null) ? 0 : verificacion.hashCode());
		return result;
	}

	public String asTexto() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.tipoMensaje);
		sb.append(this.originador);
		sb.append(this.fecha);
		sb.append(this.idMensaje);
		sb.append(this.getLongitudDeCuerpo());
		if(this.validateVerificacion(this.getVerificacion()))
		sb.append(this.getVerificacion());
		else
			return null;
		return sb.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cabecera other = (Cabecera) obj;
		if (verificacion == null) {
			if (other.verificacion != null)
				return false;
		} else if (!verificacion.equals(other.verificacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cabecera [tipoMensaje=" + tipoMensaje + ", originador=" + originador + ", fecha=" + fecha
				+ ", idMensaje=" + idMensaje + ", longitudDeCuerpo=" + longitudDeCuerpo + ", verificacion="
				+ verificacion + "]";
	}

	public Cabecera() {

	}

	private boolean validateTipoMensaje(String string) {
		if (string.equals("RQ") || string.equals("RS"))
			return true;
		return false;
	}
	private boolean validateVerificacion(String string){
		if(string.length()==32)
		return true;
		return false;
	}
}
