package test.com.dudhoo.nemesis.component;

import com.dudhoo.nemesis.component.BotaoFindPessoa;

import junit.framework.TestCase;

public class FindPessoaTest extends TestCase{
    public FindPessoaTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see com.dudhoo.nemesis.component.BotaoFindPessoa#getPessoa()
     */
    public void testGetPessoa(){
	BotaoFindPessoa f = new BotaoFindPessoa();
	/*f.getBotaoProcurar().getActionListeners()[0].actionPerformed(null);
	System.out.println(f.getPessoa().getDataNascimento());*/
    }
}
