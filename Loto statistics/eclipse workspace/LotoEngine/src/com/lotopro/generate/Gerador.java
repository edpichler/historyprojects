package com.lotopro.generate;

import java.util.Collection;

import org.apache.log4j.Logger;

import com.lotopro.Cartao;
import com.lotopro.GrupoNumero;
import com.lotopro.Sorteio;

/** Gerador de grupos de n�meros */
public class Gerador {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Gerador.class);

	public Cartao gerarCartao() {
		if (logger.isDebugEnabled()) {
			logger.debug("gerarCartao() - start"); //$NON-NLS-1$
		}

		Cartao cartao = new Cartao();
		gerarGrupo(cartao);

		if (logger.isDebugEnabled()) {
			logger.debug("gerarCartao() - end"); //$NON-NLS-1$
		}
		return cartao;
	}

	public Sorteio gerarSorteio() {
		if (logger.isDebugEnabled()) {
			logger.debug("gerarSorteio() - start"); //$NON-NLS-1$
		}

		Sorteio sorteio = new Sorteio();
		gerarGrupo(sorteio);

		if (logger.isDebugEnabled()) {
			logger.debug("gerarSorteio() - end"); //$NON-NLS-1$
		}
		return sorteio;
	}

	private void gerarGrupo(GrupoNumero grupoNumero) {
		if (logger.isDebugEnabled()) {
			logger.debug("gerarCartoes() - start"); //$NON-NLS-1$
		}
		Collection<Integer> numeros = grupoNumero.getNumeros();
		while (numeros.size() < grupoNumero.getQuantidadeMaximaNumeros()) {
			int numeroNovo = (int) (Math.random() * 100);// gera n�meros de 0 �
														// 99
			if (!numeros.contains(numeroNovo)) {
				try {
					grupoNumero.addNumero(numeroNovo);
				} catch (Exception exc) {
					logger.error(String.format(
							"O n�mero %0 j� existe no grupo! Gerando outro...",
							numeroNovo), exc);
				}
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("gerarCartoes() - end"); //$NON-NLS-1$
		}
	}

}
