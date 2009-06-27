package com.dudhoo.farmaco.dto;

import java.util.Date;

public class Entity{
    /**
     * @attribute
     */
    int id;//TODO FAZER SETAR USUARIO E SER OBRIGATORIO NO BANCO

    /**
     * @attribute
     */
    Date ult_mod;

    /**
     * @attribute
     */
    private Usuario usuarioMod;

    /**
     * @attribute
     */
    String descricao;

    public int getId(){
	return id;
    }

    public void setId(int id){
	this.id = id;
    }

    public Date getUlt_mod(){
	return ult_mod;
    }

    public void setUlt_mod(Date ult_mod){
	this.ult_mod = ult_mod;
    }

   

    public String getDescricao(){
	return descricao;
    }

    public void setDescricao(String descricao){
	this.descricao = descricao;
    }

    public Usuario getUsuarioMod(){
	return usuarioMod;
    }

    public void setUsuarioMod(Usuario usuarioMod){
	this.usuarioMod = usuarioMod;
    }
}
