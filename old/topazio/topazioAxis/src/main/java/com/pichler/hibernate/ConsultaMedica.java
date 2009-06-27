package com.pichler.hibernate;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.pichler.hibernate.root.Entidade;

@Entity
@SequenceGenerator(name = "MY_SEQ", sequenceName = "SEQ_CONSULTAS")
public class ConsultaMedica extends Entidade {
	private Calendar dataMarcadaConsulta;

	private Medico medico;

	private Pessoa paciente;

	@Column(name = "dataMarcadaConsulta", nullable = false, unique = false)
	public Calendar getDataMarcadaConsulta() {
		return dataMarcadaConsulta;
	}

	public void setDataMarcadaConsulta(Calendar dataMarcadaConsulta) {
		this.dataMarcadaConsulta = dataMarcadaConsulta;
	}

	@ManyToOne(optional = false)
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@ManyToOne(optional = false)
	public Pessoa getPaciente() {
		return paciente;
	}

	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}
}
