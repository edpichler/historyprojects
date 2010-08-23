package test.com.dudhoo.nemesis.swing.produto.categorias;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.produto.categorias.JDialogCategoria;

import junit.framework.TestCase;

public class JDialogCategoriaTest extends TestCase {
    public JDialogCategoriaTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        JDialogCategoria di = new JDialogCategoria(StartFrame.getCurrentInstance(), true);
        di.setVisible(true);
    }

}
