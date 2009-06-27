package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.criterion.Expression;

public class ContaReceberHome extends HibernateRoot{
    private long pg_id;
    public ContaReceberHome(){
    }

    public void setPg_id(long pg_id){
	this.pg_id = pg_id;
    }

    public long getPg_id(){
	return pg_id;
    }

    public ContaReceber findContaReceber(Long id){
	ContaReceber ret = (ContaReceber) currentSession().get(ContaReceber.class,id);
	closeSession();
	return ret;
    }
    
    public List	<ContaReceber> getContasReceber(long pessoaFisicaId){
	Query q = currentSession().createQuery("from ContaReceber rec where rec.contaPaga = false and rec.pessoa.pessoaFisicas.id = :id").
	    setLong("id",pessoaFisicaId);
	System.out.println(q.list());	
	List retorno = q.list();
	closeSession();
	return retorno;
    }

    public void deletaById(Long id){
	ContaReceber c = (ContaReceber)currentSession().get(ContaReceber.class, id);
	delete(c);
	closeSession(); 
    }
}
