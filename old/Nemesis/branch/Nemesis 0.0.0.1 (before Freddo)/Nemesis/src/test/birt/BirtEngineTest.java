package test.birt;

import com.dudhoo.nemesis.Application;

import java.util.HashMap;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderContext;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderContext;
import org.eclipse.birt.report.engine.api.ReportEngine;


public class BirtEngineTest extends TestCase{
    public static Logger log = Logger.getLogger(BirtEngineTest.class);

    public BirtEngineTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();

    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testEngineLoad(){
	EngineConfig config = new EngineConfig();
	config.setEngineHome(Application.getConfiguration().getString(Application.BIRT_ENGINE_HOME));
	ReportEngine engine = new ReportEngine(config);
	IReportRunnable report;
	// Run reports, etc.
	// Shut down the engine.
	try{
	    report = 
	    engine.openReportDesign("D:\\projetos_do_mal\\Nemesis Report\\compras.rptdesign");
	    //Create task to run the report - use the task to execute and run the report,
	    IRunAndRenderTask task = engine.createRunAndRenderTask(report);
	    
	    //Set Render context to handle url and image locataions
	    HTMLRenderContext renderContext = new HTMLRenderContext();
	    renderContext.setImageDirectory("images");
	    HashMap contextMap = new HashMap();
	    contextMap.put(EngineConstants.APPCONTEXT_PDF_RENDER_CONTEXT, 
		    renderContext);
	    task.setAppContext(contextMap);

	    //Set rendering options - such as file or stream output, 
	    //output format, whether it is embeddable, etc
	    HTMLRenderOption options = new HTMLRenderOption();
	    options.setOutputFileName("c:/test/Forecast.html");
	    options.setOutputFormat("html");
	    task.setRenderOption(options);
	    
	    //run the report and destroy the engine
	    task.run();
	    engine.destroy();	    	    
	} catch(EngineException e){
	    // TODO
	    log.error(e);
	    System.out.println(e);
	}
    }
}
