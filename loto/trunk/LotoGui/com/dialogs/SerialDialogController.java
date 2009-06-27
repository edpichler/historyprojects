package dialogs;

import javax.swing.JOptionPane;

import loto.activation.Sec;
import loto.gui.FrmMain;

public class SerialDialogController {
	private SerialDialog view;

	private SerialDialogModel model = new SerialDialogModel();

	public SerialDialogController(SerialDialog dialog) {
		this.view = dialog;
		
	}

	public void ativar() {

		String codigoTransacao = view.getJTextFieldSerial().getText();

		try {
			model.verificaPagamento(codigoTransacao, view);

			FrmMain.getInstance().getController().salvaSerial(
					"" + Sec.getSerial(Sec.getActivationCode()));
			JOptionPane.showMessageDialog(view, "Seu software foi ativado!",
					"Pagamento confirmado", JOptionPane.INFORMATION_MESSAGE);
			view.dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, e.getMessage(),
					"Erro na ativação", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void comprar() {
		JOptionPane.showMessageDialog(view, "Para comprar visite "
				+ JDialogSobre.SITE_PRODUTO, "Comprar",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
