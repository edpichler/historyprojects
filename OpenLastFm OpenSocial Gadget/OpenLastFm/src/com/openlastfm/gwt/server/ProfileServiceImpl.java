package com.openlastfm.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.openlastfm.conf.LastFmUserAccount;
import com.openlastfm.gwt.client.Musica;
import com.openlastfm.gwt.client.ProfileService;

@SuppressWarnings("serial")
public class ProfileServiceImpl extends RemoteServiceServlet implements
		ProfileService {
	ProfileModel model = new ProfileModel();
	@Override
	public String getImageUrlArtist(String user, String pass) {
		
		// TODO Auto-generated method stub
		return model.getImageUrlArtist(new LastFmUserAccount(user, pass));
	}

	@Override
	public Musica[] getMusicas(String user) {
		return model.getMusicasTocadas(user);
	}
}
