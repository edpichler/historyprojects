/*
 * EvilInformation.java
 *
 * Created on 13 de Fevereiro de 2006, 20:02
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
public class EvilInformation {
    private Component c = null;
    /** Creates a new instance of EvilInformation */
    public EvilInformation(Component _c) {
        c = _c;
    }
    public void showMessage(String mensagem){
        JOptionPane.showMessageDialog(c , mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
