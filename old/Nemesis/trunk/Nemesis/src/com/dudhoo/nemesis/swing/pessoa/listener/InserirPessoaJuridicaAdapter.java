package com.dudhoo.nemesis.swing.pessoa.listener;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.pessoa.JDialogPessoaJuridica;

public class InserirPessoaJuridicaAdapter implements InserirPressListener{
    public InserirPessoaJuridicaAdapter(){
    }

    public void doAfterClick(){
	click();
    }
    
    private void click(){
	JDialogPessoaJuridica jd = 
	    new JDialogPessoaJuridica(StartFrame.getCurrentInstance(), true);
	jd.setVisible(true);
    }
}
