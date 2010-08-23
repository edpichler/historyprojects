/*
 * QueryNotSetedException.java
 *
 * Created on 22 de Março de 2006, 21:23
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.exception;

/**
 *
 * @author duduzera
 */
public class QueryNotSetedException extends Exception {
    
    /** Creates a new instance of QueryNotSetedException */
    public QueryNotSetedException() {
        super("Não foi setada uma query. Não é possível fazer o refresh sem sql " +
                "para mandar ao banco de dados");
    }
    
}
