package com.dudhoo.farmaco.swing;

import com.dudhoo.evilframework.components.BotaoLimpar16;
import com.dudhoo.evilframework.components.BotaoLimpar24;
import com.dudhoo.evilframework.swing.EvilAsk;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.evilframework.swing.EvilMain;
import com.dudhoo.farmaco.app.Application;
import com.dudhoo.farmaco.hibernate.PrincipioAtivo;
import com.dudhoo.farmaco.hibernate.PrincipioAtivoHome;
import com.dudhoo.farmaco.swing.event.AboutAdapter;
import com.dudhoo.farmaco.swing.event.ClearPesquisaListener;
import com.dudhoo.farmaco.swing.pAtivo.JDialogPrincipioAtivo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class StartFrame extends EvilMain{

    private static StartFrame instance;

    private StartFrame(String nome){
	super(nome);
	jbInit();
	
    }

    public static StartFrame getCurrentInstance(){
	if(instance == null){	   
	    instance = new StartFrame(Application.getConfiguration().getString(Application.APP_NAME ));            
	}
	return instance;
    }

    private void jbInit(){
        initDudu();
    }
    
    private void initDudu(){
        this.getContentsMenuItem().setVisible(false);
        this.getJMenuSystem().setVisible(false);
            
	PanelPesquisa jpanel = PanelPesquisa.getInstance();
	getContentPane().add(jpanel);
        
        JButton novo = new JButton("Novo");
        novo.setMnemonic('n');
        novo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JDialogPrincipioAtivo p = new JDialogPrincipioAtivo(StartFrame.getCurrentInstance(), true);
                p.setVisible(true);
            }
        });
        getJToolBarPrincipal().add(novo);
        
        JButton edi = new JButton("Editar");
        edi.setMnemonic('d');
        edi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){                
                PanelPesquisa pan = PanelPesquisa.getInstance();
                PrincipioAtivo o = (PrincipioAtivo) pan.getSelectedPrincipioAtivo();
                if(o != null){
                    JDialogPrincipioAtivo p = new JDialogPrincipioAtivo(StartFrame.getCurrentInstance(), true);
                    p.setPrincipioAtivo((PrincipioAtivo)o);
                    p.setVisible(true);
                }
                
            }
        });
        getJToolBarPrincipal().add(edi);
        
        
        JButton delete = new JButton("Delete");
        delete.setMnemonic('D');
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                try{
                    PanelPesquisa pan = PanelPesquisa.getInstance();
                    PrincipioAtivo o = (PrincipioAtivo) pan.getSelectedPrincipioAtivo();
                    if(o != null){
                        if (new EvilAsk(StartFrame.getCurrentInstance())
                            .setVisible("Tem certeza que deseja remover") == JOptionPane.YES_OPTION){
                            PrincipioAtivoHome home = new PrincipioAtivoHome();
                            home.delete(o);
                            new EvilInformation(StartFrame.getCurrentInstance()).showMessage("Removido com sucesso!");
                        }
                    }               
                }catch(Exception exc){
                    new EvilError(StartFrame.getCurrentInstance(), false, exc).setVisible(true);
                }
            }
        });
        getJToolBarPrincipal().add(delete);     
        
        
        
        BotaoLimpar24 limpar = new BotaoLimpar24();
        limpar.setText("Limpar");
        limpar.setMnemonic('L');
        limpar.setToolTipText("Limpa os resultados de uma pesquisa");
        limpar.addActionListener(new ClearPesquisaListener());
        getJToolBarPrincipal().add(limpar);    
        
        this.setDialogAboutListener( new AboutAdapter());
    }
}
