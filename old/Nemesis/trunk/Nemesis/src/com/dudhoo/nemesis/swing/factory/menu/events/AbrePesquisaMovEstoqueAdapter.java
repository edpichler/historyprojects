package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaComprasBuilder;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class AbrePesquisaMovEstoqueAdapter implements ActionListener{
    public void actionPerformed(ActionEvent actionEvent){
	final PanelPesquisaGeneric panel = new PanelPesquisaComprasBuilder().getJPanelPesquisaCompras(false, false);
	StartFrame.getCurrentInstance().addJPanel(panel);
    }
}
