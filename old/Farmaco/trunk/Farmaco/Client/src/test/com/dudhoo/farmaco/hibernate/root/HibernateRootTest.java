package test.com.dudhoo.farmaco.hibernate.root;

import com.dudhoo.farmaco.hibernate.root.HibernateRoot;

import junit.framework.TestCase;

public class HibernateRootTest extends TestCase {
    public HibernateRootTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see HibernateRoot#currentSession()
     */
    public void testCurrentSession() {
        Object o = new HibernateRoot().currentSession();
        assertNotNull(o);
    }
}
