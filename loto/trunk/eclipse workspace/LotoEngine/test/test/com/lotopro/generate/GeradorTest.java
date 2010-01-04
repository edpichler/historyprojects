/**
 * 
 */
package test.com.lotopro.generate;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lotopro.Cartao;
import com.lotopro.Sorteio;
import com.lotopro.generate.Gerador;

/**
 * @author Administrador
 * 
 */
public class GeradorTest {

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
	 * Testa a quantidade de numeros no cartao
	 */
	@Test
	public void testGerarCartao() {
		Gerador ger = new Gerador();
		Cartao cartao = ger.gerarCartao();
		System.out.println(cartao.toString());
		assertTrue("Quantidade de números no cartão está errada ", cartao
				.getNumeros().size() == Cartao.QUANTIDADE_LOTOFACIL);
	}

	/**
	 * Testa a quantidade de numeros no sorteio
	 */
	@Test
	public void testGerarSorteio() {
		Gerador ger = new Gerador();
		Sorteio sorteio = ger.gerarSorteio();
		System.out.println(sorteio.toString());
		assertTrue("Quantidade de números no sortei está errada ", sorteio
				.getNumeros().size() == Sorteio.QUANTIDADE_SORTEIO_LOTOMANIA);
	}	
	
}
