/**
 * 
 */
package br.com.msakaguchi.vo;


/**
 * @author myller
 *
 */
public class Jogador{
	
	protected String nome;
	
	private DesempenhoJogador desempenhoJogador;
	
	public Jogador(String nome) {
		this.nome = nome;
	}
		
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the desempenhoJogador
	 */
	public DesempenhoJogador getDesempenhoJogador() {
		if(desempenhoJogador == null){
			desempenhoJogador = new DesempenhoJogador();
		}
		return desempenhoJogador;
	}

	/**
	 * @param desempenhoJogador the desempenhoJogador to set
	 */
	public void setDesempenhoJogador(DesempenhoJogador desempenhoJogador) {
		this.desempenhoJogador = desempenhoJogador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}