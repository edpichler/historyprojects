/*
 * InitHibernate.java
 *
 * Created on 2 de Fevereiro de 2006, 21:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.hibernate.thread;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.hibernate.UsuarioHome;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author duduzera
 */
public class InitHibernate extends Thread {
    Logger log = Logger.getLogger(this.getClass());
    /** Creates a new instance of InitHibernate */
    public InitHibernate() {
        this.setPriority(Thread.MIN_PRIORITY);
    }
    
    public void run(){
        super.run();
        try{
            log.info("Iniciando Hibernate....");
            new UsuarioHome().currentSession();
            log.info("Hibernate iniciado....uhull \\,,/");
        }catch(HibernateException xx){
            new EvilError(null, false, xx).setVisible(true);
        }
    }
    
}
