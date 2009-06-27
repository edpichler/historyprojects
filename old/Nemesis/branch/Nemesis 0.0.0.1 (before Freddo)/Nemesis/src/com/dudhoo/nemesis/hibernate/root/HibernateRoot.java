package com.dudhoo.nemesis.hibernate.root;

import com.dudhoo.nemesis.hibernate.CidadeHome;
import com.dudhoo.nemesis.swing.StartFrame;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class HibernateRoot {
    
    private static SessionFactory sessionFactory;
    
    protected final Logger log = Logger.getLogger(this.getClass());
    
    private final ThreadLocal session = new ThreadLocal();
    
    public HibernateRoot() {
        try {
            if(sessionFactory == null){
                sessionFactory = new Configuration().configure()
                .buildSessionFactory();
                
            }
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }    
    
    public Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }
    
    public void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        closeSession(s);
    }
    
    protected void persist(Object transientInstance) {
        Transaction t = currentSession().beginTransaction(); 
        try {
            currentSession().persist(transientInstance);
            t.commit();
        } catch (HibernateException re) {            
            t.rollback();            
            throw re;
        }finally{
            closeSession();
        }
    }
    
    public void saveOrUpdate(Object transientInstance) {
        Transaction t = currentSession().beginTransaction();
        try {            
            currentSession().saveOrUpdate(transientInstance);
            t.commit();
        } catch (HibernateException re) {            
            t.rollback();            
            throw re;
        }finally{
             closeSession();
        }
    }
    
    public void update(Object transientInstance) {
        Transaction t = currentSession().beginTransaction();
        try {
            currentSession().update(transientInstance);
            t.commit();
        } catch (HibernateException re){
            t.rollback();
            closeSession();
            throw re;
        }
    }
    
    protected void lock(Object instance, LockMode none) {
        Transaction t = currentSession().beginTransaction();
        try {
            currentSession().lock(instance, none);
            t.commit();
        } catch (HibernateException re) {
            t.rollback();
            closeSession();
            throw re;
        }
    }
    
    public void delete(Object instance) {
        Transaction t = currentSession().beginTransaction();
        try {
            currentSession().delete(instance);
            t.commit();
        } catch (HibernateException re) {
            t.rollback();
            closeSession();
            throw re;
        }
    }
    
    protected Object merge(Object instance) {
        Transaction t = currentSession().beginTransaction();
        try {
            Object o = currentSession().merge(instance);
            t.commit();
            return o;
        } catch (HibernateException re) {
            t.rollback();
            closeSession();
            throw re;
        }
    }
    
    protected List executeSQLQuery(String tableName, Class theClass,
            String where, Object arg[]) {
        Session session = currentSession();
        SQLQuery q = session.createSQLQuery("select {" + tableName
                + ".*} from " + tableName + " where " + where);
        q.addEntity(tableName, theClass);
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] instanceof Integer) {
                q.setInteger(i, ((Integer) arg[i]).intValue());
            } else if (arg[i] instanceof Short) {
                q.setShort(i, ((Short) arg[i]).shortValue());
            } else if (arg[i] instanceof Long) {
                q.setLong(i, ((Long) arg[i]).longValue());
            } else if (arg[i] instanceof Double) {
                q.setDouble(i, ((Double) arg[i]).doubleValue());
            } else if (arg[i] instanceof Float) {
                q.setFloat(i, ((Float) arg[i]).floatValue());
            } else if (arg[i] instanceof BigDecimal) {
                q.setBigDecimal(i, (BigDecimal) arg[i]);
            } else if (arg[i] instanceof BigInteger) {
                q.setBigInteger(i, (BigInteger) arg[i]);
            } else if (arg[i] instanceof String) {
                q.setString(i, (String) arg[i]);
            } else if (arg[i] instanceof Boolean) {
                q.setBoolean(i, ((Boolean) arg[i]).booleanValue());
            } else if (arg[i] instanceof Date) {
                q.setDate(i, (Date) arg[i]);
            } else {
                throw new IllegalStateException("bad type");
            }
        }
        List list = q.list();
        closeSession();
        return list;
    }
    
    /**
     *faz rolback uma transação
     */
    public void roolbackTransaction(Transaction t){
        if( t != null){
            t.rollback();
        }
    }
     /**
     *faz commit na transação
     */
    public void commitTransaction(Transaction t){
        if( t != null){
            try{
                t.commit();
            }catch(Exception xxx){
                erro(xxx);
            }
        }
    }
    
    /**Fecha uma session*/
    public void closeSession(Session s){
        if (s != null) {
            try{
                s.close();
            }catch(Exception xxx){
                erro(xxx);
            }
        } 
    }
    
    protected void erro(Throwable th){
        new com.dudhoo.evilframework.swing.EvilError(StartFrame.getCurrentInstance(), false, th).setVisible(true);
    }
}