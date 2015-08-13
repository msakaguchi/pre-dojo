/**
 * 
 */
package br.com.msakaguchi.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author myller
 *
 */
public class Partida {

	private Long idPartida;
	private Date inicioPartida;
	private Date fimPartida;
	private List<EventoMorte> eventos;
	
	
	public Partida() {
	
	}
	public Partida(Long idPartida, Date inicioPartida, Date fimPartida) {
		this.idPartida = idPartida;
		this.inicioPartida = inicioPartida;
		this.fimPartida = fimPartida;

	}

	/**
	 * @return the idPartida
	 */
	public Long getIdPartida() {
		return idPartida;
	}

	/**
	 * @param idPartida the idPartida to set
	 */
	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}

	/**
	 * @return the inicioPartida
	 */
	public Date getInicioPartida() {
		return inicioPartida;
	}

	/**
	 * @param inicioPartida the inicioPartida to set
	 */
	public void setInicioPartida(Date inicioPartida) {
		this.inicioPartida = inicioPartida;
	}

	/**
	 * @return the fimPartida
	 */
	public Date getFimPartida() {
		return fimPartida;
	}

	/**
	 * @param fimPartida the fimPartida to set
	 */
	public void setFimPartida(Date fimPartida) {
		this.fimPartida = fimPartida;
	}

	/**
	 * @return the eventos
	 */
	public List<EventoMorte> getEventos() {
		
		if(eventos == null){
			eventos = new ArrayList<EventoMorte>();
		}
		
		return eventos;
	}

	/**
	 * @param eventos the eventos to set
	 */
	public void setEventos(List<EventoMorte> eventos) {
		this.eventos = eventos;
	}
	
	public Partida addEvento(EventoMorte evento){
		
		getEventos().add(evento);
		
		return this;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", inicioPartida=" + inicioPartida + ", fimPartida=" + fimPartida
				+ ", eventos=" + eventos + "]";
	}
}