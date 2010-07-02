/**
 * 
 */
package test.com.lotopro;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lotopro.Cartao;
import com.lotopro.ProcessadorResultados;
import com.lotopro.ResultadoConferencia;
import com.lotopro.Sorteio;
import com.lotopro.generate.Gerador;

/**
 * 
 * Testar um cartao com 20 pontos, outro com 19, 18, 17, 16.
 * <p>
 * Testar 5000 cartoes com numeros aleatorios e colher os resultados.
 * <p>
 * Testar 3 cartoes com 0 pontos e um com 16 pontos.
 * <p> Testar para os cartoes não se misturarem por exemplo, um que acertou 20 pontos não está acertando 19.
 * 
 * @author Administrador
 * 
 */
public class ProcessadorResultadosTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * Testará 1 cartao com 20 pontos.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferir1com20Pontos() throws Exception {
		Cartao cartao = new Cartao();
		Sorteio sorteio = new Sorteio();

		for (int i = 0; i <= 19; i++) {
			cartao.addNumero(i);
			sorteio.addNumero(i);
		}
		for (int i = 20; i <= 49; i++) {
			cartao.addNumero(i);
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio,
				new Cartao[] { cartao });

		assertEquals(1, resultado.getCartoesCom20Pontos().length);
		assertEquals(0, resultado.getCartoesCom19Pontos().length);
		assertEquals(0, resultado.getCartoesCom18Pontos().length);
		assertEquals(0, resultado.getCartoesCom17Pontos().length);
		assertEquals(0, resultado.getCartoesCom16Pontos().length);
		assertEquals(0, resultado.getCartoesCom0Pontos().length);
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * Testará 1 cartao com 19 pontos.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferir1com19Pontos() throws Exception {
		Cartao cartao = new Cartao();
		Sorteio sorteio = new Sorteio();

		for (int i = 0; i <= 19; i++) {
			sorteio.addNumero(i);
		}

		for (int i = 1; i <= 50; i++) {
			cartao.addNumero(i);
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio,
				new Cartao[] { cartao });

		assertEquals(0, resultado.getCartoesCom20Pontos().length);
		assertEquals(1, resultado.getCartoesCom19Pontos().length);
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * Testará 1 cartao com 18 pontos.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferir1com18Pontos() throws Exception {
		Cartao cartao = new Cartao();
		Sorteio sorteio = new Sorteio();

		for (int i = 0; i <= 19; i++) {
			sorteio.addNumero(i);
		}

		for (int i = 2; i <= 51; i++) {
			cartao.addNumero(i);
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio,
				new Cartao[] { cartao });

		assertEquals(0, resultado.getCartoesCom20Pontos().length);
		assertEquals(0, resultado.getCartoesCom19Pontos().length);
		assertEquals(1, resultado.getCartoesCom18Pontos().length);
		assertEquals(0, resultado.getCartoesCom17Pontos().length);
		assertEquals(0, resultado.getCartoesCom16Pontos().length);
		assertEquals(0, resultado.getCartoesCom0Pontos().length);
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * Testará 1 cartao com 17 pontos.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferir1com17Pontos() throws Exception {
		Cartao cartao = new Cartao();
		Sorteio sorteio = new Sorteio();

		for (int i = 0; i <= 19; i++) {
			sorteio.addNumero(i);
		}

		for (int i = 3; i <= 52; i++) {
			cartao.addNumero(i);
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio,
				new Cartao[] { cartao });

		assertEquals(0, resultado.getCartoesCom20Pontos().length);
		assertEquals(0, resultado.getCartoesCom19Pontos().length);
		assertEquals(0, resultado.getCartoesCom18Pontos().length);
		assertEquals(1, resultado.getCartoesCom17Pontos().length);
		assertEquals(0, resultado.getCartoesCom16Pontos().length);
		assertEquals(0, resultado.getCartoesCom0Pontos().length);
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * Testará 1 cartao com 16 pontos.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferir1com16Pontos() throws Exception {
		Cartao cartao = new Cartao();
		Sorteio sorteio = new Sorteio();

		for (int i = 0; i <= 19; i++) {
			sorteio.addNumero(i);
		}
		// 
		for (int i = 4; i <= 53; i++) {
			cartao.addNumero(i);
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio,
				new Cartao[] { cartao });

		assertEquals(0, resultado.getCartoesCom20Pontos().length);
		assertEquals(0, resultado.getCartoesCom19Pontos().length);
		assertEquals(0, resultado.getCartoesCom18Pontos().length);
		assertEquals(0, resultado.getCartoesCom17Pontos().length);
		assertEquals(1, resultado.getCartoesCom16Pontos().length);
		assertEquals(0, resultado.getCartoesCom0Pontos().length);
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * Testará 500 cartões com números aleatórios e colherá os resultados.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferirUmMonteDeCartões() throws Exception {
		Gerador gerador = new Gerador();
		Sorteio sorteio = gerador.gerarSorteio();

		List cartoesGerados = new ArrayList<Cartao>();
		int quantidade = 500;
		for (int i = 0; i < quantidade; i++) {
			cartoesGerados.add(gerador.gerarCartao());
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio,
				(Cartao[]) cartoesGerados.toArray(new Cartao[cartoesGerados
						.size()]));
		StringBuilder strBuilder = new StringBuilder("###############\n");
		
		strBuilder.append("Parabéns campeão, hoje é seu dia de sorte!\n");
		strBuilder.append("Com " + quantidade
				+ " cartões, temos os seguintes resultados:\n");
		
		strBuilder.append(20 + " pontos: " + resultado.getCartoesCom20Pontos() + "\n");
		strBuilder.append(19 + " pontos: " + resultado.getCartoesCom19Pontos() + "\n");
		strBuilder.append(18 + " pontos: " + resultado.getCartoesCom18Pontos() + "\n");
		strBuilder.append(17 + " pontos: " + resultado.getCartoesCom17Pontos() + "\n");
		strBuilder.append(16 + " pontos: " + resultado.getCartoesCom16Pontos() + "\n");
		strBuilder.append(0 + " pontos: " + resultado.getCartoesCom0Pontos() + "\n");
	
			
		System.out.println(strBuilder.toString());
	}

	/**
	 * 
	 * Test method for
	 * {@link lotopro.ProcessadorResultados#conferir(com.lotopro.Sorteio, com.lotopro.Cartao[])}.
	 * <p>
	 * Testar 3 cartoes com 0 pontos e um com 16 pontos.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConferir3cartoesCom0Pontos() throws Exception {
		Cartao cartao3 = new Cartao();
		Cartao cartao2 = new Cartao();
		Cartao cartao1 = new Cartao();

		Cartao cartao16Pontos = new Cartao();

		Sorteio sorteio = new Sorteio();

		for (int i = 0; i <= 19; i++) {
			sorteio.addNumero(i);
		}

		for (int i = 4; i <= 53; i++) {
			cartao16Pontos.addNumero(i);
		}
		for (int i = 20; i <= 69; i++) {
			cartao1.addNumero(i);
		}

		for (int i = 20; i <= 69; i++) {
			cartao2.addNumero(i);
		}

		for (int i = 20; i <= 69; i++) {
			cartao3.addNumero(i);
		}

		ProcessadorResultados proc = new ProcessadorResultados();
		ResultadoConferencia resultado = proc.conferir(sorteio, new Cartao[] {
				cartao1, cartao2, cartao3 ,cartao16Pontos});

		assertEquals(0, resultado.getCartoesCom20Pontos().length);
		assertEquals(0, resultado.getCartoesCom19Pontos().length);
		assertEquals(0, resultado.getCartoesCom18Pontos().length);
		assertEquals(0, resultado.getCartoesCom17Pontos().length);
		assertEquals(1, resultado.getCartoesCom16Pontos().length);
		assertEquals(3, resultado.getCartoesCom0Pontos().length);
	}
}
