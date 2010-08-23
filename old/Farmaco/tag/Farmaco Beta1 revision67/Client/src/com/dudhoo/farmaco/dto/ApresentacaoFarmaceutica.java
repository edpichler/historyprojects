package com.dudhoo.farmaco.dto;

public class ApresentacaoFarmaceutica extends Entity{
    private Posologia posologia;

    public void setPosologia(Posologia posologia){
	this.posologia = posologia;
    }

    public Posologia getPosologia(){
	return posologia;
    }
    public String toString(){	
	return this.getDescricao();
    }
}

