package loto.gui;

import com.lotopro.Cartao;
import com.lotopro.generate.Gerador;

public class FrmMainModel {
	
	private Cartao cards[];
	
	public Cartao[] getCards(int qtd) {
		Gerador g = new Gerador();
		cards = new Cartao[qtd];
		for (int i = 0; i < qtd; i++) {
			cards[i] = g.gerarCartao();
		}

		return cards;
	}

	public Cartao[] getCartoes() {
			return this.cards;
	}
}
