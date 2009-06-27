package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaVendasBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVendasAdapter implements ActionListener{
    public void actionPerformed(ActionEvent actionEvent){
	final PanelPesquisaGeneric gen = new PanelPesquisaVendasBuilder().getPanelPesquisaVendas(false, false);
	StartFrame.getCurrentInstance().addJPanel(gen);
    }
}
