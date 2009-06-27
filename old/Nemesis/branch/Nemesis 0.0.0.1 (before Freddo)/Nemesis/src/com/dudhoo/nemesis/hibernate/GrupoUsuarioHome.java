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
 * Home object for domain model class GrupoUsuario.
 * @see com.dudhoo.nemesis.hibernate.GrupoUsuario
 * @author Hibernate Tools
 */
public class GrupoUsuarioHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(GrupoUsuarioHome.class);
   
    public void persist(GrupoUsuario transientInstance) {
        log.debug("persisting GrupoUsuario instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(GrupoUsuario instance) {
        log.debug("attaching dirty GrupoUsuario instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GrupoUsuario instance) {
        log.debug("attaching clean GrupoUsuario instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(GrupoUsuario persistentInstance) {
        log.debug("deleting GrupoUsuario instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GrupoUsuario merge(GrupoUsuario detachedInstance) {
        log.debug("merging GrupoUsuario instance");
        try {
            GrupoUsuario result = (GrupoUsuario) currentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public GrupoUsuario findById( Long id) {
        log.debug("getting GrupoUsuario instance with id: " + id);
        try {
            GrupoUsuario instance = (GrupoUsuario) currentSession()
                    .get("com.dudhoo.nemesis.hibernate.GrupoUsuario", id);
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
    
    
    public List<GrupoUsuario> findByExample(GrupoUsuario instance) {
        log.debug("finding GrupoUsuario instance by example");
        try {
            List<GrupoUsuario> results = (List<GrupoUsuario>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.GrupoUsuario")
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

    public  List <GrupoUsuario> findAll(){
	log.debug("finding ALL grupoUsuario");
	try {
	    List <GrupoUsuario> results = 
		currentSession()
		    .createCriteria("com.dudhoo.nemesis.hibernate.GrupoUsuario").list();
	    log.debug("find by example successful, result size: " + results.size());
	    return results;
	}
	catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}
    }
}
