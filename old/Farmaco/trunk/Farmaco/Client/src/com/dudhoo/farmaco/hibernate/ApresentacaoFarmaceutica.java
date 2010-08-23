package com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.abstracts.Entity;

public class ApresentacaoFarmaceutica extends Entity {
    
    private String posologia;
    private String nome;
    private PrincipioAtivo principioAtivo;
    
    public ApresentacaoFarmaceutica() {
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setNome(String nome) {
        this.nome = (nome == null ? nome : nome.toUpperCase());
    }

    public String getNome() {
        return (nome == null ? nome : nome.toUpperCase());
    }

    public void setPrincipioAtivo(PrincipioAtivo principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public PrincipioAtivo getPrincipioAtivo() {
        return principioAtivo;
    }
}