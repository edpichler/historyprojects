/*
 * ExitApplicationUtil.java
 *
 * Created on 7 de Janeiro de 2006, 17:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.util;

import java.awt.Component;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 * Esta classe terá os procedimentos globais para a aplicação fazer exit.
 * Sempre que a aplicação precisar ser finalizada, chamar essa classe.
 * @author dudu
 */
public class ExitApplicationUtil {
    private final Logger log = Logger.getLogger(this.getClass());
    /** Creates a new instance of ExitApplicationUtil */
    private static ExitApplicationUtil instance = null; 
    
    public ExitApplicationUtil() {
        
    }
    /**Retorna a instancia da classe. Singleton. ^^
     */
    public static ExitApplicationUtil getCurrentInstance(){
        if(instance == null){
            instance = new ExitApplicationUtil();
        }
        return instance;
    }
    public void exitEvilApplication(Component parentComponent){
        int choosed = JOptionPane.showConfirmDialog(parentComponent,
                java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary").getString("are_you_sure_to_finish_the_application"),java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary").getString("finishing_the_application"),
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choosed == JOptionPane.YES_OPTION){
            log.info(java.util.ResourceBundle.getBundle("com/dudhoo/evilframework/resources/dictionary").getString("Exiting_application..."));
            System.exit(0);
        }
    }
}
