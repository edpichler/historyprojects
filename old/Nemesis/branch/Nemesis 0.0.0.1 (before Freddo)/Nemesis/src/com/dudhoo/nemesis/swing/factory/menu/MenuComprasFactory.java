package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.events.AbrePesquisaMovEstoqueAdapter;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MenuComprasFactory{
    public MenuComprasFactory(){
    }
    public JMenu getMenuCompras(){
	JMenu menuContas = new JMenu();
	menuContas.setText("Compras");
	menuContas.setToolTipText(menuContas.getText());
	menuContas.setMnemonic('O');
	adicionarMenuCompras(menuContas);	
	return menuContas;

    }

    private void adicionarMenuCompras(JMenu menu){
	JMenuItem menuItem = menu.add("Entrada de mercadorias");
	menuItem.addActionListener( new AbrePesquisaMovEstoqueAdapter());
    }    
}
