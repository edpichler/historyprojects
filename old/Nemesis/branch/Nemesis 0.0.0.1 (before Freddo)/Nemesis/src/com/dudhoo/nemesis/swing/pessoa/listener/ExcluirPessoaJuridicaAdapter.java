package com.dudhoo.nemesis.swing.pessoa.listener;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import javax.swing.JOptionPane;

public class ExcluirPessoaJuridicaAdapter implements ExcluirPressListener{
    private PanelPesquisaGeneric panel = null;
    
    public ExcluirPessoaJuridicaAdapter( PanelPesquisaGeneric _panel){
	panel = _panel;
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
	    PessoaJuridicaHome ph = new PessoaJuridicaHome();
	    try{
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());
		PessoaJuridica pj = ph.findById(id);
		if(pj == null){
		    new EvilInformation(null)
			.showMessage("Não foi encontrado um item para remover, talvez já tenha sido removido");
		} else {
		    ph.delete(pj);
		    new EvilInformation(null).showMessage("Removido com sucesso!");
		}
	    } catch(Exception xxx){
		new com.dudhoo.evilframework.swing.EvilError(null, false, xxx)
		    .setVisible(true);
	    } finally{
		ph.closeSession();
	    }
	}
    }
}
