package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ContraIndicacao;

import com.dudhoo.farmaco.dto.PrincipioAtivo;

import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.SQLException;

public interface ContraIndicacaoDao{    

    public void insertOrUpdateCascade(Connection p0, ContraIndicacao p1, int principioAtivoId) throws SQLException;

    public ContraIndicacao find(Connection con, PrincipioAtivo principio) throws SQLException;

    public void delete(Connection con, int id)throws SQLException;
}
