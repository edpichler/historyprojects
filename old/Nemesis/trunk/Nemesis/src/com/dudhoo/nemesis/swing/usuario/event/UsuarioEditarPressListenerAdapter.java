package com.dudhoo.nemesis.swing.usuario.event;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

public class UsuarioEditarPressListenerAdapter implements EditarPressListener{
    PanelPesquisaGeneric panel = null;
    public UsuarioEditarPressListenerAdapter( PanelPesquisaGeneric panel){
	this.panel = panel;
    }

    public void doAfterClick(){
	new UsuarioInserirPressListenerAdapter(panel).novo();
    }
}
