/**
 * 
 */
package com.openlastfm.backing;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * @author duduzerah
 * 
 */
public class DateHumanConverter implements Converter {

/**{@inheritDoc 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented Yet.");
	}

/**{@inheritDoc
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM HH:mm");
		String retorno =  formatter.format(arg2 );
		return retorno;
	}

}
