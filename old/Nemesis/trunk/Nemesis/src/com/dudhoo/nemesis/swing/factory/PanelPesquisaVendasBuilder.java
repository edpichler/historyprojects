package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.EditarVendaMercadoriaListAdapter;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.ExcluirMovimentoMercadoriaListAdapter;
import com.dudhoo.nemesis.swing.movimentoEstoque.event.InserirVendaMercadoriaListAdapter;


public class PanelPesquisaVendasBuilder {
    public PanelPesquisaVendasBuilder() {
    }

    public PanelPesquisaGeneric getPanelPesquisaVendas(boolean botaoFechar, 
                                                       boolean isSelectable) {
        final PanelPesquisaGeneric panel = 
            new PanelPesquisaGeneric(botaoFechar, isSelectable);
        panel.setName("Saída de mercadorias");
        panel.setSqlQueryToFilteredRowSet("select MOVIMENTO_ESTOQUE.ID as Código,\n" + 
                                          "  pessoa.NOME as Pessoa,\n" + 
                                          "  TIPO_CONTA.NOME as Conta,\n" + 
                                          "  CONCAT( 'R$',TO_CHAR(conta.VALOR, '999,999.99')) as Valor, \n" + 
                                          "  TO_CHAR(conta.DATA_PAGAMENTO, 'DD-MON-YYYY')  as \"Data Pagamento\",\n" + 
                                          "  (Case conta.CONTA_PAGA when 1 then 'Sim' else 'Não' end) as \"Conta Paga\",\n" + 
                                          "  obs.OBS as observações\n" + 
                                          "  from (((((CONTA_RECEBER \n" + 
                                          "  inner join conta_financeira conta on CONTA_RECEBER.ID = conta.ID)\n" + 
                                          "  inner join TIPO_CONTA on conta.TIPO_CONTA_ID = TIPO_CONTA.ID)  \n" + 
                                          "  inner join MOVIMENTO_ESTOQUE on MOVIMENTO_ESTOQUE.CONTA_FINANCEIRA_ID = conta.ID)\n" + 
                                          "  left join OBSERVACAO obs on obs.id = conta.OBSERVACAO_ID)\n" + 
                                          "  left join pessoa on conta.PESSOA_ID = PESSOA.ID)  \n" + 
                                          "  where TIPO_CONTA.CREDITO = 1\n" + 
                                          "  order by conta.DATA_PAGAMENTO desc, conta.VALOR, TIPO_CONTA.NOME", 
                                          1);

        panel.setInserirListener(new InserirVendaMercadoriaListAdapter());
        panel.setEditarListener(new EditarVendaMercadoriaListAdapter(panel));
        panel.setExcluirListener(new ExcluirMovimentoMercadoriaListAdapter(panel));

        return panel;
    }
}
