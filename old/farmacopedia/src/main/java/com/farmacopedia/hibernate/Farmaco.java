package com.farmacopedia.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import com.farmacopedia.hibernate.root.Entidade;

@Entity
@SequenceGenerator(name = "MY_SEQ", sequenceName = "SEQ_FARMACO")
public class Farmaco extends Entidade {

	private String descricao;

	private String nome;

	@Column(name = "descricao", length = 4000, nullable = false, unique = true)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "nome", length = 400)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
