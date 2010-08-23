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
	panel.setSqlQueryToFilteredRowSet("select \n" + 
	"  pessoa.id as Código,\n" + 
	"  pessoa.nome as Fornecedor,\n" + 
	"  pessoa.TELEFONE_COMERCIAL as telefone,\n" + 
	"  pessoa.EMAIL as email\n" + 
	"  from PESSOA order by pessoa.nome", 1);	
	return panel;

    }
}
