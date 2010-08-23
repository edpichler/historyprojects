package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.CuidadosEspeciais;

public class JPanelCuidadosEspeciais extends JPanelDescricao{
    private CuidadosEspeciais cuidadosEspeciais;
    public JPanelCuidadosEspeciais(){
    }

    public void setCuidadosEspeciais(CuidadosEspeciais cuidadosEspeciais){
	this.cuidadosEspeciais = cuidadosEspeciais;
	if(cuidadosEspeciais == null){
	    this.setText(null);
	}else{
	    this.setText(cuidadosEspeciais.getDescricao());
	}
    }

    public CuidadosEspeciais getCuidadosEspeciais(){
	if(this.cuidadosEspeciais == null){
	    this.cuidadosEspeciais = new CuidadosEspeciais();
	}
	this.cuidadosEspeciais.setDescricao(getText());
	return cuidadosEspeciais;
    }
}
