package br.com.msakaguchi.service;

import java.util.List;

import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;

public interface IResultadoPartida {

	/**
	 * retorna resultado da partida. Retornando quantidade de assassinatos e
	 * quantidade de mortes para cada jogador
	 * @param partida
	 * @return
	 */
	public List<ResultadoJogadorPartida> obterResultadoPartida(Partida partida);

	/**
	 * retorna resultado da partida. Retornando quantidade de assassinatos,
	 * quantidade de mortes para cada jogador. Além disso, caso o jogador tenha ganho
	 * o trofeu RapidoNoGatilho, este é retornado também.
	 * @param partida
	 * @return
	 */
	public List<ResultadoJogadorPartida> obterJogadoresTrofeuRapidoNoGatilhoNa(Partida partida);
}
