package com.people;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.people.service.geolocation.Address;

@Entity
@RooJavaBean
@RooToString()
@RooEntity(findEntriesMethod = "find")
public class Person {

	@NotNull
	@Size(min = 2, max = 255)
	private String name;
	
	
	@OneToOne(targetEntity = Address.class )
	private Address address;

/*	public static List<Person> findPersonEntries(int firstResult, int maxResults) {
		List<Person> persons = entityManager().createQuery(
				"select o from Person o").setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			Address dataBaseAddress = person.getAddress();
			if (dataBaseAddress != null) {
				String description = Address.findAddressREST(
						dataBaseAddress.getId()).getDescription();
				dataBaseAddress.setDescription(description);
			}
		}

		return persons;
	}

	public static Person findPerson(Long id) {
		if (id == null)
			return null;
		Person person = entityManager().find(Person.class, id);
		Address dataBaseAddress = person.getAddress();
		if (dataBaseAddress != null) {
			String description = Address.findAddressREST(
					dataBaseAddress.getId()).getDescription();
			dataBaseAddress.setDescription(description);
		}

		return person;
	}*/
}
