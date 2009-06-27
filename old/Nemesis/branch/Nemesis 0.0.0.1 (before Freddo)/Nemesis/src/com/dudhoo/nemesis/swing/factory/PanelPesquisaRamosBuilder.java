/*
 * PanelPesquisaRamosFactory.java
 *
 * Created on 17 de Fevereiro de 2006, 00:37
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;
import com.dudhoo.nemesis.swing.ramos.listeners.EditarPressListenerAdapter;
import com.dudhoo.nemesis.swing.ramos.listeners.ExcluirPressListenerAdapter;
import com.dudhoo.nemesis.swing.ramos.listeners.InserirPressListenerAdapter;

import javax.swing.JOptionPane;

/**
 *
 * @author duduzera
 */
public class PanelPesquisaRamosBuilder {
    
    /** Creates a new instance of PanelPesquisaRamosFactory */
    public PanelPesquisaRamosBuilder() {
        
    }
    /**Traz o panelMovimentacaoEstoque com o botao fechar no panelMovimentacaoEstoque sul
     */
    public PanelPesquisaGeneric getJPanelpesquisaRamos(){
        return getJPanelpesquisaRamos(true, false);
    
    }
    /**@param botaoFechar Se for verdadeiro, cria o botao fechar
     */
    public PanelPesquisaGeneric getJPanelpesquisaRamos(boolean botaoFechar, boolean isSelectable){
        final PanelPesquisaGeneric panel = new PanelPesquisaGeneric(botaoFechar, isSelectable) ;            
            panel.setName("Ramos de negócio");            
            panel.setSqlQueryToFilteredRowSet("SELECT * FROM RAMO", 1);
            
            panel.setInserirListener(new InserirPressListenerAdapter());
            
            panel.setEditarListener(new EditarPressListenerAdapter(panel));
	    
	    panel.setExcluirListener(new ExcluirPressListenerAdapter(panel) );
            return panel;
    }
   
    
}
