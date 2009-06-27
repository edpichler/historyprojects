package test.com.dudhoo.nemesis.component.dialog;

import com.dudhoo.nemesis.component.dialog.JDialogFindProduto;

import com.dudhoo.nemesis.swing.StartFrame;

import junit.framework.TestCase;

public class JDialogFindProdutoTest extends TestCase{
    public JDialogFindProdutoTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }
    public void testCreate(){
	JDialogFindProduto prod = new JDialogFindProduto(StartFrame.getCurrentInstance(), true);
//	prod.setVisible(true);
//	System.out.println(prod.getProdutoId());
	
    }
}
