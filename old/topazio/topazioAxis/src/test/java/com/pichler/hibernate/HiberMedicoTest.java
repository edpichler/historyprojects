package com.pichler.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HiberMedicoTest {
	Medico med = new Medico();
	
	public HiberMedicoTest() {
		med.setNome("medico");
		med.setRg("rgdomal");
		med.setDataNascimento(Calendar.getInstance());
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HiberMedico hiber = new HiberMedico();
		hiber.salvar(med);
	}

	@After
	public void tearDown() throws Exception {
		HiberMedico hiber = new HiberMedico();
		hiber.deletar(med);
	}

	@Test
	public void testList() throws Exception {
		assertTrue( new HiberMedico().list().size() > 0);
	}

	@Test
	public void testFindById() throws Exception {
		assertNotNull(new HiberMedico().findById(med));
	}	
	
}
