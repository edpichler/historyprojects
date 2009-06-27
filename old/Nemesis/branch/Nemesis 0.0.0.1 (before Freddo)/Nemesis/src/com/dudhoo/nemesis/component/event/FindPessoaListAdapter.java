package com.dudhoo.nemesis.component.event;

import com.dudhoo.nemesis.component.BotaoFindPessoa;
import com.dudhoo.nemesis.component.dialog.JDialogFindPessoa;

import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaFisicaHome;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPessoaListAdapter implements ActionListener{
    private Frame frame;
    private boolean modal;
    BotaoFindPessoa findPess;
    public FindPessoaListAdapter(Frame _frame, boolean _modal, BotaoFindPessoa findP){
	frame = _frame;
	modal = _modal;
	findPess = findP;
	
    }

    public void actionPerformed(ActionEvent evt){
	JDialogFindPessoa dialog = new JDialogFindPessoa(frame, modal);
	dialog.setVisible(true);
	if(dialog.getPessoaId() != null ){
	    long id = dialog.getPessoaId();
	    PessoaFisicaHome home = new PessoaFisicaHome();
	    PessoaFisica pess = home.findById(id);
	    if(pess != null){
		findPess.setPessoa(pess.getPessoa());
	    }
	    home.closeSession();
	    home = null;
	}
    }
}
