package com.dudhoo.nemesis.swing.contas;

import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.swing.contas.event.SalvaContaPagar;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import java.awt.Frame;


public class JDialogContaPagar extends JDialogGenericSaveCancel{
    JPanelContaPagar jPanelContaPagar = new JPanelContaPagar();

    public JDialogContaPagar(Frame parent, boolean modal){
	super(parent, modal, "Conta à pagar");
	jbInit();
    }

    private void jbInit(){
	super.addPanelAtCenter(jPanelContaPagar);
	setSize(550, 400);
	centralize();
	addSaveListener();
    }

    private void addSaveListener(){
	this.setSavePressListener(new SalvaContaPagar(this));
    }

    public void setJPanelContaPagar(JPanelContaPagar jPanelContaPagar){
	this.jPanelContaPagar = jPanelContaPagar;
    }

    public JPanelContaPagar getJPanelContaPagar(){
	return jPanelContaPagar;
    }

    public void setContaPagar(ContaPagar pg){
	jPanelContaPagar.setContaPagar(pg);
    }
}
