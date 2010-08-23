/**
 * 
 */
package com.openlastfm.backing;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

/**
 * @author duduzerah
 * 
 */
public class Conf implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5997083613831708977L;
	private ConfController controller;
	private java.lang.String secret;
	private java.lang.String key;
	private java.lang.String googleAnalyticsCode;

	/**
	 * 
	 */
	public Conf() {
		if (controller == null) {
			controller = new ConfController(this);

		}
		controller.refreshView();
	}

	public java.lang.String getSecret() {
		
		return secret;
	}

	public void setSecret(java.lang.String secret) {
		this.secret = secret;
	}

	public java.lang.String getKey() {
		
		return key;
	}

	public void setKey(java.lang.String key) {
		this.key = key;
	}

	public void salvar(ActionEvent e) {
		controller.salvar(key, secret, googleAnalyticsCode);
	}

	/**
	 * @param googleAnalyticsCode
	 *            the googleAnalyticsCode to set
	 */
	public void setGoogleAnalyticsCode(java.lang.String googleAnalyticsCode) {
		this.googleAnalyticsCode = googleAnalyticsCode;
	}

	/**
	 * @return the googleAnalyticsCode
	 */
	public java.lang.String getGoogleAnalyticsCode() {
		
		return googleAnalyticsCode;
	}

}
