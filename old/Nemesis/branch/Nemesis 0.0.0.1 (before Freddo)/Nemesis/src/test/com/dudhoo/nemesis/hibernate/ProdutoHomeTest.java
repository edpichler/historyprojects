package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.ProdutoHome;

import com.dudhoo.nemesis.hibernate.Usuario;

import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdutoHomeTest extends TestCase{
    public ProdutoHomeTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see ProdutoHome#findAll()
     */
    public void testFindAll(){
	List list = new ProdutoHome().findAll();
        ((Produto)list.get(1)).getFornecedores();        
        ((Produto)list.get(1)).getUsuario();        
	assertNotNull(list);
    }
    public void testInsertAndFindAndDelete(){
	ProdutoHome home = new ProdutoHome();
	Session s = home.currentSession();
	Transaction t = s.beginTransaction();	
	Produto p = new Produto();
	p.setNome( String.valueOf(Math.random() * 1000) );
	p.setUsuario(Application.getUsuarioLogado());
	s.save(p);
	boolean b = p.getId() != 0 ;
	assertTrue(b);
	Produto pr = home.findById(p.getId());
	home.delete(pr);
	assertNotNull(pr);
	t.rollback();
	s.close();
    }    
    
    public void testDeleteById(){
	ProdutoHome home = new ProdutoHome();
	Session s = home.currentSession();	
	Produto p = new Produto();
	p.setNome( String.valueOf(Math.random() * 1000) );
	p.setUsuario(Application.getUsuarioLogado());
	s.save(p);
	boolean b = p.getId() != 0 ;
	assertTrue(b);
	Produto pr = home.findById(p.getId());
	home.deleteProdutoById(pr.getId());	
	s.close();
    }    
    
    public void testFornecedores(){
	ProdutoHome home = new ProdutoHome();	
	ArrayList list = (ArrayList) home.findAll();
	Session s = home.currentSession();      
	Transaction t = s.beginTransaction();
	PessoaJuridica pes = (PessoaJuridica)s.createCriteria(PessoaJuridica.class).setFetchSize(1).list().get(0);
	if(list != null && list.size() > 0){
	    Produto p = (Produto)list.get(0);
	    Set set = new HashSet();
	    set.add(pes);
	    p.setFornecedores(set);
	}
	t.commit();
	s.close();
    }
}
