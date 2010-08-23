package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.farmaco.app.Application;

import java.sql.SQLException;

public class AbstractDaoImpl{
    protected int usuarioId;
    public AbstractDaoImpl(){
	try{
	    usuarioId = Application.getUsuarioLogado().getId();
	} catch(SQLException e){
	    new EvilError(null, true, e).setVisible(true);
	}
    }
}