package com.dudhoo.farmaco.swing.event;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.Posologia;
import com.dudhoo.farmaco.swing.component.JPanelPosologia;

import java.nio.channels.SelectionKey;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListaRemediosValueChangeListener implements ListSelectionListener{
    private JList listaApresentacoes; 
    private JPanelPosologia panelPos;
    
    public ListaRemediosValueChangeListener(JList _listaApresentacoes, JPanelPosologia _panelPos){
	this.listaApresentacoes = _listaApresentacoes;
	panelPos = _panelPos;
    }

    public void valueChanged(ListSelectionEvent listSelectionEvent){
	if(listSelectionEvent.getValueIsAdjusting() == true){
	    ApresentacaoFarmaceutica app = (ApresentacaoFarmaceutica)
	                this.listaApresentacoes.getSelectedValue();
	    this.panelPos.setPosologia(app.getPosologia() );
	}
    }
}