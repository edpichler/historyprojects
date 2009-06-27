package com.dudhoo.nemesis.hibernate;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoque;

import org.hibernate.HibernateException;

public class MovimentoEstoqueHome extends HibernateRoot{
    public MovimentoEstoqueHome(){
    }

    public List<MovimentoEstoque> findAll(){
	List list = null;
	try{
	    list = currentSession().createCriteria(MovimentoEstoque.class).list();	    
	    return list;
	}catch(HibernateException ex){
	    throw ex;
	}finally{
	    closeSession();
	}
    }

    /**
     * Salva o movimento no estoque e cria uma conta no financeiro
     * */
    public void saveOrUpdate(MovimentoEstoque mvs){
	Session sess = currentSession();
	Transaction t = sess.beginTransaction();
	try{	    
	    sess.saveOrUpdate(mvs);	    
	    t.commit();
	} catch(Exception ex){
	    t.rollback();
	    throw new HibernateException(ex);
	} finally{
	    closeSession();
	}
    }

    public MovimentoEstoque findById(Long id){	
	try{
	    MovimentoEstoque mov = (MovimentoEstoque)currentSession().get(MovimentoEstoque.class, id);
	    return mov;
	}catch(HibernateException ex){
	    throw ex;
	}finally{
	    closeSession();
	}
    }

    public void deleteById(Long id){
	Transaction t = currentSession().beginTransaction();
	try{	    
	    MovimentoEstoque mov = (MovimentoEstoque)currentSession().get(MovimentoEstoque.class, id);
	    currentSession().delete(mov);	    
	    t.commit();
	}catch(HibernateException ex){
	    t.rollback();
	    throw ex;
	}finally{	
	    closeSession();
	}
    }
}
