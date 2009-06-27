package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.Usuario;
import com.dudhoo.farmaco.jdbc.JdbcHelper;

import java.sql.SQLException;

import javax.sql.RowSet;

public class UsuarioDaoImpl implements UsuarioDao{

    
    public Usuario findById(int id) throws SQLException{
	final String SQL = "SELECT ID, NOME_COMPLETO, USR, PASSWORD FROM USUARIO";
	JdbcHelper hell = new JdbcHelper();
	RowSet rs = hell.executeSql(SQL, null);
	if(rs.next()){
	    return fecthUsuario(rs);
	}else{
	    return null;
	}
	
    }

    private Usuario fecthUsuario(RowSet rs) throws SQLException{
	Usuario u = new Usuario();
	u.setId(rs.getInt(1));
	u.setNomeCompleto(rs.getString(2));
	u.setUsr(rs.getString(3));
	u.setPassword(rs.getString(4));
	return u;
    }
}


