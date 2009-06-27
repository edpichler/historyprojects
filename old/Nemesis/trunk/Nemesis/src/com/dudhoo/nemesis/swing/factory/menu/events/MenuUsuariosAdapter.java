package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaCidadeBuilder;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaUsuariosBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUsuariosAdapter implements ActionListener{
    public MenuUsuariosAdapter(){
    }

    public void actionPerformed(ActionEvent actionEvent){
	try{
	    StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
	    final PanelPesquisaGeneric panel = 
		new PanelPesquisaUsuariosBuilder().getPanelPesquisarUsuarios(true,false);
	
	}catch(Exception eee){
	    new EvilError(null, false, eee).setVisible(true);
	}finally{
	    StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
    }
}
