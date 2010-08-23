package com.pichler.hibernate.root;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.pichler.hibernate.ConsultaMedica;
import com.pichler.hibernate.Medico;
import com.pichler.hibernate.Pessoa;
import com.pichler.hibernate.Usuario;


/**
 * Classe que manipula o acesso global as sessões do hibernate e conexões com o
 * recurso do reposiório de dados.
 * 
 */
public abstract class HibernateRoot {

	/**
	 * Logger.
	 */
	protected final static Logger _LOG = Logger.getLogger(HibernateRoot.class);

	private static SessionFactory sessionFactory;

	// ~--- fields -------------------------------------------------------------

	private Session session;

	boolean sessionFornecida = false;

	// ~--- constructors -------------------------------------------------------

	/**
	 * Constructs ...
	 * 
	 */
	public HibernateRoot() {
		try {
			if (sessionFactory == null) {
				sessionFactory = new AnnotationConfiguration()
						.addAnnotatedClass(Usuario.class)
						.addAnnotatedClass(Pessoa.class)
						.addAnnotatedClass(Medico.class)
						.addAnnotatedClass(ConsultaMedica.class)						
						.configure()
						.buildSessionFactory();
			}
		} catch (Throwable ex) {
			_LOG .error("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);
		}
	}

	// ~--- methods ------------------------------------------------------------

	/**
	 * Fecha a sessão do hibernate.
	 * 
	 * @param force
	 *            true para fechar indepentemente se a session tenha sido
	 *            fornecida manualmente.
	 */
	public void closeSession(boolean force) {
		if ((session != null) && ((Session) session).isOpen()) {
			if (force) {
				((Session) session).close();
			} else if (isSessionFornecida() == false) {
				((Session) session).close();
			}
		}
	}

	/**
	 * Fecha a sessão quando ela é criada automaticamente e não é setada (sem
	 * chamar o método setSession)
	 */
	public void closeSession() {
		this.closeSession(!isSessionFornecida());
	}

	/**
	 * Retorna a sessão <i>current</i>.
	 * 
	 * @return a sessão.
	 * @throws HibernateException
	 *             caso ocorra erros.
	 */
	public Session currentSession() throws Exception {
		try {
			if (session == null || !session.isOpen()) {
				session = sessionFactory.openSession();
			}
			return session;
		} catch (HibernateException x) {
			throw x;
		}
	}

	// ~--- get methods --------------------------------------------------------

	/**
	 * Acessor.
	 * 
	 * @return true se a sess�o foi fornecida ou setada manualmente.
	 */
	public boolean isSessionFornecida() {
		return sessionFornecida;
	}

	// ~--- set methods --------------------------------------------------------

	/**
	 * Acessor.
	 * 
	 * @param s
	 *            a sess�o
	 */
	public void setSession(Session s) {
		session = s;
		sessionFornecida = (s != null);
	}
}
