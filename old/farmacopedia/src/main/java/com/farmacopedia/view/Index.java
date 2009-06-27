package com.farmacopedia.view;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.farmacopedia.hibernate.Farmaco;
import com.farmacopedia.hibernate.HiberFarmaco;
import com.farmacopedia.view.root.Page;

public class Index extends Page {
	private String key;

	private HtmlDataTable tabela;

	private List resultado;

	public void buscar(ActionEvent evt) {
		try {
			resultado = new HiberFarmaco().findByKey(key);
		} catch (Exception e) {
			addMessage(e);
		}
	}

	/**
	 * @return o key
	 */
	public String getKey() {
		return key;
	}

	public List getResultado() {
		return resultado;
	}

	public void ver(ActionEvent evt) {
		try {
			System.out.println("###########0");
			Farmaco f = (Farmaco) tabela.getRowData();
			System.out.println("###########1");
			ViewFarmaco vf = (ViewFarmaco) getBeanFromContext(ViewFarmaco.JSF_PAGE_BEAN);
			System.out.println("###########2");
			vf.setFarmaco(f);
			System.out.println("###########3");
			setBeanToContext(vf, ViewFarmaco.JSF_PAGE_BEAN);
			System.out.println("###########4");
		} catch (Exception e) {
			addMessage(e);
		}
	}

	public String getAcao() {
		System.out.println("###########veeeeeeeeer");
		return "ver";
	}

	/**
	 * @param key
	 *            o key a ser configurado
	 */
	public void setKey(String key) {
		this.key = key;
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
