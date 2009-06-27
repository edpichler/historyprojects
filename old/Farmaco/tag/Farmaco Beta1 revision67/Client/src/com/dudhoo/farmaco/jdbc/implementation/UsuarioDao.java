package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.Usuario;

import java.sql.SQLException;

public interface UsuarioDao{
    public Usuario findById(int id) throws SQLException;
}
