package com.dudhoo.nemesis.hibernate;
// Generated 23/01/2006 21:05:43 by Hibernate Tools 3.1.0 beta1JBIDERC2

import com.dudhoo.nemesis.hibernate.interfaces.Fornecedor;

import java.util.HashSet;
import java.util.Set;


/**
 * PessoaJuridica generated by hbm2java
 */

public class PessoaJuridica  implements java.io.Serializable, Fornecedor {


    // Fields    

     private long id;
     private Pessoa pessoa;
     private String razaoSocial;     
     private String cnpj;
     private String inscricaoEstadual;
     private String nomeCompletoContato;
     private Set <Empresa> empresas = new HashSet();          

    // Constructors

    /** default constructor */
    public PessoaJuridica() {
    }

	/** minimal constructor */
    public PessoaJuridica(long id, Pessoa pessoa, String razaoSocial, String cnpj, String inscricaoEstadual, String nomeCompletoContato) {
        this.id = id;
        this.pessoa = pessoa;
        this.razaoSocial = razaoSocial;        
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeCompletoContato = nomeCompletoContato;
    }
    
    /** full constructor */
    public PessoaJuridica(long id, Pessoa pessoa, String razaoSocial, String fantasia, String cnpj, String inscricaoEstadual, String nomeCompletoContato, Set<Empresa> empresas) {
        this.id = id;
        this.pessoa = pessoa;
        this.razaoSocial = razaoSocial;        
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeCompletoContato = nomeCompletoContato;
        this.empresas = empresas;
    }
    

   
    // Property accessors

    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }
    
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeCompletoContato() {
        return this.nomeCompletoContato;
    }
    
    public void setNomeCompletoContato(String nomeCompletoContato) {
        this.nomeCompletoContato = nomeCompletoContato;
    }

    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }


    public String getNome(){
	return getPessoa().getNome();
    }
    /**Seta a fantasia da empresa
     * */
    public void setNome(String _nome){
	getPessoa().setNome(_nome);;
    }

    public String toString(){
	return getNome() + " - " + getRazaoSocial(); 
    }        

}
