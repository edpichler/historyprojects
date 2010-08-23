package test.com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.hibernate.NomeComercial;
import com.dudhoo.farmaco.hibernate.NomeComercialHome;

import com.dudhoo.farmaco.hibernate.PrincipioAtivo;

import java.util.List;

import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Iterator;

public class NomeComercialHomeTest extends TestCase {
    public NomeComercialHomeTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testFind(){
        Session s = new NomeComercialHome().currentSession();
        List l = s.createCriteria(NomeComercial.class).list();
        System.out.println(l);
    }

    public void testSave(){
        Session s = new NomeComercialHome().currentSession();
        Transaction t = s.beginTransaction();
        NomeComercial ata = new NomeComercial();
        PrincipioAtivo ativo = new PrincipioAtivo();
        ativo.setDescricao("" + (int)(Math.random() * 1000));
        ativo.setNome("teste" + Math.random());
        ata.setNome("teste" + Math.random());
        ata.setPrincipioAtivo(ativo);
        s.saveOrUpdate(ata);        
        t.commit();
        s.close();
    }
    
    public void testCorrige(){
        Session s = new NomeComercialHome().currentSession();
        Transaction t = s.beginTransaction();
        List <PrincipioAtivo>  prs =  s.createCriteria(PrincipioAtivo.class).list();
        for(Iterator iterator = prs.iterator();iterator.hasNext();) {
            PrincipioAtivo principioAtiv = (PrincipioAtivo) iterator.next();
            ApresentacaoFarmaceutica ap = new ApresentacaoFarmaceutica();
            ap.setNome("" + Math.random() + " mg");
            ap.setPosologia("Posologia do mal");
            ap.setPrincipioAtivo(principioAtiv);
           
            
            NomeComercial nm = new NomeComercial();
            nm.setNome("nome" + Math.random());            
            nm.setPrincipioAtivo(principioAtiv);
            
            
           
        }
        
        t.rollback();// commit();
        s.close();
    }
}
