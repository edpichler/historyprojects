package com.dudhoo.nemesis.swing.contas.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.hibernate.CategoriaProduto;
import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;
import com.dudhoo.nemesis.hibernate.TipoConta;
import com.dudhoo.nemesis.hibernate.TipoContaHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.tipo.JDialogTipoContas;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import com.dudhoo.nemesis.swing.produto.categorias.JDialogCategoria;

import test.com.dudhoo.nemesis.swing.produto.categorias.JDialogCategoriaTest;

public class EditarTipoContaAdapter implements EditarPressListener {
    PanelPesquisaGeneric panel;

    public EditarTipoContaAdapter(PanelPesquisaGeneric _pan) {
        panel = _pan;
    }

    public void doAfterClick() {
        TipoContaHome home = new TipoContaHome();
        try {
            long id = Long.valueOf(panel.getIdCampoSelecionado().toString());
            TipoConta tip = home.findById(id);
            if(tip != null){
                JDialogTipoContas dialog = new JDialogTipoContas(StartFrame.getCurrentInstance(), true);
                dialog.setTipo(tip);
                dialog.setVisible(true);
            }
        } catch (Exception ex) {
            new EvilError(StartFrame.getCurrentInstance(), true, 
                          ex).setVisible(true);
        }
    }
}
