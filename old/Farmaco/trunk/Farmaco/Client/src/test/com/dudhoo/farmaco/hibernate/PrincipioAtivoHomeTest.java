package test.com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.NomeComercial;
import com.dudhoo.farmaco.hibernate.PrincipioAtivo;
import com.dudhoo.farmaco.hibernate.PrincipioAtivoHome;

import junit.framework.TestCase;

import org.hibernate.Session;

public class PrincipioAtivoHomeTest extends TestCase {
    public PrincipioAtivoHomeTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see PrincipioAtivoHome#findAll(int)
     */
    public void testFindAll() throws Exception {
        int co = new PrincipioAtivoHome().findAll(1).size();
        assertTrue( co > -1);
    }

    public void testOne() throws Exception {
        Session s = new PrincipioAtivoHome().currentSession();
        PrincipioAtivo co = (PrincipioAtivo)s.createCriteria(PrincipioAtivo.class)
            .setMaxResults(1).list().get(0);
        System.out.println(co.getNomesComerciais().size());
        s.close();
    }

    public void testSave() throws Exception {
        PrincipioAtivo p = new PrincipioAtivo();
        p.setNome("" + (int)(Math.random() * 1000));
        p.setDescricao("" + (int)(Math.random() * 1000));
        
        Session ses  = new PrincipioAtivoHome().currentSession();
        ses.save(p);
        System.out.println(p.getNomesComerciais());
        ses.close();
        ses.getSessionFactory().openSession();
        ses.delete(p);
        ses.close();
    }

    public void testDel() throws Exception {
        PrincipioAtivoHome ph = new PrincipioAtivoHome();
        int anyers = ph.findAll(500).size();
        if(anyers > 0){
            PrincipioAtivo p = (PrincipioAtivo) ph.findAll(500).get(0);
            ph.delete(p);
            assertFalse(anyers == ph.findAll(0).size());
        }
    }
}

