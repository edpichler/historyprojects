package com.dudhoo.nemesis.swing.contas;

import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.swing.contas.event.SalvaContaPagar;

import com.dudhoo.nemesis.swing.contas.event.SalvaContaReceber;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import java.awt.Frame;

public class JDialogContaReceber extends JDialogGenericSaveCancel{
    JPanelContaReceber jPanelContaRec = new JPanelContaReceber();

    public JDialogContaReceber(Frame parent, boolean modal){
	super(parent, modal, "Conta à receber");
	jbInit();
    }

    private void jbInit(){
	super.addPanelAtCenter(jPanelContaRec);
	setSize(550, 400);
	centralize();
	addSaveListener();
    }

    private void addSaveListener(){
	this.setSavePressListener(new SalvaContaReceber(this));
    }

    public void setJPanelContaRec(JPanelContaReceber jPanelContaPagar){
	this.jPanelContaRec = jPanelContaPagar;
    }

    public JPanelContaReceber getJPanelContaRec(){
	return jPanelContaRec;
    }

    public void setContaReceber(ContaReceber pg){
	jPanelContaRec.setContaReceber(pg);
    }
}
