package com.openlastfm.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CanvasServiceAsync {
	void getImageUrlArtist(String user,
			AsyncCallback<String> callback);
	
	void getImageUrlSong(String user,
			AsyncCallback<String> callback);

}
