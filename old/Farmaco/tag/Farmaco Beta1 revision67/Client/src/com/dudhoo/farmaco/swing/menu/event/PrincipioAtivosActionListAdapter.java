package com.dudhoo.farmaco.swing.menu.event;

import com.dudhoo.farmaco.swing.PanelPesquisaPrincipiosAtivos;
import com.dudhoo.farmaco.swing.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipioAtivosActionListAdapter implements ActionListener{

    public void actionPerformed(ActionEvent actionEvent){
	StartFrame.getCurrentInstance().addJPanel(PanelPesquisaPrincipiosAtivos.getIntance() );
    }
    
}
