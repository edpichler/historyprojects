package com.farmacopedia.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.impl.CriteriaImpl.CriterionEntry;

import com.farmacopedia.hibernate.root.HibernateRoot;

public class HiberFarmaco extends HibernateRoot {

	public void salvar(Farmaco farmaco) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.saveOrUpdate(farmaco);
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
	public List<Farmaco> list() throws Exception {
		try {
			Session s = currentSession();
			return s.createCriteria(Farmaco.class).list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public void deletar(Farmaco teste) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.delete(teste);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	}

	public Farmaco findById(Farmaco farm) throws Exception {
		try {
			Session s = currentSession();
			Farmaco ret = (Farmaco) s.createCriteria(Farmaco.class).add(
					Expression.idEq(farm.getId())).uniqueResult();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List <Farmaco> findByKey(String key) throws Exception {
		try {
			Session s = currentSession();
			List<Farmaco> ret = s.createCriteria(Farmaco.class)
					.add(Expression.ilike("nome", key, MatchMode.ANYWHERE))
					.list();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}
}
