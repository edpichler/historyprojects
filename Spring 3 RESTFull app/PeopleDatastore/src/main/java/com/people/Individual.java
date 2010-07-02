package com.people;

import com.people.Person;
import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import com.people.Sex;
import javax.persistence.Enumerated;

/** Indivíduo/Pessoa física */
@Entity
@RooJavaBean
@RooToString
@RooEntity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Individual extends Person {

	@Enumerated
	private Sex sex;
}
