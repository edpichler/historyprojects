package test.com.dudhoo.nemesis.swing.fornecedor;

import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.fornecedor.JDialogFindFornecedor;

import junit.framework.TestCase;

public class JDialogFindFornecedorTest extends TestCase{
    JDialogFindFornecedor dialog;

    public JDialogFindFornecedorTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
	dialog = new JDialogFindFornecedor(null, true);
	if(dialog.getOpcao().equals(OpcaoEscolhida.SELECT)){
	    assertNotNull(dialog.getFornecedor());
	}
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testCreate(){
	dialog.setVisible(true);

    }

    /**
     * @see JDialogFindFornecedor#setFornecedor(Fornecedor)
     */
    public void testSetFornecedor(){
    }

    /**
     * @see JDialogFindFornecedor#jbInit()
     */
    public void testJbInit(){
    }

    /**
     * @see JDialogFindFornecedor#getFornecedor()
     */
    public void testGetFornecedor(){
    }
}
