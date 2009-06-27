package com.dudhoo.nemesis.swing.produto;

import com.dudhoo.evilframework.swing.dialog.EvilDialogSaveCancel;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;
import com.dudhoo.nemesis.swing.produto.event.SalvarProdutoListAdapter;

import java.awt.Frame;

public class JDialogProduto extends JDialogGenericSaveCancel{
    JPanelProduto panel = new JPanelProduto();
    public JDialogProduto(Frame parent, boolean modal ){        
        super(parent, modal,"Produto");        
	jbInit();
        initListeners();	
    }
    
    private void jbInit(){
	this.add(panel);
	this.setSize(450,380);
	this.setModal(true);	
	this.setLocationRelativeTo(null);
	
    }

    private void initListeners(){
	this.setSavePressListener(new SalvarProdutoListAdapter(this));
    }
    
    public void setProduto(Produto prod){
	panel.setProduto(prod);	
    }

    public JPanelProduto getPanelProduto(){
	return panel;
    }
}
