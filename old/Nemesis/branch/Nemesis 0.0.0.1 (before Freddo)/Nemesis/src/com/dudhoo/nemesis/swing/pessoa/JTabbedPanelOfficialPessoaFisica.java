package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;

import java.awt.Dimension;

/**
 * Form para salvar e editar pessoas
 * @author duduzera
 */
public class JTabbedPanelOfficialPessoaFisica
    extends JTabbedPanelRootPessoa{
    private JPanelPessoaFisica panelPf;

    /**
     * Creates a new instance of JTabbedPanelOfficialPessoaJuridica
     */
    public JTabbedPanelOfficialPessoaFisica(){
	super();
//	int count = this.getTabCount();
	panelPf = new JPanelPessoaFisica();
	this.insertTab("Pessoa Física", null, panelPf, null, 0);
	this.setSelectedIndex(0);
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    public PessoaFisica getPessoaFisica() throws Exception{
	return panelPf.getPessoaFisica();
    }

    public void setPessoaFisica(PessoaFisica pj) throws Exception{
	panelPf.setPessoaFisica(pj);
	this.setPessoa(pj.getPessoa());
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(407, 432));
    }
}
