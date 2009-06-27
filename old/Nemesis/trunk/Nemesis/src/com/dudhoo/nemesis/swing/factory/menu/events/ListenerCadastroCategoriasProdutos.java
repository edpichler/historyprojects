package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaCategoriasProdutosBuilder;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaTipoContaBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCadastroCategoriasProdutos implements ActionListener{
    public ListenerCadastroCategoriasProdutos() {
    }
    public void actionPerformed(ActionEvent evt){
        try{           
            StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));            
            final PanelPesquisaGeneric panel = 
                new PanelPesquisaCategoriasProdutosBuilder().getPanelCategorias(false, false);
            StartFrame.getCurrentInstance().addJPanel(panel);
        } catch(Exception eee){
            new EvilError(null, false, eee).setVisible(true);
        } finally{
            StartFrame.getCurrentInstance()
                .setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }    
}

