package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.event.EditarContaReceber;
import com.dudhoo.nemesis.swing.contas.event.ExcluirContaReceber;
import com.dudhoo.nemesis.swing.contas.event.InserirContaReceber;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;


public class PanelPesquisaContaReceberBuilder {
    public PanelPesquisaContaReceberBuilder() {
    }

    public PanelPesquisaGeneric getPanelPesquisarContasReceber(boolean criaBotaoFechar, 
                                                               boolean isSelectable) {
        final PanelPesquisaGeneric panel = 
            new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
        //panel.setInserirListener();
        panel.setName("Contas à receber");
        StartFrame.getCurrentInstance().addJPanel(panel);
        panel.setSqlQueryToFilteredRowSet("select \n" + 
                                          "  CONTA_RECEBER.ID as Código,  \n" + 
                                          "  pessoa.NOME as Pessoa,\n" + 
                                          "  TIPO_CONTA.NOME as Conta,\n" + 
                                          "  CONCAT( 'R$',TO_CHAR(CONTA_FINANCEIRA.VALOR, '999,999.99')) as Valor,  \n" + 
                                          "  TO_CHAR(CONTA_FINANCEIRA.DATA_PAGAMENTO, 'DD-MON-YYYY')  as \"Data Pagamento\",\n" + 
                                          "  (Case CONTA_FINANCEIRA.CONTA_PAGA when 1 then 'Sim' else 'Não' end) as \"Conta Paga\",\n" + 
                                          "  OBSERVACAO.OBS as observações\n" + 
                                          "  from ((((CONTA_RECEBER \n" + 
                                          "        inner join conta_financeira on CONTA_RECEBER.ID = CONTA_FINANCEIRA.ID)\n" + 
                                          "        inner join TIPO_CONTA on CONTA_FINANCEIRA.TIPO_CONTA_ID = TIPO_CONTA.ID)\n" + 
                                          "        left join OBSERVACAO on OBSERVACAO.id = CONTA_FINANCEIRA.OBSERVACAO_ID)\n" + 
                                          "        left join pessoa on CONTA_FINANCEIRA.PESSOA_ID = PESSOA.ID)\n" + 
                                          "  order by CONTA_FINANCEIRA.DATA_PAGAMENTO desc, valor, TIPO_CONTA.NOME ", 
                                          1);
        panel.setInserirListener(new InserirContaReceber(StartFrame.getCurrentInstance(), 
                                                         true));
        panel.setEditarListener(new EditarContaReceber(panel, true));
        panel.setExcluirListener(new ExcluirContaReceber(panel));
        return panel;
    }
}
