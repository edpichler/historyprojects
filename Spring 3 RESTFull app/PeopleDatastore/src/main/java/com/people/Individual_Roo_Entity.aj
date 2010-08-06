package com.people;

import com.people.Individual;
import java.lang.Long;
import java.util.List;

privileged aspect Individual_Roo_Entity {
    
    public static long Individual.countIndividuals() {
        return (Long) entityManager().createQuery("select count(o) from Individual o").getSingleResult();
    }
    
    public static List<Individual> Individual.findAllIndividuals() {
        return entityManager().createQuery("select o from Individual o").getResultList();
    }
    
    public static Individual Individual.findIndividual(Long id) {
        if (id == null) return null;
        return entityManager().find(Individual.class, id);
    }
    
    public static List<Individual> Individual.findIndividualEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Individual o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
