package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;
import com.dudhoo.nemesis.swing.contas.JDialogContaReceber;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;

public class InserirContaReceber implements InserirPressListener{
    Frame panel;
    boolean modal;

    public InserirContaReceber(Frame _panel, boolean _modal){
	panel = _panel;
	modal = _modal;
    }

    public void doAfterClick(){
	new JDialogContaReceber(panel, modal).setVisible(true);
    }
}
