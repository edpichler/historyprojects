package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;

import java.awt.Frame;

public class InserirContaPagar implements InserirPressListener{
    private Frame parent;
    private boolean modal;

    public InserirContaPagar(Frame _parent, boolean _modal){
	parent = _parent;
	modal = _modal;
    }

    public void doAfterClick(){
	new JDialogContaPagar(parent, modal).setVisible(true);
    }
}
