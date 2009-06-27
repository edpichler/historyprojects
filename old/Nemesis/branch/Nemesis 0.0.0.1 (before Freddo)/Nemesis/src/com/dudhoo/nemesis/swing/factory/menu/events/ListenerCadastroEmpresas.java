/*
 * ListenerCadastroEmpresas.java
 *
 * Created on 2 de Fevereiro de 2006, 21:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.StartFrame;
import java.awt.Cursor;
import java.awt.event.ActionListener;

/**
 *
 * @author duduzera
 */
public class ListenerCadastroEmpresas implements ActionListener {
    
    /**
     * Creates a new instance of ListenerCadastroEmpresas 
     */
    public ListenerCadastroEmpresas(){        
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
	PanelPesquisaGeneric panel = new PanelPesquisaGeneric();
        //panel.setInserirListener();
        panel.setName("Empresas/Filiais");
        StartFrame.getCurrentInstance().addJPanel(panel);
        panel.setSqlQueryToFilteredRowSet("select * from ((empresa inner join pessoa_juridica on pessoa_juridica.id = empresa.pessoa_juridica_id)" +
                " inner join pessoa on pessoa.id = pessoa_juridica.pessoa_id)",  1);
	StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }    
}