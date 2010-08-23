package com.dudhoo.nemesis.swing.contas.tipo;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.TipoConta;
import com.dudhoo.nemesis.swing.contas.tipo.event.SalvaTipoConta;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import java.awt.Frame;

public class JDialogTipoContas extends JDialogGenericSaveCancel {
    private PanelTipoContas panel;
    public JDialogTipoContas(Frame parent, boolean modal) {
        super(parent, modal, "Tipo de conta");
        jbInit();
    }
    private void jbInit(){
        panel = new PanelTipoContas();
        addPanelAtCenter(panel);
        setSize(380,300);
        setLocationRelativeTo(null);
        initListeners();
    }
    public void setTipo(TipoConta _tipo) {
        panel.setTipo(_tipo);
    }
    public TipoConta getTipoConta() throws ValidationException{
        return panel.getTipo();
    }
    public void initListeners(){
        this.setSavePressListener(new SalvaTipoConta(this));
    }
}
