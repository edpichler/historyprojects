package com.lotopro;

/** 
 * Um sorteio da lotomania � um grupo de 20 n�meros �nicos 
 * */
public class Sorteio extends GrupoNumero {

	public static final int QUANTIDADE_SORTEIO_LOTOMANIA = 20;

	public Sorteio() {
		super(QUANTIDADE_SORTEIO_LOTOMANIA);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString().replace(" ",  " - ");
	}

}
