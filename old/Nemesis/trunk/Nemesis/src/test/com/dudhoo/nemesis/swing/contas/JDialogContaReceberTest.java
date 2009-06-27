package test.com.dudhoo.nemesis.swing.contas;

import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.ContaReceberHome;
import com.dudhoo.nemesis.swing.contas.JDialogContaReceber;

import java.util.ArrayList;

import junit.framework.TestCase;

public class JDialogContaReceberTest extends TestCase{
    public JDialogContaReceberTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testCreate(){
	JDialogContaReceber visx = new JDialogContaReceber(null, false);
	assertNotNull(visx);
	ContaReceberHome home = new ContaReceberHome();
	ArrayList list = 
	    (ArrayList)home.currentSession().createCriteria(ContaReceber.class)
	    .list();
	ContaReceber rec = (ContaReceber)list.get(0);
	visx.setContaReceber(rec);
	home.closeSession();
    }
}
