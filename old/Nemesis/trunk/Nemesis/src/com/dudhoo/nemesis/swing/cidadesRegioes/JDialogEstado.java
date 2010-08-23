/*
 * JDialogEstado.java
 *
 * Created on 14 de Fevereiro de 2006, 21:37
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
import com.dudhoo.nemesis.hibernate.Estado;
import com.dudhoo.nemesis.hibernate.EstadoHome;
import com.dudhoo.nemesis.hibernate.Pais;
import java.awt.Frame;
import org.hibernate.HibernateException;
/**
 *
 * @author duduzera
 */
public class JDialogEstado extends JDialogGenericSaveCancel {
    JPanelEstado panelEs ;
    boolean update = false;
    Estado estado;
    Pais pais;
    /** Creates a new instance of JDialogEstado */
    public JDialogEstado(Frame parent, boolean modal, Pais pp) {
        super(parent, modal, "Estado");        
        this.pais = pp;        
        init();
        addListeners();
        pack();
    }
    /**
     * Para fazer update do estado
     */
    public JDialogEstado(Frame parent, boolean modal, Estado pp) {
        this(parent, modal, pp.getPais());                
        estado = pp;
        if(pp != null){
            panelEs.setEstado(estado);
            this.update = true;            
        }
    }
    
    private void init(){
        panelEs =  new JPanelEstado();
        super.addPanelAtCenter(this.panelEs);
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
            Estado e = panelEs.getEstado();
            e.setUltMod(java.util.Calendar.getInstance().getTime());
            e.setUsuario(Application.getUsuarioLogado());
            e.setPais(pais);
            new EstadoHome().persist(e);
            messageAfterTheSaveWithSucess(panelEs);
            close();
        }catch(HibernateException xxx){
            erro(null, xxx);
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }   
    
    private void salvaEditado(){
        try{            
            Estado temp = this.panelEs.getEstado();
            temp.setUltMod(java.util.Calendar.getInstance().getTime());
            temp.setUsuario(Application.getUsuarioLogado());            
            new EstadoHome().update(temp);
            messageAfterTheSaveWithSucess(panelEs);
            close();
        }catch(HibernateException xxx){
            erro(null, xxx);
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }   
}
