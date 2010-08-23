package com.dudhoo.nemesis.hibernate;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import static org.hibernate.criterion.Example.create;



/**
 * Home object for domain model class Cidade.
 * @see com.dudhoo.nemesis.hibernate.Cidade
 * @author Hibernate Tools
 */
public class CidadeHome extends HibernateRoot{
    
    public void persist(Cidade transientInstance) {
        log.debug("persisting Cidade instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Cidade instance) {
        log.debug("attaching dirty Cidade instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Cidade instance) {
        log.debug("attaching clean Cidade instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Cidade persistentInstance) {
        log.debug("deleting Cidade instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Cidade merge(Cidade detachedInstance) {
        log.debug("merging Cidade instance");
        try {
            Cidade result = (Cidade) currentSession()
            .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public List <Cidade> findAll(){
        log.debug("getting all Estados");
        try {
            List <Cidade> instance = currentSession().createCriteria(Cidade.class).list();
            
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
    
    public Cidade findById( Long id) {
        log.debug("getting Cidade instance with id: " + id);
        try {
            Cidade instance = (Cidade) currentSession()
            .get("com.dudhoo.nemesis.hibernate.Cidade", id);
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
    
    
    public List<Cidade> findByExample(Cidade instance) {
        log.debug("finding Cidade instance by example");
        try {
            List<Cidade> results = (List<Cidade>) currentSession()
            .createCriteria("com.dudhoo.nemesis.hibernate.Cidade")
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