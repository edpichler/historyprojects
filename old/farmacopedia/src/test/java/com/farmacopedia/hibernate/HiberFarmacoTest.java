/**
 * 
 */
package com.farmacopedia.hibernate;

import java.util.List;

import org.junit.Test;

import com.farmacopedia.hibernate.root.HibernateRootTest;

/**
 * @author dudu
 * 
 */
public class HiberFarmacoTest extends HibernateRootTest {

	/**
	 * Testar método para
	 * {@link com.farmacopedia.hibernate.HiberFarmaco#salvar(com.farmacopedia.hibernate.Farmaco)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSalvar() throws Exception {
		Farmaco teste = new Farmaco();
		teste.setDescricao("teste");
		teste.setNome("unico" + Math.random());
		HiberFarmaco h = new HiberFarmaco();
		h.salvar(teste);
		h.deletar(teste);
		assertNull(h.findById(teste));
	}

	/**
	 * Testar método para {@link com.farmacopedia.hibernate.HiberFarmaco#list()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testList() throws Exception {
		Farmaco teste = new Farmaco();
		teste.setDescricao("teste");
		teste.setNome("unico" + Math.random());
		List l = new HiberFarmaco().list();
		System.out.println("Quantidade de farmacos cadastrados:" + l.size());
	}
	
	@Test	
	public void testFindByKey() throws Exception {
		Farmaco teste = new Farmaco();
		teste.setDescricao("teste");
		teste.setNome("unico" + Math.random());
		HiberFarmaco h = new HiberFarmaco();
		h.salvar(teste);
		List <Farmaco> lista = h.findByKey("nic");
		assertTrue(lista.size() > 0);
		h.deletar(teste);
		assertNull(h.findById(teste));
	}
	
}
