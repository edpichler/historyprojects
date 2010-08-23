package com.dudhoo.nemesis.swing.ramos.listeners;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.ramos.JDialogCadRamos;

public class InserirPressListenerAdapter implements InserirPressListener{
    public InserirPressListenerAdapter(){
    }

    public void doAfterClick(){
	JDialogCadRamos cidr = new JDialogCadRamos( StartFrame.getCurrentInstance(), true);
	String title = "Ramos de negócio";
	cidr.setVisible(true);
    }
}
