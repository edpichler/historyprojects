package com.pichler.database;

import static org.junit.Assert.assertTrue;
import junit.framework.AssertionFailedError;

import org.hibernate.criterion.MatchMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pichler.hibernate.HiberUsuario;
import com.pichler.hibernate.Usuario;

public class IntegridadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Testa se existe um usuário administrador no banco com o nome de 'root' de
	 * dados, se não existir será criado um com senha 'root'.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIntegridade() throws Exception {
		HiberUsuario h = new HiberUsuario();
		try {
			assertTrue(h.findByUsername("root", MatchMode.EXACT).size() > 0);
		} catch (AssertionFailedError ex) {
			Usuario root = new Usuario();
			root.setUsername("root");
			root.setPassword(root.getUsername());
			h.salvar(root);
		}
	}

}
