package net.pqno.engine;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.pqno.bigtable.BigTableManager;
import net.pqno.vo.Suffix;
import net.pqno.vo.WebAddress;

public class UrlSuffixGenerator {
	Logger logger = Logger.getLogger(UrlSuffixGenerator.class.getName());
	private Object oSync = new Object();

	/**
	 * Retorna a url encurtada.
	 * 
	 * @throws Exception
	 *             se, por exemplo, a url for inválida
	 * */
	public String getSuffix(String urlToShort) throws Exception {
		logger.fine("Starting to short the url: " + urlToShort);
		String retorno = null;
		synchronized (oSync) {
			urlToShort = urlToShort.trim();
			urlToShort = putHttpPreffix(urlToShort);
			UrlValidator urlValidator = new UrlValidator();

			BigTableManager bigTable = new BigTableManager();

			// Verifica se já existe.
			// Se já existir retorna a mesma.
			final WebAddress webAddressByUrl = bigTable
					.getWebAddressByUrl(urlToShort);
			if (webAddressByUrl != null) {
				retorno = webAddressByUrl.getSuffix().getSuffix();
			} else {

				// criar novo
				urlValidator.validateUrl(urlToShort);
				final long lastNumberGenerated = bigTable
						.getLastNumberGenerated();
				long nextNumber = lastNumberGenerated + 1;
				NumberToSuffixConverter converter = new NumberToSuffixConverter();
				final String stringGenerated = converter.convert(nextNumber);
				final Suffix suffix = new Suffix();
				suffix.setNumber(nextNumber);
				suffix.setSuffix(stringGenerated);
				WebAddress urlShorted = new WebAddress();
				urlShorted.setOriginalUrl(urlToShort);
				urlShorted.setSuffix(suffix);
				// salva
				bigTable.saveWebAddress(urlShorted);
				logger.fine("Starting to short the url: " + urlToShort);
				retorno = urlShorted.getSuffix().getSuffix();
			}

		}
		logger.fine("Finished to short the url: " + urlToShort);
		return retorno;

	}

	/**
	 * Caso a URL não tiver HTTP no início do URL, esse método irá colocar.
	 * **/
	private String putHttpPreffix(String urlToShort) {
		String http = "http://";
		String https = "https://";
		final String lowerCase = urlToShort.toLowerCase();
		if (lowerCase.startsWith(http) || lowerCase.startsWith(https)) {
			return urlToShort;
		} else {
			urlToShort = http + urlToShort;
			return urlToShort;
		}

	}
}
