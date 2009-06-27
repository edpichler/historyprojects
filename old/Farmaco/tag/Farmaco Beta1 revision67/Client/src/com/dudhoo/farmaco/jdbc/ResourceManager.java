package com.dudhoo.farmaco.jdbc;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.farmaco.app.Application;

import com.dudhoo.farmaco.swing.StartFrame;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceManager{
    private static Connection con;
    
    public ResourceManager(){
    }
    public static Connection getConnection() throws SQLException{
	if(con == null || (con != null && con.isClosed())){
	    try{
		Class.forName( Application.getConfiguration().getString(Application.JDBC_DRIVER_NAME) );
	    } catch(ClassNotFoundException e){
		new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);;
	    }
	    con = DriverManager.getConnection(Application.getConfiguration().getString(Application.CONNECTION_STRING));              
	}
	return con;
    }

    public static void close(Connection conn){
	if(conn != null){
	    try{
		conn.close();
		conn = null;
	    } catch(SQLException e){
		new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);;
	    }
	}	    
    }

    public static void close(Statement st){
	if(st != null){
	    try{
		st.close();
		st = null;
	    } catch(SQLException e){
		new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);;
	    }
	}           
	
    }
}
