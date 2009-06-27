package com.dudhoo.nemesis.component.dialog;

import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaPessoaFisicaBuilder;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaProdutoBuilder;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSelectCancel;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;

public class JDialogFindProduto extends JDialogGenericSelectCancel{
    PanelPesquisaGeneric panel;
    public JDialogFindProduto(Frame parent, boolean modal){
	super(parent, modal);
	setTitle("Procurar produtos");
	jbInit();
    }
    private void jbInit(){
	panel = 
     new PanelPesquisaProdutoBuilder().getJPanelPesquisaProduto(false, false);
	super.addPanelAtCenter(panel);
	setSelectPressListener(new SelectPressListener(){
		    public void doAfterClick(){
			if(panel.isAlgumaLinhaSelecionada()){
			    close();
			} else {
			    new EvilInformation(panel)
				.showMessage("Selecione primeiro um registro na tabela");
			}
		    }
		});
	setSize(400, 500);
	centralize(); 
    }

    public Long getProdutoId(){
	if(panel.isAlgumaLinhaSelecionada()){
	    return Long.parseLong(panel.getIdCampoSelecionado().toString());
	} else {
	    return null;
	}
    }
}
