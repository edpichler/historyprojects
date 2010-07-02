package net.pqno.engine;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator {
	Logger logger = Logger.getLogger(UrlValidator.class.getName());

	/**
	 * Validate the URL
	 * */
	public void validateUrl(String urlToValidate) throws Exception {
		logger.log(Level.FINE, "Starting to validate a url: " + urlToValidate);
		validateByRegex(urlToValidate);
		URL url;
		
		url = new URL(urlToValidate);
		int response = 0;
		try {

			URLConnection connection = url.openConnection();
			if (connection instanceof HttpURLConnection) {
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				httpConnection.connect();
				response = httpConnection.getResponseCode();
				if (String.valueOf(response).startsWith("2")) {
					return;// ok
					// http://java.sun.com/developer/JDCTechTips/2003/tt0422.html
					// todas respostas que começam com 200 são válias
					// 1xx - informational
					// 2xx - successful
					// 3xx - redirection
					// 4xx - error
					// 5xx - server error
					// 
				}
				InputStream is = httpConnection.getInputStream();
				byte[] buffer = new byte[50];
				while (is.read(buffer) != -1) {
				}
				is.close();
			}
		} catch (IOException e) {
			throw new Exception("The informed URL seems to be invalid (url="
					+ urlToValidate + "; returned code=" + response + ")", e);
		}
		logger
				.log(Level.FINE, "Finished to validate the url: "
						+ urlToValidate);
	}

	/**
	 * Validate url by regex
	 * 
	 * @throws Exception
	 */
	private void validateByRegex(String urlToValidate) throws Exception {
		String pattern = "^(https?://)"
				+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // user@
				+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP- 199.194.52.184
				+ "|" // allows either IP or domain
				+ "([0-9a-z_!~*'()-]+\\.)*" // tertiary domain(s)- www.
				+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // second level domain
				+ "[a-z]{2,6})" // first level domain- .com or .museum
				+ "(:[0-9]{1,4})?" // port number- :80
				+ "((/?)|" // a slash isn't required if there is no file name
				+ "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(urlToValidate);
		boolean ret = m.matches();
		if (!ret) {
			throw new Exception("The URL is invalid: " + urlToValidate);
		}
	}
}
