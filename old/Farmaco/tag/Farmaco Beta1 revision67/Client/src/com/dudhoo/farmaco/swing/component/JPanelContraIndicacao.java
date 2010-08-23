package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.ContraIndicacao;

public class JPanelContraIndicacao extends JPanelDescricao{
    private ContraIndicacao contraIndicacao;
    public JPanelContraIndicacao(){
    }

    public void setContraIndicacao(ContraIndicacao contraIndicacao){
	this.contraIndicacao = contraIndicacao;
	if(contraIndicacao == null){
	    this.setText(null);
	}else{
	    this.setText(contraIndicacao.getDescricao());
	}
    }

    public ContraIndicacao getContraIndicacao(){
	if(contraIndicacao == null){
	    contraIndicacao = new ContraIndicacao();
	}
	contraIndicacao.setDescricao(this.getText());
	return contraIndicacao;
    }
}
