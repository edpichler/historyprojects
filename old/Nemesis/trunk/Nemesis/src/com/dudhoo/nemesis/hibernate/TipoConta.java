package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.abstracts.Entidade;

public class TipoConta extends Entidade {

    private String nome;
    private String descricao;
    private boolean credito;
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public String toString(){
        return nome;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public boolean isCredito() {
        return credito;
    }
}
