package com.dudhoo.farmaco.swing.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDao;
import com.dudhoo.farmaco.jdbc.implementation.PrincipioAtivoDaoImpl;
import com.dudhoo.farmaco.swing.PanelAdminPrincipioAtivo;

import com.dudhoo.farmaco.swing.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SalvarListener implements ActionListener{
    private PanelAdminPrincipioAtivo panel;
    public SalvarListener(PanelAdminPrincipioAtivo _panel){
	panel = _panel;
    }

    public void actionPerformed(ActionEvent actionEvent){
	try  {
	    PrincipioAtivo ativo = panel.getPrincipioAtivo();
	    new PrincipioAtivoDaoImpl().insertOrUpdateCascade(null, ativo);
	    new EvilInformation(panel).showMessage("Salvo com sucesso!");
	    panel.close();
	    System.out.println(panel);
	} catch (Exception ex)  {
	    new EvilError(StartFrame.getCurrentInstance(), true, ex ).setVisible(true);
	} 	
    }
}