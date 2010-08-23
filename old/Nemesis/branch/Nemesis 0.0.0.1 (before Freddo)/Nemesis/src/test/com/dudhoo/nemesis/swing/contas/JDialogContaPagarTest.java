package test.com.dudhoo.nemesis.swing.contas;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;

import junit.framework.TestCase;

public class JDialogContaPagarTest extends TestCase{
    public JDialogContaPagarTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testCreate(){
	new JDialogContaPagar(StartFrame.getCurrentInstance(), 
		       true); //.setVisible(true);;
    }
}
