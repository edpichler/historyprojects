/*
 * JDialogCidade.java
 *
 * Created on 14 de Fevereiro de 2006, 23:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.cidadesRegioes;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.Cidade;
import com.dudhoo.nemesis.hibernate.CidadeHome;
import com.dudhoo.nemesis.hibernate.Estado;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import java.awt.Frame;

import org.hibernate.HibernateException;


/**
 *
 * @author duduzera
 */
public class JDialogCidade extends JDialogGenericSaveCancel{
    JPanelCidade panelCida;
    Estado estado;
    boolean update = false;
    /** Creates a new instance of JDialogCidade */
    public JDialogCidade(Frame parent, boolean modal, Estado es){
        super(parent, modal, "Cidade");        
        estado = es;
        init();
        addListeners();
        pack();
    }
    public JDialogCidade(Frame parent, boolean modal, Cidade cida){
        this(parent, modal, cida.getEstado());
        this.panelCida.setCidade(cida);
        update = true;
    }
    private void init(){
        panelCida =  new JPanelCidade();
        super.addPanelAtCenter(panelCida);
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
    
    private void salvaEditado(){
        try{
            Cidade temp = this.panelCida.getCidade();
            temp.setUltMod(java.util.Calendar.getInstance().getTime());
            temp.setUsuario(Application.getUsuarioLogado());
            new CidadeHome().update(temp);
            messageAfterTheSaveWithSucess(panelCida);
            close();
        }catch(HibernateException xxx){
            erro(null, xxx);
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    
    private void salvaNovo(){
        try{
            Cidade c = panelCida.getCidade();
            c.setUltMod(java.util.Calendar.getInstance().getTime());
            c.setUsuario(Application.getUsuarioLogado());
            c.setEstado(estado);
            new CidadeHome().persist(c);
            messageAfterTheSaveWithSucess(panelCida);
            close();
        }catch(HibernateException xxx){
            erro(null, xxx);
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    
}
