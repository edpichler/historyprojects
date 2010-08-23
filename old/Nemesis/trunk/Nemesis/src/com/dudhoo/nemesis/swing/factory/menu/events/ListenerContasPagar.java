package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.StartFrame;

import com.dudhoo.nemesis.swing.factory.PanelPesquisaContaPagarBuilder;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerContasPagar implements ActionListener{
    public ListenerContasPagar(){    
    }

    public void actionPerformed(ActionEvent actionEvent){
	PanelPesquisaGeneric gen = new PanelPesquisaContaPagarBuilder().getPanelPesquisarContasPagar(false,false);
	StartFrame.getCurrentInstance().addJPanel(gen);
    }
}
