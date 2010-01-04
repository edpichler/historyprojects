package loto.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.lotopro.Cartao;

import dialogs.JDialogSobre;

public class FrmMain extends JFrame {

	private static final String NOME_SOFTWARE = "Lotochance";

	private FrmMainControler controller;

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private PanelMain panelMain = null;

	private JMenuBar jJMenuBar = null;

	private JMenu jMenu = null;

	private JMenuItem jMenuItemGerarCartoes = null;
	
	private static FrmMain instance =  null;

	private JMenuItem jMenuItemGerarSorteio = null;

	private JMenuItem jMenuItemConferir = null;

	private JMenu jMenuAbout = null;

	private JMenuItem jMenuItemAbout = null;

	/**
	 * This is the default constructor
	 */
	private FrmMain() {
		super();
		initialize();
		setController(new FrmMainControler(this));
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 618);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Generated
		this.setJMenuBar(getJJMenuBar()); // Generated
		this.setContentPane(getJContentPane());
		this.setTitle(NOME_SOFTWARE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPanelMain(), BorderLayout.CENTER); // Generated
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelMain
	 * 
	 * @return loto.gui.PanelMain
	 */
	public PanelMain getPanelMain() {
		if (panelMain == null) {			
				panelMain = new PanelMain();			
		}
		return panelMain;
	}

	public JList getListaCartoes() {
		return panelMain.getListaCartoes();
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			try {
				jJMenuBar = new JMenuBar();
				jJMenuBar.add(getJMenu()); // Generated
				jJMenuBar.add(getJMenuAbout());
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			try {
				jMenu = new JMenu();
				jMenu.setText("Ações"); // Generated
				jMenu.add(getJMenuItemGerarCartoes());
				jMenu.add(getJMenuItemGerarSorteio());
				jMenu.add(getJMenuItemConferir());
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItemGerarCartoes
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemGerarCartoes() {
		if (jMenuItemGerarCartoes == null) {
			try {
				jMenuItemGerarCartoes = new JMenuItem();
				jMenuItemGerarCartoes.setText("Gerar cartões..."); // Generated
				jMenuItemGerarCartoes
						.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(
									java.awt.event.ActionEvent e) {
								getController().gerarCartoes();
							}
						});
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jMenuItemGerarCartoes;
	}

	public static FrmMain getInstance() {
		if(instance == null){
			instance = new FrmMain();
		}
		return instance;
	}

	public Cartao[]  getCartoes() {
		return getController().getCartoes();
		
	}

	/**
	 * This method initializes jMenuItemGerarSorteio	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemGerarSorteio() {
		if (jMenuItemGerarSorteio == null) {
			jMenuItemGerarSorteio = new JMenuItem();
			jMenuItemGerarSorteio.setText("Gerar sorteio...");
			jMenuItemGerarSorteio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					panelMain.novoSorteio();
				}
			});
		}
		return jMenuItemGerarSorteio;
	}

	/**
	 * This method initializes jMenuItemConferir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemConferir() {
		if (jMenuItemConferir == null) {
			jMenuItemConferir = new JMenuItem();
			jMenuItemConferir.setText("Conferir tudo...");
			jMenuItemConferir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					panelMain.conferir();
				}
			});
		}
		return jMenuItemConferir;
	}

	/**
	 * This method initializes jMenuAbout	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuAbout() {
		if (jMenuAbout == null) {
			jMenuAbout = new JMenu();
			jMenuAbout.setText("Ajuda");
			jMenuAbout.add(getJMenuItemAbout());
		}
		return jMenuAbout;
	}

	/**
	 * This method initializes jMenuItemAbout	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAbout() {
		if (jMenuItemAbout == null) {
			jMenuItemAbout = new JMenuItem();
			jMenuItemAbout.setText("Sobre");
			jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JDialogSobre sobre = new JDialogSobre(FrmMain.getInstance());
					sobre.setLocationRelativeTo(null);
					sobre.setVisible(true);
				}
			});
		}
		return jMenuItemAbout;
	}

	public void verifySerial() {
		//getController().verifySerial();
		
	}

	public void setController(FrmMainControler controller) {
		this.controller = controller;
	}

	public FrmMainControler getController() {
		return controller;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
