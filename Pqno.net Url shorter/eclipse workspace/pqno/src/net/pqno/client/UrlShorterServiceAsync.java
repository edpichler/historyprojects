package net.pqno.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UrlShorterServiceAsync {
	void sortNow(String url, AsyncCallback<String> callback);
}
