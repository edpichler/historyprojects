package dialogs;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import loto.activation.Sec;
import loto.exceptions.ActivationException;

public class SerialDialogModel {

	public void verificaPagamento(String codigoTransacao, Component comp)
			throws ActivationException, IOException {
		System.out
				.println("Verificando pagamento com a instituição financeira...");
		// Construct data

		String str = "";
		String utf = "UTF-8";
		try {
			str = URLEncoder.encode("chave", utf) + "="
					+ URLEncoder.encode(codigoTransacao, utf) + "&"
					+ URLEncoder.encode("mac", utf) + "="
					+ URLEncoder.encode(Sec.getFormattedMacAddress(), utf);
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		// Send data
		URL u = null;
		try {
			u = new URL("http://www.megaloteria.net/lotochance/default.aspx");
		} catch (MalformedURLException e) {
			// não vai acontecer
			e.printStackTrace();
		}
		URLConnection uc;
		String res = null;
		try {
			uc = u.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(str);
			pw.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc
					.getInputStream(), "UTF-8"));
			res = in.readLine();
			in.close();

		} catch (IOException e) {
			throw new IOException(
					"Erro ao conectar ao servidor. Certifique-se que você está conectado na internet.");
		}

		System.out.println("Verificado...");

		if (res != null && !res.toUpperCase().trim().equals("TRUE")) {
			// nao foi pago ainda
			throw new ActivationException(res);
		}
	}
}
