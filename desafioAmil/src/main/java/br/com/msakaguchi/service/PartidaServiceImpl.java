package br.com.msakaguchi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import br.com.msakaguchi.vo.Arma;
import br.com.msakaguchi.vo.JogadorAssassino;
import br.com.msakaguchi.vo.EventoMorte;
import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;

public class PartidaServiceImpl implements ImportadorPartida {

	
	private EventoMorte createEventoMorte(Date dataOcorrencia, String assassino, 
			String assassinado, String nomeArma){
		
		EventoMorte evt = new EventoMorte();
		
		evt.setJogadorAssassino(new JogadorAssassino(assassino, new Arma(nomeArma)));
		evt.setDataOcorrencia(dataOcorrencia);
		evt.setJogadorMorto(new Jogador(assassinado));
		
		return evt;
	}
	
	public List<Partida> listaPartidas() {

		List<Partida> partidas = new LinkedList<Partida>();

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Partida partida = new Partida();
			partida.setInicioPartida(sdf.parse("23/04/2013 15:34:22"));
			partida.setFimPartida(sdf.parse("23/04/2013 15:45:22"));
			
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:36:04"), "Roman", "Nick", "M16"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:36:33"), "<WORLD>", "Nick", "Drown"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:36:45"), "Roman", "<WORLD>", "M16"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:36:50"), "Nick", "Roman", "M16"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:37:00"), "Myller", "Roman", "Bereta"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:37:05"), "Myller", "Nick", "Shotgun"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:37:10"), "Myller", "<WORLD>", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:37:15"), "Myller", "Roman", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:38:10"), "Myller", "Nick", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:38:20"), "<WORLD>", "Roman", "SubMachineGun"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:38:25"), "Roman", "<WORLD>", "Bereta"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:39:30"), "Roman", "Nick", "Bereta"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:40:45"), "Roman", "<WORLD>", "M16"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:40:59"), "Nick", "Roman", "Bereta"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:41:30"), "Roman", "Nick", "Bereta"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:42:10"), "Myller", "<WORLD>", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:42:15"), "Myller", "Nick", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:42:20"), "Myller", "<WORLD>", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:42:25"), "Myller", "Nick", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:42:30"), "Myller", "<WORLD>", "Magnum44"));
			partida.getEventos().add(createEventoMorte(sdf.parse("23/04/2013 15:42:35"), "Myller", "<WORLD>", "Magnum44"));
			
			
			partidas.add(partida);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return partidas;

	}

	private Set<Jogador> listarAssassinos(Partida partida) {
		
		Set<Jogador> assassinos =  new HashSet<Jogador>();
		
		for(EventoMorte evt:partida.getEventos()){
			assassinos.add( new Jogador(evt.getJogadorAssassino().getNome()));
		}
	
		return assassinos;
	}

	private Set<Jogador> listarAssassinados(Partida partida) {
		
		Set<Jogador> assassinados =  new HashSet<Jogador>();
		
		for(EventoMorte evt:partida.getEventos()){
			assassinados.add(new Jogador(evt.getJogadorMorto().getNome()));
		}
		
		return assassinados;
	}

	public Set<Jogador> listarJogadores(Partida partida) {
		
		Set<Jogador> jogadores = new HashSet<Jogador>();
		jogadores.addAll(this.listarAssassinos(partida));
		jogadores.addAll(this.listarAssassinados(partida));
		
		return jogadores;
	}

	public ResultadoJogadorPartida rankingPartida(Partida partida) {
		// TODO Auto-generated method stub
		return null;
	}

	public Partida consultarPartida(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
