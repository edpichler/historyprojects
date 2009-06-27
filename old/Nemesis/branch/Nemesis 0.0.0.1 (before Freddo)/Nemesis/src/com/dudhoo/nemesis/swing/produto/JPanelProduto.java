package com.dudhoo.nemesis.swing.produto;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.Produto;

import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;
import com.dudhoo.nemesis.swing.fornecedor.JPanelListaFornecedores;

import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import java.awt.Rectangle;

import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelProduto extends JPanel{
    private Produto produto;
    private JLabel jLabelProduto = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JPanelListaFornecedores panelForn = 
	new JPanelListaFornecedores();

    public JPanelProduto(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }
    
    public Set <Pessoa> getFornecedores(){
	return panelForn.getFornecedores();		
    }    
    public void setFornecedores(Set <Pessoa> forn){
	panelForn.setFornecedores(forn);
    }

    public Produto getProduto() throws ValidationException{
	String nome = this.jTextField1.getText().trim();
	if(nome == null || nome.length() < 3){
	    throw new ValidationException("Digite um produto com mais de 3 caracteres.");
	}
	if(produto == null){
	    produto = new Produto();
	}
	produto.setNome(nome);
	produto.setUsuario(Application.getUsuarioLogado());
	produto.setFornecedores(panelForn.getFornecedores());
	return produto;
    }

    public void setProduto(Produto produto){
	this.produto = produto;
	if(this.produto != null){
	    this.jTextField1.setText(produto.getNome());
	    this.panelForn.setFornecedores(produto.getFornecedores());
	}else{
	    this.jTextField1.setText(null);
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(446, 209));
	jLabelProduto.setText("Produto:");
	jLabelProduto.setBounds(new Rectangle(5, 5, 40, 15));
	jTextField1.setColumns(47);
	jTextField1.setBounds(new Rectangle(45, 5, 390, 20));
	panelForn.setBounds(new Rectangle(5, 35, 430, 165));
	panelForn.setToolTipText("Fornecedores do produto");
	this.setLayout(null);
	this.add(panelForn, null);
	this.add(jLabelProduto, 
	  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 8, 0), 0, 0));
	this.add(jTextField1, 
	  new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 10), 0, 0));
    }
}
