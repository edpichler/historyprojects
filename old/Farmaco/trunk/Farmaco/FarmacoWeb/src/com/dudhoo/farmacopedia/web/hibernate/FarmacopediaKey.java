package com.dudhoo.farmacopedia.web.hibernate;

import java.util.Date;

public class FarmacopediaKey {
    
    private String serial;
        
    public FarmacopediaKey(String _serial){
        setSerial(_serial);
    }
    public void setSerial(String key) {
        this.serial = key.toUpperCase();
    }

    public String getSerial() {
        return serial;
    }
    public String toString(){
        return getSerial();
    }
}
