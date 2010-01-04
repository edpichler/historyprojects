package dialogs;

import javax.swing.JDialog;

import loto.activation.Sec;
import loto.gui.FrmMain;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.net.SocketException;
import java.net.UnknownHostException;
/*
Quando o usuário abrir o programa. ele vai pedir o código do pagamento. 
   O software vai fazer um sql no BD para verificar se esse id já esta associado à um macaddress e caso for o mesmo, ativa o software. Caso não avisa que outro computador já ativou usando a chave.
   Caso nao exista no bd,   O software vai acessar o pagseguro e verificar se foi pago.
      Se foi pago, ativa o software e atualiza o BD associando o mac adress com o codigo do pagamento
      Caso não, diz que a transaçao ainda não foi confirmada como paga pela instituição financeira. Caso ja tenha pago, tente mais tarde.

Pronto ativo e eu estou com a grana.*/
public class SerialDialog extends JDialog {
	private JPanel jPanel = null;

	private JLabel jLabel1 = null;

	private JTextField jTextFieldSerial = null;

	private JButton jButtonAtivar = null;

	private SerialDialogController controller;

	private JButton jButtonAdquirirLicenca = null;

	public SerialDialog(Frame owner) {
		super(owner);
		setModal(true);
		initialize();
		controller = new SerialDialogController(this);
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(412, 114));
		this.setDefaultCloseOperation(0);
		this.setContentPane(getJPanel());
		this.setTitle("Ativação");
		this.setResizable(false);
		this.setModal(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.insets = new Insets(10, 5, 0, 0);
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridwidth = 1;
			gridBagConstraints4.insets = new Insets(10, 0, 0, 0);
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 2.0D;
			gridBagConstraints3.insets = new Insets(0, 5, 0, 30);
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.weightx = 1.0D;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.ipadx = 3;
			gridBagConstraints2.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Codigo:");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel1, gridBagConstraints2);
			jPanel.add(getJTextFieldSerial(), gridBagConstraints3);
			jPanel.add(getJButtonAtivar(), gridBagConstraints4);
			jPanel.add(getJButtonAdquirirLicenca(), gridBagConstraints11);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextFieldSerial
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldSerial() {
		if (jTextFieldSerial == null) {
			jTextFieldSerial = new JTextField();
			jTextFieldSerial.setToolTipText("O código de ativação (número da transação do pagamento realizado).");
		}
		return jTextFieldSerial;
	}

	/**
	 * This method initializes jButtonAtivar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAtivar() {
		if (jButtonAtivar == null) {
			jButtonAtivar = new JButton();
			jButtonAtivar.setText("Ativar");
			jButtonAtivar.setToolTipText("Ativar o programa pela internet");
			jButtonAtivar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							controller.ativar();
						}
					});
		}
		return jButtonAtivar;
	}

	/**
	 * This method initializes jButtonAdquirirLicenca
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAdquirirLicenca() {
		if (jButtonAdquirirLicenca == null) {
			jButtonAdquirirLicenca = new JButton();
			jButtonAdquirirLicenca.setText("Comprar");
			jButtonAdquirirLicenca.setToolTipText("Comprar licença");
			jButtonAdquirirLicenca
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							controller.comprar();
						}
					});
		}
		return jButtonAdquirirLicenca;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
