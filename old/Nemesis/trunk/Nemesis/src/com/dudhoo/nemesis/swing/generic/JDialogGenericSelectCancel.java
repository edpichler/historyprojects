package com.dudhoo.nemesis.swing.generic;

import com.dudhoo.evilframework.components.BotaoSelecionar20;
import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author duduzera
 */
public class JDialogGenericSelectCancel extends JDialogGenericCancel{
    private SelectPressListener selectPressListener; 
    
    /** Creates a new instance of JDialogGenericSelectCancel */
    public JDialogGenericSelectCancel(Frame parent, boolean modal) {
        super(parent, modal);
        init();
    }
    private void init(){
        BotaoSelecionar20 bc = new BotaoSelecionar20();
        bc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setOpcao(OpcaoEscolhida.SELECT);
                if(getSelectPressListener() != null){
                    getSelectPressListener().doAfterClick();
                }                
            }
        });
        super.addBotaoAtBottom(bc);
    }

    public SelectPressListener getSelectPressListener() {
        return selectPressListener;
    }

    public void setSelectPressListener(SelectPressListener selectPressListener) {
        this.selectPressListener = selectPressListener;
    }
    
}
