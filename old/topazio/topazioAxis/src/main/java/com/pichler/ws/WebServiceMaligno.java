package com.pichler.ws;

import java.util.List;

import org.apache.log4j.Logger;

import com.pichler.hibernate.ConsultaMedica;
import com.pichler.hibernate.HiberConsultaMedicas;
import com.pichler.hibernate.HiberMedico;
import com.pichler.hibernate.HiberPessoa;

public class WebServiceMaligno {
	protected final Logger _LOG = Logger.getLogger(this.getClass());

	public void newPessoa(com.pichler.hibernate.Pessoa pes) throws Exception {
		_LOG.info("Salvando pessoa...");
		try {
			new HiberPessoa().salvar(pes);
			_LOG.info("Salvou");
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}

	public void newMedico(com.pichler.hibernate.Medico med) throws Exception {

		_LOG.info("Salvando médico...");
		try {
			new HiberPessoa().salvar(med);
			_LOG.info("Salvou");
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}

	public void marcarNovaConsultaMedica(
			com.pichler.hibernate.ConsultaMedica cons) throws Exception {
		_LOG.info("Marcando nova consulta médica");
		try {
			new HiberConsultaMedicas().salvar(cons);
			_LOG.info("A consulta foi marcada.");
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public java.util.List getConsultasMedicas(long medicoId,
			java.util.Calendar dataInicial, java.util.Calendar dataFinal)
			throws Exception {
		_LOG.info("Pesquisando consultas médicas");
		try {
			List<ConsultaMedica> resultado = new HiberConsultaMedicas()
					.getConsultasMedicas(medicoId, dataInicial, dataFinal);
			_LOG.info("Encontrado " + resultado.size() + " consultas medicas.");
			return resultado;
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public java.util.List getMedicos() throws Exception {
		_LOG.info("Pesquisando médicos");
		try {
			List resultado = new HiberMedico().list();
			_LOG.info("Encontrado " + resultado.size() + " medicos.");
			return resultado;
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * Pesquisa pessoas do sistema.
	 * 
	 * @param nome
	 *            o nome
	 * @param maxResults
	 *            número máximo de pessoas no resultado
	 * @return as pessoas conforme os filtros especificados
	 * 
	 */
	public java.util.List getPessoas(java.lang.String nome, int maxResults)
			throws Exception {
		_LOG.info("Pesquisando Pessoas");
		try {
			List resultado = new HiberPessoa().findByNome(nome, maxResults);
			_LOG.info("Encontrado " + resultado.size() + " pessoas.");
			return resultado;
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}

	/**
	 * Retorna consultas entre duas datas. 
	 * DataInicial e final será comparada com a data de marcação da consulta.
	 * @throws Exception 
	 */
	public java.util.List getConsultasBetweenDates(java.util.Calendar dataInicial,
			java.util.Calendar dataFinal, long medicoId, java.lang.String nomePaciente,
			int maxResults) throws Exception {
		_LOG.info("Pesquisando consultas");
		try {
			List resultado = new HiberConsultaMedicas().getConsultasMedicas(
					dataInicial, dataFinal, medicoId, nomePaciente, maxResults);
			_LOG.info("Encontrado " + resultado.size() + " consultas.");
			return resultado;
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}
	/**
	 * Retorna consultas entre duas datas. 
	 * DataInicial e final será comparada com a data de marcação da consulta.
	 * @param pacienteId id do paciente.
	 * @throws Exception 
	 */
	public java.util.List getConsultasByPaciente(java.util.Calendar dataInicial,
			java.util.Calendar dataFinal, long pacienteId,
			int maxResults) throws Exception {
		_LOG.info("Pesquisando consultas");
		try {
			List resultado = new HiberConsultaMedicas().getConsultasMedicas(
					dataInicial, dataFinal, pacienteId, maxResults);
			_LOG.info("Encontrado " + resultado.size() + " consultas.");
			return resultado;
		} catch (Exception e) {
			_LOG.error(e);
			throw e;
		}
	}
}
