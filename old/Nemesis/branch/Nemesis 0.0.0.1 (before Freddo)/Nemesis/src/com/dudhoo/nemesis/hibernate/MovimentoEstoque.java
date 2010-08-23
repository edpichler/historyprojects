package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.abstracts.ContaFinanceira;
import com.dudhoo.nemesis.hibernate.abstracts.Entidade;

public class MovimentoEstoque extends Entidade{
    //TODO TERÁ DE TER A UNIDADE DE MEDIDA
    private Produto produto;
    private long quantidade;
    private Pessoa pessoa;
    private long precoUnitario;
    private ContaFinanceira conta;
    
    public MovimentoEstoque(){
    }

    public Produto getProduto(){
	return produto;
    }

    public void setProduto(Produto produto){
	this.produto = produto;
    }

    public long getQuantidade(){
	return quantidade;
    }

    public void setQuantidade(long quantidade){
	this.quantidade = quantidade;
    }

    public Pessoa getPessoa(){
	return pessoa;
    }

    public void setPessoa(Pessoa pessoa){
	this.pessoa = pessoa;
    }

    public long getPrecoUnitario(){
	return precoUnitario;
    }

    public void setPrecoUnitario(long precoUnitario){
	this.precoUnitario = precoUnitario;
    }

    public void setConta(ContaFinanceira conta){
	this.conta = conta;
    }

    public ContaFinanceira getConta(){
	return conta;
    }
}
