
package com.dudhoo.nemesis;

import com.dudhoo.nemesis.swing.StartFrame;
;

/**
 *
 * @author dudu
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
       StartFrame.getCurrentInstance().setVisible(true);       
    }
    
    public static void main( String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
