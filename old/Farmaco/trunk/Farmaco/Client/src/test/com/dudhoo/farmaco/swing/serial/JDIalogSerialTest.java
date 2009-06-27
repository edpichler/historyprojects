package test.com.dudhoo.farmaco.swing.serial;

import com.dudhoo.farmaco.swing.serial.JDialogSerial;

import junit.framework.TestCase;

public class JDIalogSerialTest extends TestCase {
    public JDIalogSerialTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    public void testSerial(){
        new JDialogSerial().setVisible(true);
    }
}
