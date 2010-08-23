package com.dudhoo.farmaco.swing.event;

import com.dudhoo.evilframework.components.DuduPanelImage;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.eventListeners.DialogAboutListener;

import com.dudhoo.farmaco.app.Application;

import com.dudhoo.farmaco.swing.StartFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutAdapter implements DialogAboutListener{
    public JPanel getPanel() {
       DuduPanelImage panel = null;
        try {
            panel = new DuduPanelImage();             
            panel.setImagem(new javax.swing.ImageIcon(getClass().getResource("/resources/official.png")));            
        } catch (Exception e) {
            new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);
        }
        return panel;
    }

    public String getTabName() {
        return Application.getConfiguration().getString(Application.APP_NAME);
    }

    public Dimension getSize() {
        return new Dimension(430,380);
    }
}
