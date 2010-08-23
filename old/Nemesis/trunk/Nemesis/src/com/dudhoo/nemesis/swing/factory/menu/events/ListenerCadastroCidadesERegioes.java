package com.dudhoo.nemesis.swing.factory.menu.events;

import com.dudhoo.evilframework.swing.EvilError;

import com.dudhoo.nemesis.swing.factory.PanelPesquisaCidadeBuilder;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.StartFrame;
import java.awt.Cursor;
import java.awt.event.ActionListener;

/**
 *
 * @author duduzera
 */
public class ListenerCadastroCidadesERegioes  implements ActionListener {
    
    /** Creates a new instance of ListenerCadastroCidadesERegioes */
    public ListenerCadastroCidadesERegioes() {
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        try{
            StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.WAIT_CURSOR));
            final PanelPesquisaGeneric panel = new PanelPesquisaCidadeBuilder().getPanelPesquisarCidade(true,false);
      
        }catch(Exception eee){
            new EvilError(null, false, eee).setVisible(true);
        }finally{
            StartFrame.getCurrentInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
  
    
}
