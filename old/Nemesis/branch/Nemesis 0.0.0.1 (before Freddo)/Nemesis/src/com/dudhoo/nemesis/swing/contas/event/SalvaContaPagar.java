package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.ContaPagarHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.JDialogContaPagar;
import com.dudhoo.nemesis.swing.contas.JPanelContaPagar;
import com.dudhoo.evilframework.swing.*;

public class SalvaContaPagar implements SavePressListener{
    JDialogContaPagar jDialogContaPagar;

    public SalvaContaPagar(JDialogContaPagar _jDialogContaPagar){
	jDialogContaPagar = _jDialogContaPagar;
	;
    }

    public void doAfterClick(){
	try{
	    ContaPagarHome hom = new ContaPagarHome();
	    hom.saveOrUpdate(jDialogContaPagar.getJPanelContaPagar().getContaPagar());
	    hom.closeSession();
	    new EvilInformation(jDialogContaPagar).showMessage("Salvo com sucesso!");
	    jDialogContaPagar.close();
	} catch(Exception ex){
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	}
    }
}
