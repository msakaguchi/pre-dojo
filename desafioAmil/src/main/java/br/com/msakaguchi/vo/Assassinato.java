package br.com.msakaguchi.vo;

import java.util.Date;

public class Assassinato {
	
	private Date dataOcorrencia;
	private JogadorAssassino jogadorAssassino;
	private Jogador jogadormorto;
	
	
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	public JogadorAssassino getJogadorAssassino() {
		return jogadorAssassino;
	}
	public void setJogadorAssassino(JogadorAssassino jogadorAssassino) {
		this.jogadorAssassino = jogadorAssassino;
	}
	public Jogador getJogadormorto() {
		return jogadormorto;
	}
	public void setJogadormorto(Jogador jogadormorto) {
		this.jogadormorto = jogadormorto;
	}
}