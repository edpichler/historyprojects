package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.ContraIndicacao;

import com.dudhoo.farmaco.dto.CuidadosEspeciais;
import com.dudhoo.farmaco.dto.Posologia;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;
import com.dudhoo.farmaco.jdbc.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import java.util.List;

import javax.sql.rowset.FilteredRowSet;

public class ApresentacaoFarmaceuticaDaoImpl extends AbstractDaoImpl 
					implements ApresentacaoFarmaceuticaDao {
    
    private final static String TABLE_NAME = "APRESENTACAO_FARMACEUTICA";
    private final static String UPDATE = "UPDATE " + TABLE_NAME + " SET PRINCIPIO_ATIVO_ID = ? , DESCRICAO = ?, USUARIO_ID = ? WHERE ID = ?";
    private final static String INSERT = "INSERT INTO " + TABLE_NAME + "(PRINCIPIO_ATIVO_ID, DESCRICAO, USUARIO_ID) VALUES(?,?,?)";
    private final static String SQL_SELECT = "SELECT ID, ULT_MOD, USUARIO_ID, DESCRICAO FROM " + TABLE_NAME;    
    private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME ;

    
    public void insertOrUpdateCascade(Connection con,  Set <ApresentacaoFarmaceutica> set, int principioAtivoId) throws SQLException{
	
	for(Iterator iterator = set.iterator();iterator.hasNext();) {
	    ApresentacaoFarmaceutica apresentacaoFarmaceutica = (ApresentacaoFarmaceutica) iterator.next();	    
	    if (apresentacaoFarmaceutica.getId() == 0){
	        PreparedStatement st = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	        st.setObject(1, principioAtivoId);
	        st.setObject(2, apresentacaoFarmaceutica.getDescricao());
	        st.setObject(3, usuarioId);
	        st.execute();
	        ResultSet rset = st.getGeneratedKeys();
	        rset.next();
	        apresentacaoFarmaceutica.setId(rset.getInt(1));
	        ResourceManager.close(rset.getStatement());
	    }else{
	        PreparedStatement st = con.prepareStatement(UPDATE);
	        st.setObject(1, principioAtivoId);
	        st.setObject(2, apresentacaoFarmaceutica.getDescricao());
	        st.setObject(3, usuarioId);
	        st.setObject(4, apresentacaoFarmaceutica.getId());
	        st.execute();
	    }
	    //posologia
	     Posologia poso  =  apresentacaoFarmaceutica.getPosologia();
	     if(poso != null){
	         PosologiaDao impl = new PosologiaDaoImpl();
	         impl.insertOrUpdateCascade(con, poso, apresentacaoFarmaceutica.getId());
	     }	    
	}	    
    }

    public Set<ApresentacaoFarmaceutica> find(Connection conn, 
					      PrincipioAtivo principio) throws SQLException{
	Set <ApresentacaoFarmaceutica> cont = new HashSet();
	JdbcHelper hell = new JdbcHelper();             
	FilteredRowSet fl = hell.executeSql(conn, SQL_SELECT + " WHERE PRINCIPIO_ATIVO_ID = ?",
	    new Object[]{principio.getId() }, null);
	PosologiaDao cuidadao = new PosologiaDaoImpl();
	
	while(fl.next()){	
	    ApresentacaoFarmaceutica  app = new ApresentacaoFarmaceutica();          
	    app.setDescricao(fl.getString(4));
	    app.setId(fl.getInt(1)); 
	    
	    //posologia
	    Posologia poss =  cuidadao.find(conn, app);
	    if(poss != null){            
	        app.setPosologia(poss);
	    }
	    
	    cont.add(app);
	}
	if (cont.size() < 1){
	    cont = null;
	}
	return cont;
    }


    public void delete(Connection con, int[] id) throws SQLException{
	JdbcHelper hell = new JdbcHelper();
	StringBuffer buf = new StringBuffer("");
	PosologiaDao pdao = new PosologiaDaoImpl();
	ApresentacaoFarmaceutica farm = new ApresentacaoFarmaceutica();	
	for(int i = 0; i < id.length; i++){
	    buf.append(id[i] + ( i < id.length-1 ? "," : "") );
	    farm.setId(id[i]);
	    pdao.deleteByAppFarmaceutica(con, farm);
	}
	hell.execute(con, SQL_DELETE + " WHERE ID IN (" + buf.toString() + " )", null );
    }
}
