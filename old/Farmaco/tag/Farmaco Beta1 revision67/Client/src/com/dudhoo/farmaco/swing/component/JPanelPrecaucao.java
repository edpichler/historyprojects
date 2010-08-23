package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.Precaucao;

public class JPanelPrecaucao extends JPanelDescricao{
    private Precaucao precaucao;
    public JPanelPrecaucao(){
    }

    public void setPrecaucao(Precaucao precausao){
	this.precaucao = precausao;
	if(precausao == null){
	    this.setText(null);
	}else{
	    this.setText(precausao.getDescricao());
	}
    }

    public Precaucao getPrecaucao(){
	if(precaucao == null){
	    precaucao = new Precaucao();
	}
	precaucao.setDescricao(getText());
	return precaucao;
    }
}
