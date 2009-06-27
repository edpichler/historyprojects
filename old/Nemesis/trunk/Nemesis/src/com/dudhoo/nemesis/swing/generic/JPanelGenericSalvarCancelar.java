/*
 * JPanelGenericSalvarCancelar.java
 *
 * Created on 8 de Fevereiro de 2006, 22:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.generic;

import com.dudhoo.evilframework.components.BotaoCancelar20;
import com.dudhoo.evilframework.components.BotaoSalvar20;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.dudhoo.nemesis.swing.*;

/**
 *
 * @author duduzera
 */
public class JPanelGenericSalvarCancelar  extends AbstractJPanelGeneric {
    
    /** Creates a new instance of JPanelGenericSalvarCancelar */
    public JPanelGenericSalvarCancelar() {
        init();
    }
    private void fecha(){
        super.fecharPanel();        
    }
    private void init(){
        BotaoCancelar20  cancel = new BotaoCancelar20();
        cancel.setMnemonic('c');
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent eee){
                fecha();
            }
        });
        
        BotaoSalvar20 save = new BotaoSalvar20();
        save.setMnemonic('S');
        super.addButtonAtBottom(save);
        super.addButtonAtBottom(cancel);
    }
}