package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.root.HibernateRoot;


public class ContaPagarHome extends HibernateRoot{
    public ContaPagarHome(){
    }

    public ContaPagar findContaPagar(Long id){
	ContaPagar c = (ContaPagar ) currentSession().get(ContaPagar.class,id);	
	closeSession();
	return c;
    }

    public void deleteById(Long id){
	ContaPagar c = (ContaPagar)currentSession().get(ContaPagar.class, id);
	delete(c);
	closeSession();	
    }
}
