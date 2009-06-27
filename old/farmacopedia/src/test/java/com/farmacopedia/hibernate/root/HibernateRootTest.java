/**
 * 
 */
package com.farmacopedia.hibernate.root;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dudu
 * 
 */
public class HibernateRootTest extends TestCase {
	public HibernateRootDuble hroot;	
	public HibernateRootTest() {
		hroot = new HibernateRootDuble();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Testar método para
	 * {@link com.farmacopedia.hibernate.root.HibernateRoot#closeSession(boolean)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCloseSession() throws Exception {
		// pega a sessão e fecha
		Session s = hroot.currentSession();
		assertNotNull(s);
		assertTrue(s.isOpen());
		hroot.closeSession(false);
		assertTrue(!s.isOpen());

		// seta uma sessão, dai tenta fechar sem forçar
		s = hroot.currentSession();
		assertTrue(s.isOpen());
		hroot.setSession(s);
		hroot.closeSession(false);
		assertTrue(s.isOpen());

		// seta uma sessão dai tenta fechar forçando
		s = hroot.currentSession();
		assertTrue(s.isOpen());
		hroot.closeSession(true);
		assertTrue(!s.isOpen());
	}

	/**
	 * Testar método para
	 * {@link com.farmacopedia.hibernate.root.HibernateRoot#currentSession()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCurrentSession() throws Exception {
		Session s = hroot.currentSession();
		assertNotNull(s);
		assertTrue(s.isOpen());
	}

	// /so pq HibernateRoot é abstrato
	private class HibernateRootDuble extends HibernateRoot {

	}
}
