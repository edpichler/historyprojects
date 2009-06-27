package com.dudhoo.evilframework.swing.dialog;

import java.awt.Dimension;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JDialog;

abstract class AbstractDialog extends JDialog {
    private BotaoConstants botaoClicado;

    public AbstractDialog(Frame parent, boolean modal){
        super(parent, modal);
        jbInit();
    }

    public void closeDialog() {
        this.dispose();
    }

    /**chama o metodo pack() e centraliza na tela
    * */
    public void centralize() {        
        this.setLocationRelativeTo(null);
    }

    /**seta o tamanho e centraliza na tela
     * */
    public void centralize(Dimension d) {
        this.setSize(d);
        this.setLocationRelativeTo(null);        
    }

    public void setBotaoClicado(BotaoConstants botaoClicado) {
        this.botaoClicado = botaoClicado;
    }

    public BotaoConstants getBotaoClicado() {
        return botaoClicado;
    }

    private void jbInit(){
        this.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        closed(e);
                    }
                });
    }

    private void closed(WindowEvent e) {
        setBotaoClicado(BotaoConstants.CLOSE);
    }
}
