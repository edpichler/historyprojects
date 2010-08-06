package com.people.service.geolocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.people.Person;

public aspect AddressRestServices {

	private static final String addressService = "http://localhost:8080/geoLocationApp/address.xml";

	//pointcut novaPessoa() : call(Person.new()) ;
	
	 /*before(): novaPessoa(){
		System.out.println( new Address().findFuckingAll());		
	}*/

	public static ArrayList<Address> Address.findAllREST() {
		RestTemplate restTemplate;
		ApplicationContext xmlWebApplicationContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
		 
		restTemplate = (RestTemplate) xmlWebApplicationContext
				.getBean("restTemplate");		
		ArrayList<Address> result = restTemplate.getForObject(addressService, ArrayList.class);
		
		return result;
	}
	
	public static Address Address.findAddressREST(Long id){
		ArrayList<Address> result = new Address().findAllREST();
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Address address = (Address) iterator.next();
			if(address.getId().equals(id)){
				return address;
			}
		}
		return null;
	}
}
