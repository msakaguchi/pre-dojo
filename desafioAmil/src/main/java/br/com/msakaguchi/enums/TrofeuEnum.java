package br.com.msakaguchi.enums;

public enum TrofeuEnum {

	INVENCIVEL("Vencer a partida invicto!"),
	RAPIDO_NO_GATILHO("Matar mais de cinco jogadores em menos de um minuto!");
	
	private String descricao;
	
	private TrofeuEnum(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}