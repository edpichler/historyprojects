package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaContaPagarBuilder;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaContaReceberBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerContasReceber implements ActionListener{
    public ListenerContasReceber(){
    }

    public void actionPerformed(ActionEvent actionEvent){
	PanelPesquisaGeneric gen = new PanelPesquisaContaReceberBuilder().getPanelPesquisarContasReceber(false,false);
	StartFrame.getCurrentInstance().addJPanel(gen);
    }
}
