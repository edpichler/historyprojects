package com.pichler.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;

import com.pichler.hibernate.root.HibernateRoot;

public class HiberPessoa extends HibernateRoot{

	public void salvar(Pessoa pes) throws Exception {
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
	public List<Pessoa> list() throws Exception {
		try {
			Session s = currentSession();
			return s.createCriteria(Pessoa.class).list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public void deletar(Pessoa pessoa) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.delete(pessoa);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	} 
	
	public Pessoa findById(Pessoa pes) throws Exception {
		try {
			Session s = currentSession();
			Pessoa ret = (Pessoa) s.createCriteria(Pessoa.class).add(
					Expression.idEq(pes.getId())).uniqueResult();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public List findByNome(String nome, int maxResult) throws Exception{
		try {
			Session s = currentSession();
			List pessoas = s.createCriteria(Pessoa.class).setMaxResults(maxResult).
				add(Expression.ilike("nome",nome, MatchMode.ANYWHERE)).list();
			return pessoas;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}
	
}
