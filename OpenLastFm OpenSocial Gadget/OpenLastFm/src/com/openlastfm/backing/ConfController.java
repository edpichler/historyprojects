/**
 * 
 */
package com.openlastfm.backing;

import java.io.Serializable;

import com.openlastfm.conf.Configuracoes;
import com.openlastfm.conf.GoogleAnalytics;

/**
 * @author duduzerah
 * 
 */
public class ConfController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7815512661656679129L;
	private ConfModel model;
	private Conf view;

	public ConfController(Conf param) {
		this.view = param;
		model = new ConfModel();

	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(Conf view) {
		this.view = view;
	}

	/**
	 * @return the view
	 */
	public Conf getView() {
		return view;
	}

	public void salvar(String key, String secret, String googleAnalytics) {
		GoogleAnalytics analyt = new GoogleAnalytics();
		analyt.setHtml(googleAnalytics);
		final Configuracoes conf = Configuracoes.getInstance();
		conf.setGoogleAnalytics(analyt);
		conf.setLastFmKey(key);
		conf.setLastFmSecret(secret);		
		model.salvar(conf);
		refreshView();
	}

	public void refreshView() {
		final Configuracoes confs = Configuracoes.getInstance();
		view.setKey(confs.getLastFmKey());
		view.setSecret(confs.getLastFmSecret());
		view.setGoogleAnalyticsCode(Configuracoes.getInstance()
				.getGoogleAnalytics().getHtml());
	}
}
