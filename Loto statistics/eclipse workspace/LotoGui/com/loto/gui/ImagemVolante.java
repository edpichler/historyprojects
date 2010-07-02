package loto.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lotopro.Cartao;

public class ImagemVolante extends JPanel {

	private static final int COLUMN_1 = 38;//-7

	private static final int COLUMN_2 = 62;

	private static final int COLUMN_3 = 86;

	private static final int COLUMN_4 = 110;

	private static final int COLUMN_5 = 137;

	private static final int COLUMN_6 = 159;

	private static final int COLUMN_7 = 183;

	private static final int COLUMN_8 = 209;

	private static final int COLUMN_9 = 233;
	
	private static final int COLUMN_10 = 258;

	private static final int ROW_1 = 116; //-13

	private static final int ROW_2 = 135;

	private static final int ROW_3 = 153;

	private static final int ROW_4 = 172;

	private static final int ROW_5 = 190;

	private static final int ROW_6 = 209;

	private static final int ROW_7 = 228;

	private static final int ROW_8 = 245;

	private static final int ROW_9 = 263;

	private static final int ROW_10 = 283;

	private JLabel jLabelImagem = null;

	private JLabel lblNumeros[] = new JLabel[100];

	/**
	 * This method initializes
	 * 
	 */
	public ImagemVolante() {
		super();
		initializeMarcadores();
		initialize();
	}

	
	public void showMarcados(Cartao card){
		for (int i = 0; i < lblNumeros.length; i++) {
			lblNumeros[i].setVisible(false);
		}
		Collection<Integer> numeros = card.getNumeros();
		for (int num : numeros) {
			lblNumeros[num].setVisible(true);
		}
	}
	private void initializeMarcadores() {
		final ImageIcon dotImage = new ImageIcon(getClass().getResource(
				"/dot.png"));

		for (int i = 0; i < lblNumeros.length; i++) {
			lblNumeros[i] = new JLabel();
			lblNumeros[i].setIcon(dotImage);
			lblNumeros[i].setVisible(false);
			this.add(lblNumeros[i], null);

		}

		lblNumeros[1].setBounds(new Rectangle(COLUMN_1, ROW_1, 22, 15));
		lblNumeros[2].setBounds(new Rectangle(COLUMN_2, ROW_1, 22, 15));
		lblNumeros[3].setBounds(new Rectangle(COLUMN_3, ROW_1, 22, 15));
		lblNumeros[4].setBounds(new Rectangle(COLUMN_4, ROW_1, 22, 15));
		lblNumeros[5].setBounds(new Rectangle(COLUMN_5, ROW_1, 22, 15));
		lblNumeros[6].setBounds(new Rectangle(COLUMN_6, ROW_1, 22, 15));
		lblNumeros[7].setBounds(new Rectangle(COLUMN_7, ROW_1, 22, 15));
		lblNumeros[8].setBounds(new Rectangle(COLUMN_8, ROW_1, 22, 15));
		lblNumeros[9].setBounds(new Rectangle(COLUMN_9, ROW_1, 22, 15));
		lblNumeros[10].setBounds(new Rectangle(COLUMN_10, ROW_1, 22, 15));

		lblNumeros[11].setBounds(new Rectangle(COLUMN_1, ROW_2, 22, 15));
		lblNumeros[12].setBounds(new Rectangle(COLUMN_2, ROW_2, 22, 15));
		lblNumeros[13].setBounds(new Rectangle(COLUMN_3, ROW_2, 22, 15));
		lblNumeros[14].setBounds(new Rectangle(COLUMN_4, ROW_2, 22, 15));
		lblNumeros[15].setBounds(new Rectangle(COLUMN_5, ROW_2, 22, 15));
		lblNumeros[16].setBounds(new Rectangle(COLUMN_6, ROW_2, 22, 15));
		lblNumeros[17].setBounds(new Rectangle(COLUMN_7, ROW_2, 22, 15));
		lblNumeros[18].setBounds(new Rectangle(COLUMN_8, ROW_2, 22, 15));
		lblNumeros[19].setBounds(new Rectangle(COLUMN_9, ROW_2, 22, 15));
		lblNumeros[20].setBounds(new Rectangle(COLUMN_10, ROW_2, 22, 15));

		lblNumeros[21].setBounds(new Rectangle(COLUMN_1, ROW_3, 22, 15));
		lblNumeros[22].setBounds(new Rectangle(COLUMN_2, ROW_3, 22, 15));
		lblNumeros[23].setBounds(new Rectangle(COLUMN_3, ROW_3, 22, 15));
		lblNumeros[24].setBounds(new Rectangle(COLUMN_4, ROW_3, 22, 15));
		lblNumeros[25].setBounds(new Rectangle(COLUMN_5, ROW_3, 22, 15));
		lblNumeros[26].setBounds(new Rectangle(COLUMN_6, ROW_3, 22, 15));
		lblNumeros[27].setBounds(new Rectangle(COLUMN_7, ROW_3, 22, 15));
		lblNumeros[28].setBounds(new Rectangle(COLUMN_8, ROW_3, 22, 15));
		lblNumeros[29].setBounds(new Rectangle(COLUMN_9, ROW_3, 22, 15));
		lblNumeros[30].setBounds(new Rectangle(COLUMN_10, ROW_3, 22, 15));

		lblNumeros[31].setBounds(new Rectangle(COLUMN_1, ROW_4, 22, 15));
		lblNumeros[32].setBounds(new Rectangle(COLUMN_2, ROW_4, 22, 15));
		lblNumeros[33].setBounds(new Rectangle(COLUMN_3, ROW_4, 22, 15));
		lblNumeros[34].setBounds(new Rectangle(COLUMN_4, ROW_4, 22, 15));
		lblNumeros[35].setBounds(new Rectangle(COLUMN_5, ROW_4, 22, 15));
		lblNumeros[36].setBounds(new Rectangle(COLUMN_6, ROW_4, 22, 15));
		lblNumeros[37].setBounds(new Rectangle(COLUMN_7, ROW_4, 22, 15));
		lblNumeros[38].setBounds(new Rectangle(COLUMN_8, ROW_4, 22, 15));
		lblNumeros[39].setBounds(new Rectangle(COLUMN_9, ROW_4, 22, 15));
		lblNumeros[40].setBounds(new Rectangle(COLUMN_10, ROW_4, 22, 15));

		lblNumeros[41].setBounds(new Rectangle(COLUMN_1, ROW_5, 22, 15));
		lblNumeros[42].setBounds(new Rectangle(COLUMN_2, ROW_5, 22, 15));
		lblNumeros[43].setBounds(new Rectangle(COLUMN_3, ROW_5, 22, 15));
		lblNumeros[44].setBounds(new Rectangle(COLUMN_4, ROW_5, 22, 15));
		lblNumeros[45].setBounds(new Rectangle(COLUMN_5, ROW_5, 22, 15));
		lblNumeros[46].setBounds(new Rectangle(COLUMN_6, ROW_5, 22, 15));
		lblNumeros[47].setBounds(new Rectangle(COLUMN_7, ROW_5, 22, 15));
		lblNumeros[48].setBounds(new Rectangle(COLUMN_8, ROW_5, 22, 15));
		lblNumeros[49].setBounds(new Rectangle(COLUMN_9, ROW_5, 22, 15));
		lblNumeros[50].setBounds(new Rectangle(COLUMN_10, ROW_5, 22, 15));

		lblNumeros[51].setBounds(new Rectangle(COLUMN_1, ROW_6, 22, 15));
		lblNumeros[52].setBounds(new Rectangle(COLUMN_2, ROW_6, 22, 15));
		lblNumeros[53].setBounds(new Rectangle(COLUMN_3, ROW_6, 22, 15));
		lblNumeros[54].setBounds(new Rectangle(COLUMN_4, ROW_6, 22, 15));
		lblNumeros[55].setBounds(new Rectangle(COLUMN_5, ROW_6, 22, 15));
		lblNumeros[56].setBounds(new Rectangle(COLUMN_6, ROW_6, 22, 15));
		lblNumeros[57].setBounds(new Rectangle(COLUMN_7, ROW_6, 22, 15));
		lblNumeros[58].setBounds(new Rectangle(COLUMN_8, ROW_6, 22, 15));
		lblNumeros[59].setBounds(new Rectangle(COLUMN_9, ROW_6, 22, 15));
		lblNumeros[60].setBounds(new Rectangle(COLUMN_10, ROW_6, 22, 15));

		lblNumeros[61].setBounds(new Rectangle(COLUMN_1, ROW_7, 22, 15));
		lblNumeros[62].setBounds(new Rectangle(COLUMN_2, ROW_7, 22, 15));
		lblNumeros[63].setBounds(new Rectangle(COLUMN_3, ROW_7, 22, 15));
		lblNumeros[64].setBounds(new Rectangle(COLUMN_4, ROW_7, 22, 15));
		lblNumeros[65].setBounds(new Rectangle(COLUMN_5, ROW_7, 22, 15));
		lblNumeros[66].setBounds(new Rectangle(COLUMN_6, ROW_7, 22, 15));
		lblNumeros[67].setBounds(new Rectangle(COLUMN_7, ROW_7, 22, 15));
		lblNumeros[68].setBounds(new Rectangle(COLUMN_8, ROW_7, 22, 15));
		lblNumeros[69].setBounds(new Rectangle(COLUMN_9, ROW_7, 22, 15));
		lblNumeros[70].setBounds(new Rectangle(COLUMN_10, ROW_7, 22, 15));

		lblNumeros[71].setBounds(new Rectangle(COLUMN_1, ROW_8, 22, 15));
		lblNumeros[72].setBounds(new Rectangle(COLUMN_2, ROW_8, 22, 15));
		lblNumeros[73].setBounds(new Rectangle(COLUMN_3, ROW_8, 22, 15));
		lblNumeros[74].setBounds(new Rectangle(COLUMN_4, ROW_8, 22, 15));
		lblNumeros[75].setBounds(new Rectangle(COLUMN_5, ROW_8, 22, 15));
		lblNumeros[76].setBounds(new Rectangle(COLUMN_6, ROW_8, 22, 15));
		lblNumeros[77].setBounds(new Rectangle(COLUMN_7, ROW_8, 22, 15));
		lblNumeros[78].setBounds(new Rectangle(COLUMN_8, ROW_8, 22, 15));
		lblNumeros[79].setBounds(new Rectangle(COLUMN_9, ROW_8, 22, 15));
		lblNumeros[80].setBounds(new Rectangle(COLUMN_10, ROW_8, 22, 15));

		lblNumeros[81].setBounds(new Rectangle(COLUMN_1, ROW_9, 22, 15));
		lblNumeros[82].setBounds(new Rectangle(COLUMN_2, ROW_9, 22, 15));
		lblNumeros[83].setBounds(new Rectangle(COLUMN_3, ROW_9, 22, 15));
		lblNumeros[84].setBounds(new Rectangle(COLUMN_4, ROW_9, 22, 15));
		lblNumeros[85].setBounds(new Rectangle(COLUMN_5, ROW_9, 22, 15));
		lblNumeros[86].setBounds(new Rectangle(COLUMN_6, ROW_9, 22, 15));
		lblNumeros[87].setBounds(new Rectangle(COLUMN_7, ROW_9, 22, 15));
		lblNumeros[88].setBounds(new Rectangle(COLUMN_8, ROW_9, 22, 15));
		lblNumeros[89].setBounds(new Rectangle(COLUMN_9, ROW_9, 22, 15));
		lblNumeros[90].setBounds(new Rectangle(COLUMN_10, ROW_9, 22, 15));

		lblNumeros[91].setBounds(new Rectangle(COLUMN_1, ROW_10, 22, 15));
		lblNumeros[92].setBounds(new Rectangle(COLUMN_2, ROW_10, 22, 15));
		lblNumeros[93].setBounds(new Rectangle(COLUMN_3, ROW_10, 22, 15));
		lblNumeros[94].setBounds(new Rectangle(COLUMN_4, ROW_10, 22, 15));
		lblNumeros[95].setBounds(new Rectangle(COLUMN_5, ROW_10, 22, 15));
		lblNumeros[96].setBounds(new Rectangle(COLUMN_6, ROW_10, 22, 15));
		lblNumeros[97].setBounds(new Rectangle(COLUMN_7, ROW_10, 22, 15));
		lblNumeros[98].setBounds(new Rectangle(COLUMN_8, ROW_10, 22, 15));
		lblNumeros[99].setBounds(new Rectangle(COLUMN_9, ROW_10, 22, 15));
		lblNumeros[0].setBounds(new Rectangle(COLUMN_10, ROW_10, 22, 15));
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		// jLabel1.setBounds(new Rectangle(49, 131, 19, 13));

		this.setLayout(null);
		jLabelImagem = new JLabel();
		jLabelImagem.setIcon(new ImageIcon(getClass().getResource(
				"/LOTOMANIA.JPG")));

		jLabelImagem.setBounds(new Rectangle(0, 0, 318, 531));
		this.add(jLabelImagem, null);
	}

} // @jve:decl-index=0:visual-constraint="10,10"
