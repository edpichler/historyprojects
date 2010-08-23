package test.com.dudhoo.nemesis.swing.produto;

import com.dudhoo.nemesis.swing.produto.JDialogProduto;

import junit.framework.TestCase;

public class JDialogProdutoTest extends TestCase{
    public JDialogProdutoTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see JDialogProduto#$init$()
     */
    public void test$init$(){
	JDialogProduto prod = new JDialogProduto();
	prod.setModal(true);
	assertNotNull(prod);
    }
}
