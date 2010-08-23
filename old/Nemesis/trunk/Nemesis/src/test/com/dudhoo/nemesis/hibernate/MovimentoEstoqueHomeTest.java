package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.MovimentoEstoqueHome;

import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaHome;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;

import com.dudhoo.nemesis.hibernate.Produto;

import com.dudhoo.nemesis.hibernate.ProdutoHome;

import com.dudhoo.nemesis.hibernate.TipoConta;

import java.util.Calendar;

import junit.framework.TestCase;

import org.hibernate.criterion.Criterion;

public class MovimentoEstoqueHomeTest extends TestCase{
    public MovimentoEstoqueHomeTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testInsertEntradaProduto(){
	MovimentoEstoqueHome h = new MovimentoEstoqueHome();
	MovimentoEstoque mov = new MovimentoEstoque();
	PessoaJuridicaHome hom = new PessoaJuridicaHome();
	Produto prod = new ProdutoHome().findAll().get(1);
	PessoaJuridica pj = hom.findAll().get(1);
	mov.setPessoa(pj.getPessoa());
	mov.setPrecoUnitario(10);
	mov.setProduto(prod);
	mov.setQuantidade(7);
	mov.setUsuario(Application.getUsuarioLogado());
	ContaPagar pag = new ContaPagar();
        TipoConta conta = new TipoConta();
        conta.setId(1);
        pag.setTipoConta(conta);
	pag.setContaPaga(false);
	pag.setDataPagamento(Calendar.getInstance().getTime());
	pag.setPessoa(pj.getPessoa());
	pag.setUsuario(Application.getUsuarioLogado());
	pag.setValor(mov.getPrecoUnitario() * mov.getQuantidade());
	mov.setConta(pag);
	h.saveOrUpdate(mov);
	ContaPagar pgEnviad = 
	    (ContaPagar)h.currentSession().get(ContaPagar.class, new Long(pag.getId()));
	assertEquals(pag.getId(), pgEnviad.getId());
	h.closeSession();
    }
    
    public void testInsertSaidaProduto(){
	MovimentoEstoqueHome h = new MovimentoEstoqueHome();
	MovimentoEstoque mov = new MovimentoEstoque();
	PessoaJuridicaHome hom = new PessoaJuridicaHome();
	Produto prod = new ProdutoHome().findAll().get(1);
	PessoaJuridica pj = hom.findAll().get(1);
	mov.setPessoa(pj.getPessoa());
	mov.setPrecoUnitario(10);
	mov.setProduto(prod);
	mov.setQuantidade(7);
	mov.setUsuario(Application.getUsuarioLogado());
	ContaReceber pag = new ContaReceber();
        TipoConta conta = new TipoConta();
        conta.setId(1);
        pag.setTipoConta(conta);
	pag.setContaPaga(false);
	pag.setDataPagamento(Calendar.getInstance().getTime());
	pag.setPessoa(pj.getPessoa());
	pag.setUsuario(Application.getUsuarioLogado());
	pag.setValor(mov.getPrecoUnitario() * mov.getQuantidade());
	mov.setConta(pag);
	h.saveOrUpdate(mov);
	ContaReceber pgEnviad = 
	    (ContaReceber) h.currentSession().get(ContaReceber.class, new Long(pag.getId()));
	assertEquals(pag.getId(), pgEnviad.getId());
	h.closeSession();
    }

    public void testDelete(){
	MovimentoEstoqueHome h = new MovimentoEstoqueHome();
	MovimentoEstoque mov = h.findAll().get(0);
	h.delete(mov);
	h.closeSession();
    }

    public void testInsertMovEContas(){
	MovimentoEstoqueHome h = new MovimentoEstoqueHome();
	MovimentoEstoque mov = new MovimentoEstoque();
	Pessoa pes = new PessoaHome().findAll().get(1);
	mov.setPessoa(pes);
	mov.setPrecoUnitario(10);
	mov.setProduto(new ProdutoHome().findAll().get(1));
	mov.setQuantidade(15);
	mov.setUsuario(Application.getUsuarioLogado());
	ContaPagar pag = new ContaPagar();
	pag.setContaPaga(false);
        TipoConta conta = new TipoConta();
        conta.setId(1);
        pag.setTipoConta(conta);
	pag.setDataPagamento(Calendar.getInstance().getTime());
	pag.setPessoa(pes);
	pag.setUsuario(Application.getUsuarioLogado());
	pag.setValor(mov.getPrecoUnitario() * mov.getQuantidade());
	mov.setConta(pag);
	h.saveOrUpdate(mov);

    }

    public void testFindById(){
	MovimentoEstoqueHome h = new MovimentoEstoqueHome();
	MovimentoEstoque mov = h.findById(new MovimentoEstoqueHome().findAll().get(0).getId());
	assertNotNull(mov);
    }
    public void testDeleteById(){
	MovimentoEstoqueHome h = new MovimentoEstoqueHome();
	long id = new MovimentoEstoqueHome().findAll().get(0).getId();
	h.deleteById(id);	
	assertNull(h.findById(id));
    }
}
