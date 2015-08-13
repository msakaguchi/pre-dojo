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

	Set<Jogador> listarJogadoresDa(Partida partida);
	Set<Jogador> calcularDesempenhoJogadoresNaPartida(Partida partida);
}
