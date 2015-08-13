/**
 * 
 */
package br.com.msakaguchi.service;

import java.util.List;
import java.util.Set;
import br.com.msakaguchi.exception.ResultadoNaoEncontradoException;
import br.com.msakaguchi.vo.Arma;
import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.AgrupamentoArmasJogador;

/**
 * @author myller
 *
 */
public abstract class JogadorDesempenhoAbs implements IJogadorDesempenho {

	protected Jogador vencedorPartida;

	protected abstract List<Arma> listarTodasArmasUsadasJogador(Jogador jogador);

	protected abstract Set<Arma> listarArmasJogadorAgrupadas(Jogador jogador);

	protected abstract List<AgrupamentoArmasJogador> agrupaArmasPorQuantidadeUtilizada(Set<Arma> armasAgrupadas,
			List<Arma> todasArmasUsadas);

	protected abstract void ordenaPorMaisUtilizadas(List<AgrupamentoArmasJogador> armasUsadasQuantidade);

	public Arma obterArmaPreferidaNaPartida(){
		if (vencedorPartida != null) {

			Set<Arma> armasAgrupadas = this.listarArmasJogadorAgrupadas(vencedorPartida);
			List<Arma> armasUsadasJogador = this.listarTodasArmasUsadasJogador(vencedorPartida);
			List<AgrupamentoArmasJogador> armasUsadasQuantidade = this.agrupaArmasPorQuantidadeUtilizada(armasAgrupadas,
					armasUsadasJogador);

			ordenaPorMaisUtilizadas(armasUsadasQuantidade);

			if (!armasUsadasQuantidade.isEmpty()) {
				return armasUsadasQuantidade.iterator().next().getArma();
			}
		}

		throw new ResultadoNaoEncontradoException("Vencedor da partida não foi encontrado");
	}
	
	
}