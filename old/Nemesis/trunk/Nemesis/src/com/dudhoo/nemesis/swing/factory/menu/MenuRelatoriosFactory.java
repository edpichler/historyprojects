package com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.swing.factory.menu.events.AbrePesquisaMovEstoqueAdapter;

import com.dudhoo.nemesis.swing.factory.menu.events.AbreRelatorios;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuRelatoriosFactory {

    public MenuRelatoriosFactory() {
    }

    public JMenu getMenuRelatorios() {
        JMenu menuContas = new JMenu();
        menuContas.setText("Relatórios");
        menuContas.setToolTipText(menuContas.getText());
        menuContas.setMnemonic('R');
        adicionarMenus(menuContas);
        return menuContas;

    }

    private void adicionarMenus(JMenu menu) {
        String pathRelatorios = 
            new File(Application.getConfiguration().getString(Application.BIRT_REPORTS_HOME)).getAbsolutePath();
        
        File reports[] = new File[4];
        reports[0] = new File(pathRelatorios + File.separator + 
        "Contas pagar.rptdesign");
        reports[1] = new File(pathRelatorios + File.separator + 
        "contas receber.rptdesign");
        reports[2] = new File(pathRelatorios + File.separator + 
        "ranking dos vendedores.rptdesign");
        reports[3] = new File(pathRelatorios + File.separator + 
        "vendas.rptdesign");
        
        JMenuItem menuItem[] = new JMenuItem[4];
        for (int i = 0; i < menuItem.length; i++)  {
            menuItem[i] = new JMenuItem();
            menu.add(menuItem[i]);
        }        
        
        menuItem[0].setText("Contas à pagar");
        menuItem[1].setText("Contas à receber");
        menuItem[2].setText("Ranking dos vendedores");
        menuItem[3].setText("Vendas");
        
        menuItem[0].addActionListener(new AbreRelatorios(reports[0]));
        menuItem[1].addActionListener(new AbreRelatorios(reports[1]));
        menuItem[2].addActionListener(new AbreRelatorios(reports[2]));
        menuItem[3].addActionListener(new AbreRelatorios(reports[3]));
    }
}
