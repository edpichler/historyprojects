/*
 * EventosTecladoGerenciador.java
 *
 * Created on 31 de Janeiro de 2006, 21:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.swing.eventListeners;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilMain;
import java.awt.Component;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.event.KeyEvent;
import org.apache.log4j.Logger;

/**Cuida dos eventos globais de teclado*/
public class EventosTecladoGerenciador  extends DefaultKeyboardFocusManager{
    /** Creates a new instance of EventosTecladoGerenciador */
    Logger log = Logger.getLogger(this.getClass() );
    private EvilMain main;
    public EventosTecladoGerenciador(EvilMain _main) {
        main = _main;
    }
    public boolean dispatchKeyEvent(KeyEvent e) {
        if(( e.getID() ==  KeyEvent.KEY_PRESSED) &&
                (e.getKeyCode() == KeyEvent.VK_W
                && e.getModifiers() == KeyEvent.CTRL_MASK )
                ){            
            log.info("Executando evento global de teclado: " + e.toString());
            try{
                int i = main.getJTabbedPanePrincipal().getSelectedIndex();
                if(i != -1){
                    main.getJTabbedPanePrincipal().remove(i);		    
		}                
            }catch(Throwable xx){
                new EvilError(null, false, xx).setVisible(true);
            }
        }
        return super.dispatchKeyEvent(e);
    }
}