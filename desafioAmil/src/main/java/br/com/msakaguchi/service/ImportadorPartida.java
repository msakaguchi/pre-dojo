/**
 * 
 */
package br.com.msakaguchi.service;

import java.util.List;
import java.util.Set;
import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;

/**
 * @author myller
 *
 */
public interface ImportadorPartida {
	
	/**
	 * recupera de um arquivo e faz o parser para
	 * List<Partida>
	 * @return List<Partida> 
	 */
	List<Partida> listaPartidas();
	
	/**
	 * Recupera Partida do arquivo a partir do id da partida
	 * @param id
	 * @return
	 */
	Partida consultarPartida(Long id);
	
	Set<Jogador> listarJogadores(Partida partida);
	
	ResultadoJogadorPartida rankingPartida(Partida partida);
	
}
