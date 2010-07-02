package com.openlastfm.conf;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

public class JsfUtil {
	private static Logger logger = Logger.getLogger(JsfUtil.class);

	public static Object getBeanFromFacesContext(final String theBeanName,
			final FacesContext theFacesContext) {

		final Object returnObject = theFacesContext.getELContext()
				.getELResolver().getValue(theFacesContext.getELContext(), null,
						theBeanName);
		if (returnObject == null) {
			logger
					.error("Bean with name " + theBeanName + " was not found. Check the faces-config.xml file if the given bean name is ok."); //$NON-NLS-1$ //$NON-NLS-2$  
		}
		return returnObject;
	}

	public static void setBeanFromFacesContext(final String theBeanName,
			final FacesContext theFacesContext, Object bean) {
		if (logger.isDebugEnabled()) {
			logger.debug("Setting the managed bean: #{" + theBeanName
					+ "}. Value: " + bean.toString());
		}
		theFacesContext.getExternalContext().getSessionMap().put(theBeanName,
				bean);
		if (logger.isDebugEnabled()) {
			logger.debug("The value of managed bean was set.");
		}
	}
}
