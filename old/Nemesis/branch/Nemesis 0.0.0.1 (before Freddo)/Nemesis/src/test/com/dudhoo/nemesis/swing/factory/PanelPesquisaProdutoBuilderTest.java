package test.com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.factory.PanelPesquisaProdutoBuilder;

import junit.framework.TestCase;

public class PanelPesquisaProdutoBuilderTest extends TestCase{
    public PanelPesquisaProdutoBuilderTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see PanelPesquisaProdutoBuilder#getJPanelPesquisaProduto(boolean,boolean)
     */
    public void testGetJPanelPesquisaProduto(){
	PanelPesquisaProdutoBuilder panel = new PanelPesquisaProdutoBuilder();
	boolean nulo = panel.getJPanelPesquisaProduto(false, false) == null;
	nulo = panel.getJPanelPesquisaProduto(true, false) == null;
	nulo = panel.getJPanelPesquisaProduto(true, true) == null;
	nulo = panel.getJPanelPesquisaProduto(false, true) == null;
	assertFalse(nulo);
    }
}
