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
 * Home object for domain model class Permissoes.
 * @see com.dudhoo.nemesis.hibernate.Permissoes
 * @author Hibernate Tools
 */
public class PermissoesHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(PermissoesHome.class);

   
    
    public void persist(Permissoes transientInstance) {
        log.debug("persisting Permissoes instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Permissoes instance) {
        log.debug("attaching dirty Permissoes instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Permissoes instance) {
        log.debug("attaching clean Permissoes instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Permissoes persistentInstance) {
        log.debug("deleting Permissoes instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Permissoes merge(Permissoes detachedInstance) {
        log.debug("merging Permissoes instance");
        try {
            Permissoes result = (Permissoes) currentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Permissoes findById( Long id) {
        log.debug("getting Permissoes instance with id: " + id);
        try {
            Permissoes instance = (Permissoes) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.Permissoes", id);
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
    
    
    public List<Permissoes> findByExample(Permissoes instance) {
        log.debug("finding Permissoes instance by example");
        try {
            List<Permissoes> results = (List<Permissoes>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Permissoes")
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