/**
 * 
 */
package br.com.msakaguchi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.msakaguchi.enums.TrofeuEnum;
import br.com.msakaguchi.exception.ResultadoNaoEncontradoException;
import br.com.msakaguchi.vo.AgrupamentoArmasJogador;
import br.com.msakaguchi.vo.Arma;
import br.com.msakaguchi.vo.EventoMorte;
import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.JogadorAssassino;
import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.RankingSequenciaAssassinatos;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;
import br.com.msakaguchi.vo.Trofeu;

/**
 * @author myller
 *
 */
public class JogadorDesempenho extends JogadorDesempenhoAbs {

	private IPartidaService partidaService;
	private ResultadoJogadorPartida resPartidaVencedor;

	public JogadorDesempenho() {
		this.partidaService = new PartidaService();
	}

	public IJogadorDesempenho fromVencedor(Partida partida) {
		Set<Jogador> jogadores = this.partidaService.calcularDesempenhoJogadoresNaPartida(partida);

		// determinar vencedor
		// o que matou mais
		Integer maiorAssasssino = 0;

		for (Jogador jog : jogadores) {
			if (maiorAssasssino < jog.getDesempenhoJogador().getAssassinatosJogador().size()) {
				maiorAssasssino = jog.getDesempenhoJogador().getAssassinatosJogador().size();
				this.vencedorPartida = jog;
			}
		}

		return this;
	}

	@Override
	protected List<Arma> listarTodasArmasUsadasJogador(Jogador jogador) {

		if (jogador != null && jogador.getDesempenhoJogador() != null
				&& jogador.getDesempenhoJogador().getAssassinatosJogador() != null
				&& !jogador.getDesempenhoJogador().getAssassinatosJogador().isEmpty()) {
			List<Arma> armas = new ArrayList<Arma>();

			for (JogadorAssassino jog : jogador.getDesempenhoJogador().getAssassinatosJogador()) {
				armas.add(jog.getArma());
			}

			return armas;
		}

		throw new ResultadoNaoEncontradoException("Jogador não possui nenhum registro de assassinato.");

	}

	@Override
	protected Set<Arma> listarArmasJogadorAgrupadas(Jogador jogador) {

		if (jogador != null && jogador.getDesempenhoJogador() != null
				&& jogador.getDesempenhoJogador().getAssassinatosJogador() != null
				&& !jogador.getDesempenhoJogador().getAssassinatosJogador().isEmpty()) {

			Set<Arma> armas = new HashSet<Arma>();
			for (JogadorAssassino jog : jogador.getDesempenhoJogador().getAssassinatosJogador()) {
				armas.add(jog.getArma());
			}

			return armas;
		}

		throw new ResultadoNaoEncontradoException("Jogador não possui nenhum registro de assassinato.");

	}

	@Override
	protected List<AgrupamentoArmasJogador> agrupaArmasPorQuantidadeUtilizada(Set<Arma> armasAgrupadas,
			List<Arma> todasArmasUsadas) {

		List<AgrupamentoArmasJogador> rankingArmasJog = new ArrayList<AgrupamentoArmasJogador>();

		for (Arma arm : armasAgrupadas) {

			Integer totalArma = 0;

			for (Arma arma : todasArmasUsadas) {
				if (arm.getNome().equals(arma.getNome())) {
					totalArma++;
				}
			}

			AgrupamentoArmasJogador rank = new AgrupamentoArmasJogador();

			rank.setArma(arm);
			rank.setQuantidade(totalArma);

			rankingArmasJog.add(rank);

		}

		return rankingArmasJog;
	}

	@Override
	protected void ordenaPorMaisUtilizadas(List<AgrupamentoArmasJogador> armasUsadasQuantidade) {
		Collections.sort(armasUsadasQuantidade, new Comparator<AgrupamentoArmasJogador>() {

			public int compare(AgrupamentoArmasJogador o1, AgrupamentoArmasJogador o2) {

				if (o1.getQuantidade() < o2.getQuantidade())
					return 1;
				if (o1.getQuantidade() > o2.getQuantidade())
					return -1;

				return 0;
			}
		});

	}

