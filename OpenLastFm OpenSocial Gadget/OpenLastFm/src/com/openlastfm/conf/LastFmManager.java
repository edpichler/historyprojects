/**
 * 
 */
package com.openlastfm.conf;

import java.util.Collection;
import java.util.Map;

import net.roarsoftware.lastfm.Artist;
import net.roarsoftware.lastfm.Authenticator;
import net.roarsoftware.lastfm.Caller;
import net.roarsoftware.lastfm.Image;
import net.roarsoftware.lastfm.ImageSize;
import net.roarsoftware.lastfm.PaginatedResult;
import net.roarsoftware.lastfm.Period;
import net.roarsoftware.lastfm.Session;
import net.roarsoftware.lastfm.Track;
import net.roarsoftware.lastfm.User;
import net.roarsoftware.lastfm.cache.ExpirationPolicy;

import org.apache.log4j.Logger;

import com.openlastfm.gwt.client.Musica;
import com.openlastfm.lastfmbindings.AppEngineCache;

/**
 * @author duduzerah
 * 
 */
public class LastFmManager {

	private static final String NO_IMAGE_URL = "some url";
	private static Session sessionLastFm;
	private static LastFmManager instance;
	private Logger logger = Logger.getLogger(this.getClass());

	public static Session getSession(String username, String password) {
		Logger logger = Logger.getLogger(LastFmManager.class);
		if (sessionLastFm == null) {
			logger.debug("Autenticando para criar uma sessão.");
			Configuracoes instance = Configuracoes.getInstance();

			sessionLastFm = Authenticator.getMobileSession(username,
					password, instance.getLastFmKey(), instance.getLastFmSecret());
			logger.debug("Autenticado..");
		}
		return sessionLastFm;
	}

	private LastFmManager() {
		final Caller instanceCaller = Caller.getInstance();
		if (!(instanceCaller.getCache() instanceof AppEngineCache)) {
			final AppEngineCache cache = new AppEngineCache();
			cache.setExpirationPolicy(new ExpirationPolicy() {

				public long getExpirationTime(String method,
						Map<String, String> params) {
					// 5 segundos
					return 5 * 1000;
				}

			});

			instanceCaller.setCache(cache);
		}
	}

	public static LastFmManager getInstance() {
		if (instance == null) {
			instance = new LastFmManager();

		}
		return instance;
	}

	public String getImageURL(String username, String password) {
		LastFmManager.getInstance();
		return User.getInfo(LastFmManager.getSession(username, password))
				.getImageURL();
	}

	public String getUserNick(String username, String password) {
		LastFmManager.getInstance();
		return User.getInfo(LastFmManager.getSession(username, password)).getName();
	}

	public int getUserPlaycount(String username, String password) {
		LastFmManager.getInstance();
		return User.getInfo(LastFmManager.getSession(username, password))
				.getPlaycount();
	}

	public Collection<Track> getTopTracks(String username) {
		return User.getTopTracks(username, Period.THREE_MONTHS, Configuracoes
				.getInstance().getLastFmKey());

	}

	public Collection<Artist> getTopArtists(String username) {
		return User.getTopArtists(username, Period.THREE_MONTHS, Configuracoes
				.getInstance().getLastFmKey());
	}

	public String getImageURLImageLastMusic(String username) {
		logger.info("Buscando imagem do último som...");
		final Collection<Track> recentTracks = User.getRecentTracks(username,
				Configuracoes.getInstance().getLastFmKey());
		String imageURL;
		if (recentTracks.size() > 0) {
			imageURL = recentTracks.iterator().next().getImageURL(
					ImageSize.LARGE);
			logger.info("Imagem encontrada:" + imageURL);
			return imageURL;
		}
		logger
				.warn("Nenhuma imagem encontrada. Retornando a url de imagem padrão.");
		return NO_IMAGE_URL;
	}

	public String getImageURLImageLastArtist(String username) {
		logger.info("Buscando imagem do último artistas...");
		final Collection<Track> recentTracks = User.getRecentTracks(username,
				Configuracoes.getInstance().getLastFmKey());
		String imageURL;
		if (recentTracks.size() > 0) {
			String artista = recentTracks.iterator().next().getArtist();
			final PaginatedResult<Image> images = Artist.getImages(artista,
					Configuracoes.getInstance().getLastFmKey());

			imageURL = images.getPageResults().iterator().next().getImageURL(
					ImageSize.LARGE);
			logger.info("Imagem encontrada:" + imageURL);
			return imageURL;
		}
		logger
				.warn("Nenhuma imagem encontrada. Retornando a url de imagem padrão.");
		return NO_IMAGE_URL;
	}

	public Musica[] getMusicasTocadas(String username) {
		logger.info("Buscando últimas músicas tocadas.");
		final Collection<Track> recentTracks = User.getRecentTracks(username,
				Configuracoes.getInstance().getLastFmKey());
		logger.info("Retornado " + recentTracks.size());

		Musica musicas[] = new Musica[recentTracks.size()];

		int i = 0;
		for (Track track : recentTracks) {
			musicas[i++] = new Musica(track.getName(), track.getArtist(), track
					.getPlayedWhen(), track.isNowPlaying());
		}
		return musicas;
	}

	public void testLastFmLogin(String username, String pass) throws Exception {
		Session session = getSession(username, pass);
		if(session == null){
			throw new Exception("Invalid login.");
		}

	}
}
