package test.com.dudhoo.farmaco.swing.pAtivo;

import com.dudhoo.farmaco.swing.pAtivo.JDialogPrincipioAtivo;

import junit.framework.TestCase;

public class JDialogprincipioAtivoTest extends TestCase {
    public JDialogprincipioAtivoTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreate(){
        JDialogPrincipioAtivo d = new JDialogPrincipioAtivo(null,true);

        d.setVisible(true);
    }
}
