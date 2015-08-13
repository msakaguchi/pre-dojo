/**
 * 
 */
package br.com.msakaguchi.test;

import br.com.msakaguchi.builder.PartidaBuilder;
import br.com.msakaguchi.vo.Partida;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * @author myller
 *
 */
public class PartidaBuilderTest {

	
	@Test
	public void criaNovaPartida(){
	Partida	partida = new PartidaBuilder().novaPartida(1L, "23/04/2013 15:34:22", "23/04/2013 15:45:22")
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
				.criaEvento("23/04/2013 15:42:35", "Myller", "<WORLD>", "Magnum44")
				.constroi();
		
		assertThat (partida, notNullValue());
	
	}
	
	@Test(expected=RuntimeException.class)
	public void lancaExcecaoAoCriarNovaPartida(){
		
		new PartidaBuilder().novaPartida(1L, "", "")
				.criaEvento("", "Roman", "Nick", "M16")
				.constroi();
		
		
	}
}
