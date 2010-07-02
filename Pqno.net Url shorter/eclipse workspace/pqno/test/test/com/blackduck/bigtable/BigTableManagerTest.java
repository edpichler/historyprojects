package test.com.blackduck.bigtable;

import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;

import net.pqno.bigtable.BigTableManager;
import net.pqno.vo.Suffix;
import net.pqno.vo.WebAddress;

import org.datanucleus.util.MathUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.com.appegine.TestEnvironment;

import com.google.appengine.api.datastore.dev.LocalDatastoreService;
import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;

public class BigTableManagerTest {

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

	@Test
	public void testSaveWebAddress() {
		Suffix suf = new Suffix();
		suf.setNumber(new Long(33));
		suf.setSuffix("xx");

		WebAddress endereco = new WebAddress();
		endereco.setOriginalUrl("www.google.com.br");
		endereco.setSuffix(suf);
		BigTableManager man = new BigTableManager();

		try {
			man.saveWebAddress(endereco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testGetWebAddressBySuffix() throws Exception {
		Suffix suf = new Suffix();
		suf.setNumber(new Long(33));
		final String suffix = "cnn";
		suf.setSuffix(suffix);

		WebAddress endereco = new WebAddress();
		endereco.setOriginalUrl("www.cnn.com.br");
		endereco.setSuffix(suf);
		BigTableManager man = new BigTableManager();

		assertNull(endereco.getId());

		man.saveWebAddress(endereco);
		final WebAddress webAddressFromBigTable = man
				.getWebAddressBySuffix(suffix);

		assertNotNull("Não encontrou", webAddressFromBigTable);
		assertNotNull(webAddressFromBigTable.getId());
		assertEquals("www.cnn.com.br", webAddressFromBigTable.getOriginalUrl());
	}

	@Test
	/**Pesquisa sem nenhum resultado
	 * */
	public void testGetWebAddressBySuffixNoResults() throws Exception {
		Suffix suf = new Suffix();
		suf.setNumber(new Long(33));
		final String suffix = "cnn";
		suf.setSuffix(suffix);

		WebAddress endereco = new WebAddress();
		endereco.setOriginalUrl("www.cnn.com.br");
		endereco.setSuffix(suf);
		BigTableManager man = new BigTableManager();

		assertNull(endereco.getId());

		man.saveWebAddress(endereco);
		final WebAddress webAddressFromBigTable = man
				.getWebAddressBySuffix("anysuffix");

		assertNull("Não podia ter encontrado.", webAddressFromBigTable);
	}

	@Test
	public void testGetWebAddressByUrl() throws Exception {
		Suffix suf = new Suffix();
		suf.setNumber(new Long(33));
		final String suffix = "cnn";
		suf.setSuffix(suffix);

		WebAddress endereco = new WebAddress();
		final String url = "www.cnn.com.br";
		endereco.setOriginalUrl(url);
		endereco.setSuffix(suf);
		BigTableManager man = new BigTableManager();

		assertNull(endereco.getId());

		man.saveWebAddress(endereco);
		final WebAddress webAddressFromBigTable = man.getWebAddressByUrl(url);

		assertNotNull("Não encontrou", webAddressFromBigTable);
		assertNotNull(webAddressFromBigTable.getId());
		assertEquals(url, webAddressFromBigTable.getOriginalUrl());

	}

	/**
	 * Testar uma pesquisa com 0 resultados.
	 * */
	@Test
	public void testGetWebAddressByUrlNoResults() throws Exception {
		Suffix suf = new Suffix();
		suf.setNumber(new Long(33));
		final String suffix = "cnn";
		suf.setSuffix(suffix);

		WebAddress endereco = new WebAddress();
		final String url = "www.cnn.com.br";
		endereco.setOriginalUrl(url);
		endereco.setSuffix(suf);
		BigTableManager man = new BigTableManager();

		assertNull(endereco.getId());

		man.saveWebAddress(endereco);
		final WebAddress webAddressFromBigTable = man
				.getWebAddressByUrl("www.terra.com");

		assertNull("Não podia ter encontrado.", webAddressFromBigTable);

	}

	@Test
	/**
	 * Salva n enderecos e vê se o método retorna o maior número gerado. obs: função max não é suportada no appengine
	 * */
	public void testGetLastNumberGeneratedForSuffixes() throws Exception {
		long maxNumber = 0;
		BigTableManager man = new BigTableManager();
		for (int i = 0; i < 3000; i++) {
			Suffix suffixo = new Suffix();
			final long number = (long)(Math.random() * 1115000);
			suffixo.setNumber(number );
			final String sigla = "cnn";
			suffixo.setSuffix(sigla);

			WebAddress endereco = new WebAddress();
			final String url = "www.cnn.com.br";
			endereco.setOriginalUrl(url);
			endereco.setSuffix(suffixo);
			
			man.saveWebAddress(endereco);
			if(number > maxNumber){
				maxNumber = number;
			}
		}
		

		final long lastNumberGenerated = man.getLastNumberGenerated();
		assertEquals(maxNumber, lastNumberGenerated);
		System.out.println("The number is: " + lastNumberGenerated);
	}

}
