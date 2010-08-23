/*
 * JDialogGenericSaveCancel.java
 *
 * Created on 8 de Fevereiro de 2006, 23:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.generic;

import com.dudhoo.evilframework.components.BotaoCancelar20;
import com.dudhoo.evilframework.components.BotaoSalvar20;
import com.dudhoo.nemesis.event.SavePressListener;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.*;

/**
 *
 * @author duduzera
 */
public class JDialogGenericSaveCancel extends JDialogGeneric {
     
    private OpcaoEscolhida opcao = OpcaoEscolhida.CANCEL;
    
    private SavePressListener savePressListener = null;
    /** Creates a new instance of JDialogGenericSaveCancel */
    public JDialogGenericSaveCancel(Frame  parent, boolean modal, String title) {
        super(parent, modal);
	this.setTitle(title);
        jbInit2();
    }
    private void jbInit2(){	
        BotaoSalvar20 bs = new BotaoSalvar20();
        bs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(savePressListener != null){
                    setOpcao(OpcaoEscolhida.SAVE);
                    savePressListener.doAfterClick();
                }
            }
        });
        
        BotaoCancelar20 bc = new BotaoCancelar20();
        bc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setOpcao(OpcaoEscolhida.CANCEL);
                close();
            }
        });
        
        super.addBotaoAtBottom(bs);
        super.addBotaoAtBottom(bc);
    }
    
    public SavePressListener getSavePressListener() {
        return savePressListener;
    }
    
    public void setSavePressListener(SavePressListener savePressListener) {
        this.savePressListener = savePressListener;
    }
    
    /**
     *
     * @return
     * @see OpcaoEscolhida
     */
    public OpcaoEscolhida getOpcao() {
        return opcao;
    }
    /**@see OpcaoEscolhida*/
    public void setOpcao(OpcaoEscolhida opcao) {
        this.opcao = opcao;
    }
    
}
