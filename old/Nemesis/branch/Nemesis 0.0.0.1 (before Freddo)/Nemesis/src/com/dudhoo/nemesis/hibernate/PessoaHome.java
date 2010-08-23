package com.dudhoo.nemesis.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;



/**
 * Home object for domain model class Pessoa.
 * @see com.dudhoo.nemesis.hibernate.Pessoa
 * @author Hibernate Tools
 */
public class PessoaHome extends HibernateRoot{
    
    private static final Log log = LogFactory.getLog(PessoaHome.class);
    
    
    
    public void persist(Pessoa transientInstance) {
        log.debug("persisting Pessoa instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Pessoa instance) {
        log.debug("attaching dirty Pessoa instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Pessoa instance) {
        log.debug("attaching clean Pessoa instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Pessoa persistentInstance) {
        log.debug("deleting Pessoa instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Pessoa merge(Pessoa detachedInstance) {
        log.debug("merging Pessoa instance");
        try {
            Pessoa result = (Pessoa) currentSession()
            .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Pessoa findById( Long id) {
        log.debug("getting Pessoa instance with id: " + id);
        try {
            Pessoa instance = (Pessoa) currentSession()
            .get("com.dudhoo.nemesis.hibernate.Pessoa", id);
            if (instance==null) {
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
    public List <Pessoa> findAll() {		
	    List <Pessoa> instance = currentSession().createCriteria(Pessoa.class).list();	    
	    closeSession();
	    return instance;	
    }
    
    public List<Pessoa> findByExample(Pessoa instance) {
        log.debug("finding Pessoa instance by example");
        try {
            List<Pessoa> results = (List<Pessoa>) currentSession()
            .createCriteria("com.dudhoo.nemesis.hibernate.Pessoa")
            .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    
}