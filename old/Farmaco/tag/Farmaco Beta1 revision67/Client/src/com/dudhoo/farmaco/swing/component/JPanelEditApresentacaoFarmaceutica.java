package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelEditApresentacaoFarmaceutica extends JPanel{

    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JPanelPosologia jPanelPosologia1 = new JPanelPosologia();
    private ApresentacaoFarmaceutica apresentacaoFarmaceutica;
    
    public JPanelEditApresentacaoFarmaceutica(){
	try{
	    jbInit();	    
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setLayout(gridBagLayout1);
	jLabel1.setText("Apres. Farmacêutica:");
	jPanelPosologia1.setBorder(BorderFactory.createTitledBorder("Posologia"));
	jPanelPosologia1.setToolTipText("Descrição da posologia");
	this.add(jTextField1, new GridBagConstraints(1, 0, 1, 1, 0.01, 0.01, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(20, 12, 0, 8), 0, 
					      0));
	this.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,GridBagConstraints.NORTH, GridBagConstraints.NONE, 
					  new Insets(20, 6, 0, 0), 0, 0));
	this.add(jPanelPosologia1, 
	  new GridBagConstraints(0, 1, 2, 1, 0.01, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 3, -6));
    }

    public void setApresentacaoFarmaceutica(ApresentacaoFarmaceutica apresentacaoFarmaceutica){
	this.apresentacaoFarmaceutica = apresentacaoFarmaceutica;
	if(this.apresentacaoFarmaceutica == null){
	    this.jPanelPosologia1.setPosologia(null);
	    this.jTextField1.setText(null);
	}else{
	    this.jPanelPosologia1.setPosologia(this.apresentacaoFarmaceutica.getPosologia());
	    this.jTextField1.setText( this.apresentacaoFarmaceutica.getDescricao() );
	}
    }

    public ApresentacaoFarmaceutica getApresentacaoFarmaceutica(){
	if(apresentacaoFarmaceutica == null){
	    apresentacaoFarmaceutica = new ApresentacaoFarmaceutica();	    
	}
	apresentacaoFarmaceutica.setDescricao(this.jTextField1.getText().trim());
	apresentacaoFarmaceutica.setPosologia( jPanelPosologia1.getPosologia());
	return apresentacaoFarmaceutica;
    }
}
