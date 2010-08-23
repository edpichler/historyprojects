package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.swing.factory.menu.events.AbrePesquisaMovEstoqueAdapter;

import com.dudhoo.nemesis.swing.factory.menu.events.AbreRelatorios;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuRelatoriosFactory{
    
    public MenuRelatoriosFactory(){
    }
    
    public JMenu getMenuRelatorios(){
	JMenu menuContas = new JMenu();
	menuContas.setText("Relatórios");
	menuContas.setToolTipText(menuContas.getText());
	menuContas.setMnemonic('R');
	adicionarMenus(menuContas);       
	return menuContas;

    }

    private void adicionarMenus(JMenu menu){
	File pathRelatorios = new File(Application.getConfiguration().getString(Application.BIRT_REPORTS_HOME));
	
	File reports[] = pathRelatorios.listFiles();
	for (int i = 0; i < reports.length; i++)  {
	    if(reports[i].isFile() && reports[i].getAbsolutePath().endsWith(".rptdesign") ){
	        JMenuItem menuItem = menu.add(reports[i].getAbsolutePath());	        
		menuItem.addActionListener( new AbreRelatorios(reports[i]));	    
	    }
	}
	

    }    
}
