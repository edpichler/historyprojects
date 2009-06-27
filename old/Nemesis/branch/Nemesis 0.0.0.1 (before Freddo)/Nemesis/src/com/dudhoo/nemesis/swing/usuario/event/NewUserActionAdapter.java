package com.dudhoo.nemesis.swing.usuario.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.GrupoUsuario;
import com.dudhoo.nemesis.hibernate.UsuarioHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.usuario.JDialogUsuario;

import com.dudhoo.nemesis.swing.usuario.JPanelAdminUsuarios;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

public class NewUserActionAdapter implements ActionListener{
    private JPanelAdminUsuarios panel= null;

    public NewUserActionAdapter(JPanelAdminUsuarios _panel) throws NullPointerException{
	panel = _panel;
    }

    public void actionPerformed(ActionEvent actionEvent){
	salva();
    }

    private void salva(){
	GrupoUsuario grupo = panel.getGrupoUsuario();
	JDialogUsuario jd = new JDialogUsuario(StartFrame.getCurrentInstance(), true, grupo);
	jd.setVisible(true);
	if(jd.getOpcao() == OpcaoEscolhida.SAVE){
	    panel.preencherDados();
	    //TODO SELECIONAR O GRUPO E O USUÁRIO NOVO
	}
    }
}
