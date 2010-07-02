/**
 * 
 */
package com.openlastfm.backing;

import java.io.Serializable;

import com.openlastfm.conf.Configuracoes;
import com.openlastfm.conf.GoogleAnalytics;
import com.openlastfm.datastore.BigTableManager;

/**
 * @author duduzerah
 *
 */
public class ConfModel implements Serializable {

	public void salvar(Configuracoes conf) {
		new BigTableManager().salvarConfiguracoes(conf);
		
	}

	
	
}
