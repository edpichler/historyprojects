package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.TipoContaHome;

import junit.framework.TestCase;

public class TipoContaHomeTest extends TestCase {
    public TipoContaHomeTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see TipoContaHome#getAllTipoContas()
     */
    public void testGetAllTipoContas() {
        System.out.println(new TipoContaHome().getAllTipoContas());
        System.out.println(new TipoContaHome().getAllTipoContasDebito());
        System.out.println(new TipoContaHome().getAllTipoContasCredito());
    
        
        
    }
    
}