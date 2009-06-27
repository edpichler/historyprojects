package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.dto.ReacaoAdversa;

import java.sql.Connection;
import java.sql.SQLException;

public interface ReacaoAdversaDao{
    public void insertOrUpdateCascade(Connection con,  ReacaoAdversa reac, int principioAtivoId) throws SQLException;

    public ReacaoAdversa find(Connection con, PrincipioAtivo principio) throws SQLException;
    public void delete(Connection con, int id)throws SQLException;
}
