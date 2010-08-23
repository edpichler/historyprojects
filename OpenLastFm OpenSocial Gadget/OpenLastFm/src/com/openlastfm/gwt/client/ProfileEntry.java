package com.openlastfm.gwt.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ProfileEntry implements EntryPoint {

	private String idImagem = "imagemUltimaMusica";

	private final ProfileServiceAsync profileService = GWT
			.create(ProfileService.class);

	public ProfileEntry() {

	}

	@Override
	public void onModuleLoad() {
		final Element divImagem = RootPanel.get(idImagem).getElement();
		final Element imgArtista = DOM.createImg();
		imgArtista.setAttribute("width", "96px");

		String user = "duduzerah";
		profileService.getImageUrlArtist(user, "senha",
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// TODO imagem not found
						Window.alert(caught.getMessage());
					}

					public void onSuccess(String imagemUrl) {
						imgArtista.setAttribute("src", imagemUrl);
						divImagem.appendChild(imgArtista);
					}
				});

		final Element tabela = RootPanel.get("tableMusicas").getElement();
		profileService.getMusicas(user, new AsyncCallback<Musica[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());

			}

			@Override
			public void onSuccess(Musica[] musicas) {
				for (Musica musica : musicas) {
					Element tr = DOM.createTR();
					Element tdMusica = DOM.createTD();
					Element tdHora = DOM.createTD();
					tdMusica.setInnerHTML(musica.getNome());
					if (!musica.isNowPlaying()) {

						tdMusica.setClassName("musica_tocada_passado");
						tdHora.setClassName("td_data_musica");
						Date playedWhen = musica.getPlayedWhen();
						DateTimeFormat format = DateTimeFormat.getFormat("dd MMM hh:mm");
						tdHora.setInnerHTML( format.format(playedWhen));
					} else {

						tdMusica.setClassName("musica_tocando_agora");
						tdHora.setClassName("td_data_ouvindoagora");
						tdHora.setInnerHTML("ouvindo agora <img src=\"images/icon_equalizerlastfm.gif\" style=\"width: 12px;\" />");
						
					}

					tr.appendChild(tdMusica);
					tr.appendChild(tdHora);
					tabela.appendChild(tr);
				}

				divImagem.appendChild(imgArtista);

			}

		});

	}
	private native String getSomething(String name) /*-{

	  // ...implemented with JavaScript
	  var re = /(\w+)\s(\w+)/;
	  return name.replace(re, '$2, $1');

	}-*/;
}


