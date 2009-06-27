package com.dudhoo.farmaco.jdbc;

import com.dudhoo.farmaco.jdbc.ResourceManager;

import com.sun.rowset.CachedRowSetImpl;

import com.sun.rowset.FilteredRowSetImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;

import org.apache.log4j.Logger;

/**
 * Classe para jogar sqls triviais ao banco de dados...
 * */
public class JdbcHelper{
    protected static final Logger logger = Logger.getLogger(JdbcHelper.class);

    Connection con = null;

    public JdbcHelper(){

    }

    public void fechaConexao(){
	ResourceManager.close(con);
    }

    /**
     * Executa o sql e traz um CachedRowSet
     * @param sql O Sql para executar
     * @param params  os par√¢metros para serrem compilados
     * @maxRows o m·ximo de linhas que pode ter no ResultSet
     * @return Um resultSet com os dados.
     * @throws SQLException
     */
    public FilteredRowSet executeSql(Connection con, String sql,
				     Object[] params, Integer maxRows) throws SQLException{
	boolean conexaoPassada = con != null;
	PreparedStatement p = null;
	ResultSet rs = null;
	try{
	    if(!conexaoPassada){
		con = new ResourceManager().getConnection();
		con.setAutoCommit(false);
	    }
	    p = con.prepareStatement(sql,
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    if(maxRows != null){
		p.setMaxRows(maxRows);
	    }
	    if(params != null){
		for(int i = 0; i < params.length; i++){
		    p.setObject(i + 1, params[i]);
		}
	    }
	    logger.info("Executando: " + sql);

	    FilteredRowSet filRowset = new FilteredRowSetImpl();
	    rs = p.executeQuery();
	    filRowset.populate(rs);
	    if(!conexaoPassada){
		con.commit();
	    }
	    return filRowset;
	} catch(SQLException e){
	    if(!conexaoPassada){
		con.rollback();
	    }
	    throw e;
	} finally{
	    ResourceManager.close(p);
	    if(!conexaoPassada){
		ResourceManager.close(con);
	    }
	}
    }

    /**
     * Executa o sql e traz um CachedRowSet
     * @param sql O Sql para executar
     * @param params  os par√¢metros para serrem compilados
     * @return Um resultSet com os dados.
     * @throws SQLException
     */
    public FilteredRowSet executeSql(String sql,
				     Object[] params) throws SQLException{
	return this.executeSql(null, sql, params, null);
    }


    public boolean execute(String sql, Object[] params) throws SQLException{
	PreparedStatement p = null;
	try{
	    con = new ResourceManager().getConnection();
	    p = con.prepareStatement(sql);
	    if(params != null){
		for(int i = 0; i < params.length; i++){
		    p.setObject(i + 1, params[i]);
		}
	    }
	    logger.info("executando " + sql);
	    return p.execute();
	} catch(SQLException e){
	    throw e;
	} finally{
	    ResourceManager.close(p);
	    ResourceManager.close(con);

	}
    }

    public ResultSet executeAndReturnGeneredKeys(Connection _con, String sql,
						 Object[] params) throws SQLException{
	PreparedStatement p = null;
	try{
	    con = _con;
	    p = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	    if(params != null){
		for(int i = 0; i < params.length; i++){
		    p.setObject(i + 1, params[i]);
		}
	    }
	    logger.info("executando " + sql);
	    p.execute();
	    return p.getGeneratedKeys();
	} catch(SQLException e){
	    throw e;
	}
    }

    /**
     * Executa uma query no banco, como È passado a conex„o,
     * apÛs ele executar a query, n„o È fechado a conex„o.
     * Portanto, vocÍ deve fech·-la.
     * */
    public boolean execute(Connection _conn,String sql, Object[] params
			   ) throws SQLException{
	PreparedStatement p = null;
	try{
	    p = _conn.prepareStatement(sql);
	    if(params != null){
		for(int i = 0; i < params.length; i++){
		    p.setObject(i + 1, params[i]);
		}
	    }
	    logger.debug("Executando " + sql);
	    return p.execute();
	} catch(SQLException e){
	    if(_conn == null){
		throw new SQLException("The object Connection must not to be null.");
	    } else if(_conn.isClosed()){
		throw new SQLException("The object Connection must not to be closed.");
	    } else {
		throw e;
	    }
	} finally{
	    ResourceManager.close(p);
	}
    }
}
