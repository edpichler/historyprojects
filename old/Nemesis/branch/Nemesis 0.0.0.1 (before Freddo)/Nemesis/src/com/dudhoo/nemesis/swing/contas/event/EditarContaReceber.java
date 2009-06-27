package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.ContaReceberHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;
import com.dudhoo.nemesis.swing.contas.JDialogContaReceber;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

public class EditarContaReceber implements EditarPressListener{ //TODO CRIAR UMA CLASE ABSTRATA E DEIXAR MAIS ORIENTADO Á OBJETOS
    private PanelPesquisaGeneric panel;
    private boolean modal;

    public EditarContaReceber(PanelPesquisaGeneric _panel, boolean _modal){
	panel = _panel;
	modal = _modal;
    }

    public void doAfterClick(){
	try{
	    if(panel.isAlgumaLinhaSelecionada()){
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
		JDialogContaReceber jd = 
		    new JDialogContaReceber(StartFrame.getCurrentInstance(), modal);
		ContaReceberHome home = new ContaReceberHome();
		ContaReceber pg = home.findContaReceber(id);
		if(pg != null){
		    jd.setContaReceber(pg);
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
