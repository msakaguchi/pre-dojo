package br.com.msakaguchi.vo;

public class RankingSequenciaAssassinatos {

	private String nomeJogador;
	private Integer sequenciaAssassinatos;
	
	public RankingSequenciaAssassinatos(String nomeJogador, Integer sequenciaAssassinatos) {
		this.nomeJogador = nomeJogador;
		this.sequenciaAssassinatos = sequenciaAssassinatos;
	}
	
	public RankingSequenciaAssassinatos() {
		
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
	 * @return the sequenciaAssassinatos
	 */
	public Integer getSequenciaAssassinatos() {
		return sequenciaAssassinatos;
	}
	/**
	 * @param sequenciaAssassinatos the sequenciaAssassinatos to set
	 */
	public void setSequenciaAssassinatos(Integer sequenciaAssassinatos) {
		this.sequenciaAssassinatos = sequenciaAssassinatos;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RankingSequenciaAssassinatos [nomeJogador=" + nomeJogador + ", sequenciaAssassinatos="
				+ sequenciaAssassinatos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeJogador == null) ? 0 : nomeJogador.hashCode());
		result = prime * result + ((sequenciaAssassinatos == null) ? 0 : sequenciaAssassinatos.hashCode());
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
		RankingSequenciaAssassinatos other = (RankingSequenciaAssassinatos) obj;
		if (nomeJogador == null) {
			if (other.nomeJogador != null)
				return false;
		} else if (!nomeJogador.equals(other.nomeJogador))
			return false;
		if (sequenciaAssassinatos == null) {
			if (other.sequenciaAssassinatos != null)
				return false;
		} else if (!sequenciaAssassinatos.equals(other.sequenciaAssassinatos))
			return false;
		return true;
	}
	
	
	
	
	
}
