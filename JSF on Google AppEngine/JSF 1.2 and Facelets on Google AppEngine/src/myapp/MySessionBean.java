package myapp;

import java.io.Serializable;
import java.util.logging.Logger;


public class MySessionBean implements Serializable {
	private Logger logger = Logger.getLogger(MySessionBean.class.getName());
	
	private String value;
	/**
	 * 
	 */
	public MySessionBean() {
		logger.info("The Session Bean is being created.");
	}
	private static final long serialVersionUID = 1L;

	public String submit() {
		logger.info("Submit action was called.");
		return null;
	}

	public void setValue(String value) {
		logger.info("Setting the value.");
		this.value = value;
	}

	public String getValue() {
		logger.info("Getting the value.");
		return value;
	}
}
