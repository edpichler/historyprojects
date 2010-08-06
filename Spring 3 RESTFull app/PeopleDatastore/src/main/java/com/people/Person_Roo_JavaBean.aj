package com.people;

import com.people.service.geolocation.Address;
import java.lang.String;

privileged aspect Person_Roo_JavaBean {
    
    public String Person.getName() {
        return this.name;
    }
    
    public void Person.setName(String name) {
        this.name = name;
    }
    
    public Address Person.getAddress() {
        return this.address;
    }
    
    public void Person.setAddress(Address address) {
        this.address = address;
    }
    
}
