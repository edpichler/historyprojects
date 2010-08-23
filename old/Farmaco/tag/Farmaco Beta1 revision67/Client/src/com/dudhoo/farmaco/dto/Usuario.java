package com.dudhoo.farmaco.dto;

public class Usuario{
    private int id;
    /**
     * @attribute
     */
    String nomeCompleto;

    /**
     * @attribute
     */
    String usr;

    /**
     * @attribute
     */
    String password;

    public int getId(){
	return id;
    }

    public void setId(int id){
	this.id = id;
    }

    public String getNomeCompleto(){
	return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto){
	this.nomeCompleto = nomeCompleto;
    }

    public String getUsr(){
	return usr;
    }

    public void setUsr(String user){
	this.usr = user;
    }

    public String getPassword(){
	return password;
    }

    public void setPassword(String password){
	this.password = password;
    }
}
