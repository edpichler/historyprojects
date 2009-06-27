/*
 * JDialogCadRamos.java
 *
 * Created on 16 de Fevereiro de 2006, 22:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.ramos;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;
import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;
import java.awt.Frame;

/**
 *
 * @author duduzera
 */
public class JDialogCadRamos extends JDialogGenericSaveCancel {
    private JPanelCadRamos cad = null;
    /** Creates a new instance of JDialogCadRamos */
    private boolean update = false;
    public JDialogCadRamos(Frame parent, boolean modal) {
        super(parent, modal,"Ramos");
        cad = new JPanelCadRamos();
        this.addPanelAtCenter(cad);
        adicionaListeners();
        this.pack();
        this.setLocationRelativeTo(null);
    }
    private void adicionaListeners(){
        this.setSavePressListener(new SavePressListener(){
            public void doAfterClick(){
                if(update ==false){
                    salvaNovo();
                }else{
                    salvaEditado();
                }                
            }
        });
    }
    
    public void setRamo(Ramo ra){
        try{
            cad.setRamo(ra);
            this.update = true;
        }catch(Exception xxx){
            new com.dudhoo.evilframework.swing.EvilError(null, false, xxx).setVisible(true);
        }
    }
    
    public Ramo getRamo(){
        try{
            return cad.getRamo();
        }catch(Exception xxx){
            new com.dudhoo.evilframework.swing.EvilError(null, false, xxx).setVisible(true);
            return null;
        }
    }
    
    private void salvaNovo(){
        try{
            Ramo temp = cad.getRamo();
            temp.setUsuario(Application.getUsuarioLogado());
            temp.setUltMod(java.util.Calendar.getInstance().getTime()); //TODO MUDAR PARA O BANCO COLOCAR A DATA AUTOMÁTICO
            new RamoHome().persist(temp);
            messageAfterTheSaveWithSucess(this);
            close();
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    private void salvaEditado(){
        try{
            Ramo temp = cad.getRamo();
            temp.setUsuario(Application.getUsuarioLogado());
            temp.setUltMod(java.util.Calendar.getInstance().getTime()); //TODO MUDAR PARA O BANCO COLOCAR A DATA AUTOMÁTICO
            new RamoHome().update(temp);
            messageAfterTheSaveWithSucess(this);
            close();
        }catch(Exception xxx){
            erro(null, xxx);
        }
    }
    
}
