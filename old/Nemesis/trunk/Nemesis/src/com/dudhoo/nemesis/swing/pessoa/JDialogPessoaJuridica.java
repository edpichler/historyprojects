/*
 * JDialogPessoaJuridica.java
 *
 * Created on 16 de Fevereiro de 2006, 00:18
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;

import java.awt.Component;
import java.awt.Frame;
import org.hibernate.HibernateException;


/**
 *
 * @author duduzera
 */
public class JDialogPessoaJuridica extends JDialogGenericSaveCancel{
    JTabbedPanelOfficialPessoaJuridica panel ;
    PessoaJuridicaHome pjhome;
    /** Creates a new instance of JDialogPessoaJuridica */
    public JDialogPessoaJuridica(Frame parent, boolean modal) {
        super(parent, modal,"Pessoa Jurídica");
        initDudu();
        this.setSize(520, 510);
        this.setLocationRelativeTo(null);
    }
    
    private void initDudu(){
        panel = new JTabbedPanelOfficialPessoaJuridica();
        addPanelAtCenter(panel);
        initSaveListener();
    }
    
    /**
     * Seta uma pessoa juridica
     */
    public void setPessoaJuridica(Long id) throws HibernateException{
        this.pjhome = new PessoaJuridicaHome();                
        try  {
            this.panel.setPessoaJuridica(pjhome.findById(id, pjhome.currentSession()));    
        } catch (HibernateException ex){
            throw ex;
        } finally  {
            pjhome.closeSession();
        }
    }
    
    private void initSaveListener(){
        this.setSavePressListener(new SaveAdapter());        
    }
   
    private class SaveAdapter implements SavePressListener{
        public void doAfterClick(){
            try{
                pjhome = new PessoaJuridicaHome();                
                PessoaJuridica pj = panel.getPessoaJuridica();
                panel.getPessoa().setNome(panel.getFantasia());                
                pj.setPessoa( panel.getPessoa());
                pjhome.saveOrUpdate(pj);
                messageAfterTheSaveWithSucess(panel);//TODO VER ONDE TEM SALVO COM SUCESSO NO PROGRAMA E SUBSTITUIR COMO ESTÁ AQUI NESSE METODO
            }catch(Exception xxx){
		xxx.printStackTrace();
		erro(StartFrame.getCurrentInstance(), xxx);
            }
        }
    }
}