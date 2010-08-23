package net.pqno.server;

import net.pqno.client.UrlShorterService;
import net.pqno.engine.UrlSuffixGenerator;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UrlShortServiceImpl extends RemoteServiceServlet implements
		UrlShorterService {

	public String sortNow(String urlToShort) throws Exception {
		UrlSuffixGenerator gen = new UrlSuffixGenerator();

		return gen.getSuffix(urlToShort);

	}
}
