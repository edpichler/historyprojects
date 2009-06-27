package com.dudhoo.farmaco.swing.event;

import com.dudhoo.evilframework.components.EvilTable;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDao;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDaoImpl;
import com.dudhoo.farmaco.swing.StartFrame;


import com.dudhoo.farmaco.swing.view.PanelVisualizaPrincipio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewListAdapter implements ActionListener{
    private EvilTable evilTable;

    public ViewListAdapter(EvilTable _eviltTable){
	setEvilTable(_eviltTable);
    }

    public EvilTable getEvilTable(){
	return evilTable;
    }

    public void setEvilTable(EvilTable evilTable){
	this.evilTable = evilTable;
    }

    public void actionPerformed(ActionEvent actionEvent){
	try{
	    if(evilTable.isAlgumaLinhaSelecionada()){
		PrincipioAtivoDao prinDao = new PrincipioAtivoDaoImpl();
		int id = Integer.parseInt(evilTable.getIdCampoSelecionado().toString());
		PrincipioAtivo principio = prinDao.findFullById(null, id);
		if(principio != null){
		    PanelVisualizaPrincipio view = new PanelVisualizaPrincipio();
		    view.setName(principio.getNome());
		    view.setPrincipio(principio);
		    StartFrame.getCurrentInstance().addJPanel(view);
		}else{
		    new EvilInformation(evilTable)
		        .showMessage("O princípio ativo selecionado não foi encontrado para ser visualizado.");
		}		
	    }
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);;
	}
    }
}
