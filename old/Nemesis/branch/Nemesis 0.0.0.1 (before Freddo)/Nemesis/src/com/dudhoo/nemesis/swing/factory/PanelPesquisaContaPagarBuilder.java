package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.event.EditarContaPagar;
import com.dudhoo.nemesis.swing.contas.event.ExcluirContaPagar;
import com.dudhoo.nemesis.swing.contas.event.InserirContaPagar;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

public class PanelPesquisaContaPagarBuilder{
    public PanelPesquisaContaPagarBuilder(){
    }
    public PanelPesquisaGeneric getPanelPesquisarContasPagar(boolean criaBotaoFechar,
							  boolean isSelectable){
	final PanelPesquisaGeneric panel =
	    new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
	//panel.setInserirListener();
	panel.setName("Contas à pagar");
	StartFrame.getCurrentInstance().addJPanel(panel);
	panel.setSqlQueryToFilteredRowSet("select *  from conta_pagar " +
			"inner join conta_financeira " +
			"on conta_pagar.ID = CONTA_FINANCEIRA.ID ",
				   1);
	panel.setInserirListener(new InserirContaPagar(StartFrame.getCurrentInstance(),true));
	panel.setEditarListener(new EditarContaPagar(panel,true));
	panel.setExcluirListener(new ExcluirContaPagar(panel,true));
	return panel;
    }
}
