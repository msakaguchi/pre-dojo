/**
 * 
 */
package br.com.msakaguchi.service;

import java.util.Set;

import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.Partida;

/**
 * @author myller
 *
 */
public interface IPartidaService {

	/**
	 * lista os jogadores participantes da partida.
	 * @param partida
	 * @return
	 */
	Set<Jogador> listarJogadoresDa(Partida partida);
	
	/**
	 * calcula o desempenho dos jogadores na partida
	 * @param partida
	 * @return
	 */
	Set<Jogador> calcularDesempenhoJogadoresNaPartida(Partida partida);
}
