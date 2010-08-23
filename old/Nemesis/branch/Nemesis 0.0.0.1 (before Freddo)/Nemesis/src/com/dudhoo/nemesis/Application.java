/*
 * Application.java
 *
 * Created on 8 de Fevereiro de 2006, 23:39
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.hibernate.UsuarioHome;

import com.dudhoo.nemesis.swing.StartFrame;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;


//TODO VALIDAR CAMPOS DE TODA A APLICAÇÃO, NÃO PODEM SER MAIORES DO QUE O BANCO PERMITE. PODE OLHAR NOS ARQUIVOS XML DO HIBERNATE.
//TODO MUDAR NO BANCO DE DADOS, OS CAMOS ULTIMA MODIFICACAO DEVE TER O VALOR PADRÃO QUE É O TIMESTAMP CORRENTE
/**
 *
 * @author duduzera
 */
public class Application{
    private static Usuario usuarioLogado;
    private static XMLConfiguration configuration;    
    public static String APP_NAME = "app.name";   
    public static String APP_VERSION = "app.version";   
    public static String BIRT_ENGINE_HOME = "app.birt.engine.home";
    public static String BIRT_REPORTS_HOME = "app.birt.reports.home";
    public static String SO_COMMAND_BROWSER = "app.command.browser";
    
    /** Creates a new instance of Application */
    private static Logger logger = Logger.getLogger(Application.class);

    public Application(){

    }

    public static Usuario getUsuarioLogado(){
	if(usuarioLogado == null){
	    //TODO REMOVER ISSO, USUÁRIO SERÁ PEGO NO LOGIN
	    UsuarioHome uh = new UsuarioHome();
	    usuarioLogado = uh.findById(null,new Long(1));	    
	}
	return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usr){
	usuarioLogado = usr;
    }

    public static XMLConfiguration getConfiguration(){
	if(configuration == null){
	    initConf();
	}
	return configuration;
    }

    private static void initConf(){
	try{
	    File arquivoxml = 
		new File(getAppDirectory().getAbsolutePath() + File.separator + "nemesis-conf.xml");
	    configuration = new XMLConfiguration();	    	    
	    configuration.setAutoSave(true);
	    configuration.setFile(arquivoxml);
	    if(arquivoxml.exists()){
		configuration.load();
	    } else {
		configuration.addProperty(APP_NAME, "Nemesis");		
		configuration.addProperty(APP_VERSION, "0.1 beta");
		String ata = "rundll32 url.dll FileProtocolHandler";
		configuration.addProperty(SO_COMMAND_BROWSER, ata); // se for linux é String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
		File engineBirtHome = new File( getAppDirectory().getAbsolutePath() + "/lib/birt/birt-runtime-2_0_1/Report Engine/");
	        configuration.addProperty(BIRT_ENGINE_HOME, engineBirtHome.getAbsolutePath() );
	        File birtReportsHome = new File( getAppDirectory().getAbsolutePath() + "/reports/");
	        configuration.addProperty(BIRT_REPORTS_HOME, birtReportsHome.getAbsolutePath() );                
	    }
	    configuration.save(arquivoxml);
	    logger.info("Diretório da aplicação é: " + 
		 getAppDirectory().getAbsolutePath());
	} catch(ConfigurationException e){
	    new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);
	}
    }
    //TODO FAZER RODAR NO LINUX
    //TODO fazer achar um lugar pra instalação
    private static File getAppDirectory(){	
	return new File("");
    }
}

/* //TODO O sistema irá oferecer:
	- Cadastro de produtos, usuários, clientes, fornecedores;  	
	- Vendas, com baixa de estoque e controle dos produtos;
	- Controle de fluxo e saldo de caixa/bancos;
	- Controle de contas a receber e a pagar;
	- Controle de comissões de representantes;
	- Controle de acessos e alterações feitas por cada usuário da empresa;
	- Através de dispositivos móveis: Cadastrar clientes, efetuar vendas, consultar preços, entre outros;
	- Relatórios: Lista de preços, gerenciais, contas, entre outros de acordo com a necessidade do cliente.
	- Integração com Pocket’s Pc para vendas.*/
