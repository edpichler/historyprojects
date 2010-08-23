package com.dudhoo.farmaco.swing;

import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.jdbc.JdbcHelper;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;

public class PesquisaFactory{
    
    private String consultaPadrao = "SELECT " +
	    " PRINCIPIO_ATIVO.ID AS Código," +
	    " PRINCIPIO_ATIVO.NOME as Principio_Ativo," +
	    " SUBSTR( PRINCIPIO_ATIVO.DESCRICAO , 1, 35) as Princ_Ativo_Descrição," +
	    " SUBSTR( CONTRA_INDICACAO.DESCRICAO , 1, 35) as Contra_Indicação," +
	    " SUBSTR( INDICACAO.DESCRICAO , 1, 35) as Indicação," + 
	    " SUBSTR( INTERACAO.DESCRICAO , 1, 35) as Interação," + 
	    " SUBSTR( PRECAUCAO.DESCRICAO , 1, 35) as Precaução," + 
	    " SUBSTR( REACAO_ADVERSA.DESCRICAO , 1, 35) as Reação_Adversa," +       
	    " SUBSTR( CUIDADOS_ESPECIAIS.DESCRICAO , 1, 35) as Cuidados_Especiais " +       
	    " FROM " +
		"((((((PRINCIPIO_ATIVO " +
		" LEFT JOIN CONTRA_INDICACAO on PRINCIPIO_ATIVO.ID = CONTRA_INDICACAO.PRINCIPIO_ATIVO_ID)" +
		" LEFT JOIN INDICACAO ON INDICACAO.PRINCIPIO_ATIVO_ID = PRINCIPIO_ATIVO.ID)" +
		" LEFT JOIN INTERACAO ON INTERACAO.PRINCIPIO_ATIVO_ID = PRINCIPIO_ATIVO.ID)" +
		" LEFT JOIN PRECAUCAO ON PRECAUCAO.PRINCIPIO_ATIVO_ID = PRINCIPIO_ATIVO.ID)" +
		" LEFT JOIN REACAO_ADVERSA ON REACAO_ADVERSA.PRINCIPIO_ATIVO_ID = PRINCIPIO_ATIVO.ID)" +
		" LEFT JOIN CUIDADOS_ESPECIAIS ON CUIDADOS_ESPECIAIS.PRINCIPIO_ATIVO_ID = PRINCIPIO_ATIVO.ID) " +
		" ORDER BY PRINCIPIO_ATIVO.NOME";
		
    public PesquisaFactory(){
    }
    public FilteredRowSet getPesquisa() throws SQLException{
	JdbcHelper jd = new JdbcHelper();
        FilteredRowSet row =  jd.executeSql(consultaPadrao, new Class[]{});
	return row;	
    }
}
