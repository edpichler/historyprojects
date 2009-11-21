package test.com.blackduck.engine;

import static org.junit.Assert.*;

import java.io.File;

import net.pqno.bigtable.BigTableManager;
import net.pqno.engine.UrlSuffixGenerator;
import net.pqno.vo.WebAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.com.appegine.TestEnvironment;

import com.google.appengine.api.datastore.dev.LocalDatastoreService;
import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;

public class UrlSuffixGeneratorTest {

	@Before
	public void setUp() throws Exception {
		ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment());
		ApiProxy.setDelegate(new ApiProxyLocalImpl(new File(".")) {
		});

		ApiProxyLocalImpl proxy = (ApiProxyLocalImpl) ApiProxy.getDelegate();
		proxy.setProperty(LocalDatastoreService.NO_STORAGE_PROPERTY,
				Boolean.TRUE.toString());
	}

	@After
	public void tearDown() throws Exception {
		// not strictly necessary to null these out but there's no harm either
		ApiProxy.setDelegate(null);
		ApiProxy.setEnvironmentForCurrentThread(null);

		ApiProxyLocalImpl proxy = (ApiProxyLocalImpl) ApiProxy.getDelegate();
		if (proxy != null) {
			LocalDatastoreService datastoreService = (LocalDatastoreService) proxy
					.getService("datastore_v3");
			if (datastoreService != null) {
				datastoreService.clearProfiles();
			}
		}

	}

	/**
	 * Encurta uma url, depois encurta outra, dai encurta uma igual a primeira,
	 * deve ser gerado apenas dois sufixos diferentes
	 * */
	@Test
	public void testGetSuffix() throws Exception {
		String urlGoogle = "www.google.com";
		UrlSuffixGenerator gen = new UrlSuffixGenerator();
		String suffix1 = gen.getSuffix(urlGoogle);

		String suffix2 = gen.getSuffix("www.terra.com.br");

		String suffix3 = gen.getSuffix(urlGoogle);

		assertEquals(suffix1, suffix3);
		assertFalse(suffix1.equals(suffix2));

	}

	/**
	 * Verificar se está colocando o http no começo dos urls que o usuário
	 * coloca sem http
	 * */
	@Test
	public void testGetSuffixPreffixHttp() throws Exception {
		String urlGoogle = "www.google.com";
		UrlSuffixGenerator gen = new UrlSuffixGenerator();
		String suffix1 = gen.getSuffix(urlGoogle);
		BigTableManager bg = new BigTableManager();
		final WebAddress webAddressBySuffix = bg.getWebAddressBySuffix(suffix1);
		final boolean result = webAddressBySuffix.getOriginalUrl().startsWith("http://");
		assertTrue("Teria que ter adicionado o prefixo", true);
	}
}
