package com.dudhoo.nemesis.hibernate;
// Generated 23/01/2006 21:05:43 by Hibernate Tools 3.1.0 beta1JBIDERC2

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Pais generated by hbm2java
 */

public class Pais  implements java.io.Serializable {


    // Fields    

     private long id;
     private Usuario usuario;
     private String nome;
     private String sigla;
     private Date ultMod;
     private Set<Estado> estados = new HashSet();


    // Constructors

    /** default constructor */
    public Pais() {
    }

	/** minimal constructor */
    public Pais(long id, Usuario usuario, String nome, String sigla, Date ultMod) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.sigla = sigla;
        this.ultMod = ultMod;
    }
    
    /** full constructor */
    public Pais(long id, Usuario usuario, String nome, String sigla, Date ultMod, Set<Estado> estados) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.sigla = sigla;
        this.ultMod = ultMod;
        this.estados = estados;
    }
    

   
    // Property accessors

    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Date getUltMod() {
        return this.ultMod;
    }
    
    public void setUltMod(Date ultMod) {
        this.ultMod = ultMod;
    }

    public Set<Estado> getEstados() {
        return this.estados;
    }
    
    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }
   








}
