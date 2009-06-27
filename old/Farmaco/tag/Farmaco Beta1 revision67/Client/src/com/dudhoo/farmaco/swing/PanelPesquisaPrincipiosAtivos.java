package com.dudhoo.farmaco.swing;


import com.dudhoo.evilframework.components.BotaoDelete16;
import com.dudhoo.evilframework.components.BotaoEditar16;
import com.dudhoo.evilframework.components.BotaoFechar24;
import com.dudhoo.evilframework.components.BotaoNovo16;
import com.dudhoo.evilframework.components.BotaoRefresh16;
import com.dudhoo.evilframework.components.EvilTable;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.farmaco.jdbc.JdbcHelper;

import com.dudhoo.farmaco.swing.event.DeletePrincipioAtivoListAdapter;
import com.dudhoo.farmaco.swing.event.EditarPrincipioAtivoListAdapter;
import com.dudhoo.farmaco.swing.event.NovoPrincAtivo;

import com.dudhoo.farmaco.swing.event.ViewListAdapter;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import javax.sql.rowset.FilteredRowSet;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class PanelPesquisaPrincipiosAtivos extends JPanel{
    private static PanelPesquisaPrincipiosAtivos intance = null;

    private BorderLayout borderLayout1 = new BorderLayout();
    private JToolBar jToolBar1 = new JToolBar();
    private BotaoNovo16 botaoNovo161 = new BotaoNovo16();
    private BotaoEditar16 botaoEditar161 = new BotaoEditar16();
    private BotaoDelete16 botaoDelete161 = new BotaoDelete16();    
    
    private BotaoFechar24 botaoFechar = new BotaoFechar24();
    private JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private EvilTable evilTable1 = new EvilTable();
   
    private BotaoRefresh16 btnRefresh = new BotaoRefresh16();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator2 = new JSeparator();
    private JButton jBtnVisualizar = new JButton();

    public PanelPesquisaPrincipiosAtivos(String nome){
	this.setName(nome);
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();	    
	}
	intance = this;
    }

    private void jbInit() throws Exception{
	initEvilTable();
	initListeners();
	this.setLayout(borderLayout1);
	botaoNovo161.setText("Novo");
	botaoNovo161.setToolTipText("Inserir um novo princípio ativo");
	botaoEditar161.setText("Editar");
	botaoEditar161.setToolTipText("Editar o princípio ativo selecionado");
	botaoDelete161.setToolTipText("Deletar o princípio ativo selecionado");
	botaoDelete161.setText("Excluir");
	botaoDelete161.addActionListener(new DeletePrincipioAtivoListAdapter(evilTable1));
	jBtnVisualizar.addActionListener(new ViewListAdapter(evilTable1));
	botaoFechar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoFechar_actionPerformed(e);
		    }
		});
	btnRefresh.setText("Atualizar");
	btnRefresh.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			jButton1_actionPerformed(e);
		    }
		});
	botaoEditar161.addActionListener(new EditarPrincipioAtivoListAdapter(evilTable1));
	jSeparator1.setOrientation(SwingConstants.VERTICAL);
	jSeparator1.setMaximumSize(new Dimension(5, 100));
	jSeparator2.setOrientation(SwingConstants.VERTICAL);
	jSeparator2.setMaximumSize(new Dimension(5, 100));
	jBtnVisualizar.setText("Visualizar");
	jBtnVisualizar.setToolTipText("Visulaziar o item selecionado");
	jToolBar1.add(botaoNovo161, null);
	jToolBar1.add(botaoEditar161, null);
	jToolBar1.add(botaoDelete161, null);
	jToolBar1.add(jSeparator1, null);
	jToolBar1.add(btnRefresh, null);
	jToolBar1.add(jSeparator2, null);
	jToolBar1.add(jBtnVisualizar, null);
	this.add(jToolBar1, BorderLayout.NORTH);
	this.add(evilTable1, BorderLayout.CENTER);
	this.add(rodape, BorderLayout.SOUTH);
	rodape.add(botaoFechar);
    }

    public static PanelPesquisaPrincipiosAtivos getIntance(){
	String nome = "Princípios Ativos";
	if(intance == null){
	    intance = new PanelPesquisaPrincipiosAtivos(nome);
	}else if(intance.getParent() == null){
	    intance = new PanelPesquisaPrincipiosAtivos(nome);
	}
	return intance;
    }

    private void initEvilTable() throws Exception{
	this.evilTable1.setFilteredRowSet( new PesquisaFactory().getPesquisa(), 1);
    }

    private void initListeners(){
	this.botaoNovo161.addActionListener(new NovoPrincAtivo());
    }

    private void botaoFechar_actionPerformed(ActionEvent e){
	this.getParent().remove(this);	
    }

    private void jButton1_actionPerformed(ActionEvent e){
	try{
	    initEvilTable();
	} catch(Exception f){
	    new EvilError(StartFrame.getCurrentInstance(), true, f).setVisible(true);
	}
    }
}
