package loto.gui;

import com.lotopro.Cartao;
import com.lotopro.ProcessadorResultados;
import com.lotopro.ResultadoConferencia;
import com.lotopro.Sorteio;
import com.lotopro.generate.Gerador;

public class PanelMainModel {

	private Sorteio sorteio;

	private ResultadoConferencia resultado;

	public Sorteio novoSorteio() {
		Gerador g = new Gerador();
		sorteio = g.gerarSorteio();
		return sorteio;
	}

	public ResultadoConferencia conferirResultado(Cartao[] cartoes) {
		if (sorteio == null
				|| sorteio.getNumeros().size() < sorteio
						.getQuantidadeMaximaNumeros()) {
			throw new IllegalArgumentException(
					"Para conferir, é necessário antes gerar um sorteio.");
		}
		if (cartoes == null || cartoes.length < 1) {
			throw new IllegalArgumentException(
					"Para conferir, é necessário antes gerar uns cartões.");
		}
		ProcessadorResultados proc = new ProcessadorResultados();
		resultado = proc.conferir(sorteio, cartoes);
		return resultado;
	}

	/**
	 * Retorna o último resultado de conferencia
	 */
	public ResultadoConferencia getResultadoConferencia() {
		return resultado;
	}

	public Sorteio getSorteio() {
		return sorteio;
	}

}
