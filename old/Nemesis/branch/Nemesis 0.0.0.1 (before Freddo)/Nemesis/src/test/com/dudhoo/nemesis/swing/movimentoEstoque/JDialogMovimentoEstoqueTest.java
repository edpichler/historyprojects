package test.com.dudhoo.nemesis.swing.movimentoEstoque;

import com.dudhoo.nemesis.hibernate.ContaReceberHome;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.MovimentoEstoqueHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoque;

import com.dudhoo.nemesis.swing.movimentoEstoque.PanelMovimentacaoEstoque;

import junit.framework.TestCase;

public class JDialogMovimentoEstoqueTest extends TestCase{
    public JDialogMovimentoEstoqueTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }
    public void testCreate(){
	JDialogMovimentoEstoque dia = new JDialogMovimentoEstoque(StartFrame.getCurrentInstance(), true, PanelMovimentacaoEstoque.TIPO.SAIDA );
	dia.setModal(false);
	MovimentoEstoqueHome movhome = new MovimentoEstoqueHome();
	//MovimentoEstoque mov = movhome.findAll().get(1);
	//dia.setMovimentoEstoque(mov);
	dia.setVisible(true);	
    }
}
