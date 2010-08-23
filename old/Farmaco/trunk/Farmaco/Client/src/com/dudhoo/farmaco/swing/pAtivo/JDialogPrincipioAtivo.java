package com.dudhoo.farmaco.swing.pAtivo;

import com.dudhoo.evilframework.exception.ValidationException;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.dialog.EvilDialogSaveCancel;

import com.dudhoo.farmaco.hibernate.PrincipioAtivo;
import com.dudhoo.farmaco.hibernate.PrincipioAtivoHome;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class JDialogPrincipioAtivo extends EvilDialogSaveCancel {
    PanelPrincipioAtivo panel = new PanelPrincipioAtivo();
    public JDialogPrincipioAtivo(Frame frame, boolean modal ) {
        super(frame, modal);
        setTitle("Principio ativo");
        setSize(640,450);
        centralize();
        this.add(panel);
        getBotaoSalvar().addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent) {
                        salva();
                    }
                });
    }
    
    public void setPrincipioAtivo(PrincipioAtivo p){
        panel.setPrincipioAtivo(p);
    }
    
    private void salva() {
        Session ses = new PrincipioAtivoHome().currentSession();
        Transaction tr = ses.beginTransaction();
        try{
            Object o = panel.getPrincipioAtivo();
            ses.saveOrUpdate(o);
            tr.commit();
            panel.setPrincipioAtivo(null);
        }catch(Exception t){
            tr.rollback();
            new EvilError(null,true,t).setVisible(true);
        }finally{
            ses.close();
            tr = null;
        }
    }
}
