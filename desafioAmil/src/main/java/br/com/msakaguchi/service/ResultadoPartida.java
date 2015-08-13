package br.com.msakaguchi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import br.com.msakaguchi.enums.TrofeuEnum;
import br.com.msakaguchi.exception.ResultadoNaoEncontradoException;
import br.com.msakaguchi.vo.EventoMorte;
import br.com.msakaguchi.vo.Jogador;
import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;
import br.com.msakaguchi.vo.Trofeu;

public class ResultadoPartida implements IResultadoPartida {

	public ResultadoPartida() {
		this.partidaService = new PartidaService();
	}

	private final int delimitadorSequenciaAssassinatosTrofeu = 5;
	private final int delimitadorIntervaloTrofeu = 60;
	
	private IPartidaService partidaService;

	public List<ResultadoJogadorPartida> obterResultadoPartida(Partida partida) {

		List<ResultadoJogadorPartida> resultado = new ArrayList<ResultadoJogadorPartida>();

		Set<Jogador> jogadores = this.partidaService.calcularDesempenhoJogadoresNaPartida(partida);

		if (jogadores != null && !jogadores.isEmpty()) {

			for (Jogador jog : jogadores) {
				ResultadoJogadorPartida rk = new ResultadoJogadorPartida();
				rk.setNomeJogador(jog.getNome());
				rk.setQtdMortes(jog.getDesempenhoJogador().getMortesJogador().size());
				rk.setQtdAssassinatos(jog.getDesempenhoJogador().getAssassinatosJogador().size());

				resultado.add(rk);
			}
		}

		return resultado;
	}

	public List<ResultadoJogadorPartida> obterJogadoresTrofeuRapidoNoGatilhoNa(Partida partida) {
		
		Set<Jogador> jogadores = this.partidaService.calcularDesempenhoJogadoresNaPartida(partida);
		List<ResultadoJogadorPartida> resultadoJogadores = new ArrayList<ResultadoJogadorPartida>();
		if (jogadores != null && !jogadores.isEmpty()) {
			for (Jogador jogador : jogadores) {
				
				List<EventoMorte> eventosJogador = jogador.getDesempenhoJogador().getEventosJogador();
				
				if (isJogadorElegivelTrofeuRapidoNoGatilho(eventosJogador)) {
				
					ResultadoJogadorPartida res = new ResultadoJogadorPartida();
					res.setNomeJogador(jogador.getNome());
					res.setQtdAssassinatos(jogador.getDesempenhoJogador().getAssassinatosJogador().size());
					res.setQtdMortes(jogador.getDesempenhoJogador().getMortesJogador().size());
					res.getTrofeus().add(new Trofeu(TrofeuEnum.RAPIDO_NO_GATILHO));
					
					resultadoJogadores.add(res);
				}
			}

			return resultadoJogadores;
		}

		throw new ResultadoNaoEncontradoException("Nenhum jogador encontrado na partida.");

	}

	private Boolean isJogadorElegivelTrofeuRapidoNoGatilho(List<EventoMorte> eventosJogadorPartida) {

		Boolean retorno = false;

		if (eventosJogadorPartida != null && !eventosJogadorPartida.isEmpty()) {
			
			// verificar intervalo de tempo entre os assassinatos
			// intervalo deve ser igual ou menor que 1 minuto
			int intervaloAcumuladoSegundos = 0;
			int sequenciaAssassinatos = 0;
			for (int i = 0; i < eventosJogadorPartida.size(); i++) {
				
				sequenciaAssassinatos++;

				if (i > 0) {
					
					EventoMorte evtAtual = eventosJogadorPartida.get(i);
					EventoMorte evtAnterior = eventosJogadorPartida.get(i - 1);

					intervaloAcumuladoSegundos += intervaloEmSegundos(evtAtual.getDataOcorrencia(),
							evtAnterior.getDataOcorrencia());

					//caso intervalo seja superior a 1 minuto - 60 segundos
					if (intervaloAcumuladoSegundos > delimitadorIntervaloTrofeu) {
						// reinicia intervalo e assassinatos em sequencia
						intervaloAcumuladoSegundos = 0;
						sequenciaAssassinatos = 0;
						continue;
					}

					if(hasCondicaoTrofeuRapidoGatilho(sequenciaAssassinatos, intervaloAcumuladoSegundos)){
						retorno = true;
						break;
					}
					
				}

			}

		}

		return retorno;

	}
	
	
	//condicao para trofeu 
	//1-realizar 5 assassinatos em sequencia
	//2-no intervalo de 1 minuto - 60 segundos
	//atingiu5AssassinatosSequencia
	private Boolean hasCondicaoTrofeuRapidoGatilho(int sequenciaAssassinatos, int intervaloAcumulado){
		
		Boolean retorno = false;
		
		if (sequenciaAssassinatos == delimitadorSequenciaAssassinatosTrofeu) {
			if (intervaloAcumulado <= delimitadorIntervaloTrofeu) {
				System.out.println("hasCondicaoTrofeuRapidoGatilho");
				retorno = true;
		
			}
		}
		return retorno;
		
	}
	
	private int intervaloEmSegundos(Date dataEvtAtual, Date dataEvtAnterior) {

		DateTime evtAnterior = new DateTime(dataEvtAnterior.getTime());
		DateTime evtAtual = new DateTime(dataEvtAtual.getTime());

		return Seconds.secondsBetween(evtAnterior, evtAtual).getSeconds();

	}

}
