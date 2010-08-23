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
 * Home object for domain model class Imagem.
 * @see com.dudhoo.nemesis.hibernate.Imagem
 * @author Hibernate Tools
 */
public class ImagemHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(ImagemHome.class);

    
    public void persist(Imagem transientInstance) {
        log.debug("persisting Imagem instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Imagem instance) {
        log.debug("attaching dirty Imagem instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Imagem instance) {
        log.debug("attaching clean Imagem instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Imagem persistentInstance) {
        log.debug("deleting Imagem instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Imagem merge(Imagem detachedInstance) {
        log.debug("merging Imagem instance");
        try {
            Imagem result = (Imagem) currentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Imagem findById( java.math.BigDecimal id) {
        log.debug("getting Imagem instance with id: " + id);
        try {
            Imagem instance = (Imagem) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.Imagem", id);
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
    
    
    public List<Imagem> findByExample(Imagem instance) {
        log.debug("finding Imagem instance by example");
        try {
            List<Imagem> results = (List<Imagem>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Imagem")
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