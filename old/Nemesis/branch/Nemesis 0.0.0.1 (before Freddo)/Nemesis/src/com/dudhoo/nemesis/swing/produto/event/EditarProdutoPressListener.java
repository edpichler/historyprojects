package com.dudhoo.nemesis.swing.produto.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.ProdutoHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.produto.JDialogProduto;

public class EditarProdutoPressListener implements EditarPressListener{
    private PanelPesquisaGeneric panel;
    
    public EditarProdutoPressListener(PanelPesquisaGeneric _panel){
	panel = _panel;
    }

    public void doAfterClick(){
	try{
	    if(panel.isAlgumaLinhaSelecionada()){
		long produto_id  = Long.valueOf(panel.getIdCampoSelecionado().toString());
		Produto pro = new ProdutoHome().findById(produto_id);
		JDialogProduto jd = new  JDialogProduto();
		jd.setProduto(pro);
		jd.setVisible(true);
	    }
	} catch (Exception ex)  {
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally  {
	}
    }
}
