package com.dudhoo.farmaco.app;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.farmaco.swing.StartFrame;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;


public class Application{
    private static String filename = "app-conf.xml";
    public static String APP_NAME = "app.name";    
    public static String APP_VERSION = "app.version";
    
    public static String APP_SERIAL = "app.serial";    
    
    private static XMLConfiguration configuration;
    private static String nome = "Farmacopedia";
    private static Logger logger = Logger.getLogger(Application.class);
    
    public Application(){
    }

    public static XMLConfiguration getConfiguration(){
	if(configuration == null){
	    initConf();            
	}
	return configuration;
    }

    private static void initConf(){
	try{
	    File arquivoxml = new File(filename);	    
	    configuration = new XMLConfiguration();
	    configuration.setAutoSave(true);
	    configuration.setFile(arquivoxml);
	    if(arquivoxml.exists()){
		configuration.load();
	    } else {
		configuration.addProperty(APP_NAME, nome);
		configuration.addProperty(APP_VERSION, "beta");
	        configuration.addProperty(APP_SERIAL, "000");	        
	    }
	} catch(ConfigurationException e){
	    new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);	   
	}
    }    
    
}
