package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.pessoa.listener.EditarPessoaJuridicaAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.ExcluirPessoaJuridicaAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.InserirPessoaJuridicaAdapter;

public class PanelPesquisaPessoaJuridicaBuilder{
    public PanelPesquisaPessoaJuridicaBuilder(){
    }
    
    public PanelPesquisaGeneric getPanelPesquisarPessoaJuridica() throws Exception{
	PanelPesquisaGeneric panel = null;
	panel = new PanelPesquisaGeneric();	
	panel.setInserirListener(new InserirPessoaJuridicaAdapter());

	panel.setEditarListener(new EditarPessoaJuridicaAdapter(panel));

	panel.setExcluirListener(new ExcluirPessoaJuridicaAdapter(panel));
	panel.setName("Pessoas Jurídicas");
	StartFrame.getCurrentInstance().addJPanel(panel);
	panel.setSqlQueryToFilteredRowSet("select * from pessoa_juridica " + 
		    "inner join pessoa on pessoa.id = pessoa_juridica.pessoa_id", 1);
	return panel;
    }
}
