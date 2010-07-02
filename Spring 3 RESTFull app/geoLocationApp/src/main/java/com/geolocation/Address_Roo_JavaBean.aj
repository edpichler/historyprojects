package com.geolocation;

import java.lang.String;

privileged aspect Address_Roo_JavaBean {
    
    public String Address.getDescricao() {
        return this.descricao;
    }
    
    public void Address.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
