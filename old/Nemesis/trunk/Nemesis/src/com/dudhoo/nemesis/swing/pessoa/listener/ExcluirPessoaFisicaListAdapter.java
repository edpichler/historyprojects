package com.dudhoo.nemesis.swing.pessoa.listener;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaFisicaHome;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import javax.swing.JOptionPane;

public class ExcluirPessoaFisicaListAdapter implements ExcluirPressListener{
    PanelPesquisaGeneric panel = null;

    public ExcluirPessoaFisicaListAdapter(PanelPesquisaGeneric panel){
	this.panel = panel;
    }

    public void doAfterClick(){
	if(panel.isAlgumaLinhaSelecionada()){
	    clickDelete();
	}
    }

    private void clickDelete(){
	if(new EvilAsk(panel)
    .setVisible("Tem certeza que deseja deletar " + "o item selecionado?") == 
    JOptionPane.YES_OPTION){
	    PessoaFisicaHome ph = new PessoaFisicaHome();
	    try{
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
		PessoaFisica pf = ph.findById(id, null);
		if(pf == null){
		    new EvilInformation(null)
			.showMessage("Não foi encontrado um item para remover, talvez já tenha sido removido");
		} else {
		    ph.delete(pf);
		    new EvilInformation(null).showMessage("Removido com sucesso!");
		}
	    } catch(Exception xxx){
		new EvilError(null, false, xxx).setVisible(true);
	    } finally{
		ph.closeSession();
	    }
	}
    }
}
