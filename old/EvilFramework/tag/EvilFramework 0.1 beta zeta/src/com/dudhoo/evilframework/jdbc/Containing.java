package com.dudhoo.evilframework.jdbc;

import com.dudhoo.evilframework.swing.EvilError;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;

public class Containing implements Predicate{

    private int colunaIndex[];
    private String valor;
    /**Comparação  não é case sensitive.
     * */
    public Containing(String valor, int col[]){
	this.valor = valor;
	colunaIndex = col;
    }

    public boolean evaluate(RowSet rs){
	try{
	    CachedRowSet crs = (CachedRowSet) rs;	    
	    for(int i = 0; i < colunaIndex.length; i++){
		if(crs.isAfterLast()){
		    return false;
		}else if( crs.getObject(colunaIndex[i]).toString().toUpperCase().contains( valor.toString().toUpperCase()) == false ){
		    return false;
		}
	    }
	
	} catch(Exception exx){
	    new EvilError(null, true, exx).setVisible(true);
	}	
	return true;
    }

    public boolean evaluate(Object object, int i){	
	return true;
    }

    public boolean evaluate(Object object, String string){	
	return true;
    }
}
