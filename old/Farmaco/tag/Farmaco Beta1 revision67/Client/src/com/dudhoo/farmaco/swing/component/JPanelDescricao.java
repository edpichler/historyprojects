package com.dudhoo.farmaco.swing.component;

import com.dudhoo.evilframework.components.BotaoLimpar16;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;


public class JPanelDescricao extends JPanel{
    private BorderLayout borderLayout1 = new BorderLayout();
    private JToolBar jToolBar1 = new JToolBar();
    private BotaoLimpar16 botaoLimpar = new BotaoLimpar16();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextPane textPane = new JTextPane();

    public void addTextFocusListener(FocusListener focus){
	textPane.addFocusListener(focus);
    }

    public String getText(){
	StringBuffer buf = new StringBuffer(this.textPane.getText().trim());
	if(buf.length() == 0){
	    return buf.toString();
	}else{
	    if(buf.substring(buf.length() - 1, buf.length()).equals(".") == false){
		buf.append(".");
	    }
	    buf = new StringBuffer(buf);
	    buf.replace(0,1, new String(new char[]{ buf.charAt(0)}).toUpperCase() );
	    return buf.toString();
	}
    }

    public JPanelDescricao(){
	try{
	    jbInit();
	    initListeners();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(499, 298));
	this.setBorder(BorderFactory.createTitledBorder("Descrição"));
	this.setLayout(borderLayout1);
	botaoLimpar.setToolTipText("Limpar a descrição");
	jToolBar1.add(botaoLimpar, null);
	this.add(jToolBar1, BorderLayout.NORTH);
	jScrollPane1.getViewport().add(textPane, null);
	this.add(jScrollPane1, BorderLayout.CENTER);
    }

    private void initListeners(){
	this.botaoLimpar.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e){
		textPane.setText(null);
	    }
	});
    }
    public String getDescricao(){
	return this.getText();
    }
    public void setDescricao(String text){
	setText(text);
    }
    public void setText(String text){
	this.textPane.setText(text);
    }

    public JTextPane getTextPane(){
	return textPane;
    }

    public void setBotaoLimpar(BotaoLimpar16 botaoLimpar){
	this.botaoLimpar = botaoLimpar;
    }

    public BotaoLimpar16 getBotaoLimpar(){
	return botaoLimpar;
    }
}
