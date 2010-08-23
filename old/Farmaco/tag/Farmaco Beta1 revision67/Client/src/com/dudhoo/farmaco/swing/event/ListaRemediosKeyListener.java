package com.dudhoo.farmaco.swing.event;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.Posologia;
import com.dudhoo.farmaco.swing.component.JPanelPosologia;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;

public class ListaRemediosKeyListener implements KeyListener {
    private JList listaApresentacoes; 
    private JPanelPosologia panelPos;
    
    public ListaRemediosKeyListener(JList _listaApresentacoes, JPanelPosologia _panelPos){
	this.listaApresentacoes = _listaApresentacoes;
	panelPos = _panelPos;
    }

    public void keyTyped(KeyEvent keyEvent){	
    }

    public void keyPressed(KeyEvent keyEvent){
    }

    public void keyReleased(KeyEvent keyEvent){
	ApresentacaoFarmaceutica appre = (ApresentacaoFarmaceutica) listaApresentacoes.getSelectedValue();
	if(appre != null){
	    Posologia pos = appre.getPosologia();
	    pos.setDescricao(panelPos.getText());           
	}
    }
}
