package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.birt.EngineRelatorios;
import com.dudhoo.nemesis.swing.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;


public class AbreRelatorios implements ActionListener{
    private File file;

    public AbreRelatorios(File fileDesign){
	file = fileDesign;
    }

    public void actionPerformed(ActionEvent actionEvent){
	try{	   
	    EngineRelatorios engine = EngineRelatorios.getInstance();
	    engine.geraRelatorio(file);
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally{
	}
    }
}
