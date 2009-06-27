package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.EditarEntraMercadoriaListAdapter;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.ExcluirMovimentoMercadoriaListAdapter;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.InserirEntraMercadoriaListAdapter;


public class PanelPesquisaComprasBuilder {
    public PanelPesquisaComprasBuilder() {
    }

    /**@param botaoFechar Se for verdadeiro, cria o botao fechar
     */
    public PanelPesquisaGeneric getJPanelPesquisaCompras(boolean botaoFechar, 
                                                         boolean isSelectable) {
        final PanelPesquisaGeneric panel = 
            new PanelPesquisaGeneric(botaoFechar, isSelectable);
        panel.setName("Entrada de mercadorias");
        panel.setSqlQueryToFilteredRowSet("select \n" + 
                                          "  movimento_estoque.id as Código, \n" + 
                                          "  pessoa.NOME as \"Pessoa\", \n" + 
                                          "  produto.NOME as produto,\n" + 
                                          "  TO_CHAR(MOVIMENTO_ESTOQUE.ULT_MOD , 'DD-MON-YYYY') as Data,\n" + 
                                          "  TO_CHAR(movimento_estoque.QUANTIDADE , '999999.99') as Quantidade ,    \n" + 
                                          "  concat('R$', TO_CHAR(movimento_estoque.PRECO_UNITARIO , '999,999.99')) as \"Preço Unitário\",     \n" + 
                                          "  concat('R$', TO_CHAR(MOVIMENTO_ESTOQUE.PRECO_UNITARIO * MOVIMENTO_ESTOQUE.QUANTIDADE  , '999,999.99')) as \"Valor Total\"\n" + 
                                          "    from ((movimento_estoque \n" + 
                                          "      inner join produto on produto.id = movimento_estoque.produto_id) \n" + 
                                          "      inner join pessoa on pessoa.id = movimento_estoque.pessoa_id )\n" + 
                                          "  order by \n" + 
                                          "    MOVIMENTO_ESTOQUE.ULT_MOD, \n" + 
                                          "    pessoa.ID, \n" + 
                                          "    \"Valor Total\", \n" + 
                                          "    movimento_estoque.QUANTIDADE\n" + 
                                          "    \n" + "    ", 1);

        panel.setInserirListener(new InserirEntraMercadoriaListAdapter());
        panel.setEditarListener(new EditarEntraMercadoriaListAdapter(panel));
        panel.setExcluirListener(new ExcluirMovimentoMercadoriaListAdapter(panel));

        return panel;
    }
}
