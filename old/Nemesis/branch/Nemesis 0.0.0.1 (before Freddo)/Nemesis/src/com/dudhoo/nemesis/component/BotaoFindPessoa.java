package com.dudhoo.nemesis.component;

import com.dudhoo.evilframework.components.BotaoProcurar16;

import com.dudhoo.nemesis.component.event.FindPessoaListAdapter;
import com.dudhoo.nemesis.hibernate.Pessoa;

import com.dudhoo.nemesis.swing.StartFrame;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class BotaoFindPessoa extends BotaoFind{
    private Pessoa pessoa;

    public BotaoFindPessoa(){
	this.botaoProcurar.addActionListener(new FindPessoaListAdapter(StartFrame.getCurrentInstance(), true, this));
    }
    
    public void setPessoa(Pessoa pessoa){
	this.pessoa = pessoa;
	if(pessoa != null){
	    this.textField.setText(pessoa.getEmail());
	}else{
	    this.textField.setText(null);
	}
    }

    public Pessoa getPessoa(){
	return pessoa;
    }


}
