/*
 * PessoaStatus.java
 *
 * Created on 21 de Fevereiro de 2006, 22:18
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.enumerations;

/**
 *
 * @author duduzera
 */
public enum PessoaStatus {
    ATIVO,
    BLOQUEADO,
    ;
    
    public byte getValue() {
        switch(this){
            case ATIVO :
                return 1;
            case BLOQUEADO :
                return 2;
            default:
                return 0;
        }
    }
}
