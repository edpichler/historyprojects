package com.dudhoo.farmaco.hibernate.root;

import com.dudhoo.farmaco.hibernate.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.hibernate.NomeComercial;
import com.dudhoo.farmaco.hibernate.PrincipioAtivo;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateRoot {
    
    private static SessionFactory sessionFactory;
    
    protected final Logger log = Logger.getLogger(this.getClass());
    
    private final ThreadLocal session = new ThreadLocal();
    
    public HibernateRoot() {
        try {
            if(sessionFactory == null){
                sessionFactory = new Configuration()
                .addClass(PrincipioAtivo.class)
                .addClass(NomeComercial.class)
                .addClass(ApresentacaoFarmaceutica.class)
                .configure()
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
        }else{
            if(s.isOpen() == false){
                s = s.getSessionFactory().openSession();
            }
        }
        return s;
    }    
}
