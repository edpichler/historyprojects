package com.dudhoo.farmaco.hibernate.abstracts;

import java.util.Date;

public abstract class Entity{
    private int id;
    private Date ultMod;

    public void setUltMod(Date ultMod) {
        this.ultMod = ultMod;
    }

    public Date getUltMod() {
        return ultMod;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
