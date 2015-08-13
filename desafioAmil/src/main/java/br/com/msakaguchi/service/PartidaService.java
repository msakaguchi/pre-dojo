package br.com.msakaguchi.service;

import java.util.HashSet;
import java.util.Set;

import br.com.msakaguchi.vo.EventoMorte;
import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.DesempenhoJogador;
import br.com.msakaguchi.vo.Partida;

public class PartidaService implements IPartidaService {

	public Set<Jogador> listarJogadoresDa(Partida partida) {
		Set<Jogador> jogadores = new HashSet<Jogador>();
		jogadores.addAll(this.listarAssassinos(partida));
		jogadores.addAll(this.listarAssassinados(partida));

		return jogadores;
	}

	public Set<Jogador> calcularDesempenhoJogadoresNaPartida(Partida partida) {

		Set<Jogador> jogadores = this.listarJogadoresDa(partida);

		// p/cada jogador
		for (Jogador jogador : jogadores) {

			DesempenhoJogador desempenho = new DesempenhoJogador();

			for (EventoMorte evt : partida.getEventos()) {

				// totaliza assassinatos
				if (jogador.getNome().equals(evt.getJogadorAssassino().getNome())) {
					if (!jogador.getNome().equals("<WORLD>")) {
						if (evt.hasAssassinato()) {
							desempenho.getAssassinatosJogador().add(evt.getJogadorAssassino());
						}

					}
				}

				// totaliza mortes
				if (jogador.getNome().equals(evt.getJogadorMorto().getNome())) {
					if (evt.hasMorte()) {
						desempenho.getMortesJogador().add(evt.getJogadorMorto());
					}
				}

				// associa todos os eventos ao jogador
				if (jogador.getNome().equals(evt.getJogadorAssassino().getNome())
						|| jogador.getNome().equals(evt.getJogadorMorto().getNome())) {
					desempenho.getEventosJogador().add(evt);

				}
			}

			jogador.setDesempenhoJogador(desempenho);
		}

		return jogadores;
	}

	private Set<Jogador> listarAssassinos(Partida partida) {

		Set<Jogador> assassinos = new HashSet<Jogador>();

		for (EventoMorte evt : partida.getEventos()) {

			if (evt.hasMorte()) {
				assassinos.add(new Jogador(evt.getJogadorAssassino().getNome()));
			}

		}

		return assassinos;
	}

	private Set<Jogador> listarAssassinados(Partida partida) {

		Set<Jogador> assassinados = new HashSet<Jogador>();

		for (EventoMorte evt : partida.getEventos()) {
			if (evt.hasMorte()) {
				assassinados.add(new Jogador(evt.getJogadorMorto().getNome()));
			}
		}

		return assassinados;
	}
}