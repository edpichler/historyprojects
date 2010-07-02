package com.geolocation;

import com.geolocation.AddressDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AddressIntegrationTest_Roo_IntegrationTest {
    
    declare @type: AddressIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: AddressIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private AddressDataOnDemand AddressIntegrationTest.dod;
    
    @Test
    public void AddressIntegrationTest.testCountAddresses() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        long count = com.geolocation.Address.countAddresses();
        org.junit.Assert.assertTrue("Counter for 'Address' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void AddressIntegrationTest.testFindAddress() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        java.lang.Long id = dod.getRandomAddress().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to provide an identifier", id);
        com.geolocation.Address obj = com.geolocation.Address.findAddress(id);
        org.junit.Assert.assertNotNull("Find method for 'Address' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Address' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void AddressIntegrationTest.testFindAllAddresses() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        long count = com.geolocation.Address.countAddresses();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Address', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.geolocation.Address> result = com.geolocation.Address.findAllAddresses();
        org.junit.Assert.assertNotNull("Find all method for 'Address' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Address' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void AddressIntegrationTest.testFindAddressEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        long count = com.geolocation.Address.countAddresses();
        if (count > 20) count = 20;
        java.util.List<com.geolocation.Address> result = com.geolocation.Address.findAddressEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'Address' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Address' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void AddressIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        java.lang.Long id = dod.getRandomAddress().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to provide an identifier", id);
        com.geolocation.Address obj = com.geolocation.Address.findAddress(id);
        org.junit.Assert.assertNotNull("Find method for 'Address' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAddress(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Address' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void AddressIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        java.lang.Long id = dod.getRandomAddress().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to provide an identifier", id);
        com.geolocation.Address obj = com.geolocation.Address.findAddress(id);
        org.junit.Assert.assertNotNull("Find method for 'Address' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAddress(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Address' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void AddressIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        com.geolocation.Address obj = dod.getNewTransientAddress(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Address' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Address' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void AddressIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to initialize correctly", dod.getRandomAddress());
        java.lang.Long id = dod.getRandomAddress().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Address' failed to provide an identifier", id);
        com.geolocation.Address obj = com.geolocation.Address.findAddress(id);
        org.junit.Assert.assertNotNull("Find method for 'Address' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        org.junit.Assert.assertNull("Failed to remove 'Address' with identifier '" + id + "'", com.geolocation.Address.findAddress(id));
    }
    
}
