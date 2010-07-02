package com.people;

import com.people.Sex;

privileged aspect Individual_Roo_JavaBean {
    
    public Sex Individual.getSex() {
        return this.sex;
    }
    
    public void Individual.setSex(Sex sex) {
        this.sex = sex;
    }
    
}
