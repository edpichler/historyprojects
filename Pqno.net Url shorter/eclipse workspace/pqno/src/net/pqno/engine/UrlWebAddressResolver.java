package net.pqno.engine;

import net.pqno.bigtable.BigTableManager;
import net.pqno.vo.WebAddress;


public class UrlWebAddressResolver {
	private BigTableManager bigTableManager;

	public WebAddress getWebAddress(String suffix) {
		if (bigTableManager == null) {
			bigTableManager = new BigTableManager();
		}
		return bigTableManager.getWebAddressBySuffix(suffix);
	}
}
