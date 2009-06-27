/*
 * ListenerCadastrarPessoas.java
 *
 * Created on 25 de Janeiro de 2006, 23:41
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaPessoaJuridicaBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.pessoa.JDialogPessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import com.dudhoo.nemesis.event.ExcluirPressListener;

import com.dudhoo.nemesis.swing.pessoa.listener.EditarPessoaJuridicaAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.ExcluirPessoaJuridicaAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.InserirPessoaJuridicaAdapter;

import javax.swing.JOptionPane;


/**
 *
 * @author duduzera
 */
public class ListenerCadastrarPessoasJuridicas implements ActionListener{
    private PanelPesquisaGeneric panel = null;

    /**
     * Creates a new instance of ListenerCadastrarPessoas
     */
    public ListenerCadastrarPessoasJuridicas(){	
    }

    public void actionPerformed(java.awt.event.ActionEvent e){
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
	try{
	    panel = new PanelPesquisaPessoaJuridicaBuilder().getPanelPesquisarPessoaJuridica();
	}catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex);
	}finally{
	    StartFrame.getCurrentInstance().
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
    }


}
