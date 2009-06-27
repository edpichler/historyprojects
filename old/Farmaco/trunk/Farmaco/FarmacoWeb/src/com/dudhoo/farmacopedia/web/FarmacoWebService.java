package com.dudhoo.farmacopedia.web;

import com.dudhoo.farmacopedia.web.hibernate.FarmacopediaKey;
import com.dudhoo.farmacopedia.web.key.KeyGenerator;

import java.util.Calendar;
import java.util.Date;

public class FarmacoWebService {
    public FarmacoWebService() {
    }
    
    public Date getServerTime(){
        return Calendar.getInstance().getTime();
    }
    
    public FarmacopediaKey generateSerial(Date ini, int dias){
        return new KeyGenerator().generateKey(ini, dias);
    }
}
