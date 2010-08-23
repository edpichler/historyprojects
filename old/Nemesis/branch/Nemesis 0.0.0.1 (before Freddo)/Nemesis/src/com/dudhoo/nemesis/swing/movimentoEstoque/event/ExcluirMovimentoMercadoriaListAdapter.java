package com.dudhoo.nemesis.swing.movimentoEstoque.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.MovimentoEstoqueHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoque;
import com.dudhoo.evilframework.swing.*;;
/**Exclui tanto mercadorias que entram pelo compras como também saem pelo vendas*/
public class ExcluirMovimentoMercadoriaListAdapter implements ExcluirPressListener{
    private PanelPesquisaGeneric panel;
    public ExcluirMovimentoMercadoriaListAdapter(PanelPesquisaGeneric pa){
	panel = pa;
    }

    public void doAfterClick(){
	try{
	    if(panel.isAlgumaLinhaSelecionada()){		
		Long id = Long.parseLong(panel.getIdCampoSelecionado().toString());   
		MovimentoEstoqueHome hoome = new MovimentoEstoqueHome();
		hoome.deleteById(id);
		panel.refreshTable();
	    }       
	} catch (Exception ex)  {
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally  {
	}
    }
}
