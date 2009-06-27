package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

public interface PrincipioAtivoDao{
    public void insertOrUpdateCascade(Connection con,PrincipioAtivo principio) throws SQLException;
    
    /**
     * Retorna o Principio ativo e todos os seus objetos.
     * */
    public PrincipioAtivo findFullById(Connection con, int id) throws SQLException;

    public void deleteCascading(Connection con, PrincipioAtivo principioAtivo) throws SQLException;    
    
}
