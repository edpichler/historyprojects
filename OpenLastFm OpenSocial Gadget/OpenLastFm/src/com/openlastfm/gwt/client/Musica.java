package com.openlastfm.gwt.client;

import java.io.Serializable;
import java.util.Date;

public class Musica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9176734138691519376L;
	private String nome;
	private Date playedWhen;
	private boolean nowPlaying;

	public Musica() {

	}

	public Musica(String nome, String artist, Date playedWhen,
			boolean nowPlaying) {
		this.nome = artist + " - " + nome;

		this.playedWhen = playedWhen;
		this.nowPlaying = nowPlaying;
	}

	/**
	 * @param playedWhen
	 *            the playedWhen to set
	 */
	public void setPlayedWhen(Date playedWhen) {
		this.playedWhen = playedWhen;
	}

	/**
	 * @return the playedWhen
	 */
	public Date getPlayedWhen() {
		return playedWhen;
	}

	/**
	 * @param nowPlaying
	 *            the nowPlaying to set
	 */
	public void setNowPlaying(boolean nowPlaying) {
		this.nowPlaying = nowPlaying;
	}

	/**
	 * @return the nowPlaying
	 */
	public boolean isNowPlaying() {
		return nowPlaying;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

}
