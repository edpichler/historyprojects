package test.com.dudhoo.nemesis.swing.contas.tipo;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.tipo.JDialogTipoContas;

import junit.framework.TestCase;

public class JDialogTipoContasTest extends TestCase {
    public JDialogTipoContasTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate(){
        JDialogTipoContas dia = new JDialogTipoContas(StartFrame.getCurrentInstance(), true);
        dia.setVisible(true);
    }
}
