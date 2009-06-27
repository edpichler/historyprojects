package com.farmacopedia.view.root;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.apache.log4j.Logger;

/**
 * Classe pai de todas as páginas.
 * 
 * @author dudu
 * 
 */
public class Page {
	protected final static Logger LOGGER = Logger.getLogger(Page.class);

	private FacesContext fc;

	public Page() {
		fc = FacesContext.getCurrentInstance();
	}

	protected void addMessage(Throwable ex) {
		FacesMessage msg = new FacesMessage(ex.getMessage(), ex.getMessage());
		fc.addMessage(ex.getMessage(), msg);
	}

	/** Retorna o bean da sessão */
	protected Object getBeanFromContext(String beanName) {
		ValueBinding vb = fc.getApplication().createValueBinding(beanName);
		return vb.getValue(fc);
	}

	/** Retorna o bean da sessão */
	protected void setBeanToContext(Object obj,String beanName) {
		ValueBinding vb = fc.getApplication().createValueBinding(beanName);
		vb.setValue(fc, obj);
	}

}
