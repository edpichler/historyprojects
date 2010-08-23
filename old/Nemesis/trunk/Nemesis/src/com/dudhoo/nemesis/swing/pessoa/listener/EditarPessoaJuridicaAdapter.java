package com.dudhoo.nemesis.swing.pessoa.listener;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.pessoa.JDialogPessoaJuridica;

public class EditarPessoaJuridicaAdapter implements EditarPressListener{
    private PanelPesquisaGeneric panel = null;

    public EditarPessoaJuridicaAdapter(PanelPesquisaGeneric pan){
	panel = pan;
    }

    public void doAfterClick(){
	if(panel.isAlgumaLinhaSelecionada()){
	    clickEditar();
	}
    }

    private void clickEditar(){
	try{
	    Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
	    JDialogPessoaJuridica jd = 
		new JDialogPessoaJuridica(StartFrame.getCurrentInstance(), true);	    
	    jd.setPessoaJuridica(id);
	    jd.setVisible(true);
	} catch(Exception xxx){
	    new com.dudhoo.evilframework.swing.EvilError(null, false, xxx)
		.setVisible(true);
	}
    }
}
