package com.dudhoo.nemesis.swing.pessoa.listener;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaFisicaHome;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.pessoa.JDialogPessoaFisica;
import com.dudhoo.nemesis.swing.pessoa.JDialogPessoaJuridica;


public class EditarPessoaFisicaListener implements EditarPressListener{

    PanelPesquisaGeneric panel = null;

    public EditarPessoaFisicaListener(PanelPesquisaGeneric panel){
	this.panel = panel;
    }

    private void clickEditar(){

	try{
	    Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
	    JDialogPessoaFisica jd = 
		new JDialogPessoaFisica(StartFrame.getCurrentInstance(), true);	    	    
	    jd.setPessoaFisica(id);
	    jd.setVisible(true);
	} catch(Exception xxx){
	    new EvilError(null, false, xxx).setVisible(true);
	}
    }

    public void doAfterClick(){
	if(panel.isAlgumaLinhaSelecionada()){
	    clickEditar();
	}
    }
}
