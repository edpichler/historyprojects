package com.lotopro;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class ProcessadorResultados {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ProcessadorResultados.class);

	public ResultadoConferencia conferir(Sorteio sorteio, Cartao[] cartoes) {
		if (logger.isDebugEnabled()) {
			logger.debug("conferir(Sorteio, Cartao[]) - start"); //$NON-NLS-1$
		}

		ResultadoConferencia resultadoConferencia = new ResultadoConferencia();
		Collection<Integer> sorteioNumeros = sorteio.getNumeros();
		if (logger.isDebugEnabled()) {
			logger.debug("Sorteio: " + sorteio);
		}

		for (int i = 0; i < cartoes.length; i++) {
			Cartao cartao = cartoes[i];
			if (logger.isDebugEnabled()) {
				logger.debug("Conferindo o cartão" + cartao);
			}
			int pontos = confereCartao(sorteio, cartao);

			verificaPontosSuficientes(pontos++, cartao, resultadoConferencia);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("conferir(Sorteio, Cartao[]) - end"); //$NON-NLS-1$
		}
		return resultadoConferencia;
	}

	/**
	 * @return quantidade de pontos/acertos
	 */
	public int confereCartao(Sorteio sorteio, Cartao card) {
		if (sorteio == null) {
			throw new IllegalArgumentException("Gere um sorteio antes.");
		}
		if (card == null) {
			throw new IllegalArgumentException("Gere um cartão antes.");
		}
		Collection<Integer> sorteioNumeros = sorteio.getNumeros();

		int pontos = 0;
		Collection<Integer> numSorteados = sorteioNumeros;
		for (Iterator iter = numSorteados.iterator(); iter.hasNext();) {
			int numSorteado = (Integer) (iter.next());
			if (card.hasNumero(numSorteado)) {
				pontos++;
			}
		}
		return pontos;
	}

	/**
	 * Se tiver pontos suficentes, atualiza a conferencia.
	 */
	private void verificaPontosSuficientes(int qtdePontos, Cartao cartao,
			ResultadoConferencia resultadoConferencia) {
		if (qtdePontos > 15 || qtdePontos == 0) {
			cartao.setPremiado(true);
			resultadoConferencia.incrementaCartaoComPontos(qtdePontos, cartao);
		}else{
			cartao.setPremiado(false);
		}
	}
}
