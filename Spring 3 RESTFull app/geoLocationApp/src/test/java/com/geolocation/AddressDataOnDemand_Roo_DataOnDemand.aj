package com.geolocation;

import com.geolocation.Address;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AddressDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AddressDataOnDemand: @Component;
    
    private Random AddressDataOnDemand.rnd = new SecureRandom();
    
    private List<Address> AddressDataOnDemand.data;
    
    public Address AddressDataOnDemand.getNewTransientAddress(int index) {
        com.geolocation.Address obj = new com.geolocation.Address();
        obj.setDescricao("descricao_" + index);
        return obj;
    }
    
    public Address AddressDataOnDemand.getSpecificAddress(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Address obj = data.get(index);
        return Address.findAddress(obj.getId());
    }
    
    public Address AddressDataOnDemand.getRandomAddress() {
        init();
        Address obj = data.get(rnd.nextInt(data.size()));
        return Address.findAddress(obj.getId());
    }
    
    public boolean AddressDataOnDemand.modifyAddress(Address obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void AddressDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.geolocation.Address.findAddressEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Address' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.geolocation.Address>();
        for (int i = 0; i < 10; i++) {
            com.geolocation.Address obj = getNewTransientAddress(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
