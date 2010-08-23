package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ContraIndicacao;
import com.dudhoo.farmaco.dto.CuidadosEspeciais;

import com.dudhoo.farmaco.dto.Indicacao;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;
import com.dudhoo.farmaco.jdbc.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.FilteredRowSet;

public class IndicacaoDaoImpl extends AbstractDaoImpl implements IndicacaoDao{

    private static final String TABLE_NAME = "INDICACAO";
    private static final String UPDATE = 
	"UPDATE " + TABLE_NAME + " SET PRINCIPIO_ATIVO_ID = ? , DESCRICAO = ?, USUARIO_ID = ? WHERE ID = ?";
    private static final String INSERT = 
	"INSERT INTO " + TABLE_NAME + "(PRINCIPIO_ATIVO_ID, DESCRICAO, USUARIO_ID) VALUES(?,?,?)";
    private static final String SQL_SELECT = 
	"SELECT ID, ULT_MOD, USUARIO_ID, DESCRICAO FROM " + TABLE_NAME;
    private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME  + " WHERE ID = ?";
    public void insertOrUpdateCascade(Connection con, Indicacao ind, 
				      int principioAtivoId) throws SQLException{
	if(ind.getId() == 0){
	    PreparedStatement st = 
		con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	    st.setObject(1, principioAtivoId);
	    st.setObject(2, ind.getDescricao());
	    st.setObject(3, usuarioId);
	    st.execute();
	    ResultSet set = st.getGeneratedKeys();
	    set.next();
	    ind.setId(set.getInt(1));
	    ResourceManager.close(set.getStatement());
	} else {
	    PreparedStatement st = con.prepareStatement(UPDATE);
	    st.setObject(1, principioAtivoId);
	    st.setObject(2, ind.getDescricao());
	    st.setObject(3, usuarioId);
	    st.setObject(4, ind.getId());
	    st.execute();
	}
    }

    public Indicacao find(Connection con, 
			  PrincipioAtivo principio) throws SQLException{
	Indicacao cont = null;
	JdbcHelper hell = new JdbcHelper();
	FilteredRowSet fl = 
	    hell.executeSql(con, SQL_SELECT + " WHERE PRINCIPIO_ATIVO_ID = ?", 
		     new Object[]{ principio.getId() }, null);
	if(fl.next()){
	    cont = new Indicacao();
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
