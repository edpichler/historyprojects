package com.pichler.hibernate;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "MY_SEQ", sequenceName = "SEQ_MEDICO")
public class Medico extends Pessoa {
	
}
