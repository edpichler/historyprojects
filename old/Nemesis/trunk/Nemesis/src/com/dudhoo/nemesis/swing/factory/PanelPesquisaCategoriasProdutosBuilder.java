package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.event.EditarTipoContaAdapter;
import com.dudhoo.nemesis.swing.contas.event.ExcluirTipoContaAdapter;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.produto.categorias.event.EditarCategoriaAdapter;
import com.dudhoo.nemesis.swing.produto.categorias.event.ExcluirCategoriaAdapter;
import com.dudhoo.nemesis.swing.produto.categorias.event.InserirCategoriaAdapter;


public class PanelPesquisaCategoriasProdutosBuilder {
    public PanelPesquisaCategoriasProdutosBuilder() {
    }

    public PanelPesquisaGeneric getPanelCategorias(boolean criaBotaoFechar, 
                                                   boolean isSelectable) {
        final PanelPesquisaGeneric panel = 
            new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
        panel.setName("Categorias de produtos");
        StartFrame.getCurrentInstance().addJPanel(panel);
        panel.setSqlQueryToFilteredRowSet("select categoria_produto.id as código, " +
            "nome as Categoria, observacao.OBS as Observações from categoria_produto " +
            "left join observacao on observacao.id = categoria_produto.obs_id", 
                                          1);
        panel.setInserirListener(new InserirCategoriaAdapter());
        panel.setEditarListener(new EditarCategoriaAdapter(panel));
        panel.setExcluirListener(new ExcluirCategoriaAdapter(panel));
        return panel;
    }
}