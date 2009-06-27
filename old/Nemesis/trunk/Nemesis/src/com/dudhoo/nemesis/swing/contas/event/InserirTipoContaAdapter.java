package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.tipo.JDialogTipoContas;

public class InserirTipoContaAdapter implements InserirPressListener{
    public InserirTipoContaAdapter() {
    }
    
    public void doAfterClick(){
        JDialogTipoContas dia = new JDialogTipoContas(StartFrame.getCurrentInstance(), true);
        dia.setVisible(true);
    }
}

