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
		view.getJLabelRes15Pontos().setText(resultado.getCartoesCom15Pontos().length + sufixo);
		view.getJLabelRes14Pontos().setText(resultado.getCartoesCom14Pontos().length + sufixo);
		view.getJLabelRes13Pontos().setText(resultado.getCartoesCom13Pontos().length + sufixo);
		view.getJLabelRes12Pontos().setText(resultado.getCartoesCom12Pontos().length + sufixo);
		view.getJLabelRes11Pontos().setText(resultado.getCartoesCom11Pontos().length + sufixo);
	}
}
