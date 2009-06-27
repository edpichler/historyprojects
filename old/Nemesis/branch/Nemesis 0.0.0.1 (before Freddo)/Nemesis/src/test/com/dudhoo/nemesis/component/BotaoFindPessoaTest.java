package test.com.dudhoo.nemesis.component;

import com.dudhoo.nemesis.component.BotaoFindPessoa;

import java.awt.event.ActionListener;

import junit.framework.TestCase;

public class BotaoFindPessoaTest extends TestCase{
    public BotaoFindPessoaTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }
    public void testCreate(){
	ActionListener av = new BotaoFindPessoa().getBotaoProcurar().getActionListeners()[0] ;
	//av.actionPerformed(null);
    }
}
