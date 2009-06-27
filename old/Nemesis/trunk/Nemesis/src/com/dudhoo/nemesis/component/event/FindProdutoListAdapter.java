package com.dudhoo.nemesis.component.event;

import com.dudhoo.nemesis.component.BotaoFindProduto;
import com.dudhoo.nemesis.component.dialog.JDialogFindProduto;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.ProdutoHome;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FindProdutoListAdapter implements ActionListener{
    private Frame frame;
    private boolean modal;
    BotaoFindProduto findProd;

    public FindProdutoListAdapter(Frame _frame, boolean _modal, 
				  BotaoFindProduto findP){
	frame = _frame;
	modal = _modal;
	findProd = findP;
    }

    public void actionPerformed(ActionEvent actionEvent){
	JDialogFindProduto dialog = new JDialogFindProduto(frame, modal);
	dialog.setVisible(true);
	if(dialog.getProdutoId() != null){
	    long id = dialog.getProdutoId();
	    ProdutoHome home = new ProdutoHome();
	    Produto pod = home.findById(id);
	    if(pod != null){
		findProd.setProduto(pod);
	    }
	    home.closeSession();
	    home = null;
	}
    }
}
