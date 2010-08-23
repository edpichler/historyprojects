package com.dudhoo.nemesis.hibernate.abstracts;

import com.dudhoo.nemesis.hibernate.Observacao;
import com.dudhoo.nemesis.hibernate.Usuario;

import java.util.Date;

public class Entidade{
    private Date ultMod;
    private long id;
    private Usuario usuario;
    private Observacao observacao;
    public void setUltMod(Date ultMod){
	this.ultMod = ultMod;
    }

    public Date getUltMod(){
	return ultMod;
    }

    public void setUsuario(Usuario usuario){
	this.usuario = usuario;
    }

    public Usuario getUsuario(){
	return usuario;
    }

    public void setObservacao(Observacao observacao){
	this.observacao = observacao;
    }

    public Observacao getObservacao(){
	return observacao;
    }

    public void setId(long id){
	this.id = id;
    }

    public long getId(){
	return id;
    }
}
