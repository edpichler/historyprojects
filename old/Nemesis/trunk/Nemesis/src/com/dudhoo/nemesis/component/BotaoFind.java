package com.dudhoo.nemesis.component;

import com.dudhoo.evilframework.components.BotaoProcurar16;

import com.dudhoo.nemesis.component.event.FindPessoaListAdapter;
import com.dudhoo.nemesis.swing.StartFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class BotaoFind extends JPanel{
    public BotaoFind(){
	try{
	    jbInit();
	   
	} catch(Exception e){
	    e.printStackTrace();
	}
    }
    private void jbInit() throws Exception{
	this.setSize(new Dimension(344, 24));
	this.setLayout(gridBagLayout1);
	textField.setColumns(20);
	textField.setEditable(false);
	this.add(textField, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 
		    new Insets(0, 0, 0, 0), 0, 0));
	this.add(botaoProcurar, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 
		    new Insets(0, 0, 0, 0), 0, -5));

    }

    public void setTextField(JTextField textField){
	this.textField = textField;
    }

    public JTextField getTextField(){
	return textField;
    }

    public BotaoProcurar16 getBotaoProcurar(){
	return botaoProcurar;
    }

    public void setBotaoProcurar(BotaoProcurar16 botaoProcurar){
	this.botaoProcurar = botaoProcurar;
    }
    protected JTextField textField = new JTextField();
    protected BotaoProcurar16 botaoProcurar = new BotaoProcurar16();
    protected GridBagLayout gridBagLayout1 = new GridBagLayout();
}
