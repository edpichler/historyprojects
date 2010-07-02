/**
 * 
 */
package net.pqno.bigtable;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import net.pqno.vo.Suffix;
import net.pqno.vo.WebAddress;


/**
 * @author duduzerah
 * 
 */
public class BigTableManager {

	/**
	 * 
	 * 
	 * @return o webAddress caso existir.
	 * */
	public net.pqno.vo.WebAddress getWebAddressByUrl(String url)
			throws JDOObjectNotFoundException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Logger logger = Logger.getLogger(BigTableManager.class.getName());
		WebAddress address = null;
		try {

			logger.info("Getting WebAddress...");
			Query queryWebAddress = pm.newQuery(WebAddress.class,
					"originalUrl == url");
			queryWebAddress.declareParameters("String url");

			List<WebAddress> results2 = (List<WebAddress>) queryWebAddress
					.execute(url);
			if (results2.size() > 0) {
				address = results2.get(0);
				pm.retrieve(address);
			}

			logger.info("Endereço encontrado no Banco:" + address);
			return address;
		} catch (JDOObjectNotFoundException e) {
			throw e;

		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}

	public long getLastNumberGenerated() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Logger logger = Logger.getLogger(BigTableManager.class.getName());

		try {

			logger.info("Getting the last number generated...");
			Query queryWebAddress = pm.newQuery(Suffix.class, "number > -2");
			queryWebAddress.setOrdering("number desc");
	
			final List<Suffix> valores = (List<Suffix>) queryWebAddress.execute();
			long retorno;
			if(valores.size() < 1){
				retorno = 0;
			}else{
				retorno  = valores.get(0).getNumber();
			}
			logger.info("It is:" + retorno);
			return retorno;
		} catch (JDOObjectNotFoundException e) {
			throw e;

		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}

	/**
	 * 
	 * 
	 * @return o webAddress caso existir.
	 * */
	@SuppressWarnings("unchecked")
	public net.pqno.vo.WebAddress getWebAddressBySuffix(String suffix)
			throws JDOObjectNotFoundException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Logger logger = Logger.getLogger(BigTableManager.class.getName());
		WebAddress address = null;
		try {
			logger.info("Getting Suffix...");

			Query querySuffix = pm.newQuery(Suffix.class, "suffix == sufixo");
			querySuffix.declareParameters("String sufixo");
			List<Suffix> results = (List<Suffix>) querySuffix.execute(suffix);
			if (results.size() < 1) {
				return null;
			}
			final Suffix suf = results.get(0);

			logger.info("Getting WebAddress...");
			Query queryWebAddress = pm.newQuery(WebAddress.class,
					"suffix == key");
			queryWebAddress.declareParameters("String key");

			List<WebAddress> results2 = (List<WebAddress>) queryWebAddress
					.execute(suf.getKey());
			if (results2.size() < 1) {
				return null;
			}

			address = results2.get(0);
			pm.retrieve(address);

			logger.info("Endereço encontrado no Banco:" + address);
			return address;
		} catch (JDOObjectNotFoundException e) {
			throw e;

		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}

	/**
	 * Salva
	 * 
	 * @throws Exception
	 * */
	public void saveWebAddress(final net.pqno.vo.WebAddress address)
			throws Exception {

		Logger logger = java.util.logging.Logger
				.getLogger(BigTableManager.class.getName());

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			address.setTimestamp(Calendar.getInstance().getTime());
			pm.makePersistent(address);

			logger.info("Webaddress foi salvo: " + address);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}

	/**
	 * Returns and old expirated suffix or create a new.
	 * */
	/*
	 * public String getAvailableSuffix() { PersistenceManager pm =
	 * PMF.get().getPersistenceManager(); Logger logger =
	 * Logger.getLogger(BigTableManager.class.getName()); WebAddress address =
	 * null; try {
	 * 
	 * Query newQuery = pm.newQuery(WebAddress.class);
	 * newQuery.setOrdering("timestamp ascending");
	 * 
	 * pm.retrieve(address); logger.info("Endereço encontrado no Banco:" +
	 * address); return address; } catch (JDOObjectNotFoundException e) { throw
	 * e;
	 * 
	 * } finally { if (!pm.isClosed()) { pm.close(); } } }
	 */
}
