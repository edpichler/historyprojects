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
    private JLabel jLabel1 = new JLabel();
    private ComboCategoriaProduto comboCategoriaProduto1 = 
        new ComboCategoriaProduto();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextFieldFab = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextFieldPreco = new JTextField();

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
        long preco = Long.valueOf( jTextFieldPreco.getText().toString() );
	produto.setNome(nome);
        produto.setPrecoVenda(preco);
        produto.setFabricante(jTextFieldFab.getText().trim());
	produto.setUsuario(Application.getUsuarioLogado());
	produto.setFornecedores(panelForn.getFornecedores());
        produto.setCategoriaProduto(comboCategoriaProduto1.getCategoriaProduto());
	return produto;
    }

    public void setProduto(Produto produto){
	this.produto = produto;
	if(this.produto != null){
	    this.jTextField1.setText(produto.getNome());
            if(produto.getCategoriaProduto() != null){
                this.comboCategoriaProduto1.setCategoriaProduto(produto.getCategoriaProduto());
            }
            this.jTextFieldFab.setText(produto.getFabricante());
            this.jTextFieldPreco.setText(String.valueOf( produto.getPrecoVenda()));
	    this.panelForn.setFornecedores(produto.getFornecedores());            
	}else{
	    this.jTextField1.setText(null);
	    this.jTextFieldFab.setText(null);
            this.jTextFieldPreco.setText("0");
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(441, 286));
	jLabelProduto.setText("Produto:");
	jLabelProduto.setBounds(new Rectangle(5, 5, 115, 15));
	jTextField1.setColumns(47);
	jTextField1.setBounds(new Rectangle(125, 5, 310, 20));
	panelForn.setBounds(new Rectangle(5, 130, 430, 150));
	panelForn.setToolTipText("Fornecedores do produto");
        jLabel1.setText("Categoria");
        jLabel1.setBounds(new Rectangle(5, 55, 115, 15));
        comboCategoriaProduto1.setBounds(new Rectangle(125, 55, 310, 20));
        jLabel2.setText("Fabricante/Laboratório:");
        jLabel2.setBounds(new Rectangle(5, 80, 115, 15));
        jTextFieldFab.setBounds(new Rectangle(125, 80, 310, 20));
        jLabel3.setText("Preço de Venda:");
        jLabel3.setBounds(new Rectangle(5, 30, 115, 20));
        jTextFieldPreco.setBounds(new Rectangle(125, 30, 310, 20));
        jTextFieldPreco.setToolTipText("null");
        jTextFieldPreco.setText("0");
        this.setLayout(null);
        this.add(jTextFieldPreco, null);
        this.add(jLabel3, null);
        this.add(jTextFieldFab, null);
        this.add(jLabel2, null);
        this.add(comboCategoriaProduto1, null);
        this.add(jLabel1, null);
        this.add(panelForn, null);
        this.add(jLabelProduto, 
	  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 8, 0), 0, 0));
	this.add(jTextField1, 
	  new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 10), 0, 0));
    }
}
