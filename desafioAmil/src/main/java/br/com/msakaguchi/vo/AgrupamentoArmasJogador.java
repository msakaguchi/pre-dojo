package br.com.msakaguchi.vo;

public class AgrupamentoArmasJogador {
	
	private Arma arma;
	private Integer quantidade;
	/**
	 * @return the arma
	 */
	public Arma getArma() {
		return arma;
	}
	/**
	 * @param arma the arma to set
	 */
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RankingArmasJogador [arma=" + arma + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
