package com.dudhoo.evilframework.swing.dialog;

import com.dudhoo.evilframework.components.BotaoCancelar20;

import com.dudhoo.evilframework.components.BotaoSalvar20;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class EvilDialogSaveCancel extends AbstractDialog{
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private BotaoCancelar20 botaoCancelar = new BotaoCancelar20();
    private BotaoSalvar20 botaoSalvar = new BotaoSalvar20();


    public EvilDialogSaveCancel(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.getContentPane().setLayout(borderLayout1);
	jPanel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	jPanel1.add(botaoCancelar, null);
	jPanel1.add(botaoSalvar, null);
	jPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	botaoCancelar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoCancelar_actionPerformed(e);
		    }
		});
	botaoSalvar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoSave_actionPerformed(e);
		    }
		});
	this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
    }

    public void setBotaoCancelar(BotaoCancelar20 botaoCancelar201){
	this.botaoCancelar = botaoCancelar201;
    }

    public BotaoCancelar20 getBotaoCancelar(){
	return botaoCancelar;
    }

    public void setBotaoSalvar(BotaoSalvar20 botaoSalvar201){
	this.botaoSalvar = botaoSalvar201;
    }

    public BotaoSalvar20 getBotaoSalvar(){
	return botaoSalvar;
    }

    private void botaoCancelar_actionPerformed(ActionEvent e){
	super.setBotaoClicado(BotaoConstants.CANCEL);
	this.closeDialog();
    }

    private void botaoSave_actionPerformed(ActionEvent e){
	super.setBotaoClicado(BotaoConstants.SAVE);
	this.closeDialog();
    }

    public BotaoConstants getBotaoClicado(){
	return super.getBotaoClicado();
    }
}
