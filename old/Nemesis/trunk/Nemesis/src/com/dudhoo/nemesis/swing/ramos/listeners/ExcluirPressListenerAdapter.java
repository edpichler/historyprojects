package com.dudhoo.nemesis.swing.ramos.listeners;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.ExcluirPressListener;

import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import javax.swing.JOptionPane;

public class ExcluirPressListenerAdapter implements ExcluirPressListener{
    private PanelPesquisaGeneric panel = null;
    public ExcluirPressListenerAdapter(PanelPesquisaGeneric panel){
	this.panel = panel;
    }
    
    public void doAfterClick(){
	if(this.panel.isAlgumaLinhaSelecionada()){
	    if(new EvilAsk(this.panel).setVisible("Tem certeza que deseja remover o registro selecionado?") == JOptionPane.YES_OPTION){
		excluir(Long.parseLong(this.panel.getIdCampoSelecionado().toString()));
	    }
	}
	
    }
    
    private void excluir(long id){
	RamoHome ram = new RamoHome();
	Ramo r = ram.findById(id);
	try{
	    if(r == null){
		new EvilInformation(this.panel).showMessage("Não foi encontrado um item para remover, talvez já tenha sido removido");
	    }else{
		ram.delete(r);
		new EvilInformation(this.panel).showMessage("Removido com sucesso!");
	    }
	}catch(Exception xxx){
	    new com.dudhoo.evilframework.swing.EvilError(null, false, xxx).setVisible(true);
	}
    }
    
}
