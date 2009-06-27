package com.dudhoo.evilframework.components;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoLimpar24 extends JButton {
    public BotaoLimpar24() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(192, 29)); 
        setIcon(new ImageIcon(getClass().getResource("/com/dudhoo/evilframework/resources/images/stock_clear_24.png")));
    }
}
