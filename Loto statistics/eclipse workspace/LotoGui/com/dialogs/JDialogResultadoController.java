package dialogs;

import com.lotopro.ResultadoConferencia;


public class JDialogResultadoController {

	private JDialogResultado view;

	public JDialogResultadoController(JDialogResultado resultado) {
		view = resultado;
	}

	public void showResultados() {
		ResultadoConferencia resultado = view.getResultado();
		String sufixo = " cartões.";
		view.getJLabelRes0Pontos().setText(resultado.getCartoesCom0Pontos().length + sufixo);
		view.getJLabelRes20Pontos().setText(resultado.getCartoesCom20Pontos().length + sufixo);
		view.getJLabelRes19Pontos().setText(resultado.getCartoesCom19Pontos().length + sufixo);
		view.getJLabelRes18Pontos().setText(resultado.getCartoesCom18Pontos().length + sufixo);
		view.getJLabelRes17Pontos().setText(resultado.getCartoesCom17Pontos().length + sufixo);
		view.getJLabelRes16Pontos().setText(resultado.getCartoesCom16Pontos().length + sufixo);
	}
}
