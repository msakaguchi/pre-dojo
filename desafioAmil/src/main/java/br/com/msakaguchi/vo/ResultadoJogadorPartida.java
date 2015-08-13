package br.com.msakaguchi.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.msakaguchi.enums.TrofeuEnum;

public class ResultadoJogadorPartida {
	
	private String nomeJogador;
	private Integer qtdAssassinatos;
	private Integer qtdMortes;
	private List<Trofeu> trofeus;
	
	
	public boolean hasTrofeus(){
		
		boolean retorno = false;
		
		if(trofeus!=null && !trofeus.isEmpty()){
			retorno = true;
		}
		
		return retorno;
	}
	
	public boolean hasTrofeuRapidoNoGatilho(){
		
		boolean retorno = false;
		
		if(trofeus!=null && !trofeus.isEmpty()){
			for (Trofeu t : trofeus) {
				if(t.getTrofeu().equals(TrofeuEnum.RAPIDO_NO_GATILHO)){
					retorno = true;
					break;
				}
			}
		}
		return retorno;
	}
	
	
	
	/**
	 * @return the nomeJogador
	 */
	public String getNomeJogador() {
		return nomeJogador;
	}
	/**
	 * @param nomeJogador the nomeJogador to set
	 */
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	/**
	 * @return the qtdAssassinatos
	 */
	public Integer getQtdAssassinatos() {
		return qtdAssassinatos;
	}
	/**
	 * @param qtdAssassinatos the qtdAssassinatos to set
	 */
	public void setQtdAssassinatos(Integer qtdAssassinatos) {
		this.qtdAssassinatos = qtdAssassinatos;
	}
	/**
	 * @return the qtdMortes
	 */
	public Integer getQtdMortes() {
		return qtdMortes;
	}
	/**
	 * @param qtdMortes the qtdMortes to set
	 */
	public void setQtdMortes(Integer qtdMortes) {
		this.qtdMortes = qtdMortes;
	}
	
	public List<Trofeu> getTrofeus() {
		if(trofeus==null){
			trofeus = new ArrayList<Trofeu>();
		}
		return trofeus;
	}
	public void setTrofeus(List<Trofeu> trofeus) {
		this.trofeus = trofeus;
	}
	@Override
	public String toString() {
		return "ResultadoJogadorPartida [nomeJogador=" + nomeJogador + ", qtdAssassinatos=" + qtdAssassinatos
				+ ", qtdMortes=" + qtdMortes + ", trofeus=" + trofeus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeJogador == null) ? 0 : nomeJogador.hashCode());
		result = prime * result + ((qtdAssassinatos == null) ? 0 : qtdAssassinatos.hashCode());
		result = prime * result + ((qtdMortes == null) ? 0 : qtdMortes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoJogadorPartida other = (ResultadoJogadorPartida) obj;
		if (nomeJogador == null) {
			if (other.nomeJogador != null)
				return false;
		} else if (!nomeJogador.equals(other.nomeJogador))
			return false;
		if (qtdAssassinatos == null) {
			if (other.qtdAssassinatos != null)
				return false;
		} else if (!qtdAssassinatos.equals(other.qtdAssassinatos))
			return false;
		if (qtdMortes == null) {
			if (other.qtdMortes != null)
				return false;
		} else if (!qtdMortes.equals(other.qtdMortes))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}