package com.dudhoo.farmaco.app;

import com.dudhoo.evilframework.swing.EvilError;

import com.dudhoo.farmaco.dto.Usuario;
import com.dudhoo.farmaco.install.IntalacaoDiretorio;
import com.dudhoo.farmaco.jdbc.implementation.UsuarioDaoImpl;
import com.dudhoo.farmaco.swing.StartFrame;

import java.io.File;

import java.io.IOException;

import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;


public class Application{
    private static String filename = "app-conf.xml";
    public static String CONNECTION_STRING = "app.data.JDBC_CONNECTION_STR";
    public static String JDBC_DRIVER_NAME = "app.data.JDBC_DRIVER_NAME";
    public static String APP_NAME = "app.name";
    public static String APP_VERSION = "app.version";
    private static XMLConfiguration configuration;
    private static String nome = "Farmaco";
    private static Logger logger = Logger.getLogger(Application.class);
    
    private static File rootFile = null;
    private static Usuario instance = null;

    public Application(){
    }

    public static XMLConfiguration getConfiguration(){
	if(configuration == null){
	    initConf();
	}
	return configuration;
    }

    public static Usuario getUsuarioLogado() throws SQLException{
	if(instance == null){
	    instance = new UsuarioDaoImpl().findById(1);
	}
	return instance;
    }

    private static void initConf(){
	try{
	    File arquivoxml = new File(getAppDirectory().getAbsolutePath() + File.separator +  filename);
	    
	    configuration = new XMLConfiguration();
	    configuration.setAutoSave(true);
	    configuration.setFile(arquivoxml);
	    if(arquivoxml.exists()){
		configuration.load();
	    } else {
		configuration.addProperty(APP_NAME, nome);
		configuration.addProperty(CONNECTION_STRING, 
			    "jdbc:derby:" + getAppDirectory().getAbsolutePath() + File.separator + "database;create=true;");
		configuration.addProperty(JDBC_DRIVER_NAME, 
			    "org.apache.derby.jdbc.EmbeddedDriver");
		configuration.addProperty(APP_VERSION, "0.8");
	    }
	    logger.info("Diretório da aplicação é: " + getAppDirectory().getAbsolutePath() );	    
	} catch(ConfigurationException e){
	    new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);	   
	}
    }
    
    //TODO FAZER RODAR NO LINUX
    //TODO FAZER LOGS PARA ARQUIVOS 
    private static File getAppDirectory(){
	String separador = File.separator;
	if(rootFile == null ){
	    File f = new File(System.getProperties().getProperty("java.home"));
	    while(f.getParentFile() != null){
		f = f.getParentFile();	        
	    }
	    rootFile = f;
	}
	return new File(rootFile.getAbsolutePath() + separador + "Applications" + separador + nome + separador);	
    }
    
}
