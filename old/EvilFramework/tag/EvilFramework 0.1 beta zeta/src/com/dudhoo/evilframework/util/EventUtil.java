/*
 * EventUtil.java
 *
 * Created on 22 de Março de 2006, 22:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.util;
import javax.swing.JMenuItem;

/**s
 *
 * @author duduzera
 */
public class EventUtil {
    
    /** Creates a new instance of EventUtil */
    public EventUtil() {
    }
    /**
     * Remove os actionListener do objeto
     */
    public void removeAllActionListeners(JMenuItem com){
        if(com != null){
            for(int i = 0; i < com.getActionListeners().length; i++){
                com.removeActionListener(com.getActionListeners()[i] );
            }
        }
    }
    
}
