package com.dudhoo.nemesis.swing.movimentoEstoque.event;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoque;
import com.dudhoo.nemesis.swing.movimentoEstoque.PanelMovimentacaoEstoque;

public class InserirVendaMercadoriaListAdapter implements InserirPressListener{
    public void doAfterClick(){
	JDialogMovimentoEstoque dia = new JDialogMovimentoEstoque(StartFrame.getCurrentInstance(), true, PanelMovimentacaoEstoque.TIPO.SAIDA);
	dia.setVisible(true);
    }
}
