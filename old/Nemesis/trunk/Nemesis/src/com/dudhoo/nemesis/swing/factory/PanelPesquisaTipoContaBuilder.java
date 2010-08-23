package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.cidadesRegioes.JPanelCadCidadeRegioes;
import com.dudhoo.nemesis.swing.contas.event.EditarTipoContaAdapter;
import com.dudhoo.nemesis.swing.contas.event.ExcluirTipoContaAdapter;
import com.dudhoo.nemesis.swing.contas.event.InserirTipoContaAdapter;
import com.dudhoo.nemesis.swing.generic.JPanelGenericFechar;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

public class PanelPesquisaTipoContaBuilder {
    public PanelPesquisaTipoContaBuilder() {
    }

    public PanelPesquisaGeneric getPanelTipoContas(boolean criaBotaoFechar, 
                                                   boolean isSelectable) {
        final PanelPesquisaGeneric panel = 
            new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
        panel.setName("Tipos de Contas Financeiras");
        StartFrame.getCurrentInstance().addJPanel(panel);
        panel.setSqlQueryToFilteredRowSet("select id as código, nome as Conta, " + 
                                          "descricao as descrição from tipo_conta", 
                                          1);
        panel.setInserirListener(new InserirTipoContaAdapter());
        panel.setEditarListener(new EditarTipoContaAdapter(panel));
        panel.setExcluirListener(new ExcluirTipoContaAdapter(panel));
        return panel;
    }
}
