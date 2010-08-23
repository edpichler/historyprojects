package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.Posologia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class JPanelPosologia extends JPanelDescricao{
    private Posologia posologia;
    public JPanelPosologia(){
	try{	   	   
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    public void setPosologia(Posologia posologia){	
	this.posologia = posologia;
	if(posologia != null){
	    setText(posologia.getDescricao());
	}else{
	    setText(null);
	}
    }

    public Posologia getPosologia(){
	if(posologia == null){
	    posologia = new Posologia();
	}
	posologia.setDescricao(getText());
	return posologia;
    }   
}
