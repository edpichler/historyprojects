/*
 * JDialogGenericCancel.java
 *
 * Created on 17 de Fevereiro de 2006, 00:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.generic;

import com.dudhoo.evilframework.components.BotaoCancelar20;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author duduzera
 */
public class JDialogGenericCancel extends JDialogGeneric{
    private OpcaoEscolhida opcao = OpcaoEscolhida.CANCEL;
    /**
     * Creates a new instance of JDialogGenericCancel 
     */
    public JDialogGenericCancel(Frame parent, boolean modal) {
        super(parent, modal);
        init();
    }
    
    private void init(){        
        BotaoCancelar20 bc = new BotaoCancelar20();
        bc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setOpcao(OpcaoEscolhida.CANCEL);
                close();
            }
        });
        super.addBotaoAtBottom(bc);        
    }

    public OpcaoEscolhida getOpcao() {
        return opcao;
    }

    public void setOpcao(OpcaoEscolhida opcao) {
        this.opcao = opcao;
    }
}
