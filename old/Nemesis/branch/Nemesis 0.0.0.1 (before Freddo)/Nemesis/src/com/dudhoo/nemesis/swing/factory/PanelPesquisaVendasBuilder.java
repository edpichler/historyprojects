package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.EditarVendaMercadoriaListAdapter;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.ExcluirMovimentoMercadoriaListAdapter;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.InserirVendaMercadoriaListAdapter;


public class PanelPesquisaVendasBuilder{
    public PanelPesquisaVendasBuilder(){
    }

    public PanelPesquisaGeneric getPanelPesquisaVendas(boolean botaoFechar, 
					 boolean isSelectable){
	final PanelPesquisaGeneric panel = 
	    new PanelPesquisaGeneric(botaoFechar, isSelectable);
	panel.setName("Saída de mercadorias");
	panel.setSqlQueryToFilteredRowSet("select movimento_estoque.id as id,  pessoa.EMAIL, produto.NOME as produto, movimento_estoque.QUANTIDADE, movimento_estoque.PRECO_UNITARIO, MOVIMENTO_ESTOQUE.PRECO_UNITARIO * MOVIMENTO_ESTOQUE.QUANTIDADE as Valor_Total\n" + 
				   "from ((movimento_estoque inner join produto on produto.id = movimento_estoque.produto_id) inner join pessoa on pessoa.id = movimento_estoque.pessoa_id )\n" + 
				   "where quantidade > 0", 1);

	panel.setInserirListener(new InserirVendaMercadoriaListAdapter());
	panel.setEditarListener(new EditarVendaMercadoriaListAdapter(panel));
	panel.setExcluirListener(new ExcluirMovimentoMercadoriaListAdapter(panel));

	return panel;
    }
}
