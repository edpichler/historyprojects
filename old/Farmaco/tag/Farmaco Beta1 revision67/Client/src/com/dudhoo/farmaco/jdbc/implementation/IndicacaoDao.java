package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.Indicacao;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

public interface IndicacaoDao{
    void insertOrUpdateCascade(Connection con, Indicacao ind, int principioAtivoId) throws SQLException;

    public Indicacao find(Connection con, PrincipioAtivo principio)throws SQLException;
    public void delete(Connection con, int id)throws SQLException;
}
