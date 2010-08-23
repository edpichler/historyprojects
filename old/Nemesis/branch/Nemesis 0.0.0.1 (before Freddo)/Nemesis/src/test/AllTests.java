package test;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.swingui.TestRunner;

import test.birt.BirtEngineTest;

import test.com.dudhoo.nemesis.ApplicationTest;
import test.com.dudhoo.nemesis.component.BotaoFindPessoaTest;
import test.com.dudhoo.nemesis.component.FindPessoaTest;
import test.com.dudhoo.nemesis.component.dialog.JDialogFindPessoaTest;
import test.com.dudhoo.nemesis.component.dialog.JDialogFindProdutoTest;
import test.com.dudhoo.nemesis.hibernate.ContaPagarHomeTest;
import test.com.dudhoo.nemesis.hibernate.ContaReceberHomeTest;
import test.com.dudhoo.nemesis.hibernate.MovimentoEstoqueHomeTest;
import test.com.dudhoo.nemesis.hibernate.PessoaHomeTest;
import test.com.dudhoo.nemesis.hibernate.ProdutoHomeTest;
import test.com.dudhoo.nemesis.hibernate.UsuarioHomeTest;
import test.com.dudhoo.nemesis.hibernate.root.HibernateRootTest;
import test.com.dudhoo.nemesis.swing.StartFrameTest;
import test.com.dudhoo.nemesis.swing.contas.JDialogContaPagarTest;
import test.com.dudhoo.nemesis.swing.contas.JDialogContaReceberTest;
import test.com.dudhoo.nemesis.swing.factory.PanelPesquisaProdutoBuilderTest;
import test.com.dudhoo.nemesis.swing.factory.menu.MenuCadastroFactoryTest;
import test.com.dudhoo.nemesis.swing.factory.menu.MenuFinancasFactoryTest;
import test.com.dudhoo.nemesis.swing.factory.menu.MenuRelatoriosFactoryTest;
import test.com.dudhoo.nemesis.swing.factory.menu.MenuSegurancaFactoryTest;
import test.com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoqueTest;
import test.com.dudhoo.nemesis.swing.produto.JDialogProdutoTest;
import test.com.dudhoo.nemesis.swing.usuario.JPanelAdminUsuariosTest;
import test.com.dudhoo.nemesis.swing.usuario.event.NewUserActionAdapterTest;


public class AllTests{

    public static Test suite(){
	TestSuite suite;
	suite = new TestSuite("AllTests");
	suite.addTestSuite(UsuarioHomeTest.class);
	suite.addTestSuite(ApplicationTest.class);
	suite.addTestSuite(StartFrameTest.class);
	suite.addTestSuite(JPanelAdminUsuariosTest.class);
	suite.addTestSuite(NewUserActionAdapterTest.class);
	suite.addTestSuite(HibernateRootTest.class);
	suite.addTestSuite(ProdutoHomeTest.class);
	suite.addTestSuite(PessoaHomeTest.class);
	suite.addTestSuite(PanelPesquisaProdutoBuilderTest.class);
	suite.addTestSuite(JDialogProdutoTest.class);
	suite.addTestSuite(ContaReceberHomeTest.class);
	suite.addTestSuite(ContaPagarHomeTest.class);
	suite.addTestSuite(MenuFinancasFactoryTest.class);
	suite.addTestSuite(MenuCadastroFactoryTest.class);
	suite.addTestSuite(MenuSegurancaFactoryTest.class);
	suite.addTestSuite(JDialogFindPessoaTest.class);
	suite.addTestSuite(JDialogContaPagarTest.class);
	suite.addTestSuite(FindPessoaTest.class);
	suite.addTestSuite(JDialogContaReceberTest.class);
	suite.addTestSuite(MovimentoEstoqueHomeTest.class);
	suite.addTestSuite(BotaoFindPessoaTest.class);	
	suite.addTestSuite(JDialogFindProdutoTest.class);       
	suite.addTestSuite(JDialogMovimentoEstoqueTest.class);       	
	suite.addTestSuite(BirtEngineTest.class);          
	suite.addTestSuite(MenuRelatoriosFactoryTest.class);
	return suite;
    }

    public static void main(String[] args){
	String args2[] = { "-noloading", "test.AllTests" };
	TestRunner.main(args2);
    }
}
