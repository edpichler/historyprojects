package dialogs;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;

import com.lotopro.ResultadoConferencia;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;

public class JDialogResultado extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanelBtn = null;

	private JButton jButtonOk = null;

	private JPanel jPanelMidlle = null;

	private JLabel jLabel20Pontos = null;

	private JLabel jLabel19Pontos = null;

	private JLabel jLabel18Pontos = null;

	private JLabel jLabel17Pontos = null;

	private JLabel jLabel16Pontos = null;

	private JLabel jLabel0Pontos = null;

	private JLabel jLabelRes15Pontos = null;

	private JLabel jLabelRes14Pontos = null;

	private JLabel jLabelRes13Pontos = null;

	private JLabel jLabelRes12Pontos = null;

	private JLabel jLabelRes11Pontos = null;

	private JLabel jLabelRes0Pontos = null;

	private ResultadoConferencia resultado;
	
	private JDialogResultadoController controller;

	/**
	 * @param owner
	 */
	public JDialogResultado(Frame owner, ResultadoConferencia res) {
		super(owner,true);
		initialize();
		this.controller = new JDialogResultadoController(this);
		this.resultado = res;
		showResultados();
	}

	private void showResultados() {
		controller.showResultados();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(551, 260);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  // Generated
		this.setContentPane(getJContentPane());
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
			jContentPane.add(getJPanelBtn(), BorderLayout.SOUTH);  // Generated
			jContentPane.add(getJPanelMidlle(), BorderLayout.CENTER);  // Generated
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelBtn	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBtn() {
		if (jPanelBtn == null) {
			try {
				jPanelBtn = new JPanel();
				jPanelBtn.setLayout(new GridBagLayout());  // Generated
				jPanelBtn.add(getJButtonOk(), new GridBagConstraints());  // Generated
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jPanelBtn;
	}

	/**
	 * This method initializes jButtonOk	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOk() {
		if (jButtonOk == null) {
			try {
				jButtonOk = new JButton();
				jButtonOk.setText("Ok");  // Generated
				jButtonOk.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jButtonOk;
	}

	/**
	 * This method initializes jPanelMidlle	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelMidlle() {
		if (jPanelMidlle == null) {
			try {
				GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
				gridBagConstraints10.gridy = 5;  // Generated
				gridBagConstraints10.insets = new Insets(0, 5, 0, 0);  // Generated
				gridBagConstraints10.gridx = 1;  // Generated
				jLabelRes0Pontos = new JLabel();
				jLabelRes0Pontos.setText("...");  // Generated
				GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
				gridBagConstraints9.gridy = 4;  // Generated
				gridBagConstraints9.insets = new Insets(0, 5, 0, 0);  // Generated
				gridBagConstraints9.gridx = 1;  // Generated
				jLabelRes11Pontos = new JLabel();
				jLabelRes11Pontos.setText("...");  // Generated
				GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
				gridBagConstraints8.gridy = 3;  // Generated
				gridBagConstraints8.insets = new Insets(0, 5, 0, 0);  // Generated
				gridBagConstraints8.gridx = 1;  // Generated
				jLabelRes12Pontos = new JLabel();
				jLabelRes12Pontos.setText("...");  // Generated
				GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
				gridBagConstraints7.gridy = 2;  // Generated
				gridBagConstraints7.insets = new Insets(0, 5, 0, 0);  // Generated
				gridBagConstraints7.gridx = 1;  // Generated
				jLabelRes13Pontos = new JLabel();
				jLabelRes13Pontos.setText("...");  // Generated
				GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
				gridBagConstraints6.gridy = 1;  // Generated
				gridBagConstraints6.insets = new Insets(0, 5, 0, 0);  // Generated
				gridBagConstraints6.gridx = 1;  // Generated
				jLabelRes14Pontos = new JLabel();
				jLabelRes14Pontos.setText("...");  // Generated
				GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
				gridBagConstraints5.gridy = 0;  // Generated
				gridBagConstraints5.ipady = 0;  // Generated
				gridBagConstraints5.ipadx = 0;  // Generated
				gridBagConstraints5.insets = new Insets(0, 5, 0, 0);  // Generated
				gridBagConstraints5.gridx = 1;  // Generated
				jLabelRes15Pontos = new JLabel();
				jLabelRes15Pontos.setText("....");  // Generated
				GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
				gridBagConstraints4.gridy = 5;  // Generated
				gridBagConstraints4.anchor = GridBagConstraints.EAST;  // Generated
				gridBagConstraints4.gridx = 0;  // Generated
				jLabel0Pontos = new JLabel();
				jLabel0Pontos.setText("0 Pontos:");  // Generated
				jLabel0Pontos.setHorizontalTextPosition(SwingConstants.TRAILING);  // Generated
				GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
				gridBagConstraints3.gridy = 4;  // Generated
				gridBagConstraints3.anchor = GridBagConstraints.EAST;  // Generated
				gridBagConstraints3.gridx = 0;  // Generated
				jLabel16Pontos = new JLabel();
				jLabel16Pontos.setText("11 Pontos:");  // Generated
				jLabel16Pontos.setHorizontalTextPosition(SwingConstants.TRAILING);  // Generated
				GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
				gridBagConstraints2.gridy = 3;  // Generated
				gridBagConstraints2.anchor = GridBagConstraints.EAST;  // Generated
				gridBagConstraints2.gridx = 0;  // Generated
				jLabel17Pontos = new JLabel();
				jLabel17Pontos.setText("12 Pontos:");  // Generated
				jLabel17Pontos.setHorizontalTextPosition(SwingConstants.TRAILING);  // Generated
				GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
				gridBagConstraints11.gridy = 2;  // Generated
				gridBagConstraints11.anchor = GridBagConstraints.EAST;  // Generated
				gridBagConstraints11.gridx = 0;  // Generated
				jLabel18Pontos = new JLabel();
				jLabel18Pontos.setText("13 Pontos:");  // Generated
				jLabel18Pontos.setHorizontalTextPosition(SwingConstants.TRAILING);  // Generated
				GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
				gridBagConstraints1.gridy = 1;  // Generated
				gridBagConstraints1.anchor = GridBagConstraints.EAST;  // Generated
				gridBagConstraints1.gridx = 0;  // Generated
				jLabel19Pontos = new JLabel();
				jLabel19Pontos.setText("14 Pontos:");  // Generated
				jLabel19Pontos.setHorizontalTextPosition(SwingConstants.TRAILING);  // Generated
				GridBagConstraints gridBagConstraints = new GridBagConstraints();
				gridBagConstraints.gridy = 0;  // Generated
				gridBagConstraints.anchor = GridBagConstraints.EAST;  // Generated
				gridBagConstraints.gridx = 0;  // Generated
				jLabel20Pontos = new JLabel();
				jLabel20Pontos.setText("15 Pontos:");  // Generated
				jLabel20Pontos.setHorizontalTextPosition(SwingConstants.TRAILING);  // Generated
				jPanelMidlle = new JPanel();
				jPanelMidlle.setLayout(new GridBagLayout());  // Generated
				jPanelMidlle.setBorder(BorderFactory.createTitledBorder(null, "Resultado da conferência dos cartões:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));  // Generated
				jPanelMidlle.add(jLabel20Pontos, gridBagConstraints);  // Generated
				jPanelMidlle.add(jLabel19Pontos, gridBagConstraints1);  // Generated
				jPanelMidlle.add(jLabel18Pontos, gridBagConstraints11);  // Generated
				jPanelMidlle.add(jLabel17Pontos, gridBagConstraints2);  // Generated
				jPanelMidlle.add(jLabel16Pontos, gridBagConstraints3);  // Generated
				jPanelMidlle.add(jLabel0Pontos, gridBagConstraints4);  // Generated
				jPanelMidlle.add(jLabelRes15Pontos, gridBagConstraints5);  // Generated
				jPanelMidlle.add(jLabelRes14Pontos, gridBagConstraints6);  // Generated
				jPanelMidlle.add(jLabelRes13Pontos, gridBagConstraints7);  // Generated
				jPanelMidlle.add(jLabelRes12Pontos, gridBagConstraints8);  // Generated
				jPanelMidlle.add(jLabelRes11Pontos, gridBagConstraints9);  // Generated
				jPanelMidlle.add(jLabelRes0Pontos, gridBagConstraints10);  // Generated
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jPanelMidlle;
	}

	public void setResultado(ResultadoConferencia resultado) {
		this.resultado = resultado;
	}

	public ResultadoConferencia getResultado() {
		return resultado;
	}

	public JLabel getJLabelRes0Pontos() {
		return jLabelRes0Pontos;
	}

	public void setJLabelRes0Pontos(JLabel labelRes0Pontos) {
		jLabelRes0Pontos = labelRes0Pontos;
	}

	public JLabel getJLabelRes11Pontos() {
		return jLabelRes11Pontos;
	}

	public void setJLabelRes11Pontos(JLabel labelRes11pontos) {
		jLabelRes11Pontos = labelRes11pontos;
	}

	public JLabel getJLabelRes12Pontos() {
		return jLabelRes12Pontos;
	}

	public void setJLabelRes12Pontos(JLabel labelRes12Pontos) {
		jLabelRes12Pontos = labelRes12Pontos;
	}

	public JLabel getJLabelRes13Pontos() {
		return jLabelRes13Pontos;
	}

	public void setJLabelRes13Pontos(JLabel labelRes13Pontos) {
		jLabelRes13Pontos = labelRes13Pontos;
	}

	public JLabel getJLabelRes14Pontos() {
		return jLabelRes14Pontos;
	}

	public void setJLabelRes14Pontos(JLabel labelRes14Pontos) {
		jLabelRes14Pontos = labelRes14Pontos;
	}

	public JLabel getJLabelRes15Pontos() {
		return jLabelRes15Pontos;
	}

	public void setJLabelRes15Pontos(JLabel labelRes15Pontos) {
		jLabelRes15Pontos = labelRes15Pontos;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
