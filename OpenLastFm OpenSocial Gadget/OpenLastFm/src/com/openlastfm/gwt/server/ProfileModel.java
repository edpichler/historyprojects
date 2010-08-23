/**
 * 
 */
package com.openlastfm.gwt.server;

import java.io.Serializable;

import com.openlastfm.conf.LastFmManager;
import com.openlastfm.conf.LastFmUserAccount;
import com.openlastfm.gwt.client.Musica;

/**
 * @author duduzerah
 * 
 */
public class ProfileModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5939838069582065705L;

	public String getImageUrlArtist(LastFmUserAccount lastFmUserAccount) {
		String imageUrl = LastFmManager.getInstance().getImageURLImageLastMusic(lastFmUserAccount.getUsername());
		if (imageUrl == null || imageUrl.length() == 0){
			imageUrl = LastFmManager.getInstance().getImageURLImageLastArtist(lastFmUserAccount.getUsername());
		}
		return  imageUrl;
	}

	public Musica[] getMusicasTocadas(String username) {
		return LastFmManager.getInstance().getMusicasTocadas(username);
	}
}
