package com.dudhoo.farmaco.swing.event;

import com.dudhoo.farmaco.swing.PanelAdminPrincipioAtivo;
import com.dudhoo.farmaco.swing.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NovoPrincAtivo implements ActionListener{
    public void actionPerformed(ActionEvent actionEvent){
	StartFrame.getCurrentInstance().addJPanel( new PanelAdminPrincipioAtivo("Novo princípio ativo"));
    }
}
