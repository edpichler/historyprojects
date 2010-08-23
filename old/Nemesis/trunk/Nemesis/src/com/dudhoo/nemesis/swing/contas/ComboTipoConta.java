package com.dudhoo.nemesis.swing.contas;

import com.dudhoo.nemesis.hibernate.TipoConta;
import com.dudhoo.nemesis.hibernate.TipoContaHome;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboTipoConta extends JComboBox {
    public ComboTipoConta(boolean credito) {
        jbInit(credito);
    }

    private void jbInit(boolean credito) {
        TipoContaHome home = new TipoContaHome();
        List<TipoConta> lista = null;
        if (credito) {
            lista = home.getAllTipoContasCredito();
        } else {
            lista = home.getAllTipoContasDebito();
        }
        if (lista != null) {
            DefaultComboBoxModel mod = new DefaultComboBoxModel();
            for (int i = 0; i < lista.size(); i++) {
                mod.addElement(lista.get(i));
            }
            this.setModel(mod);
        }
    }

    public TipoConta getTipoConta() {
        if (this.getModel().getSize() > 0) {
            return (TipoConta)this.getModel().getSelectedItem();
        } else {
            return null;
        }
    }

    public void setTipoConta(TipoConta tipo) {
        for (int i = 0; i < this.getModel().getSize(); i++) {
            TipoConta temp = (TipoConta)this.getModel().getElementAt(i);
            if (temp.getId() == tipo.getId()) {
                setSelectedIndex(i);
            }
        }
    }
}