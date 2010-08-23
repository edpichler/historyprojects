package com.dudhoo.farmaco.swing.dialog;

import com.dudhoo.evilframework.swing.dialog.EvilDialogSaveCancel;
import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;

import com.dudhoo.farmaco.swing.component.JPanelEditApresentacaoFarmaceutica;

import java.awt.Dimension;

public class JDialogEditApresFarmaceutica 
extends EvilDialogSaveCancel {

    private JPanelEditApresentacaoFarmaceutica panel = new JPanelEditApresentacaoFarmaceutica(); 
    
    public JDialogEditApresFarmaceutica(boolean modal){    
	super();
	this.setModal(modal);
	centralize(new Dimension(400, 300));
	setTitle("Apresentação farmacêutica");
	this.setAlwaysOnTop(false);
	jbInit();
    }   
    private void jbInit(){
	getContentPane().add( panel );
	
    }
    public ApresentacaoFarmaceutica getApresentacaoFarmaceutica(){
	return this.panel.getApresentacaoFarmaceutica();
    }
    public void setApresentacaoFarmaceutica(ApresentacaoFarmaceutica _a){
	panel.setApresentacaoFarmaceutica(_a);
    }
}
