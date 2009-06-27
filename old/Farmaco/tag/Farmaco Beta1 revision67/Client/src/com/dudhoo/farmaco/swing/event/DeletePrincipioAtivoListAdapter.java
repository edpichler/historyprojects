package com.dudhoo.farmaco.swing.event;

import com.dudhoo.evilframework.components.EvilTable;

import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilError;

import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.evilframework.swing.dialog.BotaoConstants;
import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;
import com.dudhoo.farmaco.jdbc.ResourceManager;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDao;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDaoImpl;
import com.dudhoo.farmaco.swing.PesquisaFactory;
import com.dudhoo.farmaco.swing.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DeletePrincipioAtivoListAdapter implements ActionListener{
    private EvilTable evil = null;
    
    public DeletePrincipioAtivoListAdapter(EvilTable p0){
	evil = p0;
    }

    public void actionPerformed(ActionEvent actionEvent){
	try{
	    if(evil.isAlgumaLinhaSelecionada()){
	        EvilAsk evl = new EvilAsk(evil);
		int cho = evl.setVisible("Tem certeza que deseja remover o item?");
		if(cho == JOptionPane.YES_OPTION){
		    int id = Integer.parseInt( evil.getIdCampoSelecionado().toString() );
		    PrincipioAtivoDao dao = new PrincipioAtivoDaoImpl();                
		    dao.deleteCascading(null, dao.findFullById(null, id));
		    new EvilInformation(evil).showMessage("Removido com sucesso!");
		    this.evil.setFilteredRowSet( new PesquisaFactory().getPesquisa(), 1);
		}		
	    }    
	}catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(),true, ex).setVisible(true);;   
	}	
    }
}
