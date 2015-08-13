package br.com.msakaguchi.vo;


public class JogadorAssassino extends Jogador{
	
	public JogadorAssassino(String nome, Arma arma) {
		super(nome);
		this.arma = arma;
	}
	
	private Arma arma;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JogadorAssassino [arma=" + arma + "]";
	}
}