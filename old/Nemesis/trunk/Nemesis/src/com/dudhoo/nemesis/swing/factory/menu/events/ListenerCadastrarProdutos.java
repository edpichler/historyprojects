package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaPessoaFisicaBuilder;

import com.dudhoo.nemesis.swing.factory.PanelPesquisaProdutoBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCadastrarProdutos implements ActionListener{
    PanelPesquisaGeneric panel = null;
    public void actionPerformed(ActionEvent actionEvent){
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
	panel = new PanelPesquisaProdutoBuilder().getJPanelPesquisaProduto(true, false);    
	
	StartFrame.getCurrentInstance().addJPanel(panel);
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
