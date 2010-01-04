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
	 *            quantidade m�xima de n�meros nesse grupo
	 */
	public GrupoNumero(int quantidadeMaxima) {
		maximoNumeros = quantidadeMaxima;
	}

	/**
	 * Adiciona n�meros no grupo.
	 */
	public void addNumero(int numero) throws Exception {
		if (numero > 99 || numero < 00) {
			throw new Exception("S� pode marcar n�meros entre 00 e 99");
		}
		if (mapa.size() == maximoNumeros) {
			throw new Exception("A quantidade m�xima de n�meros � "
					+ maximoNumeros);
		}
		if (mapa.containsKey(numero)) {
			throw new Exception("Este n�mero j� foi marcado");
		}
		mapa.put(numero, true);
	}

	/** @return os n�meros do grupo */
	public Collection<Integer> getNumeros() {
		return mapa.keySet();
	}

	public int getQuantidadeMaximaNumeros() {
		return maximoNumeros;
	}

	/**
	 * @return true caso o n�mero exista no grupo
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
