package com.pichler.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HiberPessoaTest {
	Pessoa pes = new Pessoa();
	
	public HiberPessoaTest() {
		pes.setNome("ata");
		pes.setDataNascimento(Calendar.getInstance());
		pes.setRg("rgdomal");
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HiberPessoa hiber = new HiberPessoa();
		hiber.salvar(pes);
	}

	@After
	public void tearDown() throws Exception {
		HiberPessoa hiber = new HiberPessoa();
		hiber.deletar(pes);
	}

	@Test
	public void testList() throws Exception {
		assertTrue( new HiberPessoa().list().size() > 0);
	}

	@Test
	public void testFindById() throws Exception {
		assertNotNull(new HiberPessoa().findById(pes));
	}

}
