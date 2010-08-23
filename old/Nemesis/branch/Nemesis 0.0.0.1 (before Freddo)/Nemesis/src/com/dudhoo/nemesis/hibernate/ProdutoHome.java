package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;
import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class ProdutoHome extends HibernateRoot{
    public ProdutoHome(){
    }

    public List<Produto> findAll(){
	log.debug("getting all Produtos");
	try{
	    List<Produto> instance = 
		currentSession().createCriteria(Produto.class).list();

	    if(instance == null){
		log.debug("get successful, no instance found");
	    } else {
		log.debug("get successful, instance found");
	    }
	    return instance;
	} catch(RuntimeException re){
	    log.error("get failed", re);
	    throw re;
	}finally{
            closeSession();
        }
    }

    public Produto findById(Long id){
	log.debug("getting Produto instance with id: " + id);
	try{
	    Produto instance = 
		(Produto)currentSession().get("com.dudhoo.nemesis.hibernate.Produto", id);
	    if(instance == null){
		log.debug("get successful, no instance found");
	    } else {
		log.debug("get successful, instance found");
	    }
	    return instance;
	} catch(RuntimeException re){
	    log.error("get failed", re);
	    throw re;
	}
    }

    public void delete(Produto prod){
	log.debug("deleting Produto instance with id: " + prod.getId());
	try{
	    currentSession().delete(prod);
	} catch(RuntimeException re){
	    log.error("get failed", re);
	    throw re;
	}
    }

    public void deleteProdutoById(long id){
	Transaction t = currentSession().beginTransaction();
	try{
	    Produto p = findById(id);
	    if(p != null){
		this.delete(p);
	    }
	    t.commit();
	} catch(HibernateException ex){
	    t.rollback();
	    throw ex;
	}
    }
}
