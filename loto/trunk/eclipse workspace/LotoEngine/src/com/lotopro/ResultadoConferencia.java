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

	private List<Cartao> cartoesSortudos15Pontos, cartoesSortudos14Pontos,
			cartoesSortudos13Pontos, cartoesSortudos12Pontos,
			cartoesSortudos11Pontos;

	public ResultadoConferencia() {
		this.cartoesSortudos11Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos12Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos13Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos14Pontos = new ArrayList<Cartao>();
		this.cartoesSortudos15Pontos = new ArrayList<Cartao>();
	}

	/** Incrementa a quantidade de cartões que tem n pontos */
	public void incrementaCartaoComPontos(int quantidadePontos, Cartao card) {
		if (logger.isDebugEnabled()) {
			logger.debug("incrementaCartaoComPontos(int) - start"); //$NON-NLS-1$
		}

		switch (quantidadePontos) {
		case 11:
			cartoesSortudos11Pontos.add(card);
			break;
		case 12:
			cartoesSortudos12Pontos.add(card);
			break;
		case 13:
			cartoesSortudos13Pontos.add(card);
			break;
		case 14:
			cartoesSortudos14Pontos.add(card);
			break;
		case 15:
			cartoesSortudos15Pontos.add(card);
			break;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("incrementaCartaoComPontos(int) - end"); //$NON-NLS-1$
		}
	}

	public Cartao[] getCartoesCom11Pontos() {
		return cartoesSortudos11Pontos
				.toArray(new Cartao[cartoesSortudos11Pontos.size()]);
	}

	public Cartao[] getCartoesCom12Pontos() {
		return cartoesSortudos12Pontos
				.toArray(new Cartao[cartoesSortudos12Pontos.size()]);
	}

	public Cartao[] getCartoesCom13Pontos() {
		return cartoesSortudos13Pontos
				.toArray(new Cartao[cartoesSortudos13Pontos.size()]);
	}

	public Cartao[] getCartoesCom14Pontos() {
		return cartoesSortudos14Pontos
				.toArray(new Cartao[cartoesSortudos14Pontos.size()]);
	}

	public Cartao[] getCartoesCom15Pontos() {
		return cartoesSortudos15Pontos
				.toArray(new Cartao[cartoesSortudos15Pontos.size()]);
	}

}
