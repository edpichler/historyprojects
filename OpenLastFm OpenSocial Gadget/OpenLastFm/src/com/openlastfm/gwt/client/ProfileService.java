package com.openlastfm.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("profileServlet")
public interface ProfileService extends RemoteService {
	
	String getImageUrlArtist(String user, String pass);
	Musica[] getMusicas(String user);
}
