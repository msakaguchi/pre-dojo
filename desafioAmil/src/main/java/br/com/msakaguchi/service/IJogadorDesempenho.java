/**
 * 
 */
package br.com.msakaguchi.service;

import br.com.msakaguchi.vo.Arma;
import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.RankingSequenciaAssassinatos;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;

/**
 * @author myller
 *
 */
public interface IJogadorDesempenho {

	IJogadorDesempenho fromVencedor(Partida partida);

	Arma obterArmaPreferidaNaPartida();

	RankingSequenciaAssassinatos obterMaiorSequenciaAssassinatosIninterruptasNa(Partida partida);
	
	IJogadorDesempenho quePossuiTrofeuAwardInvencivelNaPartida();
	
	ResultadoJogadorPartida retornaDesempenhoComPremiacao();

}
