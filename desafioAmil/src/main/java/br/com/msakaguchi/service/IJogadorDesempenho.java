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

	/**
	 * recupera internamente o vencedor da partida
	 * @param partida
	 * @return
	 */
	IJogadorDesempenho fromVencedor(Partida partida);

	/**
	 * obtem arma preferida do vencedor da partida. deve ser chamado
	 * encadeado, primeiramente chamado o metodo fromVencedor().obterArmaPreferidaNaPartida().
	 * @return
	 */
	Arma obterArmaPreferidaNaPartida();

	RankingSequenciaAssassinatos obterMaiorSequenciaAssassinatosIninterruptasNa(Partida partida);
	
	/**
	 * metodo que checa se vencedor ganhou o trofeu de invencicel na partida.
	 * deve ser invocado de maneira encadeada, primeiramente invocando o método
	 * fromVencedor()
	 * @return
	 */
	IJogadorDesempenho quePossuiTrofeuAwardInvencivelNaPartida();
	
	/**
	 * retorna premiacao do vencedor que tenha trofeu de invencivel. Deve ser invocado
	 * de maneira encadeada: fromVencedor().quePossuiTrofeuAwardInvencivelNaPartida()
	 * .retornaDesempenhoComPremiacao()
	 * @return
	 */
	ResultadoJogadorPartida retornaDesempenhoComPremiacao();

}
