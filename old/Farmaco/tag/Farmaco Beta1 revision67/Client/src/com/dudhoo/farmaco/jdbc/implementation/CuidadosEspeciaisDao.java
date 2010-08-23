package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ContraIndicacao;
import com.dudhoo.farmaco.dto.CuidadosEspeciais;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.sql.Connection;
import java.sql.SQLException;

public interface CuidadosEspeciaisDao{
    void insertOrUpdateCascade(Connection con, CuidadosEspeciais esp, int principioAtivoid) throws SQLException;

    CuidadosEspeciais find(Connection con, PrincipioAtivo princ) throws SQLException;
    public void delete(Connection con, int id)throws SQLException;
}
