package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.usuario.event.UsuarioEditarPressListenerAdapter;
import com.dudhoo.nemesis.swing.usuario.event.UsuarioExcluirPressListenerAdapter;
import com.dudhoo.nemesis.swing.usuario.event.UsuarioInserirPressListenerAdapter;

public class PanelPesquisaUsuariosBuilder{
    public PanelPesquisaUsuariosBuilder(){
    }
    public  PanelPesquisaGeneric getPanelPesquisarUsuarios(boolean criaBotaoFechar, boolean isSelectable){
	final PanelPesquisaGeneric panel = new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
	//panel.setInserirListener();
	panel.setName("Usuários");
	StartFrame.getCurrentInstance().addJPanel(panel);
	panel.setSqlQueryToFilteredRowSet("select  usuario.NOME, GRUPO_USUARIO.NOME as Grupo, " +
	"GRUPO_USUARIO.descricao as Descrição, email from usuario \n" + 
	"inner join grupo_usuario on \n" + 
	"usuario.GRUPO_USUARIO_ID = GRUPO_USUARIO.id\n" + 
	"order by usuario.ID", null);
	panel.setInserirListener(new UsuarioInserirPressListenerAdapter(panel));
	panel.setEditarListener(new UsuarioEditarPressListenerAdapter(panel));
	panel.setExcluirListener(new UsuarioExcluirPressListenerAdapter(panel));
	return panel;
    }
}
