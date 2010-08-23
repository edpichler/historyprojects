package com.dudhoo.evilframework.swing.dialog;

import com.dudhoo.evilframework.components.BotaoFechar24;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class EvilDialogClose extends AbstractDialog{
    private JPanel panelBottom = new JPanel();
    private BorderLayout borderLayout1 = new BorderLayout();
    private BotaoFechar24 botaoFechar = new BotaoFechar24();

    public EvilDialogClose(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.getContentPane().setLayout(borderLayout1);
	panelBottom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
	botaoFechar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoFechar241_actionPerformed(e);
		    }
		});
	panelBottom.add(botaoFechar, null);
	this.getContentPane().add(panelBottom, BorderLayout.SOUTH);
    }

    private void botaoFechar241_actionPerformed(ActionEvent e){
	super.setBotaoClicado(BotaoConstants.CLOSE);
	this.closeDialog();
    }
}
