package com.pichler.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HiberConsultaMedicasTest {
	ConsultaMedica cons = new ConsultaMedica();

	private static Medico mtemp = new Medico();

	private static Pessoa ptemp = new Pessoa();

	public HiberConsultaMedicasTest() {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mtemp.setNome("medicoloco!");
		ptemp.setNome("loco");
		mtemp.setDataNascimento(Calendar.getInstance());
		ptemp.setDataNascimento(Calendar.getInstance());
		mtemp.setRg("4123");
		ptemp.setRg("3423");
		new HiberMedico().salvar(mtemp);
		new HiberPessoa().salvar(ptemp);
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		new HiberMedico().deletar(mtemp);
		new HiberPessoa().deletar(ptemp);
	}

	@Before
	public void setUp() throws Exception {
		HiberConsultaMedicas hiber = new HiberConsultaMedicas();
		cons.setDataMarcadaConsulta(Calendar.getInstance());
		cons.setPaciente(ptemp);
		cons.setMedico(mtemp);
		hiber.salvar(cons);
	}

	@After
	public void tearDown() throws Exception {
		HiberConsultaMedicas hiber = new HiberConsultaMedicas();
		hiber.deletar(cons);
	}

	@Test
	public void testList() throws Exception {
		assertTrue(new HiberConsultaMedicas().list(10).size() > 0);
	}

	@Test
	public void testFindById() throws Exception {
		assertNotNull(new HiberConsultaMedicas().findById(cons));
	}

	@Test
	public void testGetConsultasMedica() throws Exception {
		assertNotNull(new HiberConsultaMedicas()
				.getConsultasMedicas(Long.parseLong("1"), Calendar
						.getInstance(), Calendar.getInstance()));
	}

	@Test
	public void testGetConsultasMedica2() throws Exception {
		Calendar diaInicio, diaFim;
		diaInicio = Calendar.getInstance();
		diaFim = Calendar.getInstance();
		diaFim.set(Calendar.YEAR, 11);
		diaInicio.set(Calendar.YEAR, 11);

		// cria 3 consultas
		Medico m = new Medico();
		m.setNome("Bart Bartolomeu");
		Pessoa p = new Pessoa();
		p.setNome("Carlinha");
		m.setRg("ata");
		m.setDataNascimento(Calendar.getInstance());
		p.setRg("ata3");
		p.setDataNascimento(Calendar.getInstance());
		
		ConsultaMedica cs[] = new ConsultaMedica[4];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new ConsultaMedica();
			cs[i].setMedico(m);
			cs[i].setPaciente(p);
		}
		cs[0].setDataMarcadaConsulta(diaInicio);
		cs[1].setDataMarcadaConsulta(diaFim);
		cs[2].setDataMarcadaConsulta(diaFim);
		cs[3].setDataMarcadaConsulta(diaInicio);

		// salvar
		HiberConsultaMedicas h = new HiberConsultaMedicas();
		try {
			new HiberMedico().salvar(m);
			new HiberPessoa().salvar(p);
			h.salvar(cs[0]);
			h.salvar(cs[1]);
			h.salvar(cs[2]);
			h.salvar(cs[3]);

			@SuppressWarnings("unused")
			List<ConsultaMedica> resultados;

			// pegar um punhado
			Calendar passado = Calendar.getInstance();
			Calendar futuro = Calendar.getInstance();
			passado.set(Calendar.YEAR, 10);
			futuro.set(Calendar.YEAR, 20);
			resultados = new HiberConsultaMedicas().getConsultasMedicas(
					passado, futuro, m.getId(), "nha", 100);
			assertEquals(4, resultados.size());

		} catch (Exception ex) {
			throw ex;
		} finally {

			for (int i = 0; i < cs.length; i++) {
				h.deletar(cs[i]);
			}
			new HiberMedico().deletar(m);
			new HiberPessoa().deletar(p);
		}
		// /deleta consultas

	}
	@Test
	public void testGetConsultasMedica3() throws Exception {
		Calendar diaInicio, diaFim;
		diaInicio = Calendar.getInstance();
		diaFim = Calendar.getInstance();
		diaFim.set(Calendar.YEAR, 11);
		diaInicio.set(Calendar.YEAR, 11);

		// cria 3 consultas
		Medico m = new Medico();
		m.setNome("Bart Bartolomeu");
		Pessoa p = new Pessoa();
		p.setNome("Carlinha");
		m.setRg("ata");
		m.setDataNascimento(Calendar.getInstance());
		p.setRg("ata3");
		p.setDataNascimento(Calendar.getInstance());
		
		ConsultaMedica cs[] = new ConsultaMedica[4];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new ConsultaMedica();
			cs[i].setMedico(m);
			cs[i].setPaciente(p);
		}
		cs[0].setDataMarcadaConsulta(diaInicio);
		cs[1].setDataMarcadaConsulta(diaFim);
		cs[2].setDataMarcadaConsulta(diaFim);
		cs[3].setDataMarcadaConsulta(diaInicio);

		// salvar
		HiberConsultaMedicas h = new HiberConsultaMedicas();
		try {
			new HiberMedico().salvar(m);
			new HiberPessoa().salvar(p);
			h.salvar(cs[0]);
			h.salvar(cs[1]);
			h.salvar(cs[2]);
			h.salvar(cs[3]);

			@SuppressWarnings("unused")
			List<ConsultaMedica> resultados;

			// pegar um punhado
			Calendar passado = Calendar.getInstance();
			Calendar futuro = Calendar.getInstance();
			passado.set(Calendar.YEAR, 10);
			futuro.set(Calendar.YEAR, 20);
			resultados = new HiberConsultaMedicas().getConsultasMedicas(
					passado, futuro, p.getId(), 100);
			assertEquals(4, resultados.size());

		} catch (Exception ex) {
			throw ex;
		} finally {

			for (int i = 0; i < cs.length; i++) {
				h.deletar(cs[i]);
			}
			new HiberMedico().deletar(m);
			new HiberPessoa().deletar(p);
		}

	}
}
