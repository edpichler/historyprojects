package loto.gui;

import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import loto.activation.Sec;
import loto.gui.impl.ListModelCartoesImpl;

import com.lotopro.Cartao;

import dialogs.SerialDialog;

public class FrmMainControler {

	private static final String SERIAL_FILE = "loto";

	private FrmMain view;

	private FrmMainModel model;

	public FrmMainControler(FrmMain main) {
		
		this.view = main;
		model = new FrmMainModel();		
	}

	public void verifySerial() {
		try {
			File serial = new File(SERIAL_FILE);
			if (serial.exists()) {
				serial.createNewFile();
				FileInputStream fileInputStream = new FileInputStream(serial);
				byte[] dados = new byte[fileInputStream.available()];
				fileInputStream.read(dados);
				
				fileInputStream.close();
				fileInputStream = null;
				boolean validSerial = Sec.isValidSerial(new String(dados));
				if (!validSerial) {
					throw new Exception("Serial inválido!");
				}
			}else{
				throw new Exception("Ainda não foi ativado!");
			}
		} catch (Exception e) {
			SerialDialog dialog = new SerialDialog(view);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);			
		}
	}

	public void salvaSerial(String serial) throws IOException {
		File f = new File(SERIAL_FILE);
		FileOutputStream out = new FileOutputStream(f);
		out.write(serial.getBytes());
		out.close();
	}

	public void gerarCartoes() {
		int qt = askHowMuch();

		Cartao[] cards;
		view.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		cards = model.getCards(qt);
		view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		view.getPanelMain().getJCheckBoxOnlyWinners().setSelected(false);
		setCardsOnView(cards);
		view.getPanelMain().resetLabels();
		view.getPanelMain().getJCheckBoxOnlyWinners().setSelected(false);
		view.getPanelMain().clickSomentePremiados();
		view.getPanelMain().getJCheckBoxOnlyWinners().setEnabled(false);
	}

	private int askHowMuch() {

		int retorno = 0;
		while (retorno == 0) {
			try {
				String showInputDialog = JOptionPane.showInputDialog(view,
						"Quantos cartões você deseja gerar?", 3000);
				if (showInputDialog == null) {
					return 0;
				}
				retorno = Integer.parseInt(showInputDialog);

			} catch (NumberFormatException e) {
				// try again
				JOptionPane.showMessageDialog(view,
						"Informe um número inteiro.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		return retorno;
	}

	private void setCardsOnView(Cartao[] cards) {
		JList listaCartoes = view.getListaCartoes();
		ListModelCartoesImpl mdl = new ListModelCartoesImpl();
		mdl.setCartoes(cards);
		listaCartoes.setModel(mdl);
		view.repaint();

	}

	public Cartao[] getCartoes() {
		return model.getCartoes();
	}
}
