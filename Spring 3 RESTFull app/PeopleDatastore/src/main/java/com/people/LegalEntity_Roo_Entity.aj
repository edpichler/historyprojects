package com.people;

import com.people.LegalEntity;
import java.lang.Long;
import java.util.List;

privileged aspect LegalEntity_Roo_Entity {
    
    public static long LegalEntity.countLegalEntitys() {
        return (Long) entityManager().createQuery("select count(o) from LegalEntity o").getSingleResult();
    }
    
    public static List<LegalEntity> LegalEntity.findAllLegalEntitys() {
        return entityManager().createQuery("select o from LegalEntity o").getResultList();
    }
    
    public static LegalEntity LegalEntity.findLegalEntity(Long id) {
        if (id == null) return null;
        return entityManager().find(LegalEntity.class, id);
    }
    
    public static List<LegalEntity> LegalEntity.findLegalEntityEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from LegalEntity o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
