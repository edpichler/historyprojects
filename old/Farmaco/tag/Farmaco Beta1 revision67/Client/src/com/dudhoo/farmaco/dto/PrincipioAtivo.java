package com.dudhoo.farmaco.dto;

import java.util.Set;

public class PrincipioAtivo extends Entity{

    /**
     * @attribute
     */    
    private String nome;
    
    private Set <ApresentacaoFarmaceutica> apresentacaoFarmaceutica;
   
    private Interacao interacao;
    private Indicacao indicacao;
    private ContraIndicacao contraIndicacao;
    private Precaucao precaucao;
    private CuidadosEspeciais cuidadosEspec;
    private ReacaoAdversa reacaoAdversa;
    
    public PrincipioAtivo(int id){
	this.id = id;
    }
    public PrincipioAtivo(){

    }   
    
    public String getNome(){
	return nome;
    }

    public void setNome(String nome){
	this.nome = nome;
    }

    public void setApresentacaoFarmaceutica(Set<ApresentacaoFarmaceutica> apresentacaoFarmaceutica){
	this.apresentacaoFarmaceutica = apresentacaoFarmaceutica;
    }

    public Set<ApresentacaoFarmaceutica> getApresentacaoFarmaceutica(){
	return apresentacaoFarmaceutica;
    }

    public void setInteracao(Interacao interacao){
	this.interacao = interacao;
    }

    public Interacao getInteracao(){
	return interacao;
    }


    public void setIndicacao(Indicacao indicacao){
	this.indicacao = indicacao;
    }

    public Indicacao getIndicacao(){
	return indicacao;
    }

    public void setContraIndicacao(ContraIndicacao contraIndicacao){
	this.contraIndicacao = contraIndicacao;
    }

    public ContraIndicacao getContraIndicacao(){
	return contraIndicacao;
    }

    public void setPrecaucao(Precaucao precaucao){
	this.precaucao = precaucao;
    }

    public Precaucao getPrecaucao(){
	return precaucao;
    }

    public void setCuidadosEspec(CuidadosEspeciais cuidadosEspec){
	this.cuidadosEspec = cuidadosEspec;
    }

    public CuidadosEspeciais getCuidadosEspec(){
	return cuidadosEspec;
    }

    public void setReacaoAdversa(ReacaoAdversa reacaoAdversa){
	this.reacaoAdversa = reacaoAdversa;
    }

    public ReacaoAdversa getReacaoAdversa(){
	return reacaoAdversa;
    }
}
