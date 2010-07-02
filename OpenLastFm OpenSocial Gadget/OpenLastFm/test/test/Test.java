/**
 * 
 */
package test;

import java.util.Collection;
import java.util.Iterator;

import net.roarsoftware.lastfm.Artist;
import net.roarsoftware.lastfm.Authenticator;
import net.roarsoftware.lastfm.Caller;
import net.roarsoftware.lastfm.Session;
import net.roarsoftware.lastfm.Track;
import net.roarsoftware.lastfm.User;
import net.roarsoftware.lastfm.cache.MemoryCache;


/**
 * @author duduzerah
 * 
 */
public class Test {

	/**
	 * @param args
	 */
/*
	public static void main(String[] args) {
		Caller.getInstance().setCache(new MemoryCache());

		//final com.openlastfm.conf.LastFmApiAccount user = new LastFmApiAccount();
		user.setUser("duduzerah");
		user.setKey("66f4e3729bc11b37f848adeaabd8342d");
		user.setSecret("3fd014679d904dddb90cc55a97038921");
		user.setPassword("maonaoreia");
		Session session = Authenticator.getMobileSession(user.getUsernameAPI(),
				user.getPassword(), user.getKey(), user.getSecret());

		System.err.println(User.getInfo(session).getUrl());
		System.err.println(User.getInfo(session).getImageURL());
		// /
		Collection<Artist> artists = User.getTopArtists("duduzerah",net.roarsoftware.lastfm.Period.THREE_MONTHS,
				"66f4e3729bc11b37f848adeaabd8342d");

		System.err.println(artists);
		for (Iterator iterator = artists.iterator(); iterator.hasNext();) {
			Artist artista = (Artist) iterator.next();
			System.err.println(artista.getPlaycount() + " vezes - " + artista.getName()  );
		}
		// /
		Collection<Track> topTracks = User.getTopTracks("duduzerah",
				net.roarsoftware.lastfm.Period.THREE_MONTHS,
				"66f4e3729bc11b37f848adeaabd8342d");

		System.err.println(topTracks);
		for (Iterator iterator = topTracks.iterator(); iterator.hasNext();) {
			Track track = (Track) iterator.next();
			System.err.println(track.getPlaycount() + " vezes - "
					+ track.getArtist() + " - " + track.getName());
		}

		StringBuilder build = new StringBuilder(
				"http://chart.apis.google.com/chart?cht=bhg");
		build.append("&chco=76A4FB");// cor
		build.append("&chtt=Last tracks");// título
		build.append("&chs=300x200");// Tamanho
		build.append("&chxt=y");
		build.append("&chm=N*f*,000000,0,-1,11");// labels nas barras.
		final Collection<Track> tracks = User.getTopTracks(user
				.getUsernameAPI(), net.roarsoftware.lastfm.Period.THREE_MONTHS,
				user.getKey());

		StringBuffer bufPlayCount = new StringBuffer();
		final String barra = "|";
		StringBuffer bufTracks = new StringBuffer(barra);

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

				bufTracks.append(element.getArtist());
				bufTracks.append(" - ");
				bufTracks.append(element.getName());
				bufTracks.append(barra);
			}
			count++;
		}
		bufPlayCount.delete(bufPlayCount.lastIndexOf(virgula), bufPlayCount
				.lastIndexOf(virgula) + 1);

		bufTracks.delete(bufTracks.lastIndexOf(barra), bufTracks
				.lastIndexOf(barra) + 1);
		build.append("&chds=0,");
		build.append(maxPlayCount);
		build.append("&chd=t:");
		build.append(bufPlayCount.toString());

		build.append("&chxl=0:");// artistas
		build.append(bufTracks.toString());
		System.out.println(build);
	}
*/
}
