package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.events.ListenerContasPagar;

import com.dudhoo.nemesis.swing.factory.menu.events.ListenerContasReceber;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MenuFinancasFactory{
    public MenuFinancasFactory(){
    }

    public JMenu getMenuFinanca(){
	JMenu menuContas = new JMenu();
	menuContas.setText("Finanças");
	menuContas.setToolTipText("Contas e controle financeiro");
	menuContas.setMnemonic('F');
	adicionarMenuContasPagar(menuContas);
	adicionarMenuContasReceber(menuContas);
	return menuContas;

    }

    private void adicionarMenuContasPagar(JMenu menu){
	JMenuItem menuItem = menu.add("Contas à pagar");
	menuItem.addActionListener(new ListenerContasPagar() );
    }

    private void adicionarMenuContasReceber(JMenu menu){
	JMenuItem menuItem = menu.add("Contas à receber");
	menuItem.addActionListener(new ListenerContasReceber() );
    }
}
