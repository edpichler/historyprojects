package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.Interacao;

public class JPanelInteracao extends JPanelDescricao{
    private Interacao interacao;
    public JPanelInteracao(){
    }

    public void setInteracao(Interacao interacao){
	this.interacao = interacao;
	if(interacao == null){
	    this.setText(null);
	}else{
	    this.setText(interacao.getDescricao());
	}
    }

    public Interacao getInteracao(){
	if(interacao == null){
	    interacao = new Interacao();
	}
	interacao.setDescricao(getText());
	return interacao;
    }
}