	public RankingSequenciaAssassinatos obterMaiorSequenciaAssassinatosIninterruptasNa(Partida partida) {
		
		Set<Jogador> jogadores = this.partidaService.listarJogadoresDa(partida);
		
		if(jogadores!=null && !jogadores.isEmpty()){
			List<RankingSequenciaAssassinatos> rank = new ArrayList<RankingSequenciaAssassinatos>();
			
			//p/cada jogador
			for(Jogador jogador:jogadores){
				
				Integer maiorSequenciaAssassinatosSemMorteFinal = 0;
				Integer maiorSequenciaAssassinatosSemMorteParcial = 0;
				Integer sequenciaAssassinatosSemMorte = 0;
				
				
				
				RankingSequenciaAssassinatos rankSeq = new RankingSequenciaAssassinatos();
				
				for(EventoMorte evt:partida.getEventos()){
					
					if(evt.hasAssassinato()){
						if(jogador.getNome().equals(evt.getJogadorAssassino().getNome())){
							if(!evt.getJogadorAssassino().getNome().equals("<WORLD>")){
								maiorSequenciaAssassinatosSemMorteParcial = ++sequenciaAssassinatosSemMorte;
								
								if(maiorSequenciaAssassinatosSemMorteParcial>maiorSequenciaAssassinatosSemMorteFinal){
									maiorSequenciaAssassinatosSemMorteFinal = maiorSequenciaAssassinatosSemMorteParcial;
								}
							}
						}
					}
					
					if(evt.hasMorte()){
						if(jogador.getNome().equals(evt.getJogadorMorto().getNome())){
							sequenciaAssassinatosSemMorte = 0;
						}
					}
					
				}
				
				rankSeq.setNomeJogador(jogador.getNome());
				rankSeq.setSequenciaAssassinatos(maiorSequenciaAssassinatosSemMorteFinal);
				
				rank.add(rankSeq);
			}
			
			
			ordenaPelaMaiorSequenca(rank);
			rank = rank.subList(0, 1);
			
			
			return rank.iterator().next();
		}
		
		
		throw new ResultadoNaoEncontradoException("Nenhum jogador existente na partida.");
	}
	
	
	private void ordenaPelaMaiorSequenca(List<RankingSequenciaAssassinatos> rank){
		
		Collections.sort(rank, new Comparator<RankingSequenciaAssassinatos>() {

			public int compare(RankingSequenciaAssassinatos o1, RankingSequenciaAssassinatos o2) {
				if(o1.getSequenciaAssassinatos() < o2.getSequenciaAssassinatos())
					return 1;
				if(o1.getSequenciaAssassinatos() >  o2.getSequenciaAssassinatos())
					return -1;
				
				return 0;
			}

			
		});
		
		
		
	}

	public IJogadorDesempenho quePossuiTrofeuAwardInvencivelNaPartida() {
		if(this.vencedorPartida != null){
			if(vencedorPartida.getDesempenhoJogador().getMortesJogador().size() == 0){
				resPartidaVencedor = new ResultadoJogadorPartida();
				resPartidaVencedor.setNomeJogador(vencedorPartida.getNome());
				resPartidaVencedor.setQtdAssassinatos(vencedorPartida.getDesempenhoJogador().getAssassinatosJogador().size());
				resPartidaVencedor.setQtdMortes(vencedorPartida.getDesempenhoJogador().getMortesJogador().size());
				resPartidaVencedor.getTrofeus().add(new Trofeu(TrofeuEnum.INVENCIVEL));
				
				return this;
			}
			
			return this;
		}
		
		throw new ResultadoNaoEncontradoException("Vencedor da partida não encontrado.");
	}

	public ResultadoJogadorPartida retornaDesempenhoComPremiacao() {
		if(resPartidaVencedor != null && resPartidaVencedor.hasTrofeus())  {
			return resPartidaVencedor;
		}
		throw new ResultadoNaoEncontradoException("Desempenho  do jogador não encontrado.");
	}


}
