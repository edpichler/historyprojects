package com.pichler.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import com.pichler.hibernate.root.Entidade;

/**
 * Pessoa
 * */

@Entity
@SequenceGenerator(name = "MY_SEQ", sequenceName = "SEQ_PESSOA")
public class Pessoa extends Entidade{
	
	private String nome;
	
	@Column(name = "nome", length = 60, nullable = false, unique = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
