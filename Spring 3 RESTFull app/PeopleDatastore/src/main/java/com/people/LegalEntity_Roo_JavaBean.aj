package com.people;

import java.lang.String;

privileged aspect LegalEntity_Roo_JavaBean {
    
    public String LegalEntity.getCnpj() {
        return this.cnpj;
    }
    
    public void LegalEntity.setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
