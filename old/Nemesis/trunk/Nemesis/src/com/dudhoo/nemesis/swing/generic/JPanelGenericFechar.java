/*
 * JPanelGenericFechar.java
 *
 * Created on 8 de Fevereiro de 2006, 22:21
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.generic;

import com.dudhoo.evilframework.components.BotaoFechar24;
import com.dudhoo.nemesis.swing.cidadesRegioes.JPanelCadCidadeRegioes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.dudhoo.nemesis.swing.*;


/**
 *
 * @author duduzera
 */
public class JPanelGenericFechar extends AbstractJPanelGeneric{
    
    /** Creates a new instance of JPanelGenericFechar */
    public JPanelGenericFechar() {
        super();
        init();
    }
     private void fecha(){
        super.fecharPanel();
    }
    private void init(){
        BotaoFechar24 fecha = new BotaoFechar24();
        fecha.setMnemonic('e');
         fecha.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent eee){
                fecha();
            }
        });
        super.addButtonAtBottom(fecha);
    }
}
