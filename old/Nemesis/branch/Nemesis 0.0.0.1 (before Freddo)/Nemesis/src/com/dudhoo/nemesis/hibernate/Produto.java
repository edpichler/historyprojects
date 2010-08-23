package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Produto{
    private long id;	
    private String nome;
    private Usuario usuario;
    private Date ultMod;
    private Set <Pessoa> fornecedores = new HashSet();
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
}
