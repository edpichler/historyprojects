package com.dudhoo.nemesis.swing.contas.tipo.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.TipoConta;
import com.dudhoo.nemesis.hibernate.TipoContaHome;
import com.dudhoo.nemesis.swing.contas.tipo.JDialogTipoContas;
import com.dudhoo.nemesis.swing.contas.tipo.PanelTipoContas;

public class SalvaTipoConta implements SavePressListener{
    JDialogTipoContas dialog;
    public SalvaTipoConta(JDialogTipoContas _pa) {
        dialog =  _pa;
    }
    public void doAfterClick(){
        TipoContaHome home = new TipoContaHome();
        try  {
            TipoConta tipo = dialog.getTipoConta();          
            home.saveOrUpdate(tipo);          
            new EvilInformation(dialog).showMessage("Salvo com sucesso!");               
            dialog.close();
        } catch (Exception ex)  {
            new EvilError(null, true, ex).setVisible(true); 
        } finally  {
            home.closeSession();
        }
    }
}
