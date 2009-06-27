package com.lotopro;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public abstract class GrupoNumero {
	private Map<Integer, Boolean> mapa = new TreeMap<Integer, Boolean>();

	private int maximoNumeros;

	/**
	 * @param quantidadeMaxima
	 *            quantidade máxima de números nesse grupo
	 */
	public GrupoNumero(int quantidadeMaxima) {
		maximoNumeros = quantidadeMaxima;
	}

	/**
	 * Adiciona números no grupo.
	 */
	public void addNumero(int numero) throws Exception {
		if (numero > 99 || numero < 00) {
			throw new Exception("Só pode marcar números entre 00 e 99");
		}
		if (mapa.size() == maximoNumeros) {
			throw new Exception("A quantidade máxima de números é "
					+ maximoNumeros);
		}
		if (mapa.containsKey(numero)) {
			throw new Exception("Este número já foi marcado");
		}
		mapa.put(numero, true);
	}

	/** @return os números do grupo */
	public Collection<Integer> getNumeros() {
		return mapa.keySet();
	}

	public int getQuantidadeMaximaNumeros() {
		return maximoNumeros;
	}

	/**
	 * @return true caso o número exista no grupo
	 */
	public boolean hasNumero(int num) {
		return this.mapa.containsKey(num);
	}

	@Override
	public String toString() {
		StringBuilder stbu = new StringBuilder();
		Set<Entry<Integer, Boolean>> entrySet = mapa.entrySet();

		for (Entry<Integer, Boolean> entry : entrySet) {
			int element = entry.getKey();
			if (element < 10) {
				stbu.append(0);
			}
			stbu.append(element);
			stbu.append(" ");
		}
		return stbu.toString().trim();
	}
}
