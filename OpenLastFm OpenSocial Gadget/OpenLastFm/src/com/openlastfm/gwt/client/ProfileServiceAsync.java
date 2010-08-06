package com.openlastfm.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProfileServiceAsync {
	void getImageUrlArtist(String user, String pass,
			AsyncCallback<String> callback);

	void getMusicas(String user,AsyncCallback<Musica[]> callback);
}
