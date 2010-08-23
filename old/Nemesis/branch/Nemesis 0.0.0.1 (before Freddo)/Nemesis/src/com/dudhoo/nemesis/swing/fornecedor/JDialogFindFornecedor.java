package com.dudhoo.nemesis.swing.fornecedor;


import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaHome;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;
import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSelectCancel;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;

public class JDialogFindFornecedor extends JDialogGenericSelectCancel{
    PanelPesquisaGeneric panel;
    private Pessoa fornecedor;

    public JDialogFindFornecedor(Frame parent, boolean modal){
	super(parent, modal);	
	jbInit();
	initListener();
	this.setSize(350,450);
	centralize();	
    }

    public void setFornecedor(Pessoa fornecedor){
	this.fornecedor = fornecedor;
    }

    public void jbInit(){
	panel = new FornecedorSwingBuilder().createPanelPesquisa();
	this.addPanelAtCenter(panel);
    }

    public Pessoa getFornecedor(){
	return fornecedor;
    }

    private void initListener(){
	this.setSelectPressListener(new SelectPressListener(){
		    public void doAfterClick(){
			try{
			    if(panel.isAlgumaLinhaSelecionada()){
				Long id = Long.valueOf(panel.getIdCampoSelecionado().toString());
				PessoaHome home = new PessoaHome();
				setFornecedor(home.findById(id));
				home.closeSession();
				dispose();
			    }
			} catch(Exception ex){
			    new EvilError(StartFrame.getCurrentInstance(), true, ex)
				.setVisible(true);
			} finally{
			}
		    }
		});
    }
}
