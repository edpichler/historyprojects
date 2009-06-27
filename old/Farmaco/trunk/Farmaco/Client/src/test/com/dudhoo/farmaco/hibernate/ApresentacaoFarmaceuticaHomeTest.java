package test.com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.hibernate.ApresentacaoFarmaceuticaHome;

import com.dudhoo.farmaco.hibernate.PrincipioAtivo;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApresentacaoFarmaceuticaHomeTest extends TestCase {
    public ApresentacaoFarmaceuticaHomeTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testSave(){
        Session s = new ApresentacaoFarmaceuticaHome().currentSession();
        Transaction t = s.beginTransaction();        
        PrincipioAtivo pr = new PrincipioAtivo();
        pr.setNome("teste" + Math.random());
        ApresentacaoFarmaceutica p = new ApresentacaoFarmaceutica();
        p.setNome("teste" + Math.random());
        pr.setDescricao("" + (int)(Math.random() * 1000));
        p.setPosologia("teste" + Math.random());
        p.setPrincipioAtivo(pr);
        s.save(p);
        t.commit();
        s.close();
    }    
}
