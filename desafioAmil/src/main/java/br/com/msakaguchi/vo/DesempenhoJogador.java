package br.com.msakaguchi.vo;

import java.util.ArrayList;
import java.util.List;

public class DesempenhoJogador{
	
	private List<JogadorAssassino> assassinatosJogador;
	private List<Jogador> mortesJogador;
	private List<EventoMorte> eventosJogador;
	
	/**
	 * @return the assassinatosJogador
	 */
	public List<JogadorAssassino> getAssassinatosJogador() {
		
		if(assassinatosJogador == null){
			assassinatosJogador = new ArrayList<JogadorAssassino>();
		}
		return assassinatosJogador;
	}
	/**
	 * @param assassinatosJogador the assassinatosJogador to set
	 */
	public void setAssassinatosJogador(List<JogadorAssassino> assassinatosJogador) {
		this.assassinatosJogador = assassinatosJogador;
	}
	
	/**
	 * @return the mortesJogador
	 */
	public List<Jogador> getMortesJogador() {
		
		if(mortesJogador == null){
			mortesJogador = new ArrayList<Jogador>();
		}
		return mortesJogador;
	}
	/**
	 * @param mortesJogador the mortesJogador to set
	 */
	public void setMortesJogador(List<Jogador> mortesJogador) {
		this.mortesJogador = mortesJogador;
	}
	
	
	public List<EventoMorte> getEventosJogador() {
		if(eventosJogador == null){
			eventosJogador = new ArrayList<EventoMorte>();
		}
		return eventosJogador;
	}
	public void setEventosJogador(List<EventoMorte> eventosJogador) {
		this.eventosJogador = eventosJogador;
	}
	@Override
	public String toString() {
		return "DesempenhoJogador [assassinatosJogador=" + assassinatosJogador + ", mortesJogador=" + mortesJogador
				+ ", eventosJogador=" + eventosJogador + "]";
	}
	
}