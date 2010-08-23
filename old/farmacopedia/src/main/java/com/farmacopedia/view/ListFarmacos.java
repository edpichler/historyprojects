package com.farmacopedia.view;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.farmacopedia.hibernate.Farmaco;
import com.farmacopedia.hibernate.HiberFarmaco;
import com.farmacopedia.view.root.Page;

public class ListFarmacos extends Page {
	public static final String JSG_PAGE_NAME = "#{listFarmacos}";

	private List<Farmaco> farmacos;

	private HtmlDataTable tabela;

	/**
	 * @return o farmacos
	 */
	public List<Farmaco> getFarmacos() {
		try {
			farmacos = new HiberFarmaco().list();
		} catch (Exception e) {
			addMessage(e);
		}
		return farmacos;
	}

	/**
	 * @param farmacos
	 *            o farmacos a ser configurado
	 */
	public void setFarmacos(List<Farmaco> farmacos) {
		this.farmacos = farmacos;
	}

	public void editar(ActionEvent evt) {
		Farmaco f = (Farmaco) tabela.getRowData();
		if (f != null) {
			EditFarmaco edit = (EditFarmaco) getBeanFromContext(EditFarmaco.JSF_PAGE_BEAN);
			edit.setFarmaco(f);
			setBeanToContext(edit, EditFarmaco.JSF_PAGE_BEAN);
		}
	}

	public void deletar(ActionEvent evt) {
		try {
			Farmaco f = (Farmaco) tabela.getRowData();
			if (f != null) {
				new HiberFarmaco().deletar(f);
			}
		} catch (Exception ex) {
			addMessage(ex);
		}
	}

	/**
	 * @return o tabela
	 */
	public HtmlDataTable getTabela() {
		return tabela;
	}

	/**
	 * @param tabela
	 *            o tabela a ser configurado
	 */
	public void setTabela(HtmlDataTable tabela) {
		this.tabela = tabela;
	}
}
