package com.openlastfm.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.openlastfm.backing.CanvasModel;
import com.openlastfm.gwt.client.CanvasService;

@SuppressWarnings("serial")
public class CanvasServiceImpl extends RemoteServiceServlet implements
		CanvasService {
	CanvasModel model = new CanvasModel();
	@Override
	public String getImageUrlArtist(String user) {
		
		// TODO Auto-generated method stub
		return model.getChartTopArtists(user);
	}	
	
	@Override
	public String getImageUrlSong(String user) {
		
		// TODO Auto-generated method stub
		return model.getChartTopSongs(user);
	}	
}
