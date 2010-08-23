package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.events.MenuUsuariosAdapter;

import java.awt.event.InputEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuSegurancaFactory{
    public MenuSegurancaFactory(){
    }

    public JMenu getMenuSeguranca(){
	JMenu menu = new JMenu("Segurança");
	
	adicionaMenuUsuarios(menu);
	return menu;
    }

    private void adicionaMenuUsuarios(JMenu menu){
	JMenuItem menuItemUsuario = menu.add("Usuários");
	menuItemUsuario.setToolTipText("Usuários do sistema");
	menuItemUsuario.setAccelerator(KeyStroke.getKeyStroke('U', InputEvent.ALT_MASK + InputEvent.CTRL_MASK));
	menuItemUsuario.addActionListener(new MenuUsuariosAdapter());
    }
}
