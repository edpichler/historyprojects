/*
 * EvilTextFormatter.java
 *
 * Created on 13 de Fevereiro de 2006, 20:27
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 *Formata os texto antes de inserir no banco de dados
 * @author duduzera
 */
public class EvilTextFormatter {
    private final static Logger logger = Logger.getLogger(EvilTextFormatter.class);
    /** Creates a new instance of EvilTextFormatter */
    public EvilTextFormatter() {
    }    
    
    public static String transformIniciaisMaiusculas(String str){  
	str = str.trim().toLowerCase();
	StringBuffer buf = new StringBuffer( str.substring(0,1).toUpperCase() + str.substring(1,str.length()));
	
	Pattern p = Pattern.compile("\\s+(.{1})");
	Matcher mat = p.matcher(buf);
	while(mat.find()){
	    int start = mat.start(1);
	    buf = buf.replace(start, start + 1, new String( new char[]{ buf.charAt(start)} ).toUpperCase());
	}
	logger.debug("String formatada para ter iniciais maiúsculas. De  '" + str + "' para '" + buf.toString() + "'");
	return buf.toString();
    }
    /**
     * Troca todos os duplos espaços por espaço um apenas
     * */
    public static String removeDuplosEspacos(String str){
	String retorno = str.trim().replaceAll("\\s{2,}"," ");
	logger.debug("String formatada. Foi removido os espaços duplos em branco." + retorno);
	return retorno;
    }
}
