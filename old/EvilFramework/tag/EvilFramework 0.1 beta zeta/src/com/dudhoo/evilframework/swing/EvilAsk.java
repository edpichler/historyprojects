/*
 * EvilAsk.java
 *
 * Created on 13 de Fevereiro de 2006, 23:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.swing;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author duduzera
 */
public class EvilAsk {
    private Component c = null;
    /** Creates a new instance of EvilAsk */
    public EvilAsk(Component _c) {
           c = _c;
    }
    public int setVisible(String message){     
        return JOptionPane.showConfirmDialog(c , message, "Questão", JOptionPane.YES_NO_CANCEL_OPTION);       
    }
    
}
