package com.dudhoo.nemesis.swing.produto.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.ProdutoHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.produto.JDialogProduto;


public class ExcluirProdutoPressListener implements ExcluirPressListener{
    
    private PanelPesquisaGeneric panel;
    
    public ExcluirProdutoPressListener(PanelPesquisaGeneric _panel){
	panel = _panel;
    }

    public void doAfterClick(){	    
	try{
	    if(panel.isAlgumaLinhaSelecionada()){
		long produto_id  = Long.valueOf(panel.getIdCampoSelecionado().toString());	        
	        ProdutoHome home = new ProdutoHome();	        		
		home.deleteProdutoById(produto_id);				
		new EvilInformation(panel).showMessage("Removido com sucesso!");
		 //TODO TESTAR SE NÃO É NULLO, FAZER ISSO NO EDITAR TAMBEM		
	    }
	} catch (Exception ex)  {	
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally{
	}
    }
}
