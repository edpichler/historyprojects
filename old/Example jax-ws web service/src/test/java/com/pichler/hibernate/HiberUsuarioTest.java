package com.pichler.hibernate;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HiberUsuarioTest {
	private final String NOMETESTE = "USUTESTE";

	private HiberUsuario hu;

	private Usuario usuarioTeste;

	public HiberUsuarioTest() {
		hu = new HiberUsuario();
		usuarioTeste = new Usuario();
		usuarioTeste.setPassword("pass");
		usuarioTeste.setUsername("ata" + NOMETESTE);
	}

	@Before
	public void criaUsuario() throws Exception {
		hu.salvar(usuarioTeste);
	}

	@After
	public void deletaUsuario() throws Exception {
		hu.deletar(usuarioTeste);
	}

	@Test
	public void testList() throws Exception {

	}
	
	@Test
	public void testWS() throws Exception {		
		
		
	}

	

	@Test
	public void testSalvarEDeletar() throws Exception {
		Usuario temp = new Usuario();
		temp.setUsername("userssnamesss");
		temp.setPassword("pass");
		hu.salvar(temp);
		assertTrue(temp.getId() != 0);
		hu.deletar(temp);
	}

	@Test
	public void testFindById() throws Exception {
		assertTrue(hu.findById(usuarioTeste) != null);
	}

	@Test
	public void testFindByKey() throws Exception {

		assertTrue(hu.findByUsername(NOMETESTE).size() > 0);

	}
}
