package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.pessoa.listener.EditarPessoaFisicaListener;
import com.dudhoo.nemesis.swing.pessoa.listener.ExcluirPessoaFisicaListAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.InserirPessoaFisicaListAdapter;
import com.dudhoo.nemesis.swing.ramos.JDialogCadRamos;

import javax.swing.JOptionPane;

public class PanelPesquisaPessoaFisicaBuilder{
    public PanelPesquisaPessoaFisicaBuilder(){
    }
    
    /**@param botaoFechar Se for verdadeiro, cria o botao fechar
     */
    public PanelPesquisaGeneric getJPanelPesquisaPessoasFisicas(boolean botaoFechar, boolean isSelectable){
	final PanelPesquisaGeneric panel = new PanelPesquisaGeneric(botaoFechar, isSelectable) ;	    
	    panel.setName("Pessoas Físicas");            
	    panel.setSqlQueryToFilteredRowSet("select * from pessoa_fisica " + 
	                            "inner join pessoa on pessoa.id = pessoa_fisica.pessoa_id", 1);	    
	    
	    panel.setInserirListener(new InserirPessoaFisicaListAdapter());
	    panel.setEditarListener(new EditarPessoaFisicaListener(panel));	    
	    panel.setExcluirListener(new ExcluirPessoaFisicaListAdapter( panel ));
		
	    return panel;
    }   
}
