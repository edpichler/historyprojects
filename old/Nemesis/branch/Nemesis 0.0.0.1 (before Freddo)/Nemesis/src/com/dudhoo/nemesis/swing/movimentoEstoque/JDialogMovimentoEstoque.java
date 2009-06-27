package com.dudhoo.nemesis.swing.movimentoEstoque;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import com.dudhoo.nemesis.swing.movimentoEstoque.event.SalvaMovimentoAdapter;

import java.awt.Frame;


public class JDialogMovimentoEstoque extends JDialogGenericSaveCancel{
    PanelMovimentacaoEstoque panelMovimentacaoEstoque = null;
    PanelMovimentacaoEstoque.TIPO tipo;
    public JDialogMovimentoEstoque(Frame frame, boolean modal, PanelMovimentacaoEstoque.TIPO tipo){
	super(frame, modal, (tipo == tipo.ENTRADA ? "Entrada de produtos": "Saída de produtos"));
	this.tipo = tipo;
	setSize(400, 400);
	centralize();
	jbInit();
    }

    public void jbInit(){
	panelMovimentacaoEstoque = new PanelMovimentacaoEstoque(tipo);
	this.getContentPane().add(panelMovimentacaoEstoque);
	setSavePressListener(new SalvaMovimentoAdapter(this));
    }

    public PanelMovimentacaoEstoque getPanelMovimentacaoEstoque(){
	return panelMovimentacaoEstoque;
    }

    public void setMovimentoEstoque(MovimentoEstoque mov){
	panelMovimentacaoEstoque.setMovimentoEstoque(mov);
    }

    public MovimentoEstoque getMovimentoEstoque() throws ValidationException{
	return panelMovimentacaoEstoque.getMovimentoEstoque();
    }
}
