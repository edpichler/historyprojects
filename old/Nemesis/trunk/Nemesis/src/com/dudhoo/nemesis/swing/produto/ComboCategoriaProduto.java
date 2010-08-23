package com.dudhoo.nemesis.swing.produto;

import com.dudhoo.nemesis.hibernate.CategoriaProduto;
import com.dudhoo.nemesis.hibernate.CategoriaProdutoHome;
import com.dudhoo.nemesis.hibernate.TipoConta;
import com.dudhoo.nemesis.hibernate.TipoContaHome;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboCategoriaProduto extends JComboBox{
    public ComboCategoriaProduto() {
        jbInit();
    }
    private void jbInit(){
        CategoriaProdutoHome home = new CategoriaProdutoHome();
        List <CategoriaProduto> lista = null;                
        lista = home.getAllCategoria();
        if(lista != null){
            DefaultComboBoxModel mod = new DefaultComboBoxModel();
            for (int i = 0; i < lista.size(); i++)  {
                mod.addElement(lista.get(i));
            }
            this.setModel(mod);
        }
    }
    
    public CategoriaProduto getCategoriaProduto(){
        if(this.getModel().getSize() > 0){
            return (CategoriaProduto) this.getModel().getSelectedItem();
        }else{
            return null;
        }
    }
    public void setCategoriaProduto(CategoriaProduto prod) {
        for (int i = 0; i < this.getModel().getSize(); i++) {
            CategoriaProduto cat = (CategoriaProduto) this.getModel().getElementAt(i);
            if (cat.getId() == prod.getId()) {
                setSelectedIndex(i);
            }
        }
    }
}
