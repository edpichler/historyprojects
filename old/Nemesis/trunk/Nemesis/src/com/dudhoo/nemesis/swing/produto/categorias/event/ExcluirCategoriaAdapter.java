package com.dudhoo.nemesis.swing.produto.categorias.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;
import com.dudhoo.nemesis.hibernate.TipoContaHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

public class ExcluirCategoriaAdapter implements ExcluirPressListener {
    PanelPesquisaGeneric panel = null;
    public ExcluirCategoriaAdapter(PanelPesquisaGeneric _panel) {
        panel = _panel;
    }
    public void doAfterClick(){
        CategoriaProdutoHome home = new CategoriaProdutoHome();
        try {
            long id = Long.valueOf(panel.getIdCampoSelecionado().toString());
            home.deleteById(id);
            new EvilInformation(panel).showMessage("Removido com sucesso!");            
        } catch (Exception ex) {
            new EvilError(StartFrame.getCurrentInstance(), true, 
                          ex).setVisible(true);
        }  
    }
}
