package br.com.msakaguchi.vo;

import br.com.msakaguchi.enums.TrofeuEnum;

public class Trofeu {
	
	private TrofeuEnum trofeu;

	
	public Trofeu(TrofeuEnum trofeu) {
		this.trofeu = trofeu;
	}
	
	public TrofeuEnum getTrofeu() {
		return trofeu;
	}

	public void setTrofeu(TrofeuEnum trofeu) {
		this.trofeu = trofeu;
	}

	@Override
	public String toString() {
		return "Trofeu [trofeu=" + trofeu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trofeu == null) ? 0 : trofeu.hashCode());
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
		Trofeu other = (Trofeu) obj;
		if (trofeu != other.trofeu)
			return false;
		return true;
	}
	
	
	
	

}
