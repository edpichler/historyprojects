package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;



/**
 * Home object for domain model class PessoaFisica.
 * @see com.dudhoo.nemesis.hibernate.PessoaFisica
 * @author Hibernate Tools
 */
public class PessoaFisicaHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(PessoaFisicaHome.class);
    
    public void persist(PessoaFisica transientInstance) {
        log.debug("persisting PessoaFisica instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }finally{
            closeSession();
        }
    }
    
    public void attachDirty(PessoaFisica instance) {
        log.debug("attaching dirty PessoaFisica instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PessoaFisica instance) {
        log.debug("attaching clean PessoaFisica instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(PessoaFisica persistentInstance) {
        log.debug("deleting PessoaFisica instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PessoaFisica merge(PessoaFisica detachedInstance) {
        log.debug("merging PessoaFisica instance");
        try {
            PessoaFisica result = (PessoaFisica) super
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public PessoaFisica findById( Long id, Session session) {
        setSession(session);
        log.debug("getting PessoaFisica instance with id: " + id);
        try {
            PessoaFisica instance = (PessoaFisica) super.currentSession()
                    .get("com.dudhoo.nemesis.hibernate.PessoaFisica", id);
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
            if(isIsSessionFornecida() == false){
                closeSession();
            }
        }
    }
    
    
    public List<PessoaFisica> findByExample(PessoaFisica instance) {
        log.debug("finding PessoaFisica instance by example");
        try {
            List<PessoaFisica> results = (List<PessoaFisica>) super.currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.PessoaFisica")
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