package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.ReacaoAdversa;

public class JPanelReacaoAdversa extends JPanelDescricao{
    private ReacaoAdversa reacaoAdversa;
    public JPanelReacaoAdversa(){
    }

    public void setReacaoAdversa(ReacaoAdversa reacaoAdversa){
	this.reacaoAdversa = reacaoAdversa;
	if(reacaoAdversa == null){
	    this.setText(null);
	}else{
	    this.setText(reacaoAdversa.getDescricao());
	}
    }

    public ReacaoAdversa getReacaoAdversa(){
    if(this.reacaoAdversa == null){
	this.reacaoAdversa = new ReacaoAdversa();	
    }
    this.reacaoAdversa.setDescricao(getText());
	return reacaoAdversa;
    }
}
