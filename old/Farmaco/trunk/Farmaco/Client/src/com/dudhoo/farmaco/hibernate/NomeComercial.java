package com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.abstracts.Entity;

public class NomeComercial extends Entity {
    private String nome;
    private PrincipioAtivo principioAtivo;
    
    public NomeComercial() {
    }

    public void setNome(String _nome) {
        if(_nome != null){
            nome = _nome.trim().toUpperCase();
        }else{
            this.nome = _nome;
        }
    
    }

    public String getNome() {
        if(nome != null){
            return nome.trim().toUpperCase();
        }else{
            return nome;
        }
    }

    public void setPrincipioAtivo(PrincipioAtivo principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public PrincipioAtivo getPrincipioAtivo() {
        return principioAtivo;
    }
}
