package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import static org.hibernate.criterion.Example.create;

public class TipoContaHome extends HibernateRoot {
    public TipoContaHome() {
    }

    public List getAllTipoContas() {
        try {
            List list = 
                currentSession().createCriteria(TipoConta.class).list();
            return list;
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            closeSession();
        }
    }

    public List getAllTipoContasCredito() {
        try {
            TipoConta tipo = new TipoConta();
            tipo.setCredito(true);
            List list = 
                currentSession().createCriteria(TipoConta.class).add(create(tipo)).list();
            return list;
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            closeSession();
        }
    }

    public List getAllTipoContasDebito() {
        try {
            TipoConta tipo = new TipoConta();
            tipo.setCredito(false);
            List list = 
                currentSession().createCriteria(TipoConta.class).add(create(tipo)).list();
            return list;
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            closeSession();
        }
    }

    public TipoConta findById(Long id) {
        try {
            TipoConta instance = 
                (TipoConta)currentSession().get(TipoConta.class, id);
            if (instance == null) {
                log.debug("get successful, no instance found");
            } else {
                log.debug("get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        } finally {
            closeSession();
        }
    }

    public TipoConta deleteById(Long id) {
        Transaction t = currentSession().beginTransaction();
        try {
            TipoConta instance = 
                (TipoConta)currentSession().get(TipoConta.class, id);
            currentSession().delete(instance);
            t.commit();
            return instance;
        } catch (RuntimeException re) {
        t.rollback();
            log.error("get failed", re);
            throw re;
        } finally {
            closeSession();
        }
    }
}
