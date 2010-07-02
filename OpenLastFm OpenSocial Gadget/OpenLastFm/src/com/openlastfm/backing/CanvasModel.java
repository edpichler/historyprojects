package com.openlastfm.backing;

import java.util.Collection;

import net.roarsoftware.lastfm.Artist;
import net.roarsoftware.lastfm.Track;

import org.apache.log4j.Logger;

import com.openlastfm.conf.LastFmManager;

public class CanvasModel {
	

	public CanvasModel() {
	}

	public String getUrlAvatar(String username, String pass) {
		return LastFmManager.getInstance().getImageURL(username, pass);
		
	}

	public String getUserNick(String username, String pass) {
		return LastFmManager.getInstance().getUserNick(username, pass);
	}

	public int getExecucoes(String username, String pass) {
		return LastFmManager.getInstance().getUserPlaycount(username, pass);
	}

	public String getChartTopSongs(String username) {
		StringBuilder build = new StringBuilder(
				"http://chart.apis.google.com/chart?cht=bhg");
		build.append("&chco=76A4FB");// cor
		build.append("&chtt=Músicas mais tocadas|em 3 meses");// título
		build.append("&chts=76A4FB,12");// título
		build.append("&chs=300x200");// Tamanho
		build.append("&chxt=y");
		build.append("&chm=N*f*,000000,0,-1,11");// labels nas barras.
		final Collection<Track> tracks = LastFmManager.getInstance()
				.getTopTracks(username);

		StringBuffer bufPlayCount = new StringBuffer();
		final String barra = "|";
		StringBuffer bufTracks = new StringBuffer();

		final String virgula = ",";
		int count = 0;
		int maxPlayCount = 0; // valor máximo no grafico
		for (Track element : tracks) {
			if (maxPlayCount == 0) {
				maxPlayCount = element.getPlaycount();
			}
			if (count < 5) {

				bufPlayCount.append(element.getPlaycount());
				bufPlayCount.append(virgula);

				bufTracks.insert(0, element.getName());
				bufTracks.insert(0, " - ");
				bufTracks.insert(0, element.getArtist());

				bufTracks.insert(0, barra);
			}
			count++;
		}
		bufPlayCount.delete(bufPlayCount.lastIndexOf(virgula), bufPlayCount
				.lastIndexOf(virgula) + 1);

		build.append("&chds=0,");
		build.append(maxPlayCount);
		build.append("&chd=t:");
		build.append(bufPlayCount.toString());

		build.append("&chxl=0:");// artistas
		build.append(bufTracks.toString());

		return build.toString();
	}

	public String getChartTopArtists(String username) {
		StringBuilder build = new StringBuilder(
				"http://chart.apis.google.com/chart?cht=bhg");
		build.append("&chco=76A4FB");// cor
		build.append("&chtt=Artistas mais tocados|em 3 meses");// título
		build.append("&chts=76A4FB,12");// título

		build.append("&chs=300x200");// Tamanho
		build.append("&chxt=y");
		build.append("&chm=N*f*,000000,0,-1,11");// labels nas barras.
		final Collection<Artist> artists = LastFmManager.getInstance()
				.getTopArtists(username);

		StringBuffer bufPlayCount = new StringBuffer();
		final String barra = "|";
		StringBuffer bufArtistas = new StringBuffer();

		final String virgula = ",";
		int count = 0;
		int maxPlayCount = 0; // valor máximo no grafico
		for (Artist element : artists) {
			if (maxPlayCount == 0) {
				maxPlayCount = element.getPlaycount();
			}
			if (count < 5) {

				bufPlayCount.append(element.getPlaycount());
				bufPlayCount.append(virgula);

				bufArtistas.insert(0, element.getName());
				bufArtistas.insert(0, barra);
			}
			count++;
		}
		bufPlayCount.delete(bufPlayCount.lastIndexOf(virgula), bufPlayCount
				.lastIndexOf(virgula) + 1);

		build.append("&chds=0,");
		build.append(maxPlayCount);
		build.append("&chd=t:");
		build.append(bufPlayCount.toString());

		build.append("&chxl=0:");// artistas
		build.append(bufArtistas.toString());

		return build.toString();
	}

}
