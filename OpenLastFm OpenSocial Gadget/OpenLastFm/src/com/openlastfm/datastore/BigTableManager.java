/**
 * 
 */
package com.openlastfm.datastore;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;

import org.apache.log4j.Logger;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.openlastfm.conf.Configuracoes;
import com.openlastfm.conf.GoogleAnalytics;

/**
 * @author duduzerah
 * 
 */
public class BigTableManager {

	/**
	 * Chave para persistencia no JDO da classe singleton de Configura��es.
	 * (Perfil?)
	 * */
	private static final String UNIQUE_KEY = "uniqueKey";

	/**
	 * Carrega as configura��es padr�o do banco
	 * 
	 * @return
	 * */
	public Configuracoes loadConfiguracoes() throws JDOObjectNotFoundException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Logger logger = org.apache.log4j.Logger.getLogger(Configuracoes.class);
		Configuracoes singleton = null;
		try {

			singleton = pm.getObjectById(Configuracoes.class, UNIQUE_KEY);
			pm.retrieve(singleton);
			logger.info("Configura��es encontradas no BigTable.");
			return singleton;
		} catch (JDOObjectNotFoundException e) {
			throw e;
			
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}

	/**
	 * Salva as informa��es do singleton de configura��es no BigTable.
	 * */
	public void salvarConfiguracoes(final Configuracoes singleton ) {
		// n�o encontrou no BD
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {			
			singleton.setId(UNIQUE_KEY);
			final Key jdoKeyGA = KeyFactory.createKey(GoogleAnalytics.class
					.getSimpleName(), UNIQUE_KEY);

			singleton.getGoogleAnalytics().setJdoKey(jdoKeyGA);
			pm.makePersistent(singleton);
			
			Logger logger = org.apache.log4j.Logger
					.getLogger(Configuracoes.class);
			logger.info("Configura��es foram salvas.");
		} catch (Exception e) {
			Logger.getLogger(Configuracoes.class).error(e);
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}

}
