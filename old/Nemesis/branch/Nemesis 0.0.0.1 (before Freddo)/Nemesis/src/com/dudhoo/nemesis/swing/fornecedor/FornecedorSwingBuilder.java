package com.dudhoo.nemesis.swing.fornecedor;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.ramos.listeners.EditarPressListenerAdapter;
import com.dudhoo.nemesis.swing.ramos.listeners.ExcluirPressListenerAdapter;
import com.dudhoo.nemesis.swing.ramos.listeners.InserirPressListenerAdapter;

public class FornecedorSwingBuilder{
    public PanelPesquisaGeneric esquisa;

    public PanelPesquisaGeneric createPanelPesquisa(){
	final PanelPesquisaGeneric panel = 
	    new PanelPesquisaGeneric(false, false);
	panel.setName("Fornecedores");
	panel.setSqlQueryToFilteredRowSet("SELECT pessoa_id, fantasia FROM pessoa_juridica order by fantasia", 1);	
	return panel;

    }
}
