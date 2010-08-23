package com.dudhoo.evilframework.components;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoRefresh16 extends JButton{
    public BotaoRefresh16(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	setToolTipText("Atualizar");
	setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dudhoo/evilframework/resources/images/Refresh16.gif")));
	this.setSize(new Dimension(346, 100));
    }
}
