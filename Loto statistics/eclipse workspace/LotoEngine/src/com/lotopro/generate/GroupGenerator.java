package com.lotopro.generate;

import com.lotopro.Cartao;

/**
 * Classe que gera uma quantidade x de cart�es diferentes.
 */
public class GroupGenerator {
	private Gerador gerador;

	public GroupGenerator() {
		gerador = new Gerador();
	}

	/**
	 * Gerar n cart�es.
	 */
	public Cartao[] gerarCartoes(int quantidade) {
		Cartao cartoes[] = new Cartao[quantidade];
		for (int i = 0; i < cartoes.length; i++) {
			cartoes[i] = gerador.gerarCartao();
		}
		return cartoes;
	}
}
