/**
 * 
 */
package com.farmacopedia.view;

import javax.faces.event.ActionEvent;

import com.farmacopedia.hibernate.Farmaco;
import com.farmacopedia.hibernate.HiberFarmaco;
import com.farmacopedia.view.root.Page;

/**
 * @author dudu
 * 
 */
public class EditFarmaco extends Page  {
	public final static String JSF_PAGE_BEAN = "#{editFarmaco}";

	private Farmaco farmaco;

	/**
	 * @return o farmaco
	 */
	public Farmaco getFarmaco() {
		if (farmaco == null) {
			farmaco = new Farmaco();
			farmaco.setNome("Nome do princípio farmacológico...");
			farmaco.setDescricao("<h1>Cuidados especiais</h1>");
		}
		return farmaco;
	}

	public void salvar(ActionEvent evt) {
		try {
			new HiberFarmaco().salvar(farmaco);
			limpar(evt);
		} catch (Exception e) {
			addMessage(e);
			LOGGER.error(e);
		}
	}
	
	public void limpar(ActionEvent evt){
		this.setFarmaco(null);
	}
	/**
	 * @param farmaco
	 *            o farmaco a ser configurado
	 */
	public void setFarmaco(Farmaco farmaco) {
		this.farmaco = farmaco;
	}

}
