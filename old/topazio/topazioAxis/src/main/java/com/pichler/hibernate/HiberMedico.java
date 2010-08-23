package com.pichler.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.pichler.hibernate.root.HibernateRoot;

public class HiberMedico extends HibernateRoot{

	public void salvar(Medico pes) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.saveOrUpdate(pes);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Medico> list() throws Exception {
		try {
			Session s = currentSession();
			return s.createCriteria(Medico.class).list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public void deletar(Medico Medico) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.delete(Medico);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	} 
	
	public Medico findById(Medico medico) throws Exception {
		try {
			Session s = currentSession();
			Medico ret = (Medico) s.createCriteria(Medico.class).add(
					Expression.idEq(medico.getId())).uniqueResult();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}
	
}
