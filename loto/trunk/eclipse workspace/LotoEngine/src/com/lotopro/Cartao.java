package com.lotopro;



public class Cartao extends GrupoNumero {

	public static final int QUANTIDADE_LOTOFACIL = 15;
	private boolean premiado;

	public Cartao() {
		super(QUANTIDADE_LOTOFACIL);
	}

	public void setPremiado(boolean b) {
		this.premiado = b;
		
	}

	public boolean isPremiado() {
		return premiado;
	}	

}
