
package com.dudhoo.evilframework.swing;

import com.dudhoo.evilframework.swing.eventListeners.DialogAboutListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import java.util.Properties;
import java.util.ResourceBundle;

import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import java.util.Iterator;

/**
 *
 * @author  dudu
 */
public class JDialogAbout extends JDialog{
    private JButton jButton1;
    private JTabbedPane jPanelCenter = new JTabbedPane();
    private JPanel jPanelSouth;
    private final static String TAB_SYSTEM = "System";      
    int height, width;
    private JPanel panelSystem = new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JTextArea jTextArea1 = new JTextArea();

    private DialogAboutListener aboutListener;
    
    /** Creates new form JDialogAbout */
    public JDialogAbout(Frame parent, boolean modal) {
        super(parent, ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary").getString("about") , modal);
        jbInit();
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */    
    private void jbInit() {
        jPanelSouth = new JPanel();
        jButton1 = new JButton();       

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	this.setSize(new Dimension(400, 300));
	jPanelSouth.setBorder(new EtchedBorder());
	panelSystem.setLayout(borderLayout1);
	jButton1.setMnemonic('k');
        jButton1.setText(ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary").getString("Ok"));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelSouth.add(jButton1);
        getContentPane().add(jPanelSouth, BorderLayout.SOUTH);
	jScrollPane1.getViewport().add(jTextArea1, null);
	panelSystem.add(jScrollPane1, BorderLayout.CENTER);
	jPanelCenter.addTab(TAB_SYSTEM, panelSystem);
	getContentPane().add(jPanelCenter, BorderLayout.CENTER);
	initTabSystem();
    }
    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed     
        this.dispose();
    }
   
    
    private void initTabSystem(){
	Properties p = System.getProperties();	 
	for(Iterator iterator = p.entrySet().iterator();iterator.hasNext();) {
	    Object boejX = (Object) iterator.next();
	    this.jTextArea1.append(boejX + "\n");
	}
	
	
    }

    public void setAboutListener(DialogAboutListener aboutListener){
        this.aboutListener = aboutListener;
        this.setSize(aboutListener.getSize());
        if(aboutListener != null){
            this.jPanelCenter.addTab(this.aboutListener.getTabName(), this.aboutListener.getPanel());
            this.jPanelCenter.addTab(TAB_SYSTEM, panelSystem);      
        }	
    }

    public DialogAboutListener getAboutListener(){
	return aboutListener;
    }
}