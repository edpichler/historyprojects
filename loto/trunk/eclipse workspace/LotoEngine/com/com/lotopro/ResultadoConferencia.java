/**
 * 
 */
package com.lotopro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Classe para guardar a quantidade de pontos ao conferir os cartões com um
 * sorteio.
 * 
 * @author Administrador
 * 
 */
public class ResultadoConferencia {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ResultadoConferencia.class);

	private List<Cartao> cartoesSortudos20Pontos, cartoesSortudos19Pontos,
			cartoesSortudos18Pontos, cartoesSortudos17Pontos,
			cartoesSortudos16Pontos, cartoesSortudos0Pontos;

	public ResultadoConferencia() {
		this.cartoesSortudos20Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos19Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos18Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos17Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos16Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos0Pontos = new ArrayList<Cartao>();
	}

	/** Incrementa a quantidade de cartões que tem n pontos */
	public void incrementaCartaoComPontos(int quantidadePontos, Cartao card) {
		if (logger.isDebugEnabled()) {
			logger.debug("incrementaCartaoComPontos(int) - start"); //$NON-NLS-1$
		}

		switch (quantidadePontos) {
		case 16:
			cartoesSortudos16Pontos.add(card);
			break;
		case 17:
			cartoesSortudos17Pontos.add(card);
			break;
		case 18:
			cartoesSortudos18Pontos.add(card);
			break;
		case 19:
			cartoesSortudos19Pontos.add(card);
			break;
		case 20:
			cartoesSortudos20Pontos.add(card);
			break;
		case 0:
			cartoesSortudos0Pontos.add(card);
			break;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("incrementaCartaoComPontos(int) - end"); //$NON-NLS-1$
		}
	}

	public Cartao[] getCartoesCom20Pontos() {
		return cartoesSortudos20Pontos.toArray(new Cartao[cartoesSortudos20Pontos.size()]);
	}

	public Cartao[] getCartoesCom19Pontos() {
		return cartoesSortudos19Pontos.toArray(new Cartao[cartoesSortudos19Pontos.size()]);
	}

	public Cartao[] getCartoesCom18Pontos() {
		return cartoesSortudos18Pontos.toArray(new Cartao[cartoesSortudos18Pontos.size()]);
	}

	public Cartao[] getCartoesCom17Pontos() {
		return cartoesSortudos17Pontos.toArray(new Cartao[cartoesSortudos17Pontos.size()]);
	}

	public Cartao[] getCartoesCom16Pontos() {
		return cartoesSortudos16Pontos.toArray(new Cartao[cartoesSortudos16Pontos.size()]);
	}

	public Cartao[] getCartoesCom0Pontos() {
		return cartoesSortudos0Pontos.toArray(new Cartao[cartoesSortudos0Pontos.size()]);
	}	
}
