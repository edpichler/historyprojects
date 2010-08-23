package loto.gui;

import java.awt.Cursor;

import javax.swing.JList;
import javax.swing.JOptionPane;

import loto.gui.impl.ListModelCartoesImpl;

import com.lotopro.Cartao;
import com.lotopro.ProcessadorResultados;
import com.lotopro.ResultadoConferencia;
import com.lotopro.Sorteio;

import dialogs.JDialogResultado;

public class PanelMainController {

	private PanelMain view;

	private PanelMainModel model;

	public PanelMainController(PanelMain main) {
		this.view = main;
		model = new PanelMainModel();
	}

	public void novoSorteio() {
		Sorteio s = model.novoSorteio();
		view.getJLabelResultado().setText(s.toString());
		view.getJPanelDetalhes().setEnabled(true);
		resetLabels();

		view.getJCheckBoxOnlyWinners().setSelected(false);
		somentePremiados();
		view.getJCheckBoxOnlyWinners().setEnabled(false);

	}

	public void resetLabels() {
		FrmMain.getInstance().getListaCartoes().clearSelection();
		view.getJLabelTotalPontos().setText("" + 0);
	}

	public void conferir() {

		try {

			Cartao[] cartoes = view.getCartoes();

			view.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			ResultadoConferencia res = model.conferirResultado(cartoes);

			view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			FrmMain main = FrmMain.getInstance();
			JDialogResultado dialog = new JDialogResultado(main, res);

			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			view.getJCheckBoxOnlyWinners().setEnabled(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(view, ex.getMessage());
		} finally {
			view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		}

	}

	/**
	 * Mostra o cartão com os números marcados
	 */
	public void mostrarCartao() {
		int selectedIndex = view.getListaCartoes().getSelectedIndex();
		if (selectedIndex != -1) {
			Cartao card = (Cartao) view.getListaCartoes().getSelectedValue();
			view.getImagemVolante().showMarcados(card);

			Sorteio ultimoSorteio = model.getSorteio();
			int pontos = 0;
			if (ultimoSorteio != null) {
				pontos = new ProcessadorResultados().confereCartao(
						ultimoSorteio, card);

			}
			view.getJLabelTotalPontos().setText("" + pontos);
		}

	}

	public void somentePremiados() {
		resetLabels();
		JList listaCartoes = view.getListaCartoes();
		ListModelCartoesImpl modelListaCartoes = (ListModelCartoesImpl) listaCartoes
				.getModel();
		modelListaCartoes.setFiltroSoPremiados(view.getJCheckBoxOnlyWinners()
				.isSelected());
		FrmMain.getInstance().repaint();

	}

}
