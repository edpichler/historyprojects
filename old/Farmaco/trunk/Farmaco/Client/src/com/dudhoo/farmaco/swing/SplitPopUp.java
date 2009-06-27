package com.dudhoo.farmaco.swing;

import com.dudhoo.farmaco.swing.event.ClearPesquisaListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;

public class SplitPopUp extends JPopupMenu {
    private static SplitPopUp instance;
    
    private SplitPopUp() {
        JMenuItem menuposition = this.add("Mudar orientação");      
        menuposition.setToolTipText("Muda a orientação dos componentes da tela");
        this.add(menuposition);
        menuposition.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent) {
                        int ori = PanelPesquisa.getInstance()
                        .getJSplitPane().getOrientation();
                        if(ori == JSplitPane.HORIZONTAL_SPLIT){
                            PanelPesquisa.getInstance().getJSplitPane()
                                .setOrientation( JSplitPane.VERTICAL_SPLIT);    
                        }else{
                            PanelPesquisa.getInstance().getJSplitPane()
                                .setOrientation( JSplitPane.HORIZONTAL_SPLIT);    
                        }                       
                        
                    }
                });
                
        JMenuItem menu = this.add("Limpar pesquisa");      
        menu.setToolTipText("Limpa os resultados de uma pesquisa");
        this.add(menu);
        menu.addActionListener(new ClearPesquisaListener());    
    }

    public static SplitPopUp getInstance() {
        if(instance == null){
            instance = new SplitPopUp();
        }
        return instance;
    }
}
