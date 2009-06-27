package test.com.dudhoo.farmaco.swing;

import com.dudhoo.farmaco.swing.PanelPesquisa;

import javax.swing.JDialog;

import junit.framework.TestCase;

public class PanelPesquisaTest extends TestCase {
    public PanelPesquisaTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreate(){
        JDialog gia = new JDialog();
        gia.setModal(true);
        gia.setSize(500, 500);
        gia.setLocationRelativeTo(null);
        PanelPesquisa  frame = PanelPesquisa.getInstance();
        gia.add(frame);
        gia.setLocationRelativeTo(null);
        gia.setVisible(true);
    }
}
