package com.dudhoo.nemesis.hibernate;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Observacao.
 * 
 * @see com.dudhoo.nemesis.hibernate.Observacao
 * @author Hibernate Tools
 */
public class ObservacaoHome extends HibernateRoot {

	private static final Log log = LogFactory.getLog(ObservacaoHome.class);

	public void persist(Observacao transientInstance) {
		log.debug("persisting Observacao instance");		
		try {			
			super.persist(transientInstance);			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);			
			throw re;
		}
	}

	public void saveOrUpdate(Observacao instance) {
		log.debug("attaching dirty Observacao instance");
		try {
			super.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Observacao instance) {
		log.debug("attaching clean Observacao instance");
		try {
			super.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Observacao persistentInstance) {
		log.debug("deleting Observacao instance");
		try {
			super.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Observacao merge(Observacao detachedInstance) {
		log.debug("merging Observacao instance");
		try {
			Observacao result = (Observacao) super.merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Observacao findById(Long id) {
		log.debug("getting Observacao instance with id: " + id);
		try {
			Observacao instance = (Observacao) currentSession().get(
					"com.dudhoo.nemesis.hibernate.Observacao", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Observacao> findByExample(Observacao instance) {
		log.debug("finding Observacao instance by example");
		try {
			List<Observacao> results = (List<Observacao>) currentSession()
					.createCriteria("com.dudhoo.nemesis.hibernate.Observacao").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

}