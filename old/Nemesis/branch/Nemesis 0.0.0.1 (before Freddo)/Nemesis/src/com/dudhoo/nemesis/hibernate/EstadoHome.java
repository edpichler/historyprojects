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
 * Home object for domain model class Estado.
 * @see com.dudhoo.nemesis.hibernate.Estado
 * @author Hibernate Tools
 */
public class EstadoHome extends HibernateRoot {

    private static final Log log = LogFactory.getLog(EstadoHome.class);

 
    
    public void persist(Estado transientInstance) {
        log.debug("persisting Estado instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Estado instance) {
        log.debug("attaching dirty Estado instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Estado instance) {
        log.debug("attaching clean Estado instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Estado persistentInstance) {
        log.debug("deleting Estado instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Estado merge(Estado detachedInstance) {
        log.debug("merging Estado instance");
        try {
            Estado result = (Estado) currentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Estado findById( Long id) {
        log.debug("getting Estado instance with id: " + id);
        try {
            Estado instance = (Estado) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.Estado", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
     public List <Estado> findAll(){
        log.debug("getting all Estados");
        try {
            List <Estado> instance = currentSession().createCriteria(Estado.class).list();
            
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<Estado> findByExample(Estado instance) {
        log.debug("finding Estado instance by example");
        try {
            List<Estado> results = (List<Estado>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Estado")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 

}