/**
 * 
 */
package com.openlastfm.conf;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.openlastfm.datastore.BigTableManager;

/**
 * As configurações do sistema, pois o google não permite escrever em arquivos
 * '.properties'.
 * 
 * @author duduzerah
 * 
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Configuracoes {

	@PrimaryKey
	private String id; // just for JDO
	
	private static Configuracoes instance;
	@Persistent
	private GoogleAnalytics googleAnalytics;

	@Persistent
	private String lastFmKey;
	@Persistent
	private String lastFmSecret;
	
	private Configuracoes() {

	}

	public static Configuracoes getInstance() {
		if (instance == null) {
			try {
				instance = new BigTableManager().loadConfiguracoes();
			} catch (Exception e) {
				instance = new Configuracoes();
				instance.setGoogleAnalytics(new GoogleAnalytics());
				instance.setLastFmKey("key");
				instance.setLastFmSecret("secret");
				new BigTableManager().salvarConfiguracoes(instance);				
			}
		}
		return instance;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param googleAnalytics
	 *            the googleAnalytics to set
	 */
	public void setGoogleAnalytics(GoogleAnalytics googleAnalytics) {
		this.googleAnalytics = googleAnalytics;
	}

	/**
	 * @return the googleAnalytics
	 */
	public GoogleAnalytics getGoogleAnalytics() {
		return googleAnalytics;
	}

	/**
	 * @param lastFmKey the lastFmKey to set
	 */
	public void setLastFmKey(String lastFmKey) {
		this.lastFmKey = lastFmKey;
	}

	/**
	 * @return the lastFmKey
	 */
	public String getLastFmKey() {
		return lastFmKey;
	}

	/**
	 * @param lastFmSecret the lastFmSecret to set
	 */
	public void setLastFmSecret(String lastFmSecret) {
		this.lastFmSecret = lastFmSecret;
	}

	/**
	 * @return the lastFmSecret
	 */
	public String getLastFmSecret() {
		return lastFmSecret;
	}

}
