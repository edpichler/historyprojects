package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Produto{
    private long id;	
    private String nome;
    private String fabricante;
    private Usuario usuario;
    private Date ultMod;
    private long precoVenda;
    private Set <Pessoa> fornecedores = new HashSet();
    private CategoriaProduto categoriaProduto; //TODO PODE PERTENCER NA VERDADE A MAIS DE UMA CATEGORIA
    public Produto(){
    }

    public long getId(){
	return id;
    }

    public void setId(long id){
	this.id = id;
    }

    public String getNome(){
	return nome;
    }

    public void setNome(String nome){
	this.nome = nome;
    }


    public void setUsuario(Usuario usuario){
	this.usuario = usuario;
    }

    public Usuario getUsuario(){
	return usuario;
    }

    public void setUltMod(Date ultMod){
	this.ultMod = ultMod;
    }

    public Date getUltMod(){
	return ultMod;
    }

    public Set <Pessoa> getFornecedores(){
	return fornecedores;
    }

    public void setFornecedores(Set <Pessoa> fornecedores){
	this.fornecedores = fornecedores;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setPrecoVenda(long precoVenda) {
        this.precoVenda = precoVenda;
    }

    public long getPrecoVenda() {
        return precoVenda;
    }
}
