package com.dudhoo.nemesis.swing;

import com.dudhoo.evilframework.swing.eventListeners.DialogAboutListener;
import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.hibernate.thread.InitHibernate;
import com.dudhoo.nemesis.swing.factory.menu.MenuCadastroFactory;
import com.dudhoo.nemesis.swing.factory.menu.MenuComprasFactory;
import com.dudhoo.nemesis.swing.factory.menu.MenuFinancasFactory;
import com.dudhoo.nemesis.swing.factory.menu.MenuRelatoriosFactory;
import com.dudhoo.nemesis.swing.factory.menu.MenuSegurancaFactory;

import com.dudhoo.nemesis.swing.factory.menu.MenuVendasFactory;

import com.dudhoo.nemesis.swing.login.DailogLogin;

import javax.swing.JMenu;
import javax.swing.JPanel;


/**
 *
 * @author dudu
 */
public class StartFrame extends com.dudhoo.evilframework.swing.EvilMain{
    private static StartFrame instance;

    /**
     * Creates a new instance of FrameMain
     */
    private StartFrame(String title){
	super(title);
	Application.getConfiguration(); // inicializar
	iniciaThreadHibernate();
        new DailogLogin().setVisible(true);
	configuraAbout();
	configuraMenus();
        configuraBarraTitulo();
    }   
    public void configuraBarraTitulo(){
        this.setTitle(this.getTitle() + " - " + Application.getUsuarioLogado().getNome());
    }

    /**
     *Inicia uma thread do hibernate em baixa prioridade para fazer o hibernate ir iniciando com a aplicação.
     */
    private void iniciaThreadHibernate(){
	InitHibernate h = new InitHibernate();
	h.start();
    }

    public static StartFrame getCurrentInstance(){
	if(instance == null){
	    instance =  new StartFrame(
                Application.getConfiguration().getString(Application.APP_NAME));
	}
	return instance;
    }

    private void configuraMenus(){
	JMenu menuCadastros =
	    super.addMenu(new MenuCadastroFactory().constroiMenuCadastros());
	JMenu menuCompras =
	    super.addMenu(new MenuComprasFactory().getMenuCompras());
	JMenu menuFinancas =
	    super.addMenu(new MenuFinancasFactory().getMenuFinanca());
	JMenu menuRel =
	    super.addMenu(new MenuRelatoriosFactory().getMenuRelatorios());
	JMenu menuSeguranca =
	    super.addMenu(new MenuSegurancaFactory().getMenuSeguranca());
	JMenu menuVendas =
	    super.addMenu(new MenuVendasFactory().getMenuVendas());

    }

    private void configuraAbout(){
	this.setDialogAboutListener(new DialogAboutListener(){
		    public JPanel getPanel(){
			return new PanelAbout();
		    }

		    public String getTabName(){
			return "Sobre";
		    }
		});
    }

}
