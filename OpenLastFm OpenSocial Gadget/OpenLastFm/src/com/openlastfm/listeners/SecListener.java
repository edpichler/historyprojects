/**
 * 
 */
package com.openlastfm.listeners;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

/**
 * PhaseListener para somente o administrador poder entrar na pasta adm
 * 
 * @author duduzerah
 * 
 */
public class SecListener implements PhaseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2310472394601116452L;
	Logger logger = Logger.getLogger(SecListener.class);

	/**
	 * 
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	public void afterPhase(PhaseEvent event) {

	}

	/**
	 * 
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	public void beforePhase(PhaseEvent event) {
		// TODO IMPLEMENT
		final FacesContext facesContext = event.getFacesContext();
		final String viewId = facesContext.getViewRoot().getViewId();
		if (viewId.contains("/admin/")) {

			facesContext.getApplication().getNavigationHandler()
					.handleNavigation(facesContext, null, "home");
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	public PhaseId getPhaseId() {

		return PhaseId.RENDER_RESPONSE;
	}

}
