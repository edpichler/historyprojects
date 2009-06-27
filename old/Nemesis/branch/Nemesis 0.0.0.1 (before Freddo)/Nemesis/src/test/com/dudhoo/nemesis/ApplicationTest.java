package test.com.dudhoo.nemesis;

import com.dudhoo.nemesis.Application;

import junit.framework.TestCase;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class ApplicationTest extends TestCase{
    public ApplicationTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see Application#getConfiguration()
     */
    public void testGetConfiguration() throws ConfigurationException{
	XMLConfiguration conf = Application.getConfiguration();
	assertNotNull(conf);
	assertNotNull(conf.getString(Application.APP_NAME));
	assertNotNull(conf.getString(Application.APP_VERSION));
	String novoNome = "teste";
	String antigoNome = conf.getString(Application.APP_NAME);
	conf.setProperty(Application.APP_NAME, novoNome);
	conf.save();
	conf.setProperty(Application.APP_NAME, antigoNome);
	conf.save();
        conf.load();
        
    }
}
