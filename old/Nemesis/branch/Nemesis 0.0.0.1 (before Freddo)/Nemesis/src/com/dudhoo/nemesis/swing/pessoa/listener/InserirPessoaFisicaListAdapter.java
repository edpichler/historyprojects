package com.dudhoo.nemesis.swing.pessoa.listener;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.pessoa.JDialogPessoaFisica;

public class InserirPessoaFisicaListAdapter implements InserirPressListener{
    public InserirPessoaFisicaListAdapter(){
    }
    
    public void doAfterClick(){
	click();
    }
    
    private void click(){
	JDialogPessoaFisica pf = 
	    new JDialogPessoaFisica(StartFrame.getCurrentInstance(), true);
	pf.setVisible(true);
    }

}
