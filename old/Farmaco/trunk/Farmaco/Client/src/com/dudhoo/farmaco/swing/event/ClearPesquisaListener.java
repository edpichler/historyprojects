package com.dudhoo.farmaco.swing.event;

import com.dudhoo.farmaco.swing.PanelPesquisa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearPesquisaListener implements ActionListener{
    public void actionPerformed(ActionEvent actionEvent) {
        PanelPesquisa.getInstance().clearAll();
    }
}
