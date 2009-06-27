package com.dudhoo.farmaco.swing.event;

import com.dudhoo.evilframework.components.EvilTable;

import com.dudhoo.evilframework.swing.EvilError;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDao;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDaoImpl;
import com.dudhoo.farmaco.swing.PanelAdminPrincipioAtivo;
import com.dudhoo.farmaco.swing.StartFrame;

import com.dudhoo.farmaco.swing.component.JPanelApreFarmaceutica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

public class EditarPrincipioAtivoListAdapter implements ActionListener{
    private EvilTable evilt;
    public EditarPrincipioAtivoListAdapter(EvilTable table){
	evilt = table;
    }

    public void actionPerformed(ActionEvent actionEvent){
	try{
	if( evilt.isAlgumaLinhaSelecionada()){	    
	    System.out.println( evilt.getIdCampoSelecionado() );
	    int id = Integer.parseInt( evilt.getIdCampoSelecionado().toString() );
	    editar(id); 
	}
	}catch(Exception e){
	    new EvilError(StartFrame.getCurrentInstance(), false, e).setVisible(true);;
	}
    }

    private void editar(int id) throws SQLException{
	PrincipioAtivoDao dao = new PrincipioAtivoDaoImpl();
	PrincipioAtivo pr = dao.findFullById(null, id);
	if(pr != null){
	    PanelAdminPrincipioAtivo panel = new PanelAdminPrincipioAtivo("Editar princípio ativo");
	    panel.setSetPrincipioAtivo(pr);
	    StartFrame.getCurrentInstance().addJPanel( panel );
	}
    }
}