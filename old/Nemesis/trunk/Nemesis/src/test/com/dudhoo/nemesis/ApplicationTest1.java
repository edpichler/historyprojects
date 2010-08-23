package test.com.dudhoo.nemesis;

import com.dudhoo.nemesis.Application;

import junit.framework.TestCase;

public class ApplicationTest1 extends TestCase{
    public ApplicationTest1(String sTestName){
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
    public void testGetConfiguration(){   
	
	System.out.println(Application.getConfiguration().getString(Application.BIRT_ENGINE_HOME));
    }
}
