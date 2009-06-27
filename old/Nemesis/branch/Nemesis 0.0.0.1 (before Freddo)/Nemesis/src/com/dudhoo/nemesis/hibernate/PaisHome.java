package com.dudhoo.nemesis.hibernate;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import static org.hibernate.criterion.Example.create;



/**
 * Home object for domain model class Pais.
 * @see com.dudhoo.nemesis.hibernate.Pais
 * @author Hibernate Tools
 */
public class PaisHome extends HibernateRoot{
    
    private static final Log log = LogFactory.getLog(PaisHome.class);
    
    public void persist(Pais transientInstance) throws HibernateException {
        log.debug("persisting Pais instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        } catch (HibernateException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Pais instance) {
        log.debug("attaching dirty Pais instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Pais instance) {
        log.debug("attaching clean Pais instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Pais persistentInstance) {
        log.debug("deleting Pais instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Pais merge(Pais detachedInstance) {
        log.debug("merging Pais instance");
        try {
            Pais result = (Pais) super.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Pais findById( Long id) {
        log.debug("getting Pais instance with id: " + id);
        try {
            Pais instance = (Pais) currentSession()
            .get("com.dudhoo.nemesis.hibernate.Pais", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            } else {
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
    
    public List <Pais> findAll() {
        log.debug("getting all Pais");
        try {
            List <Pais> instance = currentSession().createCriteria(Pais.class).list();
            
            if (instance==null) {
                log.debug("get successful, no instance found");
            } else {
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
    
    
    public List<Pais> findByExample(Pais instance) {
        log.debug("finding Pais instance by example");
        try {
            List<Pais> results = (List<Pais>) currentSession()
            .createCriteria("com.dudhoo.nemesis.hibernate.Pais")
            .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        } finally{
            closeSession();
        }
    }
    
}