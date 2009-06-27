package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.Interacao;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

public interface InteracaoDao{
    public void insertOrUpdateCascade(Connection con, Interacao intera, 
				   int principioAtivoId) throws SQLException;

    public Interacao find(Connection con, PrincipioAtivo princ) throws SQLException;
    public void delete(Connection con, int id)throws SQLException;
}
