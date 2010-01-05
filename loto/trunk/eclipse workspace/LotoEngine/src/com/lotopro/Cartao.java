package com.lotopro;



public class Cartao extends GrupoNumero {

	public static final int QUANTIDADE_LOTOMANIA = 50;
	private boolean premiado;

	public Cartao() {
		super(QUANTIDADE_LOTOMANIA);
	}

	public void setPremiado(boolean b) {
		this.premiado = b;
		
	}

	public boolean isPremiado() {
		return premiado;
	}	

}
