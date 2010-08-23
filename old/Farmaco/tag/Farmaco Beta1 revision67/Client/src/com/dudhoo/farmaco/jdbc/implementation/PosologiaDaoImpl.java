package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;

import com.dudhoo.farmaco.dto.CuidadosEspeciais;
import com.dudhoo.farmaco.dto.Posologia;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;
import com.dudhoo.farmaco.jdbc.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Iterator;
import java.util.Set;

import javax.sql.rowset.FilteredRowSet;

public class PosologiaDaoImpl extends AbstractDaoImpl 
					implements PosologiaDao {
    private final static String TABLE_NAME = "POSOLOGIA";
    private final static String UPDATE = "UPDATE " + TABLE_NAME + " SET APRESENTACAO_FARMACEUTICA_ID = ? , DESCRICAO = ?, USUARIO_ID = ? WHERE ID = ?";
    private final static String INSERT = "INSERT INTO " + TABLE_NAME + "(APRESENTACAO_FARMACEUTICA_ID, DESCRICAO, USUARIO_ID) VALUES(?,?,?)";
    private final static String SQL_SELECT = "SELECT ID, ULT_MOD, USUARIO_ID, DESCRICAO FROM " + TABLE_NAME;    
    private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME  ;
    
    public void insertOrUpdateCascade(Connection con,  Posologia posolog, int apresenFarmacId) throws SQLException{
	    if (posolog.getId() == 0){
		PreparedStatement st = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setObject(1, apresenFarmacId);
		st.setObject(2, posolog.getDescricao());
		st.setObject(3, usuarioId);
		st.execute();
		ResultSet rset = st.getGeneratedKeys();
		rset.next();
		posolog.setId(rset.getInt(1));
	        ResourceManager.close(rset.getStatement());
	    }else{
		PreparedStatement st = con.prepareStatement(UPDATE);
		st.setObject(1, apresenFarmacId);
		st.setObject(2, posolog.getDescricao());
		st.setObject(3, usuarioId);
		st.setObject(4, posolog.getId());
		st.execute();
	    }
    }

    public Posologia find(Connection con, ApresentacaoFarmaceutica _apresentacao) throws SQLException{
	Posologia posologiaMaligna = null;
	JdbcHelper hell = new JdbcHelper();             
	FilteredRowSet fl = hell.executeSql(con, SQL_SELECT + " WHERE APRESENTACAO_FARMACEUTICA_ID = ?",
	    new Object[]{ _apresentacao.getId() }, null);
	if(fl.next()){
	    posologiaMaligna = new Posologia();
	    posologiaMaligna.setDescricao(fl.getString(4));
	    posologiaMaligna.setId(fl.getInt(1));
	}
	return posologiaMaligna;
    }

    public void delete(Connection con, int id) throws SQLException{
	JdbcHelper hell = new JdbcHelper();
	hell.execute(con, SQL_DELETE + " WHERE ID = ?", new Object[]{ id });
    }

    public void deleteByAppFarmaceutica(Connection con, 
					ApresentacaoFarmaceutica app) throws SQLException{
	String sufix = " WHERE " + TABLE_NAME+  ".ID IN " +
	"(SELECT POSOLOGIA.ID " +
	"FROM (POSOLOGIA INNER JOIN APRESENTACAO_FARMACEUTICA ON POSOLOGIA.APRESENTACAO_FARMACEUTICA_ID = APRESENTACAO_FARMACEUTICA.ID AND APRESENTACAO_FARMACEUTICA.ID = ? ))";	    	    
	JdbcHelper hell = new JdbcHelper();
	hell.execute(con, SQL_DELETE + sufix, new Object[]{ app.getId() });
    }
}
