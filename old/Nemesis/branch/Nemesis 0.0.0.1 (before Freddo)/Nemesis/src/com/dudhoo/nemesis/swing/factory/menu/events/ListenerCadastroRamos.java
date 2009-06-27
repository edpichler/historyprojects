/*
 * ListenerCadastroRamos.java
 *
 * Created on 16 de Fevereiro de 2006, 21:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaRamosBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.ramos.JDialogCadRamos;

import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;

import java.awt.Cursor;
import java.awt.event.ActionListener;


/**
 *
 * @author duduzera
 */
public class ListenerCadastroRamos implements ActionListener{

    /** Creates a new instance of ListenerCadastroRamos */
    public ListenerCadastroRamos(){

    }

    public void actionPerformed(java.awt.event.ActionEvent e){
	try{
	    StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
	    final PanelPesquisaGeneric panel = 
		new PanelPesquisaRamosBuilder().getJPanelpesquisaRamos();
	    StartFrame.getCurrentInstance().addJPanel(panel);

	} catch(Exception eee){
	    new EvilError(null, false, eee).setVisible(true);
	} finally{
	    StartFrame.getCurrentInstance()
		.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
    }
}
