package com.dudhoo.nemesis.hibernate;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import org.hibernate.Session;
import static org.hibernate.criterion.Example.create;



/**
 * Home object for domain model class Usuario.
 * @see com.dudhoo.nemesis.hibernate.Usuario
 * @author Hibernate Tools
 */
public class UsuarioHome extends HibernateRoot{

    private static final Log log = LogFactory.getLog(UsuarioHome.class);
    
    public void persist(Usuario transientInstance) {
        log.debug("persisting Usuario instance");
        try {
            super.persist(transientInstance);
            log.debug("persist successful");        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Usuario instance) {
        log.debug("attaching dirty Usuario instance");
        try {
            super.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Usuario instance) {
        log.debug("attaching clean Usuario instance");
        try {
            super.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Usuario persistentInstance) {
        log.debug("deleting Usuario instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Usuario merge(Usuario detachedInstance) {
        log.debug("merging Usuario instance");
        try {
            Usuario result = (Usuario) super
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Usuario findById(Session s, Long id) {
        log.debug("getting Usuario instance with id: " + id);
        try {
	    Session ses; 
	    if(s != null){
		ses = s;
	    }else{
		ses = currentSession();
	    }
	    
            Usuario instance = (Usuario) ses.get("com.dudhoo.nemesis.hibernate.Usuario", id);
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
	    if(s == null){
		closeSession();	    
	    }
	}
    }
    
    
    public List<Usuario> findByExample(Usuario instance) {
        log.debug("finding Usuario instance by example");
        try {
            List<Usuario> results = (List<Usuario>) currentSession()
                    .createCriteria("com.dudhoo.nemesis.hibernate.Usuario")
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