/**
 * 
 */
package br.com.msakaguchi.service;

import java.util.List;
import br.com.msakaguchi.vo.Partida;


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
	 * Recupera Partida a partir do id da partida
	 * @param id
	 * @return
	 */
	Partida consultarPartida(Long id);
	
	
}
