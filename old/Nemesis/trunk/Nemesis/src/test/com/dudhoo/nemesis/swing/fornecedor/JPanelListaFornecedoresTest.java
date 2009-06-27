package test.com.dudhoo.nemesis.swing.fornecedor;

import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;
import com.dudhoo.nemesis.swing.fornecedor.JPanelListaFornecedores;

import junit.framework.TestCase;

public class JPanelListaFornecedoresTest extends TestCase{
    public JPanelListaFornecedoresTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see JPanelListaFornecedores#addFornecedor(Fornecedor)
     */
    public void testAddFornecedor(){
	JPanelListaFornecedores f = new JPanelListaFornecedores();
	Fornecedor forn = new PessoaJuridica();
	f.addFornecedor((Pessoa)forn);
    }
}
