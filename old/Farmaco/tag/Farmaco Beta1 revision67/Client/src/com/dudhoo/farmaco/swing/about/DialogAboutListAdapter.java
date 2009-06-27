package com.dudhoo.farmaco.swing.about;

import com.dudhoo.evilframework.swing.interfaces.DialogAboutListener;

import javax.swing.JPanel;

public class DialogAboutListAdapter implements DialogAboutListener{

    public JPanel getPanel(){
	return new JPanel();
    }

    public String getTabName(){
	return "TODO";
    }
}
