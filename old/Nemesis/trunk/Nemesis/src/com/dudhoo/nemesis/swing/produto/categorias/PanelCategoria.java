package com.dudhoo.nemesis.swing.produto.categorias;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.CategoriaProduto;

import com.dudhoo.nemesis.swing.JPanelObservacoes;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCategoria extends JPanel{
    CategoriaProduto categoriaProduto;
    private JPanelObservacoes jPanelObservacoes1 = new JPanelObservacoes();
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextFieldNome = new JTextField();

    public PanelCategoria() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCategoriaProduto(CategoriaProduto _categoriaProduto) {
        this.categoriaProduto = _categoriaProduto;
        if(this.categoriaProduto == null){
            this.jTextFieldNome.setText(null);
            this.jPanelObservacoes1.setObs(null);;
        }else{
            this.jTextFieldNome.setText(categoriaProduto.getNome());
            this.jPanelObservacoes1.setObs(categoriaProduto.getObservacao());
        }
    }

    public CategoriaProduto getCategoriaProduto() throws ValidationException{
        if(this.categoriaProduto == null){
            this.categoriaProduto = new CategoriaProduto();
        }
        String nome = this.jTextFieldNome.getText().trim();
        int q = 2;
        if(nome.length() < q ){
            throw new ValidationException("O nome tem que ter mais de " + q +" caracteres");
        }
        this.categoriaProduto.setUsuario(Application.getUsuarioLogado());
        this.categoriaProduto.setNome(nome);
        this.categoriaProduto.setObservacao(this.jPanelObservacoes1.getObs());
        return categoriaProduto;
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(435, 137));
        this.setLayout(null);
        jPanelObservacoes1.setBounds(new Rectangle(85, 45, 340, 85));
        jLabel1.setText("Nome:");
        jLabel1.setBounds(new Rectangle(10, 15, 75, 15));
        jTextFieldNome.setBounds(new Rectangle(85, 15, 335, 20));
        this.add(jTextFieldNome, null);
        this.add(jLabel1, null);
        this.add(jPanelObservacoes1, null);
    }
}
