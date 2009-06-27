/**
 * 
 */
package dialogs;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;


/**
 * @author pichler
 *
 */
public class JDialogSobre extends JDialog {

	public static final String SITE_PRODUTO = "www.megaloteria.net";

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanelSouth = null;

	private JButton jButtonClose = null;

	private JLabel jLabelSite = null;

	/**
	 * This method initializes jPanelSouth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSouth() {
		if (jPanelSouth == null) {
			jPanelSouth = new JPanel();
			jPanelSouth.setLayout(new GridBagLayout());
			jPanelSouth.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			jPanelSouth.add(getJButtonClose(), new GridBagConstraints());
		}
		return jPanelSouth;
	}

	/**
	 * This method initializes jButtonClose	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClose() {
		if (jButtonClose == null) {
			jButtonClose = new JButton();
			jButtonClose.setText("Fechar");
			jButtonClose.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonClose;
	}

	
	/**
	 * @param owner
	 */
	public JDialogSobre(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(255, 144);
		this.setTitle("Sobre");
		this.setModal(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelSite = new JLabel();
			jLabelSite.setText(SITE_PRODUTO);
			jLabelSite.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSite.setHorizontalAlignment(SwingConstants.CENTER);
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanelSouth(), BorderLayout.SOUTH);
			jContentPane.add(jLabelSite, BorderLayout.CENTER);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="0,56"
