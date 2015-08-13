package br.com.msakaguchi.service;

import java.util.List;

import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;

public interface IResultadoPartida {
	
	public  List<ResultadoJogadorPartida> obterResultadoPartida(Partida partida);
	public List<ResultadoJogadorPartida> obterJogadoresTrofeuRapidoNoGatilhoNa(Partida partida);
}
