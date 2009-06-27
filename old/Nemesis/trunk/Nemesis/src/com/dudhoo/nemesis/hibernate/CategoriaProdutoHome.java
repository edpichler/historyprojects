package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriaProdutoHome extends HibernateRoot{
    public CategoriaProdutoHome() {
    }
    public List getAllCategoria(){
        try  {
            List list = currentSession().createCriteria(CategoriaProduto.class).list();
            return list;
        } catch (HibernateException ex)  {
            throw ex;
        } finally  {
            closeSession();
        }
        
    }
    
    public CategoriaProduto findById(Long id, Session s){           
        setSession(s);
        try  {        
            CategoriaProduto cat = (CategoriaProduto) currentSession().load(CategoriaProduto.class, id);         
            return cat;
        } catch (HibernateException ex)  {            
            throw ex;
        }finally{            
            if(!isIsSessionFornecida()){
                closeSession();
            }
        }
    }
    
    public void deleteById(Long id){
        Transaction t = currentSession().beginTransaction();
        try  {
            CategoriaProduto cat = (CategoriaProduto) currentSession().load(CategoriaProduto.class, id);          
            currentSession().delete(cat);
            t.commit();
        } catch (HibernateException ex)  {
            t.rollback();
            throw ex;
        } finally  {
            closeSession();
        }
        
    }
}
