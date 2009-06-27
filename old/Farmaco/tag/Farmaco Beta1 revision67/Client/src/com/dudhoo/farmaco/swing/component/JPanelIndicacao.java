package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.Indicacao;

public class JPanelIndicacao extends JPanelDescricao{
    private Indicacao indicacao ;
    
    public JPanelIndicacao(){	
    }

    public void setIndicacao(Indicacao indicacao){
	this.indicacao = indicacao;
	if(this.indicacao == null){
	    this.setText(null);
	}else{
	    this.setText(indicacao.getDescricao());
	}
    }

    public Indicacao getIndicacao(){
	if(this.indicacao == null){
	    indicacao = new Indicacao();
	}
	indicacao.setDescricao(this.getText());	
	return indicacao;
    }
}
