package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.Precaucao;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

public interface PrecaucaoDao{
    public void insertOrUpdateCascade(Connection con,  Precaucao preca, int principioAtivoId) throws SQLException;

    public Precaucao find(Connection con, PrincipioAtivo principio) throws SQLException;
    public void delete(Connection con, int id)throws SQLException;
    
}
