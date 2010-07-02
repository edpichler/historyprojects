package loto.gui.impl;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import com.lotopro.Cartao;
import com.lotopro.ResultadoConferencia;

public class ListModelCartoesImpl implements ListModel {

	private Cartao cardes[] ;

	private boolean somentePremiados;

	public void setCartoes(Cartao[] cards) {
		this.cardes = cards;
	}

	public void addListDataListener(ListDataListener l) {

	}

	public Object getElementAt(int index) {
		if (somentePremiados == false) {
			return this.cardes[index];
		} else {
			int count = 0;
			for (int i = 0; i < cardes.length; i++) {
				if (cardes[i].isPremiado()) {					
					if(count == index){
						return cardes[i];
					}
					count++;
				}
			}
			return null;
		}
	}

	public int getSize() {
		if(this.cardes == null){
			return 0;
		}
		if (somentePremiados == false) {
			
			return this.cardes.length;
		} else {
			int count = 0;
			for (int i = 0; i < cardes.length; i++) {
				if (cardes[i].isPremiado()) {
					count++;
				}
			}
			return count;
		}
	}

	public void removeListDataListener(ListDataListener l) {
	}

	/**
	 * Liga e desliga o filtro para mostrar somente cartões sorteados
	 */
	public void setFiltroSoPremiados(boolean flag) {
		this.somentePremiados = flag;
	}
}
