package com.farmacopedia.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;

import org.apache.shale.test.base.AbstractViewControllerTestCase;
import org.apache.shale.test.mock.MockApplication;
import org.apache.shale.test.mock.MockFacesContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RootShaleTest extends AbstractViewControllerTestCase {

	public RootShaleTest(String name) {
		super(name);
		/*
		 * facesContext = new MockFacesContext(); application = new
		 * MockApplication();
		 */
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		List<Locale> list = new ArrayList<Locale>();
		list.add(new Locale("en"));
		list.add(new Locale("pt"));
		list.add(new Locale("es"));
		application.setSupportedLocales(list);
	}

	@Test
	public void test() {
		//so pra nao dar erro
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

}
