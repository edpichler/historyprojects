package com.dudhoo.farmaco.swing;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilMain;
import com.dudhoo.farmaco.app.Application;
import com.dudhoo.farmaco.swing.about.DialogAboutListAdapter;
import com.dudhoo.farmaco.swing.menu.MenuBuilder;

import java.sql.SQLException;


public class StartFrame extends EvilMain{

    private static StartFrame instance;

    public StartFrame(String nome){
	super(nome);
	jbInit();
	initDudu();
    }

    public static StartFrame getCurrentInstance(){
	if(instance == null){
	    String usuario = null;
	    try{
	        usuario = Application.getUsuarioLogado().getNomeCompleto();
	    } catch(SQLException e){
		new EvilError(null, true, e).setVisible(true);
	        usuario = "Não foi possível achar usuário, verifique os logs do sistema.";
	    }
	    instance = new StartFrame(Application.getConfiguration().getString(Application.APP_NAME ) + " - " + usuario);
	}
	return instance;
    }

    private void jbInit(){
	super.setDialogAboutListener(new DialogAboutListAdapter());
    }
    
    private void initDudu(){
	PanelPesquisaPrincipiosAtivos jpanel = PanelPesquisaPrincipiosAtivos.getIntance();
	this.addJPanel(jpanel);
	this.addMenu(new MenuBuilder().getMenuMedicamentos()  );
    }
}
