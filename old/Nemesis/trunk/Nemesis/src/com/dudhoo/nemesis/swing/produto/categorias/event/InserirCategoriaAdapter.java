package com.dudhoo.nemesis.swing.produto.categorias.event;

import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.produto.categorias.JDialogCategoria;

public class InserirCategoriaAdapter implements InserirPressListener {
    public InserirCategoriaAdapter() {
    }
    public void doAfterClick(){
        new JDialogCategoria(StartFrame.getCurrentInstance(), true).setVisible(true);
    }
}
