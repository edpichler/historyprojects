package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaPagarHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluirContaPagar implements ExcluirPressListener{
    private PanelPesquisaGeneric panel;
    private boolean modal;

    public ExcluirContaPagar(PanelPesquisaGeneric _panel, boolean _modal){
	panel = _panel;
	modal = _modal;
    }

    public void doAfterClick(){
	try{
	    if(panel.isAlgumaLinhaSelecionada()){
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
		ContaPagarHome home = new ContaPagarHome();
		home.deleteById(id);
		panel.refreshTable();
	    }
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally{
	}
    }
}
