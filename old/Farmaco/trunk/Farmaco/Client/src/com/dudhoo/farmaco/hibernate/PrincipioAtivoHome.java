package com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.root.HibernateRoot;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class PrincipioAtivoHome extends HibernateRoot{
    public PrincipioAtivoHome() {        
    }
    
    public List findAll(int maxRows) throws SQLException{
        Session s = currentSession();
        try  {            
            return s.createCriteria(PrincipioAtivo.class)
                .setMaxResults(maxRows).list();
        } catch (HibernateException ex)  {
            throw ex;
        } finally  {
            s.close();
        }
    }

    /**
     * Procura pela chave
     * */
    public List <PrincipioAtivo> findByKey(String key) {
        Session s = currentSession();
        try  {    
            List lista = s.createCriteria(PrincipioAtivo.class)
            .addOrder(Order.asc("nome"))
            .list();
            System.out.println(lista.size());
            return lista;
        } catch (HibernateException ex)  {
            throw ex;
        } finally  {
            s.close();
        }
    }

    public void delete(PrincipioAtivo o) {
        Session s = currentSession();
        Transaction y = s.beginTransaction();
        try  {                
            s.delete(o);
            y.commit();
        } catch (HibernateException ex)  {
            y.rollback();
            throw ex;
        } finally  {        
            s.close();
            y = null;
        }
    }
}