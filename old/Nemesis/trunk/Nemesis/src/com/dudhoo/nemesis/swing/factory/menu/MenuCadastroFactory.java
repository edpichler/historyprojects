/*
 * MenuCadastroFactory.java
 *
 * Created on 24 de Janeiro de 2006, 21:41
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastrarPessoasFisicas;
import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastrarPessoasJuridicas;
import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastrarProdutos;
import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastroCategoriasProdutos;
import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastroCidadesERegioes;
import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastroEmpresas;
import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastroRamos;

import com.dudhoo.nemesis.swing.factory.menu.events.ListenerCadastroTipoContas;

import java.awt.event.InputEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *Constroi os menus de cadastros.
 * @author duduzera
 */
public class MenuCadastroFactory {
    /**
     * Creates a new instance of MenuCadastroFactory
     */
    public MenuCadastroFactory() {
    
    }
    
    public JMenu constroiMenuCadastros(){
        JMenu cadastro = new JMenu();
        cadastro.setText("Cadastro");
        cadastro.setToolTipText("Cadastros e pesquisas no banco de dados");
        cadastro.setMnemonic('C');
        adicionarCadastroCidades(cadastro);
        adicionarCadastroComuns(cadastro);
        //adicionarCadastroEmpreas(cadastro); TODO DESMARCAR
	adicionarCadastroPessoasFisicas(cadastro);
        adicionarCadastroPessoasJuridicas(cadastro);  
	adicionarCadastroProdutos(cadastro);
        return cadastro;
    }
    /**
     * Adiciona o cadastro de pessoas
     */
    private void adicionarCadastroPessoasJuridicas(JMenu menu){
        JMenuItem menuItem =  menu.add("Pessoas Jurídicas");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
        menuItem.addActionListener(new ListenerCadastrarPessoasJuridicas() );
    }
    /**
     * Adiciona o cadastro de pessoas
     */
    private void adicionarCadastroCidades(JMenu menu){
        JMenuItem menuItem =  menu.add("Cidades e regiões");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
        menuItem.addActionListener(new ListenerCadastroCidadesERegioes() );
    }
    /**
     * Adiciona o cadastro de empresas
     */
    private void adicionarCadastroEmpreas(JMenu menu){
        JMenuItem menuItem =  menu.add("Empresas/Filiais");
        menuItem.setToolTipText("Empresas ou filiais, das quais esse sistema informatiza");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
        menuItem.addActionListener(new ListenerCadastroEmpresas() );
    }
    
    private void adicionarCadastroComuns(JMenu menu){
        JMenu comuns = new JMenu("Comuns");
        menu.add(comuns);        
        
        JMenuItem menuItem =  comuns.add("Ramos de negócio");
        menuItem.setToolTipText("Ramos de negócio das pessoas físicas e jurídicas");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
        menuItem.addActionListener(new ListenerCadastroRamos() );
        
        JMenuItem menuContas =  comuns.add("Tipos de Contas financeiras");        
        menuContas.setAccelerator(KeyStroke.getKeyStroke('K', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
        menuContas.addActionListener(new ListenerCadastroTipoContas() );
        
        JMenuItem menuCategorias =  comuns.add("Categorias de produtos");        
        menuCategorias.setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
        menuCategorias.addActionListener(new ListenerCadastroCategoriasProdutos() );
    }

    private void adicionarCadastroPessoasFisicas(JMenu menu){
	JMenuItem menuItem =  menu.add("Pessoas Físicas");	
	menuItem.setAccelerator(KeyStroke.getKeyStroke('F', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
	menuItem.addActionListener(new ListenerCadastrarPessoasFisicas() );
    
    }
    private void adicionarCadastroProdutos(JMenu menu){
	JMenuItem menuItem =  menu.add("Produtos");      
	menuItem.setAccelerator(KeyStroke.getKeyStroke('M', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
	menuItem.addActionListener(new ListenerCadastrarProdutos() );
    
    }
}
