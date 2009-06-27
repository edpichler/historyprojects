package com.dudhoo.nemesis.swing.fornecedor;

import com.dudhoo.evilframework.components.BotaoDelete16;
import com.dudhoo.evilframework.components.BotaoNovo16;
import com.dudhoo.evilframework.components.BotaoProcurar16;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;

import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import java.util.Iterator;

public class JPanelListaFornecedores extends JPanel{    
    private BorderLayout borderLayout1 = new BorderLayout();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JList jList1 = new JList();
    private JToolBar jToolBar1 = new JToolBar();
    private BotaoProcurar16 botaoFind = new BotaoProcurar16 ();
    private BotaoDelete16 botaoDelete = new BotaoDelete16();

    public JPanelListaFornecedores(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(462, 228));
	this.setBorder(BorderFactory.createTitledBorder("Fornecedores"));
	this.setLayout(borderLayout1);
	botaoFind.setToolTipText("Adicionar");
	botaoFind.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoFind_actionPerformed(e);
		    }
		});
	botaoDelete.setActionCommand("null");
	botaoDelete.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoDelete_actionPerformed(e);
		    }
		});
	jScrollPane1.getViewport().add(jList1, null);
	this.add(jScrollPane1, BorderLayout.CENTER);
	jToolBar1.add(botaoFind);
	jToolBar1.add(botaoDelete, null);
	this.add(jToolBar1, BorderLayout.NORTH);	
    }
        
    public void addFornecedor(Pessoa forn){
	DefaultListModel model  = new DefaultListModel();
	for (int i = 0; i < jList1.getModel().getSize(); i++)  {
	    Object o = jList1.getModel().getElementAt(i);
	    model.addElement(o);
	}	
	model.addElement(forn);
	this.jList1.setModel(model);
    }

    public Set <Pessoa> getFornecedores(){
	int size = this.jList1.getModel().getSize();
	HashSet set = new HashSet();	
	for (int i = 0; i < size; i++)  {
	    set.add(getFornecedorAt(i));
	}
	return set;	
    }
    
    public void setFornecedores(Set <Pessoa> forns){	
	for(Iterator iterator = forns.iterator();iterator.hasNext();) {
	    Pessoa fornecedor = (Pessoa) iterator.next();
	    addFornecedor(fornecedor);    
	}
    }
    
    public Pessoa getFornecedorAt(int i){
	DefaultListModel model = (DefaultListModel) this.jList1.getModel();		
	return (Pessoa) model.getElementAt(i);
    }

    private void botaoDelete_actionPerformed(ActionEvent e){
	remover();
    }

    private void remover(){
	if(jList1.getSelectedIndex() > -1){
	    Object forn =  this.jList1.getSelectedValue();
	    if(forn != null){
		DefaultListModel model = (DefaultListModel) this.jList1.getModel();
		model.removeElement( forn);		
	    }
	}
    }

    private void botaoFind_actionPerformed(ActionEvent e){
	JDialogFindFornecedor dialog = new JDialogFindFornecedor(null,true);
	dialog.setVisible(true);	
	if(dialog.getOpcao().equals(OpcaoEscolhida.SELECT)){
	    Pessoa f = dialog.getFornecedor();
	    if(f != null){
		addFornecedor(f);		
	    }
	}
    }
}
