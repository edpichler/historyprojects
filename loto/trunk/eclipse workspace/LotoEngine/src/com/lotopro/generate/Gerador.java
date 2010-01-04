package com.lotopro.generate;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.lotopro.Cartao;
import com.lotopro.GrupoNumero;
import com.lotopro.Sorteio;

/** Gerador de grupos de números */
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
		ArrayList<Integer> excludes = new ArrayList<Integer>();
		/*
		 * excludes.add(21); excludes.add(22); excludes.add(23);
		 * excludes.add(24); excludes.add(25);
		 */
		gerarGrupo(cartao, excludes);

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

	private void gerarGrupo(GrupoNumero grupoNumero,
			Collection<Integer> excludes) {
		if (logger.isDebugEnabled()) {
			logger.debug("gerarCartoes() - start"); //$NON-NLS-1$
		}
		Collection<Integer> numeros = grupoNumero.getNumeros();
		while (numeros.size() < grupoNumero.getQuantidadeMaximaNumeros()) {
			int numeroNovo = (int) (Math.random() * 25);// gera números de 0 à
			// 99

			if (numeroNovo > 0 && !excludes.contains(numeroNovo)
					&& !numeros.contains(numeroNovo)) {
				try {
					grupoNumero.addNumero(numeroNovo);
				} catch (Exception exc) {
					logger.error(String.format(
							"O número %0 já existe no grupo! Gerando outro...",
							numeroNovo), exc);
				}
			}

		}

		if (logger.isDebugEnabled()) {
			logger.debug("gerarCartoes() - end"); //$NON-NLS-1$
		}
	}

	private void gerarGrupo(GrupoNumero grupoNumero) {
		Collection<Integer> zero = new ArrayList<Integer>();
		gerarGrupo(grupoNumero, zero);
	}

}
