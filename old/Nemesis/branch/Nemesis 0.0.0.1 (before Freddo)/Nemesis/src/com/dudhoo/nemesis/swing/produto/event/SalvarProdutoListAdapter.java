package com.dudhoo.nemesis.swing.produto.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.ProdutoHome;
import com.dudhoo.nemesis.swing.StartFrame;

import com.dudhoo.nemesis.swing.produto.JDialogProduto;
import com.dudhoo.nemesis.swing.produto.JPanelProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Set;

public class SalvarProdutoListAdapter implements ActionListener{
    private JPanelProduto panel;
    private JDialogProduto dialog;
    public SalvarProdutoListAdapter(JDialogProduto _dialog){
	panel = _dialog.getPanelProduto();
	this.dialog = _dialog;
    }

    public void actionPerformed(ActionEvent actionEvent){
	Produto prod;
	try{
	    prod = panel.getProduto();
	    ProdutoHome home = new ProdutoHome();
	    home.saveOrUpdate(prod);	    	    
	    home.closeSession();
	    new EvilInformation(panel).showMessage("Salvo com sucesso!");
	    dialog.dispose();
	} catch(ValidationException e){
	    new EvilError(StartFrame.getCurrentInstance(),true,e).setVisible(true);
	}
    }
}
