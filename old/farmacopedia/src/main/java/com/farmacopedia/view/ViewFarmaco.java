package com.farmacopedia.view;

import com.farmacopedia.hibernate.Farmaco;
import com.farmacopedia.view.root.Page;

public class ViewFarmaco extends Page {
	public static final String JSF_PAGE_BEAN = "#{viewFarmaco}";
	private Farmaco farmaco;

	/**
	 * @return o farmaco
	 */
	public Farmaco getFarmaco() {
		return farmaco;
	}

	/**
	 * @param farmaco o farmaco a ser configurado
	 */
	public void setFarmaco(Farmaco farmaco) {
		this.farmaco = farmaco;
	}
}
