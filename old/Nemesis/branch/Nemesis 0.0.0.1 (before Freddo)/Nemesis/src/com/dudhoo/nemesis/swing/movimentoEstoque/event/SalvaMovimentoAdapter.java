package com.dudhoo.nemesis.swing.movimentoEstoque.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.MovimentoEstoqueHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.movimentoEstoque.JDialogMovimentoEstoque;
import com.dudhoo.nemesis.swing.movimentoEstoque.PanelMovimentacaoEstoque;

import java.util.Date;
import com.dudhoo.evilframework.swing.*;;

public class SalvaMovimentoAdapter implements SavePressListener{
    private JDialogMovimentoEstoque dialog = null;
    public SalvaMovimentoAdapter(JDialogMovimentoEstoque _dialogs){
	dialog = _dialogs;	
    }

    public void doAfterClick(){
	try  {
	    PanelMovimentacaoEstoque panel = dialog.getPanelMovimentacaoEstoque();
	    MovimentoEstoque mvs = panel.getMovimentoEstoque();	   
	    MovimentoEstoqueHome home = new MovimentoEstoqueHome();
	    home.saveOrUpdate(mvs );
	    new EvilInformation(this.dialog).showMessage("Salvo com sucesso!");	    
	    dialog.close();
	} catch (Exception ex)  {
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	} finally  {
	}
    }
}
