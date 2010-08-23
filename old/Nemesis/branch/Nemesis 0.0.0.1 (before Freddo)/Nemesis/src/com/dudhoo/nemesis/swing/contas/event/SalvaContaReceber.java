package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.ContaPagarHome;
import com.dudhoo.nemesis.hibernate.ContaReceberHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.JDialogContaReceber;

public class SalvaContaReceber implements SavePressListener{
    private JDialogContaReceber dia;

    public SalvaContaReceber(JDialogContaReceber _dia){
	dia = _dia;
    }

    public void doAfterClick(){
	try{
	    ContaReceberHome hom = new ContaReceberHome();
	    hom.saveOrUpdate(dia.getJPanelContaRec().getContaReceber());
	    hom.closeSession();
	    new EvilInformation(dia).showMessage("Salvo com sucesso!");
	    dia.close();
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	}
    }
}
