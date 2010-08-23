package com.dudhoo.farmaco.swing.event;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.Posologia;
import com.dudhoo.farmaco.swing.component.JPanelPosologia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

public class BotaoLimparAppFarmacAdapter implements ActionListener{
    private JList listaApresentacoes; 
    private JPanelPosologia panelPos;
    
    public BotaoLimparAppFarmacAdapter(JList _listaApresentacoes, 
				       JPanelPosologia _panelPos){
	this.listaApresentacoes = _listaApresentacoes;
	panelPos = _panelPos;
    }

    public void actionPerformed(ActionEvent actionEvent){
	ApresentacaoFarmaceutica app = (ApresentacaoFarmaceutica)listaApresentacoes.getSelectedValue();
	if(app != null){
	    Posologia pos = panelPos.getPosologia();	
	    pos.setDescricao(null);
	    app.setPosologia( pos );
	}
    }
}
