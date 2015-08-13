package br.com.msakaguchi.test;

import org.junit.Before;
import org.junit.Test;

import br.com.msakaguchi.enums.TrofeuEnum;
import br.com.msakaguchi.service.IJogadorDesempenho;
import br.com.msakaguchi.service.ImportadorPartida;
import br.com.msakaguchi.service.JogadorDesempenho;
import br.com.msakaguchi.vo.Arma;
import br.com.msakaguchi.vo.Partida;
import br.com.msakaguchi.vo.PartidaBuilder;
import br.com.msakaguchi.vo.RankingSequenciaAssassinatos;
import br.com.msakaguchi.vo.ResultadoJogadorPartida;
import br.com.msakaguchi.vo.Trofeu;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class JogadorDesempenhoTest {

	private Partida partida;
	private IJogadorDesempenho jogadorDesempenhoService;
	private ImportadorPartida importadorServiceMock;

	@Before
	public void init() {

		this.jogadorDesempenhoService = new JogadorDesempenho();

		partida = new PartidaBuilder().novaPartida(1L, "23/04/2013 15:34:22", "23/04/2013 15:45:22")
				.criaEvento("23/04/2013 15:36:04", "Roman", "Nick", "M16")
				.criaEvento("23/04/2013 15:36:45", "Roman", "<WORLD>", "M16")
				.criaEvento("23/04/2013 15:36:50", "Nick", "Roman", "M16")
				.criaEvento("23/04/2013 15:37:00", "Myller", "Roman", "Bereta")
				.criaEvento("23/04/2013 15:37:05", "Myller", "Nick", "Shotgun")
				.criaEvento("23/04/2013 15:37:10", "Myller", "<WORLD>", "Magnum44")
				.criaEvento("23/04/2013 15:37:15", "Myller", "Roman", "Magnum44")
				.criaEvento("23/04/2013 15:38:10", "Myller", "Nick", "Magnum44")
				.criaEvento("23/04/2013 15:38:20", "<WORLD>", "Roman", "SubMachineGun")
				.criaEvento("23/04/2013 15:38:25", "Roman", "<WORLD>", "Bereta")
				.criaEvento("23/04/2013 15:39:30", "Roman", "Nick", "Bereta")
				.criaEvento("23/04/2013 15:40:45", "Roman", "<WORLD>", "M16")
				.criaEvento("23/04/2013 15:40:59", "Nick", "Roman", "Bereta")
				.criaEvento("23/04/2013 15:41:30", "Roman", "Nick", "Bereta")
				.criaEvento("23/04/2013 15:42:10", "Myller", "<WORLD>", "Magnum44")
				.criaEvento("23/04/2013 15:42:15", "Myller", "Nick", "Magnum44")
				.criaEvento("23/04/2013 15:42:20", "Myller", "<WORLD>", "Magnum44")
				.criaEvento("23/04/2013 15:42:25", "Myller", "Nick", "Magnum44")
				.criaEvento("23/04/2013 15:42:30", "Myller", "<WORLD>", "Magnum44")
				.criaEvento("23/04/2013 15:42:35", "Myller", "<WORLD>", "Magnum44").constroi();

		importadorServiceMock = mock(ImportadorPartida.class);

		when(importadorServiceMock.consultarPartida(1L)).thenReturn(partida);

		partida = importadorServiceMock.consultarPartida(1L);
	}

	@Test
	public void cenarioDeveRecuperarArmaPreferidaVencedorPartida() {

		Arma armaPreferidaJogadorVencedor = this.jogadorDesempenhoService.fromVencedor(partida)
				.obterArmaPreferidaNaPartida();

		assertThat(armaPreferidaJogadorVencedor, equalTo(new Arma("Magnum44")));

	}

	@Test(expected = RuntimeException.class)
	public void cenarioLancaExcecaoAoTentarRecuperarArmaPreferidaVencedorPartida() {

		IJogadorDesempenho jogadorDesempServiceMock = mock(IJogadorDesempenho.class);

		when(jogadorDesempServiceMock.fromVencedor(partida).obterArmaPreferidaNaPartida())
				.thenReturn(new Arma("Magnum44"));

		doThrow(new RuntimeException())
				.when(jogadorDesempServiceMock.fromVencedor(partida).obterArmaPreferidaNaPartida());

		jogadorDesempServiceMock.obterArmaPreferidaNaPartida();

	}

	@Test
	public void cenarioMaiorSequenciaIninterruptaAssassinatosNaPartida() {

		RankingSequenciaAssassinatos maiorSequencia = this.jogadorDesempenhoService
				.obterMaiorSequenciaAssassinatosIninterruptasNa(partida);

		assertThat(maiorSequencia, equalTo(new RankingSequenciaAssassinatos("Myller", 11)));
	}

	@Test
	public void cenarioVerificaVencedorPartidaPosssuiTrofeuInvencivel() {

		ResultadoJogadorPartida resultadoJogadorPartida = this.jogadorDesempenhoService.fromVencedor(partida)
				.quePossuiTrofeuAwardInvencivelNaPartida().retornaDesempenhoComPremiacao();
		
		
		assertThat(resultadoJogadorPartida.getTrofeus(), hasItem(new Trofeu(TrofeuEnum.INVENCIVEL)));
	}

}
