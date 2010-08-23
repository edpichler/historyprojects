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
 * Home object for domain model class Ramo.
 * @see com.dudhoo.nemesis.hibernate.Ramo
 * @author Hibernate Tools
 */
public class RamoHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(RamoHome.class);

    public void persist(Ramo transientInstance) {
        log.debug("persisting Ramo instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Ramo instance) {
        log.debug("attaching dirty Ramo instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Ramo instance) {
        log.debug("attaching clean Ramo instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Ramo persistentInstance) {
        log.debug("deleting Ramo instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Ramo merge(Ramo detachedInstance) {
        log.debug("merging Ramo instance");
        try {
            Ramo result = (Ramo) currentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Ramo findById( Long id) {
        log.debug("getting Ramo instance with id: " + id);
        try {
            Ramo instance = (Ramo) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.Ramo", id);
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
        }finally{
            closeSession();
        }
    }
    
    
    public List<Ramo> findByExample(Ramo instance) {
        log.debug("finding Ramo instance by example");
        try {
            List<Ramo> results = (List<Ramo>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Ramo")
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