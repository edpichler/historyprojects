package com.dudhoo.nemesis.swing.produto;

import com.dudhoo.evilframework.swing.dialog.EvilDialogSaveCancel;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.swing.produto.event.SalvarProdutoListAdapter;

public class JDialogProduto extends EvilDialogSaveCancel{
    JPanelProduto panel = new JPanelProduto();
    public JDialogProduto(){	
	jbInit();
	initListeners();	
    }
    
    private void jbInit(){
	this.add(panel);
	this.setSize(450,280);
	this.setModal(true);	
	this.setLocationRelativeTo(null);
	this.setTitle("Produto");
    }

    private void initListeners(){
	this.getBotaoSalvar().addActionListener(new SalvarProdutoListAdapter(this));
    }
    
    public void setProduto(Produto prod){
	panel.setProduto(prod);	
    }

    public JPanelProduto getPanelProduto(){
	return panel;
    }
}
