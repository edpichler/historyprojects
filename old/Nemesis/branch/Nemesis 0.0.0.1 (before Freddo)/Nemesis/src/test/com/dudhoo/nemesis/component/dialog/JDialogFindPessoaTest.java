package test.com.dudhoo.nemesis.component.dialog;

import com.dudhoo.nemesis.component.dialog.JDialogFindPessoa;

import junit.framework.TestCase;

public class JDialogFindPessoaTest extends TestCase{
    public JDialogFindPessoaTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testCria(){
	new JDialogFindPessoa(null, true);
    }
}
