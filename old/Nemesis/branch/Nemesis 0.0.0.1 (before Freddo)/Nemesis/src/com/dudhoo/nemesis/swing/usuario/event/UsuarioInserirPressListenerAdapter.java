package com.dudhoo.nemesis.swing.usuario.event;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.generic.JPanelGenericFechar;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.usuario.JPanelAdminUsuarios;

public class UsuarioInserirPressListenerAdapter implements InserirPressListener {
    private PanelPesquisaGeneric panel = null;
    
    private static JPanelGenericFechar genf;    
    
    public UsuarioInserirPressListenerAdapter(PanelPesquisaGeneric _panel){
	panel = _panel;
    }

    public void doAfterClick(){
	novo();
    }
    
    public void novo(){	
	if(genf == null){
	    JPanelAdminUsuarios  cidr ;
	    genf=  new JPanelGenericFechar();
	    cidr = new JPanelAdminUsuarios();
	    genf.setJPanelInside(cidr);
	}
	String title = "Gerenciamento de usuários do sistema";
	genf.setName(title);
	genf.setGreatTitle(title);	
	panel.addJPanel(genf);
    }
}
