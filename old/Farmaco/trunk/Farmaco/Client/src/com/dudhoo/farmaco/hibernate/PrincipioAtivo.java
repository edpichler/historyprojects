package com.dudhoo.farmaco.hibernate;

import com.dudhoo.farmaco.hibernate.abstracts.Entity;

import java.util.Set;

public class PrincipioAtivo extends Entity {
    /**
     * @attribute
     */    
    private String nome;
    private String descricao;
    private String interacoes;
    private String indicacoes;
    private String contraIndicacoes;
    private String precaucoes;
    private String cuidadosEspeciais;
    private String reacoesAdversas;
    
    private Set <ApresentacaoFarmaceutica> apresentacoesFarmaceuticas;
    private Set <NomeComercial> nomesComerciais; //apenas para pesquisa

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        if(nome == null){
            return nome;
        }else{
            return nome.toUpperCase();
        }
        
    }

    public void setInteracoes(String interacao) {
        this.interacoes = interacao;
    }

    public String getInteracoes() {
        return interacoes;
    }

    public void setIndicacoes(String indicacao) {
        this.indicacoes = indicacao;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setContraIndicacoes(String contraIndicacao) {
        this.contraIndicacoes = contraIndicacao;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setPrecaucoes(String precaucao) {
        this.precaucoes = precaucao;
    }

    public String getPrecaucoes() {
        return precaucoes;
    }

    public void setCuidadosEspeciais(String cuidadosEspec) {
        this.cuidadosEspeciais = cuidadosEspec;
    }

    public String getCuidadosEspeciais() {
        return cuidadosEspeciais;
    }

    public void setReacoesAdversas(String reacaoAdversa) {
        this.reacoesAdversas = reacaoAdversa;
    }

    public String getReacoesAdversas() {
        return reacoesAdversas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
   
    public String toString(){
        return this.nome;
    }

    public void setNomesComerciais(Set<NomeComercial> nomesComerciais) {
        this.nomesComerciais = nomesComerciais;
    }

    public Set<NomeComercial> getNomesComerciais() {
        return nomesComerciais;
    }

    public void setApresentacoesFarmaceuticas(Set<ApresentacaoFarmaceutica> apresentacoesFarmaceuticas) {
        this.apresentacoesFarmaceuticas = apresentacoesFarmaceuticas;
    }

    public Set<ApresentacaoFarmaceutica> getApresentacoesFarmaceuticas() {
        return apresentacoesFarmaceuticas;
    }
}
