/**
 * 
 */
package com.openlastfm.conf;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author duduzerah
 * 
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class GoogleAnalytics {
	/*
	 * <script type="text/javascript"> var gaJsHost = (("https:" ==
	 * document.location.protocol) ? "https://ssl." : "http://www.");
	 * document.write(unescape("%3Cscript src='" + gaJsHost +
	 * "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
	 * </script> <script type="text/javascript"> try { var pageTracker =
	 * _gat._getTracker("UA-10142164-1"); pageTracker._trackPageview(); }
	 * catch(err) {}</script>
	 */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key jdoKey;
	
	@Persistent
	private String html;

	/**
	 * @param jdoKey
	 *            the jdoKey to set
	 */
	public void setJdoKey(Key jdoKey) {
		this.jdoKey = jdoKey;
	}

	/**
	 * @return the jdoKey
	 */
	public Key getJdoKey() {
		return jdoKey;
	}

	/**
	 * @param html the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}
}
