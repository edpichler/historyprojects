package com.dudhoo.farmaco.swing;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopUpMouseList implements MouseListener{
    private Component comp;
    public PopUpMouseList(Component _comp) {
        comp = _comp;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
    }

    public void mousePressed(MouseEvent mouseEvent) {
    }

    public void mouseReleased(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            SplitPopUp.getInstance()
            .show(comp, evt.getX(), evt.getY() );
        }
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }
}
