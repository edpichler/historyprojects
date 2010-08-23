package com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.abstracts.Entidade;

public class CategoriaProduto extends Entidade{
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public String toString(){
        return nome;
    }
}
