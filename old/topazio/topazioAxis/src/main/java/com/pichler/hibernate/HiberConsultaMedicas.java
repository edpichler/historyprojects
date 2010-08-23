package com.pichler.hibernate;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.pichler.hibernate.root.HibernateRoot;

public class HiberConsultaMedicas extends HibernateRoot {

	public void salvar(ConsultaMedica cons) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.saveOrUpdate(cons);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ConsultaMedica> list(int max) throws Exception {
		try {
			Session s = currentSession();
			return s.createCriteria(ConsultaMedica.class).setMaxResults(max)
					.list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public void deletar(ConsultaMedica cons) throws Exception {
		Transaction t = null;
		try {
			Session s = currentSession();
			t = s.beginTransaction();
			s.delete(cons);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			closeSession();
			t = null;
		}
	}

	public ConsultaMedica findById(ConsultaMedica cons) throws Exception {
		try {
			Session s = currentSession();
			ConsultaMedica ret = (ConsultaMedica) s.createCriteria(
					ConsultaMedica.class).add(Expression.idEq(cons.getId()))
					.uniqueResult();
			return ret;
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	/**
	 * @return as consultas médicas do médico passado em parâmetro
	 * @throws Exception
	 */
	public List getConsultasMedicas(long medicoId, Calendar dataInicial,
			Calendar dataFinal) throws Exception {
		try {
			Session s = currentSession();
			return s.createQuery(
					"from ConsultaMedica as cm where cm.medico.id = :id")
					.setLong("id", medicoId).list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

	public List getConsultasMedicas(Calendar dataInicial, Calendar dataFinal,
			long medicoId, String nomePaciente, int maxResults)
			throws Exception {
		try {
			Session s = currentSession();
			Query cr = s
					.createQuery("from ConsultaMedica c "
							+ " where c.dataMarcadaConsulta between :dataInicio and :dataFim "
							+ " and c.paciente.nome like :nome "
							+ " and c.medico.id = :medicoId");
			cr.setCalendar("dataInicio", dataInicial);
			cr.setCalendar("dataFim", dataFinal);
			cr.setString("nome", "%" + nomePaciente + "%");
			cr.setInteger("medicoId", Integer.valueOf("" + medicoId));
			cr.setMaxResults(maxResults);
			return cr.list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}
	
	public List getConsultasMedicas(Calendar dataInicial, Calendar dataFinal,
			long pacienteId, int maxResults)
			throws Exception {
		try {
			Session s = currentSession();
			Query cr = s
					.createQuery("from ConsultaMedica c "
							+ " where c.dataMarcadaConsulta between :dataInicio and :dataFim "
							+ " and c.paciente.id = :pacienteId");
							
			cr.setCalendar("dataInicio", dataInicial);
			cr.setCalendar("dataFim", dataFinal);			
			cr.setInteger("pacienteId", Integer.valueOf("" + pacienteId));
			cr.setMaxResults(maxResults);
			return cr.list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
	}

}
