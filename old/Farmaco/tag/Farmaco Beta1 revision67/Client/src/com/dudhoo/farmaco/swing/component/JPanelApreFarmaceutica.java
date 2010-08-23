package com.dudhoo.farmaco.swing.component;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class JPanelApreFarmaceutica extends JPanel{
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private JPanelListApresFarmaceutica jPanelAprsFar = new JPanelListApresFarmaceutica();
    private JPanelPosologia bor = new JPanelPosologia();
    
    public JPanelApreFarmaceutica(){
	try{
	    jbInit();
	    initListener();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(685, 488));
	this.setLayout(gridBagLayout1);
	bor.setBorder(BorderFactory.createTitledBorder("Posologia"));
	this.add(jPanelAprsFar, 
	  new GridBagConstraints(0, 0, 1, 1, 0.01, 0.01, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	this.add(bor, 
	  new GridBagConstraints(1, 0, 1, 1, 0.1, 0.01, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }

    public Set getApresentacaoFarmaceutica(){
	HashSet remedios = new HashSet();
	ArrayList <ApresentacaoFarmaceutica> farm = jPanelAprsFar.getAppresenta();
	if(farm != null){
	    for (int i = 0; i < farm.size(); i++)  {
		remedios.add(farm.get(i));
	    }
	}else{
	    remedios = null;
	}
	return remedios;	
    }

    private void initListener(){
	jPanelAprsFar.setPanelPosologia(bor);
    }

    public void setApresentacaoFarmaceutica(Set <ApresentacaoFarmaceutica> apps){
	if(apps != null){
	    ArrayList array = new ArrayList(apps);
	    this.jPanelAprsFar.setAppresenta(array);
	}else{
	    this.jPanelAprsFar.setAppresenta(null);
	}
    }
}
