package test.com.dudhoo.nemesis.birt;

import com.dudhoo.nemesis.birt.EngineRelatorios;

import java.io.File;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.birt.report.engine.api.EngineException;

public class EngineRelatoriosTest extends TestCase{
    public EngineRelatoriosTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see EngineRelatorios#geraRelatorio(File)
     */
    public void testGeraRelatorio() throws EngineException, IOException{
	 EngineRelatorios.getInstance().geraRelatorio(new File("D:\\projetos_do_mal\\Nemesis\\Nemesis\\reports\\compras.rptdesign"));
    }
}
