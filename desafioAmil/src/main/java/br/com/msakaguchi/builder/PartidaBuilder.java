/**
 * 
 */
package br.com.msakaguchi.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author myller
 *
 */
public class PartidaBuilder {
	
	private Partida partida;
	
	private final String DATA_FORMATTER = "dd/MM/yyyy HH:mm:ss";
	private SimpleDateFormat sdf = new SimpleDateFormat(DATA_FORMATTER);
	
	
	public PartidaBuilder novaPartida(Long id, String inicioPartida, String fimPartida){
		try {
			this.partida = new Partida(id,  sdf.parse(inicioPartida), sdf.parse(fimPartida));
		} catch (ParseException e) {
			throw new RuntimeException();
		}
		return this;
	}

	public PartidaBuilder criaEvento(String dataOcorrencia, String assassino, 
			String assassinado, String nomeArma){
		
		EventoMorte evt = new EventoMorte();
		
		evt.setJogadorAssassino(new JogadorAssassino(assassino, new Arma(nomeArma)));

		try {
			evt.setDataOcorrencia(sdf.parse(dataOcorrencia));
		} catch (ParseException e) {
			
			throw new RuntimeException();

		}
		evt.setJogadorMorto(new Jogador(assassinado));
		
		
		partida.addEvento(evt);
		return this;
		
	}
	
	public Partida constroi(){
		return partida;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CriadorDePartida [partida=" + partida + "]";
	}
	
	
}
