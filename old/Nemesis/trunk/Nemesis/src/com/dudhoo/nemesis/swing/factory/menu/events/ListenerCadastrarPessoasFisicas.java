package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaPessoaFisicaBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author duduzera
 */
public class ListenerCadastrarPessoasFisicas implements ActionListener{
    PanelPesquisaGeneric panel = null;

    /**
     * Creates a new instance of ListenerCadastrarPessoas
     */
    public ListenerCadastrarPessoasFisicas(){
	
    }

    public void actionPerformed(ActionEvent e){
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
	panel = new PanelPesquisaPessoaFisicaBuilder().getJPanelPesquisaPessoasFisicas(true, false);	
	
	StartFrame.getCurrentInstance().addJPanel(panel);
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

   
    
}
