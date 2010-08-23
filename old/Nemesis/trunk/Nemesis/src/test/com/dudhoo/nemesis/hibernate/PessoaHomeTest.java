package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaHome;

import com.dudhoo.nemesis.hibernate.Produto;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.hibernate.Transaction;

public class PessoaHomeTest extends TestCase{
    public PessoaHomeTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see PessoaHome#findById(Long)
     */
    public void testFindById(){
	PessoaHome p = new PessoaHome();
	Transaction t = p.currentSession().beginTransaction(); 
	Pessoa pes = p.findById(new Long(1));
	System.out.println(pes);	
	ArrayList prods = (ArrayList) p.currentSession().createCriteria(Produto.class).list();
	System.out.println(prods.size());
	if(prods != null){
	    pes.getProdutosQueFornece().add((Produto)prods.get(3));   	
	    System.out.println(pes.getContasPagar().size());
	    System.out.println(pes.getContasReceber().size());
	}	
	t.commit();
	Transaction t2 = p.currentSession().beginTransaction(); 
	pes.setProdutosQueFornece(null);
	t2.commit();
	p.closeSession();
    }
}
