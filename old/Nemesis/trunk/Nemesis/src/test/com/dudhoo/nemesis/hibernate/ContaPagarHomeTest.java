package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaPagarHome;

import com.dudhoo.nemesis.hibernate.Pessoa;

import com.dudhoo.nemesis.hibernate.TipoConta;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContaPagarHomeTest extends TestCase{
    long id = 0;
    public ContaPagarHomeTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
	testInsert();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }
    
    public void testInsert(){
	ContaPagarHome home = new ContaPagarHome();    	
	Session s = home.currentSession();
	Date data = new Date(System.currentTimeMillis());
	Transaction tt = s.beginTransaction();
	List pes = s.createCriteria(Pessoa.class).list();
	Pessoa p = (Pessoa) pes.get(2);
	ContaPagar pg = new ContaPagar();
        TipoConta conta = new TipoConta();
        conta.setId(1);
        pg.setTipoConta(conta);
	pg.setDataPagamento(data);
	pg.setContaPaga(true);
	pg.setUsuario(Application.getUsuarioLogado() );
	pg.setValor(50);
	pg.setPessoa(p);
	s.persist(pg);
	id = pg.getId();	
	tt.commit();	
	home.closeSession();
    }
    public void testFind(){
	ContaPagarHome home = new ContaPagarHome();     
	home.findContaPagar(new Long(300));
    }
    public void testDelete(){
	ContaPagarHome home = new ContaPagarHome();     
	home.deleteById(id);
    }
}
