package com.dudhoo.nemesis.hibernate.abstracts;

import com.dudhoo.nemesis.hibernate.Pessoa;

import com.dudhoo.nemesis.hibernate.TipoConta;

import java.util.Date;

public abstract class ContaFinanceira extends Entidade{
    private long valor;     
    private Pessoa pessoa;   
    private boolean contaPaga;
    private Date dataPagamento;    
    private TipoConta tipoConta;
    public ContaFinanceira(){    
    }

    public void setValor(long valor){
	this.valor = valor;
    }

    public long getValor(){
	return valor;
    }

    public void setPessoa(Pessoa pessoa){
	this.pessoa = pessoa;
    }

    public Pessoa getPessoa(){
	return pessoa;
    }

    public void setContaPaga(boolean contaPaga){
	this.contaPaga = contaPaga;
    }

    public boolean isContaPaga(){
	return contaPaga;
    }

    public void setDataPagamento(Date dataPagamento){
	this.dataPagamento = dataPagamento;
    }

    public Date getDataPagamento(){
	return dataPagamento;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }
}
