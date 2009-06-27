package test.com.dudhoo.nemesis.swing;


import com.dudhoo.nemesis.swing.contas.ComboTipoConta;

import junit.framework.TestCase;

public class ComboTipoContaTest extends TestCase {
    public ComboTipoContaTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see com.dudhoo.nemesis.swing.contas.ComboTipoConta#getTipoConta()
     */
    public void testGetTipoConta() {
        ComboTipoConta conta = new ComboTipoConta(true);
        conta.setSelectedIndex(0);
        System.out.println(conta.getTipoConta());
    }
}
