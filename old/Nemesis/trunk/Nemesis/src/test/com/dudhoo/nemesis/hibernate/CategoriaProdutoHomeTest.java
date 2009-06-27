package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;

import junit.framework.TestCase;

public class CategoriaProdutoHomeTest extends TestCase {
    public CategoriaProdutoHomeTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see CategoriaProdutoHome#getAllCategoria()
     */
    public void testGetAllCategoria() {
        System.out.println(new CategoriaProdutoHome().getAllCategoria());
    }
}
