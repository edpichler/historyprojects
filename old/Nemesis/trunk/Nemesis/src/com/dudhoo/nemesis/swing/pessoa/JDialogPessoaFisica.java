package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaFisicaHome;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import java.awt.Frame;

import org.hibernate.HibernateException;

/**
 *
 * @author duduzera
 */
public class JDialogPessoaFisica extends JDialogGenericSaveCancel{
    private JTabbedPanelOfficialPessoaFisica panel;
    private PessoaFisicaHome phome;

    /**Creates a new instance of JDialogPessoaJuridica
     */
    public JDialogPessoaFisica(Frame parent, boolean modal){
	super(parent, modal, "Pessoa Jurídica");
	initDudu();
	this.setSize(520, 510);
	this.setLocationRelativeTo(null);
    }

    private void initDudu(){
	panel = new JTabbedPanelOfficialPessoaFisica();
	addPanelAtCenter(panel);
	initSaveListener();
    }

    /**
     * Seta uma pessoa física
     */
    public void setPessoaFisica(long id) throws Exception{
	try  {
	    this.phome = new PessoaFisicaHome();            
	    this.panel.setPessoaFisica(phome.findById(id, phome.currentSession()));
	} catch (Exception ex)  {
	    throw ex;
	} finally  {
            phome.closeSession();
	}
    }

    private void initSaveListener(){
	this.setSavePressListener(new JDialogPessoaFisica.SaveAdapter());
    }

    private class SaveAdapter implements SavePressListener{
	public void doAfterClick(){
	    try{
                phome = new PessoaFisicaHome();		
		PessoaFisica pf = panel.getPessoaFisica();
	        panel.getPessoa().setNome(panel.getNome());
		pf.setPessoa(panel.getPessoa());
		phome.saveOrUpdate(pf);		
		messageAfterTheSaveWithSucess(panel);
	    } catch(Exception xxx){		
		erro(StartFrame.getCurrentInstance(), xxx);
		xxx.printStackTrace();
	    }finally{
                phome.closeSession();
            }
	}
	
    }
}
