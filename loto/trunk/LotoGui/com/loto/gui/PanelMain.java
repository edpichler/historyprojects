package loto.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.lotopro.Cartao;
import com.lotopro.ResultadoConferencia;

import java.awt.Rectangle;
import javax.swing.JCheckBox;

import loto.gui.impl.ListModelCartoesImpl;

public class PanelMain extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane jScrollPane = null;

	private JList jListCartoes = null;

	private JPanel jPanelSorteio = null;

	private JLabel jLabelResultado = null;

	private JPanel jPanelBotoes = null;

	private JButton jButtonGerarSorteio = null;

	private final PanelMainController controller;

	private JButton jButtonConferir = null;

	private JButton jButtonGerarCartoes = null;

	private JSplitPane jSplitPane = null;

	private JPanel jPanelRight = null;

	private ImagemVolante imagemVolante;

	private JCheckBox jCheckBoxOnlyWinners = null;

	private JPanel jPanelDetalhes = null;

	private JLabel jLabelTotalPontos = null;

	private JLabel jLabelPontos = null;

	/**
	 * This is the default constructor
	 */
	public PanelMain() {
		super();
		initialize();
		controller = new PanelMainController(this);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(800, 600));
		this.add(getJSplitPane(), BorderLayout.CENTER);
		this.add(getJPanelSorteio(), BorderLayout.SOUTH);
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBorder(BorderFactory.createTitledBorder(null,
					"Cartões:", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			JPanel panelLeft = new JPanel();
			panelLeft.setLayout(new BorderLayout());
			jScrollPane.setViewportView(panelLeft);
			panelLeft.add(getJList());
			panelLeft.add(getJCheckBoxOnlyWinners(), BorderLayout.NORTH);

		}
		return jScrollPane;
	}

	/**
	 * This method initializes jList
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJList() {
		if (jListCartoes == null) {
			jListCartoes = new JList();
			jListCartoes
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(
								javax.swing.event.ListSelectionEvent e) {
							controller.mostrarCartao();
						}
					});
			jListCartoes.setModel(new ListModelCartoesImpl());
		}
		return jListCartoes;
	}

	/**
	 * This method initializes jPanelSorteio
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelSorteio() {
		if (jPanelSorteio == null) {
			jLabelResultado = new JLabel();
			jLabelResultado.setText("Clique em novo sorteio.");
			jLabelResultado.setHorizontalAlignment(SwingConstants.CENTER);
			jPanelSorteio = new JPanel();
			jPanelSorteio.setLayout(new BorderLayout());
			jPanelSorteio.setBorder(BorderFactory.createTitledBorder(null,
					"Sorteio", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelSorteio.add(jLabelResultado, BorderLayout.CENTER);
			jPanelSorteio.add(getJPanelBotoes(), BorderLayout.SOUTH); // Generated
		}
		return jPanelSorteio;
	}

	/**
	 * This method initializes jPanelBotoes
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {

			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(new FlowLayout()); // Generated
			jPanelBotoes.add(getJButtonGerarCartoes(), null);
			jPanelBotoes.add(getJButtonGerarSorteio(), null); // Generated
			jPanelBotoes.add(getJButtonConferir(), null); // Generated

		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes jButtonGerarSorteio
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGerarSorteio() {
		if (jButtonGerarSorteio == null) {

			jButtonGerarSorteio = new JButton();
			jButtonGerarSorteio.setText("Novo Sorteio"); // Generated

			jButtonGerarSorteio
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							controller.novoSorteio();
						}
					});
		}
		return jButtonGerarSorteio;
	}

	public void novoSorteio() {
		controller.novoSorteio();
	}

	/**
	 * Retorna o jlist de cartoes
	 */
	public JList getListaCartoes() {
		return this.jListCartoes;
	}

	public JLabel getJLabelResultado() {
		return jLabelResultado;
	}

	/**
	 * This method initializes jButtonConferir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonConferir() {
		if (jButtonConferir == null) {
			jButtonConferir = new JButton();
			jButtonConferir.setText("Conferir tudo"); // Generated
			jButtonConferir.setToolTipText("Confere os cartões com o sortei gerado.");
			jButtonConferir
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							controller.conferir();
						}
					});

		}
		return jButtonConferir;
	}

	public Cartao[] getCartoes() {
		return FrmMain.getInstance().getCartoes();
	}

	/**
	 * This method initializes jButtonGerarCartoes
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGerarCartoes() {
		if (jButtonGerarCartoes == null) {
			jButtonGerarCartoes = new JButton();
			jButtonGerarCartoes.setText("Gerar cartões");
			jButtonGerarCartoes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							FrmMain.getInstance().getController().gerarCartoes();
						}
					});
		}
		return jButtonGerarCartoes;
	}

	public void conferir() {
		controller.conferir();
	}

	/**
	 * This method initializes jSplitPane
	 * 
	 * @return javax.swing.JSplitPane
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setDividerLocation(260);
			jSplitPane.setLeftComponent(getJScrollPane());
			jSplitPane.setRightComponent(getJPanelRight());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jPanelRight
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelRight() {
		if (jPanelRight == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weighty = 1.0D;
			gridBagConstraints.weightx = 1.0D;
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.gridx = 0;
			jPanelRight = new JPanel();
			jPanelRight.setLayout(new GridBagLayout());
			imagemVolante = new ImagemVolante();
			imagemVolante.add(getJPanelDetalhes(), null);
			jPanelRight.add(imagemVolante, gridBagConstraints);
		}
		return jPanelRight;
	}

	public ImagemVolante getImagemVolante() {

		return imagemVolante;
	}

	/**
	 * This method initializes jCheckBoxOnlyWinners
	 * 
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxOnlyWinners() {
		if (jCheckBoxOnlyWinners == null) {
			jCheckBoxOnlyWinners = new JCheckBox();
			jCheckBoxOnlyWinners.setText("Somente premiados");
			jCheckBoxOnlyWinners.setEnabled(false);
			jCheckBoxOnlyWinners
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							clickSomentePremiados();
						}
					});
		}
		return jCheckBoxOnlyWinners;
	}

	public void setJCheckBoxOnlyWinners(JCheckBox jCheckBoxOnlyWinners) {
		this.jCheckBoxOnlyWinners = jCheckBoxOnlyWinners;
	}

	/**
	 * This method initializes jPanelDetalhes
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelDetalhes() {
		if (jPanelDetalhes == null) {
			jLabelPontos = new JLabel();
			jLabelPontos.setBounds(new Rectangle(11, 33, 103, 16));
			jLabelPontos.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelPontos.setText("Total de pontos:");
			jLabelTotalPontos = new JLabel();
			jLabelTotalPontos.setBounds(new Rectangle(118, 30, 44, 18));
			jLabelTotalPontos.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelTotalPontos.setText("0");
			jPanelDetalhes = new JPanel() {
				public void setEnabled(boolean flag) {
					super.setEnabled(flag);
					Component[] components = this.getComponents();
					for (Component c : components) {
						c.setEnabled(flag);
					}
				}
			};

			jPanelDetalhes.setLayout(null);
			jPanelDetalhes.setBounds(new Rectangle(324, 5, 179, 77));
			jPanelDetalhes.setBorder(BorderFactory.createTitledBorder(null,
					"Detalhes", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));

			jPanelDetalhes.add(jLabelTotalPontos, null);
			jPanelDetalhes.add(jLabelPontos, null);
			jPanelDetalhes.setEnabled(false);
		}
		return jPanelDetalhes;
	}

	public void setJLabelTotalPontos(JLabel jLabelTotalPontos) {
		this.jLabelTotalPontos = jLabelTotalPontos;
	}

	public JLabel getJLabelTotalPontos() {
		return jLabelTotalPontos;
	}

	public void resetLabels() {
		controller.resetLabels();

	}

	public void clickSomentePremiados() {
		controller.somentePremiados();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
