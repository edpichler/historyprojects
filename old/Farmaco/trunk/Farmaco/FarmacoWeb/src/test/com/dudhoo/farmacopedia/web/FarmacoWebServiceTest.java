package test.com.dudhoo.farmacopedia.web;

import com.dudhoo.farmacopedia.web.FarmacoWebService;

import junit.framework.TestCase;

public class FarmacoWebServiceTest extends TestCase {
    public FarmacoWebServiceTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see FarmacoWebService#getServerTime()
     */
    public void testGetServerTime() {
        System.out.println(new FarmacoWebService().getServerTime());
    }    
}
