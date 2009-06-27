package test.com.lotopro.generate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lotopro.Cartao;
import com.lotopro.generate.GroupGenerator;

public class GroupGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGerarCartoes() {
		GroupGenerator gerador = new GroupGenerator();
		Cartao[] gerados = gerador.gerarCartoes(500);
		for (int i = 0; i < gerados.length; i++) {
			Cartao cartao = gerados[i];
			assertNotNull(cartao);
			System.out.println(cartao);
		}
	}

	@Test
	public void testQuantidade00() {
		GroupGenerator gerador = new GroupGenerator();
		int numeroCartoes = 500;
		Cartao[] gerados = gerador.gerarCartoes(numeroCartoes);
		int numeroEmQuestao = 00;
		int quantidade00 = 0;
		for (int i = numeroEmQuestao; i < gerados.length; i++) {
			Cartao cartao = gerados[i];

			if (cartao.getNumeros().contains(numeroEmQuestao)) {
				quantidade00++;
			}
		}
		System.out.println("Tem " + quantidade00 + " de cartoes com " + numeroEmQuestao);
		int quantidadeMinima = 170;
		assertTrue("Não tem muitos, somente " + quantidade00,
				quantidade00 > quantidadeMinima);
		
		int maximo = 300;
		assertFalse("Tem demais: " + quantidade00,
				quantidade00 > maximo);
	}
	@Test
	public void testQuantidade99() {
		GroupGenerator gerador = new GroupGenerator();
		int numeroCartoes = 500;
		Cartao[] gerados = gerador.gerarCartoes(numeroCartoes);
		int numeroEmQuestao = 99;
		int quantidade99 = 0;
		for (int i = numeroEmQuestao; i < gerados.length; i++) {
			Cartao cartao = gerados[i];

			if (cartao.getNumeros().contains(numeroEmQuestao)) {
				quantidade99++;
			}
		}
		System.out.println("Tem " + quantidade99 + " de cartoes com " + numeroEmQuestao);
		int quantidadeMinima = 170;
		assertTrue("Não tem muitos, somente " + quantidade99,
				quantidade99 > quantidadeMinima);
		
		int maximo = 300;
		assertFalse("Tem demais: " + quantidade99,
				quantidade99 > maximo);
	}
	
	@Test
	public void testQuantidade50() {
		GroupGenerator gerador = new GroupGenerator();
		int numeroCartoes = 500;
		Cartao[] gerados = gerador.gerarCartoes(numeroCartoes);
		int numeroEmQuestao = 50;
		int quantidade50 = 0;
		for (int i = numeroEmQuestao; i < gerados.length; i++) {
			Cartao cartao = gerados[i];

			if (cartao.getNumeros().contains(numeroEmQuestao)) {
				quantidade50++;
			}
		}
		System.out.println("Tem " + quantidade50 + " de cartoes com " + numeroEmQuestao);
		int quantidadeMinima = 170;
		assertTrue("Não tem muitos, somente " + quantidade50,
				quantidade50 > quantidadeMinima);
		int maximo = 300;
		assertFalse("Tem demais: " + quantidade50,
				quantidade50 > maximo);
	}
}
