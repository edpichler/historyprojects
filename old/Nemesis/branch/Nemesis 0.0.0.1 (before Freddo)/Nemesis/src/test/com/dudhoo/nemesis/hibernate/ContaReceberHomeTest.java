package test.com.dudhoo.nemesis.hibernate;


import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.ContaReceberHome;

import com.dudhoo.nemesis.hibernate.Pessoa;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Locale;

import junit.framework.TestCase;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContaReceberHomeTest extends TestCase{
    public ContaReceberHomeTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }
    
    public void testFindAll(){
	ContaReceberHome home = new ContaReceberHome();
	Session s = home.currentSession();
	s.createCriteria(ContaReceber.class).list();
	s.close();
    }
    public void testGetContasReceber(){
	ContaReceberHome home = new ContaReceberHome();
	home.getContasReceber(1);	
    }


    public void testInsertAndDelete() throws SQLException{
	ContaReceberHome home = new ContaReceberHome();
	Session session = home.currentSession();
	
	Calendar data = Calendar.getInstance();
	ArrayList pessssss = (ArrayList) session.createCriteria( Pessoa.class ).list();
	ContaReceber conta = new ContaReceber();
        conta.setDataPagamento(data.getTime());
        Pessoa pes = (Pessoa)pessssss.get(2);	
	conta.setPessoa(pes);
	conta.setContaPaga(true);
	conta.setUsuario(Application.getUsuarioLogado());
	conta.setObservacao(null);
	conta.setValor(1000);	
	session.saveOrUpdate(conta);	
	session.flush();	
	System.out.println(conta.getId());
	home.closeSession();
    }
    /**
     * @see ContaReceberHome#findContaReceber(Long)
     */
    public void testFindContaReceber(){
	new ContaReceberHome().findContaReceber(new Long(1));
    }
}
