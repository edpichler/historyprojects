package com.openlastfm.conf;

import java.io.Serializable;

/**
 * Conta de usuário lastfm.
 * */
public class LastFmUserAccount  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1084937214480009231L;
	private String username;
	private String password;

	public LastFmUserAccount(String username, String pass) {
		this.username = username;
		this.password = pass;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
}
