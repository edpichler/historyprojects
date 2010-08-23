package com.dudhoo.nemesis.swing.ramos.listeners;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.ramos.JDialogCadRamos;

public class EditarPressListenerAdapter implements EditarPressListener{
    private PanelPesquisaGeneric panel = null;
    
    public EditarPressListenerAdapter(PanelPesquisaGeneric panel){
	this.setPanel(panel);
    }
    
    public void doAfterClick(){
	if(getPanel().isAlgumaLinhaSelecionada()){
	    Object o = getPanel().getIdCampoSelecionado();
	    try{
		editar(Long.parseLong(o.toString()));    
	    }catch(Exception xxx){
		new com.dudhoo.evilframework.swing.EvilError(StartFrame.getCurrentInstance(),  false, xxx).setVisible(true);
	    }
	    
	}
    }
    
    private void editar(long id){
	RamoHome ram = new RamoHome();
	Ramo ramo = ram.findById(id);
	if(ramo != null){
	    JDialogCadRamos cadR = new JDialogCadRamos(StartFrame.getCurrentInstance(), true);
	    cadR.setRamo(ramo);
	    cadR.setVisible(true);
	}
    }

    protected PanelPesquisaGeneric getPanel(){
	return panel;
    }

    protected void setPanel(PanelPesquisaGeneric panel){
	this.panel = panel;
    }
}
