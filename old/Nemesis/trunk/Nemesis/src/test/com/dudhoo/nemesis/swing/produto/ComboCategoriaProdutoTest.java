package test.com.dudhoo.nemesis.swing.produto;

import com.dudhoo.nemesis.swing.produto.ComboCategoriaProduto;

import junit.framework.TestCase;

public class ComboCategoriaProdutoTest extends TestCase {
    public ComboCategoriaProdutoTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see ComboCategoriaProduto#getTipoConta()
     */
    public void testGetTipoConta() {
        System.out.println(new ComboCategoriaProduto().getCategoriaProduto());
    }
}
