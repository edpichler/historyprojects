package com.dudhoo.nemesis.birt;

import com.dudhoo.nemesis.Application;

import java.io.File;

import java.io.IOException;

import java.util.HashMap;

import org.apache.log4j.Logger;

import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderContext;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.ReportEngine;

public class EngineRelatorios{
    private static EngineRelatorios instance;
    private static Logger log = Logger.getLogger(EngineRelatorios.class);
    IReportRunnable report;
    ReportEngine engine;
    

    private EngineRelatorios(){
	EngineConfig config = new EngineConfig();
	config.setEngineHome(Application.getConfiguration()
		      .getString(Application.BIRT_ENGINE_HOME));
	engine = new ReportEngine(config);
	

    }

    public static EngineRelatorios getInstance(){
	if(instance == null){
	    instance = new EngineRelatorios();
	}
	return instance;
    }

    public void geraRelatorio(File fileDesign) throws EngineException, 
						      IOException{

	// Run reports, etc.
	// Shut down the engine.
	report = engine.openReportDesign(fileDesign.getAbsolutePath());
	//Create task to run the report - use the task to execute and run the report,
	IRunAndRenderTask task = engine.createRunAndRenderTask(report);

	//Set Render context to handle url and image locataions
	HTMLRenderContext renderContext = new HTMLRenderContext();	
	
	HashMap contextMap = new HashMap();
	contextMap.put(EngineConstants.APPCONTEXT_PDF_RENDER_CONTEXT, renderContext);
	task.setAppContext(contextMap);

	//Set rendering options - such as file or stream output, 
	//output format, whether it is embeddable, etc
	HTMLRenderOption options = new HTMLRenderOption();
	options.setOutputFormat("pdf");
	File gerado = 
	    new File(Application.getConfiguration().getString(Application.BIRT_REPORTS_HOME) + 
	      "/generated/" + fileDesign.getName() + "." + options.getOutputFormat());
	options.setOutputFileName(gerado.getAbsolutePath());
	
	renderContext.setImageDirectory("images"); 	
	task.setRenderOption(options);
	//run the report and destroy the engine
	task.run();
	
	//pega comando pra abrir no browser a url	 
	String coisa = Application.getConfiguration().getString(Application.SO_COMMAND_BROWSER) + 
	    " " +  gerado.getAbsolutePath();
	log.debug("executando comando para ver relatório: coisa");
	Runtime.getRuntime()
	    .exec(coisa); //TODO TENTAR
    }

    public void finalize(){
	engine.destroy();
    }
}
