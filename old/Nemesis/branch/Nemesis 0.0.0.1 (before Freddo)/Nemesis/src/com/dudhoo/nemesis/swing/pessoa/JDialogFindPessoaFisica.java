package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaPessoaFisicaBuilder;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSelectCancel;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;


public class JDialogFindPessoaFisica extends JDialogGenericSelectCancel{
    
    private Long id = null;
    
    private PanelPesquisaGeneric panel = null;
    
    public JDialogFindPessoaFisica(Frame frame, boolean modal){	
	super(frame, modal);
	initDudu();
    }

    private void initDudu(){
	panel = new PanelPesquisaPessoaFisicaBuilder().getJPanelPesquisaPessoasFisicas(false, false);
	this.setSelectPressListener( new SelectPressListener(){
	    public void doAfterClick(){
		try{
		    if(panel.isAlgumaLinhaSelecionada()){
			id = Long.parseLong(panel.getIdCampoSelecionado().toString());
			setOpcao(OpcaoEscolhida.SELECT);
			close();
		    }
		}catch(Exception xxx){
		    new com.dudhoo.evilframework.swing.EvilError(StartFrame.getCurrentInstance(), false, xxx).setVisible(true);
		}
	    }
	});
	this.addPanelAtCenter(panel);
    }
    
    /**
     * Retorna o id da pessoa física selecionada
     * */
    public Long getIdSelected() {
	return id;
    }
}
