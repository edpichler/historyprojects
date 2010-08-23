package com.people.service.geolocation;

import java.lang.String;

privileged aspect Address_Roo_JavaBean {
    
    public String Address.getDescription() {
        return this.description;
    }
    
    public void Address.setDescription(String description) {
        this.description = description;
    }
    
}
