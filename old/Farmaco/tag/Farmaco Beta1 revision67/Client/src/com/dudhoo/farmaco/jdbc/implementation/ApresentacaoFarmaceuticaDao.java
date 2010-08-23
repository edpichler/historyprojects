package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Set;

public interface ApresentacaoFarmaceuticaDao{
    public void insertOrUpdateCascade(Connection con,  Set <ApresentacaoFarmaceutica> set, int principioAtivoId) throws SQLException;

    public Set<ApresentacaoFarmaceutica> find(Connection conn, PrincipioAtivo principio) throws SQLException;
    
    public void delete(Connection con, int id[])throws SQLException;
}
