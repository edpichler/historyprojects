package test.com.dudhoo.farmaco.serial;

import com.dudhoo.farmaco.serial.SerialValidator;

import junit.framework.TestCase;

public class SerialValidatorTest extends TestCase {
    public SerialValidatorTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
   
    public void testValidaSerialDigitado() throws Exception{
        String valido = "19B9K1AFC0CB17A26F3K3F4D46K43E15";
        SerialValidator va = new SerialValidator();
        assertTrue(va.validaSerialDigitado(valido));
    }
}
