package com.dudhoo.evilframework.swing.eventListeners;

import com.dudhoo.evilframework.swing.EvilMain;
import com.dudhoo.evilframework.swing.JDialogAbout;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 *
 * @author dudu
 */
public interface DialogAboutListener {    
    public JPanel getPanel();
    public String getTabName();

    public Dimension getSize() ;
}
