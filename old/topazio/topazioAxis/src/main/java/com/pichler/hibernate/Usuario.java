package com.pichler.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import com.pichler.hibernate.root.Entidade;

@Entity
@SequenceGenerator(name = "MY_SEQ", sequenceName = "SEQ_USUARIO")
public class Usuario extends Entidade {

	private String password;

	private String username;

	@Column(name = "password", length = 40, nullable = false, unique = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "username", length = 40, nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
