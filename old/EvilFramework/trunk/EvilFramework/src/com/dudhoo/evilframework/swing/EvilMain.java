package com.dudhoo.evilframework.swing;

import com.dudhoo.evilframework.swing.eventListeners.EventosTecladoGerenciador;
import com.dudhoo.evilframework.swing.eventListeners.DialogAboutListener;

import com.dudhoo.evilframework.util.ExitApplicationUtil;

import java.awt.Dimension;

import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.JToolBar;

import org.apache.log4j.Logger;

public class EvilMain extends JFrame{
    private javax.swing.JMenuItem aboutMenuItem;

    private javax.swing.JMenuItem contentsMenuItem;

    private javax.swing.JMenuItem exitMenuItem;

    private javax.swing.JMenu fileMenu;

    private javax.swing.JMenu helpMenu;

    private javax.swing.JMenuItem jMenuEnvironmentPreferences;

    private javax.swing.JMenu jMenuSystem;

    private javax.swing.JSeparator jSeparator1;

    private javax.swing.JSeparator jSeparator2;

    private javax.swing.JTabbedPane jTabbedPanePrincipal;

    private javax.swing.JToolBar jToolBarPrincipal;

    private javax.swing.JMenuBar menuBar;

    private DialogAboutListener dialogAboutListener = null;


    private Logger log = Logger.getLogger(this.getClass());

    public EvilMain(String title){
	super(title);
	try{
	    jbInit();
	    initDudu();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void initDudu(){
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	adicionaEventosGlobaisTeclado();

    }

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt){

	openFrameAbout();

    }


     /**Abre o form about
     */
    public void openFrameAbout(){
	JDialogAbout about = new JDialogAbout(this, true);	
	about.setLocationRelativeTo(null);

	if(this.getDialogAboutListener() != null){	
	    about.setAboutListener(getDialogAboutListener());
	}
	about.setVisible(true);
	about = null;
    }

    /**
     * Adiciona um JPanel no Form Principal
     */
    public void addJPanel(JPanel panel){
	if(panel != null){
	    this.jTabbedPanePrincipal.add(panel);
	    this.jTabbedPanePrincipal.setSelectedComponent(panel);
	} else {
	    this.log.info("JPanel não foi adicionado, pois era nullo.");
	}
    }

    /**Adiciona um menu no MenuBar
     */
    protected JMenu addMenu(JMenu item){
	if(item != null){
	    this.menuBar.add(item);
	    //para posicionar no lugar certo, adiciona novamente
	    this.menuBar.add(this.jMenuSystem);
	    this.menuBar.add(this.helpMenu);
	    return item;
	} else {
	    this.log.info("JPanel não foi adicionado, pois era nullo.");
	    return null;
	}
    }

    public JTabbedPane getJTabbedPanePrincipal(){
	if(this.jTabbedPanePrincipal == null){
	    this.jTabbedPanePrincipal = new JTabbedPane();
	}
	return this.jTabbedPanePrincipal;
    }

    public DialogAboutListener getDialogAboutListener(){
	return dialogAboutListener;
    }

    public void setDialogAboutListener(DialogAboutListener frameAboutListener){
	this.dialogAboutListener = frameAboutListener;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt){

	ExitApplicationUtil.getCurrentInstance().exitEvilApplication(this);
    }


    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt){

	ExitApplicationUtil.getCurrentInstance().exitEvilApplication(this);
    }


    /**
     * Adiciona o evento de quando o usuário clica ctrl+w o pane é fechado ehehe
     */
    private void adicionaEventosGlobaisTeclado(){
	KeyboardFocusManager kbfm = 
	    KeyboardFocusManager.getCurrentKeyboardFocusManager();
	kbfm.addKeyEventDispatcher(new EventosTecladoGerenciador(this));
    }
    
    private void jbInit() throws Exception{
	jTabbedPanePrincipal = new javax.swing.JTabbedPane();
	jToolBarPrincipal = new javax.swing.JToolBar();
	menuBar = new javax.swing.JMenuBar();
	fileMenu = new javax.swing.JMenu();
	jSeparator1 = new javax.swing.JSeparator();
	exitMenuItem = new javax.swing.JMenuItem();
	jMenuSystem = new javax.swing.JMenu();
	jSeparator2 = new javax.swing.JSeparator();
	jMenuEnvironmentPreferences = new javax.swing.JMenuItem();
	helpMenu = new javax.swing.JMenu();
	contentsMenuItem = new javax.swing.JMenuItem();
	aboutMenuItem = new javax.swing.JMenuItem();

	setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	addWindowListener(new java.awt.event.WindowAdapter(){
		    public void windowClosing(java.awt.event.WindowEvent evt){
			formWindowClosing(evt);
		    }
		});

	getContentPane().add(jTabbedPanePrincipal, java.awt.BorderLayout.CENTER);

	getContentPane().add(jToolBarPrincipal, java.awt.BorderLayout.NORTH);

	fileMenu.setMnemonic('A');
	fileMenu.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
		  .getString("File"));
	fileMenu.add(jSeparator1);

	exitMenuItem.setMnemonic('s');
	exitMenuItem.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
		      .getString("Exit"));
	exitMenuItem.addActionListener(new java.awt.event.ActionListener(){
		    public void actionPerformed(java.awt.event.ActionEvent evt){
			exitMenuItemActionPerformed(evt);
		    }
		});

	fileMenu.add(exitMenuItem);

	menuBar.add(fileMenu);

	jMenuSystem.setMnemonic('S');
	jMenuSystem.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
		     .getString("Sistema"));
	jMenuSystem.add(jSeparator2);

	jMenuEnvironmentPreferences.setMnemonic('r');
	jMenuEnvironmentPreferences.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
				     .getString("preferences_environment"));
	jMenuSystem.add(jMenuEnvironmentPreferences);

	menuBar.add(jMenuSystem);

	helpMenu.setMnemonic('j');
	helpMenu.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
		  .getString("Help"));
	contentsMenuItem.setMnemonic('d');
	contentsMenuItem.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
			  .getString("Contents"));
	helpMenu.add(contentsMenuItem);

	aboutMenuItem.setMnemonic('o');
	aboutMenuItem.setText(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary")
		       .getString("about"));
	aboutMenuItem.addActionListener(new java.awt.event.ActionListener(){
		    public void actionPerformed(java.awt.event.ActionEvent evt){
			aboutMenuItemActionPerformed(evt);
		    }
		});

	helpMenu.add(aboutMenuItem);

	menuBar.add(helpMenu);

	setJMenuBar(menuBar);
    }

    public void setLog(Logger log){
	this.log = log;
    }

    public Logger getLog(){
	return log;
    }

    public void setJToolBarPrincipal(JToolBar jToolBarPrincipal) {
        this.jToolBarPrincipal = jToolBarPrincipal;
    }

    public JToolBar getJToolBarPrincipal() {
        return jToolBarPrincipal;
    }

    public void setJMenuEnvironmentPreferences(JMenuItem jMenuEnvironmentPreferences) {
        this.jMenuEnvironmentPreferences = jMenuEnvironmentPreferences;
    }

    public JMenuItem getJMenuEnvironmentPreferences() {
        return jMenuEnvironmentPreferences;
    }

    public void setContentsMenuItem(JMenuItem contentsMenuItem) {
        this.contentsMenuItem = contentsMenuItem;
    }

    public JMenuItem getContentsMenuItem() {
        return contentsMenuItem;
    }

    public void setJMenuSystem(JMenu jMenuSystem) {
        this.jMenuSystem = jMenuSystem;
    }

    public JMenu getJMenuSystem() {
        return jMenuSystem;
    }
}
