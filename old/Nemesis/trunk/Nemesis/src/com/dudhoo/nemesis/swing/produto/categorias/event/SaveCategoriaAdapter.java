package com.dudhoo.nemesis.swing.produto.categorias.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.produto.categorias.JDialogCategoria;
import com.dudhoo.nemesis.swing.produto.categorias.PanelCategoria;

public class SaveCategoriaAdapter implements SavePressListener {
    JDialogCategoria dialog = null;

    public SaveCategoriaAdapter(JDialogCategoria _dial) {
        dialog = _dial;
    }

    public void doAfterClick() {

        CategoriaProdutoHome home = new CategoriaProdutoHome();
        try {
            home.saveOrUpdate(dialog.getCategoriaProduto());
            new EvilInformation(dialog).showMessage("Salvo com sucesso!");
            dialog.close();
        } catch (Exception ex) {
            new EvilError(StartFrame.getCurrentInstance(), true, 
                          ex).setVisible(true);
        } finally {
            home.closeSession();
        }

    }
}
