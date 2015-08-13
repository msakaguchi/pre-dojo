/**
 * 
 */
package br.com.msakaguchi.vo;

import java.util.Date;


/**
 * @author myller
 *
 */
public class EventoMorte {

	private JogadorAssassino jogadorAssassino;
	private Jogador jogadorMorto;
	private Date dataOcorrencia;
	
	
	
	public EventoMorte() {
	
	}
	
	public EventoMorte(JogadorAssassino assassino, Jogador assassinado, Date dataOcorrencia) {
		this.jogadorAssassino = assassino;
		this.jogadorMorto = assassinado;
		this.dataOcorrencia = dataOcorrencia;
	}
	
	/**
	 * @return the jogadorAssassino
	 */
	public JogadorAssassino getJogadorAssassino() {
		return jogadorAssassino;
	}
	/**
	 * @param jogadorAssassino the jogadorAssassino to set
	 */
	public void setJogadorAssassino(JogadorAssassino jogadorAssassino) {
		this.jogadorAssassino = jogadorAssassino;
	}
	
	/**
	 * @return the jogadorMorto
	 */
	public Jogador getJogadorMorto() {
		return jogadorMorto;
	}
	/**
	 * @param jogadorMorto the jogadorMorto to set
	 */
	public void setJogadorMorto(Jogador jogadorMorto) {
		this.jogadorMorto = jogadorMorto;
	}
	/**
	 * @return the dataOcorrencia
	 */
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	/**
	 * @param dataOcorrencia the dataOcorrencia to set
	 */
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	
	
	public Boolean hasAssassinato(){
		if(this.jogadorAssassino != null){
			return true;
		}
		return false;
	}
	
	public Boolean hasMorte(){
		if(this.jogadorMorto != null){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventoMorte [jogadorAssassino=" + jogadorAssassino + ", jogadorMorto=" + jogadorMorto
				+ ", dataOcorrencia=" + dataOcorrencia + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOcorrencia == null) ? 0 : dataOcorrencia.hashCode());
		result = prime * result + ((jogadorAssassino == null) ? 0 : jogadorAssassino.hashCode());
		result = prime * result + ((jogadorMorto == null) ? 0 : jogadorMorto.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoMorte other = (EventoMorte) obj;
		if (dataOcorrencia == null) {
			if (other.dataOcorrencia != null)
				return false;
		} else if (!dataOcorrencia.equals(other.dataOcorrencia))
			return false;
		if (jogadorAssassino == null) {
			if (other.jogadorAssassino != null)
				return false;
		} else if (!jogadorAssassino.equals(other.jogadorAssassino))
			return false;
		if (jogadorMorto == null) {
			if (other.jogadorMorto != null)
				return false;
		} else if (!jogadorMorto.equals(other.jogadorMorto))
			return false;
		return true;
	}
	
	
	
}
