/*
 * JDialogPais.java
 *
 * Created on 9 de Fevereiro de 2006, 19:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.cidadesRegioes;

import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;
import com.dudhoo.nemesis.hibernate.Pais;
import com.dudhoo.nemesis.hibernate.PaisHome;
import java.awt.Frame;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author duduzera
 */
public class JDialogPais extends JDialogGenericSaveCancel{    
    JPanelPais ppais = null;
    
    boolean update = false;
    /** Creates a new instance of JDialogPais */
    public JDialogPais(Frame parent, boolean modal){
        super(parent, modal,"País");        
        init();
        addListeners();
        pack();
        
    }
    
    public JDialogPais(Frame parent, boolean modal, Pais p){
        this(parent, modal);
        
        this.update = true;
        ppais.setPais(p);
    }
    
    private void init(){
        ppais =  new JPanelPais();
        super.addPanelAtCenter(ppais);
    }
    
    private void addListeners(){
        this.setSavePressListener(new SavePressListener(){
            public void doAfterClick(){
                if(update){
                    salvaEditado();
                }else{
                    salvaNovo();
                }
            }
        });
    }
    private void salvaNovo(){
        try{
            Pais p = ppais.getPais();            
            p.setUsuario(Application.getUsuarioLogado());            
            new PaisHome().persist(p);
            messageAfterTheSaveWithSucess(ppais);
            close();
        }catch(HibernateException xxx){
            erro(null, xxx);
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    
    private void salvaEditado(){
        try{
            Pais pais = ppais.getPais();                        
            pais.setUsuario( Application.getUsuarioLogado() );
            PaisHome p = new PaisHome();
            p.update(pais);
            messageAfterTheSaveWithSucess(ppais);
            dispose();
        }catch(HibernateException xxx){
            erro(null, xxx);
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    
    
    
    private void limpa(){
        try{
            this.ppais.limpa();
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    
}
