package com.pichler.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;

import com.pichler.hibernate.root.HibernateRoot;

public class HiberUsuario extends HibernateRoot {

	public void salvar(Usuario user) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.saveOrUpdate(user);
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
	public List<Usuario> list() throws Exception {
		try {
			Session s = currentSession();
			return s.createCriteria(Usuario.class).list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public void deletar(Usuario user) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.delete(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	} 
	
	public Usuario findById(Usuario user) throws Exception {
		try {
			Session s = currentSession();
			Usuario ret = (Usuario) s.createCriteria(Usuario.class).add(
					Expression.idEq(user.getId())).uniqueResult();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List <Usuario> findByUsername(String key) throws Exception {
		return findByUsername(key, MatchMode.ANYWHERE);
	}
	
	@SuppressWarnings("unchecked")
	public List <Usuario> findByUsername(String key, MatchMode matchMode) throws Exception {
		try {
			Session s = currentSession();
			List<Usuario> ret = s.createCriteria(Usuario.class)
					.add(Expression.ilike("username", key, matchMode))
					.list();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}
}
