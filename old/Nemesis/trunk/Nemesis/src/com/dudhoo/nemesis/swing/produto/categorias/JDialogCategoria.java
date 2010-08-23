package com.dudhoo.nemesis.swing.produto.categorias;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.CategoriaProduto;
import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import com.dudhoo.nemesis.swing.produto.categorias.event.SaveCategoriaAdapter;

import java.awt.Frame;

import org.hibernate.HibernateException;

public class JDialogCategoria  extends JDialogGenericSaveCancel{
    PanelCategoria panel = new PanelCategoria();
    public JDialogCategoria(Frame frame, boolean modal) {
        super(frame, modal, "Categoria de produto");
        jbinit();
    }
    private void jbinit(){        
        addPanelAtCenter(panel);
        setSize(440,230);
        centralize();
        initListeners();
    }
    private void initListeners(){
        this.setSavePressListener(new SaveCategoriaAdapter(this));
    }
    public CategoriaProduto getCategoriaProduto() throws ValidationException{
        return panel.getCategoriaProduto();
    }
    public void setCategoriaProduto(long id ){
        CategoriaProdutoHome phome = new CategoriaProdutoHome();
        try  {
            CategoriaProduto cat = phome.findById(id, phome.currentSession());            
            panel.setCategoriaProduto(cat);
        } catch (HibernateException ex)  {
            throw ex;
        } finally  {
            phome.closeSession();
        }
    }
}
