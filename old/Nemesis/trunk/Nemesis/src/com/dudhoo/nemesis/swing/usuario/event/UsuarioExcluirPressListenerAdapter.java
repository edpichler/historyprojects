package com.dudhoo.nemesis.swing.usuario.event;

import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;


public class UsuarioExcluirPressListenerAdapter implements ExcluirPressListener{
    PanelPesquisaGeneric panel = null;
    public UsuarioExcluirPressListenerAdapter( PanelPesquisaGeneric panel){
	this.panel = panel;
    }

	public void doAfterClick(){
	    new UsuarioInserirPressListenerAdapter(panel).novo();
	}
}
