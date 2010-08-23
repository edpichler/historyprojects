package test.com.dudhoo.farmacopedia.web.key;

import com.dudhoo.farmacopedia.web.key.KeyGenerator;

import java.security.Timestamp;

import java.util.Date;

import junit.framework.TestCase;

public class KeyGeneratorTest extends TestCase {
    public KeyGeneratorTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see KeyGenerator#generateKey(Date,Date)
     */
    public void testGenerateKey() {        
        for (int i = 0; i < 500; i++)  {            
            String serial = new KeyGenerator().generateKey(new Date(), 90).getSerial();
            System.out.println( serial);            
        }        
    }
}
