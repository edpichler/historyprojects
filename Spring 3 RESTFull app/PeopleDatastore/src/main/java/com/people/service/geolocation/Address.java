package com.people.service.geolocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooEntity
public class Address {

	@Transient
	private String description;

	public static List<Address> findAllAddresses() {
		return Address.findAllREST();
	}

	public static long countAddresses() {
		Long i = 0L + Address.findAllREST().size();
		return i;
	}

	public static Address findAddress(Long id) {
		if (id == null) {
			return null;
		}
	    Address banco = Address.entityManager().find(Address.class, id);
	        
		ArrayList<Address> all = Address.findAllREST();
		for (Iterator iterator = all.iterator(); iterator.hasNext();) {
			Address address = (Address) iterator.next();
			if(address.getId().equals(id)){
				return address;
			}			
		}
		return null;
	}

	public static List<Address> findAddressEntries(int firstResult,
			int maxResults) {
		
		ArrayList<Address> retorno = new ArrayList<Address>();
		ArrayList<Address> all = Address.findAllREST();
		
		int count = 0;
		for (Iterator iterator = all.iterator(); iterator.hasNext();) {
			Address address = (Address) iterator.next();
			if(count >= firstResult && count < maxResults){
				retorno.add(address);
			}
			if(count > maxResults){
				return retorno;
			}
		}		
		return retorno;
	}

	public String toString() {
		return description;
	}
}
