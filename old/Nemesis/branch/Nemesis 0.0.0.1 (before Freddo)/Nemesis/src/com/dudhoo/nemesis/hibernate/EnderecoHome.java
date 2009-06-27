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
 * Home object for domain model class Endereco.
 * @see com.dudhoo.nemesis.hibernate.Endereco
 * @author Hibernate Tools
 */
public class EnderecoHome extends HibernateRoot {

    private static final Log log = LogFactory.getLog(EnderecoHome.class);

    
    public void persist(Endereco transientInstance) {
        log.debug("persisting Endereco instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Endereco instance) {
        log.debug("attaching dirty Endereco instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Endereco instance) {
        log.debug("attaching clean Endereco instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Endereco persistentInstance) {
        log.debug("deleting Endereco instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Endereco merge(Endereco detachedInstance) {
        log.debug("merging Endereco instance");
        try {
            Endereco result = (Endereco) currentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Endereco findById( Long id) {
        log.debug("getting Endereco instance with id: " + id);
        try {
            Endereco instance = (Endereco) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.Endereco", id);
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
    
    
    public List<Endereco> findByExample(Endereco instance) {
        log.debug("finding Endereco instance by example");
        try {
            List<Endereco> results = (List<Endereco>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Endereco")
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