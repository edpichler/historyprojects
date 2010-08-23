/*
 * JTabbedPanelOfficialPessoaJuridica.java
 *
 * Created on 16 de Fevereiro de 2006, 00:09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.pessoa;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;

import java.awt.Dimension;

/**
 *Form para salvar e editar pessoas
 * @author duduzera
 */
public class JTabbedPanelOfficialPessoaJuridica extends JTabbedPanelRootPessoa{
    private JPanelPessoaJuridica panelPj;
    /**
     * Creates a new instance of JTabbedPanelOfficialPessoaJuridica
     */
    public JTabbedPanelOfficialPessoaJuridica() {
        super();
//        int count = this.getTabCount();
        panelPj = new JPanelPessoaJuridica() ;
        this.insertTab("Pessoa Jurídica", null, panelPj, null, 0);
        this.setSelectedIndex(0);
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }
    
    public PessoaJuridica getPessoaJuridica() throws Exception{
        return panelPj.getPessoaJuridica(); 
    }    
    public void setPessoaJuridica(PessoaJuridica pj){
        panelPj.setPessoaJuridica(pj);
        this.setPessoa(pj.getPessoa());
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(407, 432));
    }
}
