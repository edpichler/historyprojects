package com.openlastfm.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

public class CanvasEntry implements EntryPoint {
	private final CanvasServiceAsync canvasService = GWT
	.create(CanvasService.class);
	
	@Override
	public void onModuleLoad() {
		final RootPanel divTopSongs = RootPanel.get("divTopSongs");
		final RootPanel divTopArtist = RootPanel.get("divTopArtists");
		
		initTopSongs(divTopSongs);
		initTopArtists(divTopArtist);
		

	}

	private void initTopSongs(final RootPanel divTopSongs) {
		canvasService.getImageUrlSong("duduzerah", new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				Window.alert(arg0.getMessage());
			}

			@Override
			public void onSuccess(String chartUrl) {
				Image topSongs= new Image(chartUrl);
				divTopSongs.add(topSongs);
			}
			
		});
	}
	
	private void initTopArtists(final RootPanel divTopArtists) {
		canvasService.getImageUrlArtist("duduzerah", new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				Window.alert(arg0.getMessage());
			}

			@Override
			public void onSuccess(String chartUrl) {
				Image topArtists= new Image(chartUrl);
				divTopArtists.add(topArtists);
			}
			
		});
	}

}
