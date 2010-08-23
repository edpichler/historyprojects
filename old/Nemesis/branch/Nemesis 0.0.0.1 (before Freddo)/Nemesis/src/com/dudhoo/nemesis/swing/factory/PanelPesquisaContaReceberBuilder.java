package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.event.EditarContaReceber;
import com.dudhoo.nemesis.swing.contas.event.ExcluirContaReceber;
import com.dudhoo.nemesis.swing.contas.event.InserirContaReceber;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;


public class PanelPesquisaContaReceberBuilder{
    public PanelPesquisaContaReceberBuilder(){
    }

    public PanelPesquisaGeneric getPanelPesquisarContasReceber(boolean criaBotaoFechar,
							  boolean isSelectable){
	final PanelPesquisaGeneric panel =
	    new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
	//panel.setInserirListener();
	panel.setName("Contas à receber");
	StartFrame.getCurrentInstance().addJPanel(panel);
	panel.setSqlQueryToFilteredRowSet("select * from conta_receber " +
			"inner join conta_financeira " +
			"on conta_receber.ID = CONTA_FINANCEIRA.ID ",
				   1);
	panel.setInserirListener(new InserirContaReceber(StartFrame.getCurrentInstance(), true));
	panel.setEditarListener(new EditarContaReceber(panel, true));
	panel.setExcluirListener(new ExcluirContaReceber(panel));
	return panel;
    }
}
