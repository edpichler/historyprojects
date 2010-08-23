package com.dudhoo.nemesis.swing.produto.categorias.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.hibernate.CategoriaProduto;
import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;
import com.dudhoo.nemesis.hibernate.TipoConta;
import com.dudhoo.nemesis.hibernate.TipoContaHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.contas.tipo.JDialogTipoContas;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.produto.categorias.JDialogCategoria;

public class EditarCategoriaAdapter implements EditarPressListener {
    PanelPesquisaGeneric panel = null;
    public EditarCategoriaAdapter(PanelPesquisaGeneric _panel ) {
        panel = _panel;
    }
    public void doAfterClick(){       
        CategoriaProdutoHome home = new CategoriaProdutoHome();
        try {
            long id = Long.valueOf(panel.getIdCampoSelecionado().toString());                             
            JDialogCategoria dialog = new JDialogCategoria(StartFrame.getCurrentInstance(), true);
            dialog.setCategoriaProduto(id);
            dialog.setVisible(true);            
        } catch (Exception ex) {
            new EvilError(StartFrame.getCurrentInstance(), true, 
                          ex).setVisible(true);
        }      
    }
}
