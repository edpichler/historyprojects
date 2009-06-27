package com.dudhoo.nemesis.swing.movimentoEstoque.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.MovimentoEstoqueHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoque;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.movimentoEstoque.PanelMovimentacaoEstoque;

public class EditarEntraMercadoriaListAdapter implements EditarPressListener{
    private PanelPesquisaGeneric panel;
    public EditarEntraMercadoriaListAdapter(PanelPesquisaGeneric pa){
	panel = pa;
    }

    public void doAfterClick(){
	try  {
	    if(panel.isAlgumaLinhaSelecionada()){
	        JDialogMovimentoEstoque dia = new JDialogMovimentoEstoque(StartFrame.getCurrentInstance(), true,PanelMovimentacaoEstoque.TIPO.ENTRADA);
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());   
		MovimentoEstoqueHome hoome = new MovimentoEstoqueHome();
		MovimentoEstoque mov = hoome.findById(id);
	        dia.setMovimentoEstoque(mov);
	        dia.setVisible(true);    	
	    }	    
	} catch (Exception ex)  {
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally  {
	}
	
	
    }
}
