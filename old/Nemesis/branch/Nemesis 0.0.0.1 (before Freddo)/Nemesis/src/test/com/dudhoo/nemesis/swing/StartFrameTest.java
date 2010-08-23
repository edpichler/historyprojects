package test.com.dudhoo.nemesis.swing;

import com.dudhoo.nemesis.swing.StartFrame;

import junit.framework.TestCase;

public class StartFrameTest extends TestCase{
    public StartFrameTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see StartFrame#getCurrentInstance()
     */
    public void testGetCurrentInstance(){
	assertNotNull(StartFrame.getCurrentInstance());
    }
}
