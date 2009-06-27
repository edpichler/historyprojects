package test.com.dudhoo.nemesis.hibernate.root;

import com.dudhoo.nemesis.hibernate.CidadeHome;
import com.dudhoo.nemesis.hibernate.root.HibernateRoot;

import junit.framework.TestCase;

public class HibernateRootTest extends TestCase{
    public HibernateRootTest(String sTestName){
	super(sTestName);
    }

    /**
     * @see HibernateRoot#currentSession()
     */
    public void testCurrentSession(){
	HibernateRoot root = ( (HibernateRoot) new CidadeHome());
	assertNotNull( root.currentSession());
    }
}
