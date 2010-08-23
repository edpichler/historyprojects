package com.people;

import com.people.Person;
import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

/**
 * Entidade legal/Pessoa Júridica
 * */
@Entity
@RooJavaBean
@RooToString
@RooEntity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LegalEntity extends Person {

	@Size(max = 23)
	private String cnpj;
}
