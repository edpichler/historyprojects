package com.pichler.hibernate;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import com.pichler.hibernate.root.Entidade;

/**
 * Pessoa
 * */

@Entity
@SequenceGenerator(name = "MY_SEQ", sequenceName = "SEQ_PESSOA")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa extends Entidade{
	
	private String nome;
	private Calendar dataNascimento;
	private String cpf;
	private String rg;
	private String telefone;
	private String email;
	private boolean sexo;	
	
	@Column(name = "nome", length = 60, nullable = false, unique = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "cpf", length = 11, nullable = true, unique = true)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Column(name = "dataNascimento", nullable = false, unique = false)
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Column(name = "email", length = 60, nullable = true, unique = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "rg", length = 8, nullable = false, unique = true)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	@Column(name = "telefone", length = 20, nullable = true, unique = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(name = "sexo", nullable = false, unique = false)
	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
}
