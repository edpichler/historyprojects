package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.ContaReceberHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.JDialogContaReceber;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

public class ExcluirContaReceber implements ExcluirPressListener{
    private PanelPesquisaGeneric panel;

    public ExcluirContaReceber(PanelPesquisaGeneric _panel){
	panel = _panel;
    }


    public void doAfterClick(){
	try{
	    if(panel.isAlgumaLinhaSelecionada()){
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
		ContaReceberHome home = new ContaReceberHome();
		home.deletaById(id);
		panel.refreshTable();
	    }
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally{
	}
    }
}
