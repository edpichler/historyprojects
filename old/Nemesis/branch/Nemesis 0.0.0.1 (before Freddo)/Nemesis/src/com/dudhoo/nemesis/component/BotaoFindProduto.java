package com.dudhoo.nemesis.component;

import com.dudhoo.nemesis.component.event.FindPessoaListAdapter;
import com.dudhoo.nemesis.component.event.FindProdutoListAdapter;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.swing.StartFrame;

public class BotaoFindProduto extends BotaoFind{
    private Produto produto;
    public BotaoFindProduto(){
	this.botaoProcurar.addActionListener(new FindProdutoListAdapter(StartFrame.getCurrentInstance(), true, this));
    }

    public void setProduto(Produto produto){
	this.produto = produto;	
	if(produto != null){
	    this.textField.setText(produto.getNome());
	}else{
	    this.textField.setText(null);
	}
    }

    public Produto getProduto(){
	return produto;
    }
}
