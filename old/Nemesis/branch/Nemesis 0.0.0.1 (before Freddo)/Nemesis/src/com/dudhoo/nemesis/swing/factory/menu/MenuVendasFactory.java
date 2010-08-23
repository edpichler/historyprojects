package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.events.MenuUsuariosAdapter;

import com.dudhoo.nemesis.swing.factory.menu.events.MenuVendasAdapter;

import java.awt.event.InputEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuVendasFactory{
    public JMenu getMenuVendas(){
	JMenu menu = new JMenu("Vendas");	
	adicionaMenuVendas(menu);
	return menu;
    }

    private void adicionaMenuVendas(JMenu menu){
	JMenuItem menuItemUsuario = menu.add("Vendas");	
	menuItemUsuario.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
	menuItemUsuario.addActionListener(new MenuVendasAdapter());
    }
}
