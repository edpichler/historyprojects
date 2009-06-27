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
 * Home object for domain model class Empresa.
 * @see com.dudhoo.nemesis.hibernate.Empresa
 * @author Hibernate Tools
 */
public class EmpresaHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(EmpresaHome.class);

    
    public void persist(Empresa transientInstance) {
        log.debug("persisting Empresa instance");
        try {
            currentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Empresa instance) {
        log.debug("attaching dirty Empresa instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Empresa instance) {
        log.debug("attaching clean Empresa instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Empresa persistentInstance) {
        log.debug("deleting Empresa instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Empresa merge(Empresa detachedInstance) {
        log.debug("merging Empresa instance");
        try {
            Empresa result = (Empresa) super
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Empresa findById( Long id) {
        log.debug("getting Empresa instance with id: " + id);
        try {
            Empresa instance = (Empresa) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.Empresa", id);
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
    
    
    public List<Empresa> findByExample(Empresa instance) {
        log.debug("finding Empresa instance by example");
        try {
            List<Empresa> results = (List<Empresa>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Empresa")
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