package com.dudhoo.nemesis.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;



/**
 * Home object for domain model class PessoaJuridica.
 * @see com.dudhoo.nemesis.hibernate.PessoaJuridica
 * @author Hibernate Tools
 */
public class PessoaJuridicaHome extends HibernateRoot{
    
    private static final Log log = LogFactory.getLog(PessoaJuridicaHome.class);
    
    
    public void persist(PessoaJuridica transientInstance) {
        log.debug("persisting PessoaJuridica instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }finally{
            closeSession();
        }
    }
    
    public void attachDirty(PessoaJuridica instance) {
        log.debug("attaching dirty PessoaJuridica instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PessoaJuridica instance) {
        log.debug("attaching clean PessoaJuridica instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(PessoaJuridica persistentInstance) {
        log.debug("deleting PessoaJuridica instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PessoaJuridica merge(PessoaJuridica detachedInstance) {
        log.debug("merging PessoaJuridica instance");
        try {
            PessoaJuridica result = (PessoaJuridica) currentSession()
            .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public PessoaJuridica findById( Long id) {
        log.debug("getting PessoaJuridica instance with id: " + id);
        try {            
            PessoaJuridica instance = (PessoaJuridica) currentSession()
            .get("com.dudhoo.nemesis.hibernate.PessoaJuridica", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            } else {                
                //TODO PREENCHER OS DADOS COMPLETOS DA PESSOA JURIDICA NA MEMORIA, VER SE ESTOU FAZENDO CERTO, SEI QUE EXISTE PELO XML, MAS ASSIM POSSO CONTROLAR QUANDO NAO QUERO TAMBEM.
                log.debug("get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }finally{
            closeSession();
        }
    }
    
    
    public List <PessoaJuridica> findAll() {
	try {            
	    return currentSession().createCriteria(PessoaJuridica.class).list();	    
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}finally{
	    closeSession();
	}
    }
    
    public List<PessoaJuridica> findByExample(PessoaJuridica instance) {
        log.debug("finding PessoaJuridica instance by example");
        try {
            List<PessoaJuridica> results = (List<PessoaJuridica>) currentSession()
            .createCriteria("com.dudhoo.nemesis.hibernate.PessoaJuridica")
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