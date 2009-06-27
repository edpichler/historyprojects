package test.com.dudhoo.evilframework.crypto;

import com.dudhoo.evilframework.crypto.EvilCrypto;

import java.io.IOException;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import junit.framework.TestCase;

public class EvilCryptoTest extends TestCase {
  

    public EvilCryptoTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }   
    /**
     * @see EvilCrypto#decrypt(String)
     */
    public void test2Decrypt() throws NoSuchAlgorithmException, 
                                     NoSuchPaddingException, 
                                     IllegalBlockSizeException, 
                                     BadPaddingException, IOException, 
                                     InvalidKeyException, InvalidAlgorithmParameterException {
                     
        // Our cleartext
        String texto = "This is just an example";
       
        byte b[] = 
                new EvilCrypto("farmafom".getBytes())
                .encrypt(texto.getBytes());                
        byte b2[] = new EvilCrypto("farmafom".getBytes())
                    .decrypt(b);                    
        System.out.println( );
        System.out.println( new String(b2));
    }
}
