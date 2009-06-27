package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.Posologia;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

public interface PosologiaDao{
    public void insertOrUpdateCascade(Connection con,  Posologia posolog, int apresenFarmacId) throws SQLException;

    public Posologia find(Connection con, ApresentacaoFarmaceutica _apresentacao) throws SQLException;
    public void delete(Connection con, int id)throws SQLException;

    void deleteByAppFarmaceutica(Connection con, ApresentacaoFarmaceutica principioAtivo) throws SQLException;
}
