package com.dudhoo.farmaco.swing.menu;

import com.dudhoo.farmaco.swing.menu.event.PrincipioAtivosActionListAdapter;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuBuilder{
    public MenuBuilder(){
    }
    
    public JMenu getMenuMedicamentos(){
	JMenu jmenu = new JMenu("Medicamentos");
	jmenu.setMnemonic('M');
	createMenuItemPrincipioAtivos(jmenu);
	return jmenu;
    }

    private void createMenuItemPrincipioAtivos(JMenu menu){
	JMenuItem mPri = menu.add("Principios Ativos");
	mPri.addActionListener(new PrincipioAtivosActionListAdapter());
    }
}
