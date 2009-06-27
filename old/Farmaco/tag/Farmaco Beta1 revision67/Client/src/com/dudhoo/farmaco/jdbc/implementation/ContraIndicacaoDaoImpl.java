package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ContraIndicacao;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;
import com.dudhoo.farmaco.jdbc.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.FilteredRowSet;


public class ContraIndicacaoDaoImpl extends AbstractDaoImpl 
					implements ContraIndicacaoDao {
    private final static String TABLE_NAME = "CONTRA_INDICACAO";
    private final static String UPDATE = "UPDATE " + TABLE_NAME + " SET PRINCIPIO_ATIVO_ID = ? , DESCRICAO = ?, USUARIO_ID = ? WHERE ID = ?";
    private final static String INSERT = "INSERT INTO " + TABLE_NAME + "(PRINCIPIO_ATIVO_ID, DESCRICAO, USUARIO_ID) VALUES(?,?,?)";
    private final static String SQL_SELECT = "SELECT ID, ULT_MOD, USUARIO_ID, DESCRICAO FROM " + TABLE_NAME;
    private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME  + " WHERE ID = ?";
    
    public void insertOrUpdateCascade(Connection con,  ContraIndicacao contraIndicacao, int principioAtivoId) throws SQLException{
	if (contraIndicacao.getId() == 0){
	    PreparedStatement st = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	    st.setObject(1, principioAtivoId);
	    st.setObject(2, contraIndicacao.getDescricao());
	    st.setObject(3, usuarioId);
	    st.execute();
	    ResultSet set = st.getGeneratedKeys();
	    set.next();
	    contraIndicacao.setId(set.getInt(1));
	    ResourceManager.close(set.getStatement());
	}else{
	    PreparedStatement st = con.prepareStatement(UPDATE);
	    st.setObject(1, principioAtivoId);
	    st.setObject(2, contraIndicacao.getDescricao());
	    st.setObject(3, usuarioId);
	    st.setObject(4, contraIndicacao.getId());
	    st.execute();
	}
    }

    public ContraIndicacao find(Connection con, PrincipioAtivo principio) throws SQLException{
	ContraIndicacao cont = null;
	JdbcHelper hell = new JdbcHelper();     	
	FilteredRowSet fl = hell.executeSql(con, SQL_SELECT + " WHERE PRINCIPIO_ATIVO_ID = ?",
	    new Object[]{principio.getId() }, null);
	if(fl.next()){
	    cont = new ContraIndicacao();
	    cont.setDescricao(fl.getString(4));
	    cont.setId(fl.getInt(1));	    
	}
	return cont;
    }

    public void delete(Connection con, int id) throws SQLException{
	JdbcHelper hell = new JdbcHelper();
	hell.execute(con, SQL_DELETE , new Object[]{ id });
    }
}
