package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaPagarHome;
import com.dudhoo.nemesis.swing.StartFrame;

import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;

import com.dudhoo.evilframework.swing.*;

public class EditarContaPagar implements EditarPressListener{
    private PanelPesquisaGeneric panel;
    private boolean modal;

    public EditarContaPagar(PanelPesquisaGeneric _panel, boolean _modal){
	panel = _panel;
	modal = _modal;
    }

    public void doAfterClick(){
	try{
	    if(panel.isAlgumaLinhaSelecionada()){
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
		JDialogContaPagar jd = 
		    new JDialogContaPagar(StartFrame.getCurrentInstance(), modal);
		ContaPagarHome home = new ContaPagarHome();
		ContaPagar pg = home.findContaPagar(id);
		if(pg != null){
		    jd.setContaPagar(pg);
		    jd.setVisible(true);
		} else {
		    new EvilInformation(panel)
			.showMessage("Não foi encontrado a conta selecionada. Talvez outra pessoa na rede tenha removido.");
		}
	    }
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally{
	}
    }
}
