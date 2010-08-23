package com.dudhoo.nemesis.swing.produto.event;

import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;

import com.dudhoo.nemesis.swing.produto.JDialogProduto;

import java.awt.Component;

public class InsertProdutoPressListener implements InserirPressListener{
    Component comp;
    public InsertProdutoPressListener(Component _comp){
	this.comp = _comp;
    }
    public void doAfterClick(){
	JDialogProduto jdi = new JDialogProduto(StartFrame.getCurrentInstance(), true);	
	jdi.setVisible(true);	
    }

    public Component getComp(){
	return comp;
    }

    public void setComp(Component comp){
	this.comp = comp;
    }
}
