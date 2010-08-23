package com.farmacopedia.hibernate.root;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {

	private long id;

	private Calendar ultMod;

	/**
	 * @return o id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_SEQ")
	@Column(name = "id")
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            o id a ser configurado
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return o ultMod
	 */
	public Calendar getUltMod() {
		return ultMod;
	}

	/**
	 * @param ultMod
	 *            o ultMod a ser configurado
	 */
	public void setUltMod(Calendar ultMod) {
		this.ultMod = ultMod;
	}
}
