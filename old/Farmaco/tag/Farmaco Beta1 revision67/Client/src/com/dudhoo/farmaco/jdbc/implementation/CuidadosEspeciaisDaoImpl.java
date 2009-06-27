package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ContraIndicacao;
import com.dudhoo.farmaco.dto.CuidadosEspeciais;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;
import com.dudhoo.farmaco.jdbc.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.FilteredRowSet;

public class CuidadosEspeciaisDaoImpl extends AbstractDaoImpl implements CuidadosEspeciaisDao{
    private final static String TABLE_NAME = "CUIDADOS_ESPECIAIS";
    private final static String UPDATE = "UPDATE " + TABLE_NAME + " SET PRINCIPIO_ATIVO_ID = ? , DESCRICAO = ?, USUARIO_ID = ? WHERE ID = ?";
    private final static String INSERT = "INSERT INTO " + TABLE_NAME + "(PRINCIPIO_ATIVO_ID, DESCRICAO, USUARIO_ID) VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME  + " WHERE ID = ?";    
    private final static String SQL_SELECT = "SELECT ID, ULT_MOD, USUARIO_ID, DESCRICAO FROM " + TABLE_NAME;
    
    public void insertOrUpdateCascade(Connection con, CuidadosEspeciais esp, int principioAtivoId) throws SQLException{
	if (esp.getId() == 0){
	    PreparedStatement st = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	    st.setObject(1, principioAtivoId);
	    st.setObject(2, esp.getDescricao());
	    st.setObject(3, usuarioId);
	    st.execute();
	    ResultSet set = st.getGeneratedKeys();
	    set.next();
	    esp.setId(set.getInt(1));
	    ResourceManager.close(set.getStatement());
	}else{
	    PreparedStatement st = con.prepareStatement(UPDATE);
	    st.setObject(1, principioAtivoId);
	    st.setObject(2, esp.getDescricao());
	    st.setObject(3, usuarioId);
	    st.setObject(4, esp.getId());
	    st.execute();	    
	}
    }

    public CuidadosEspeciais find(Connection con, PrincipioAtivo princ) throws SQLException{
	CuidadosEspeciais cont = null;
	JdbcHelper hell = new JdbcHelper();             
	FilteredRowSet fl = hell.executeSql(con, SQL_SELECT + " WHERE PRINCIPIO_ATIVO_ID = ?",
	    new Object[]{princ.getId() }, null);
	if(fl.next()){
	    cont = new CuidadosEspeciais();
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
