package com.dudhoo.farmaco.swing.serial;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;

import com.dudhoo.evilframework.util.ExitApplicationUtil;
import com.dudhoo.farmaco.app.Application;
import com.dudhoo.farmaco.serial.SerialValidator;
import com.dudhoo.farmaco.swing.StartFrame;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.Cipher;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDialogSerial extends JDialog{
    private JTextField jTextField1 = new JTextField();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JPanel jPanel1 = new JPanel();
    private JLabel jLabel1 = new JLabel();

    public JDialogSerial() {
        jbInit();
    }

    private void jbInit() {
        this.setSize(new Dimension(421, 190));
        this.setModal(true);
        this.getContentPane().setLayout(null);
        this.setTitle("Verificação de Serial");
        jTextField1.setColumns(30);
        jButton1.setText("Ok");
        jButton1.setBounds(new Rectangle(250, 120, 65, 23));
        jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton1_actionPerformed(e);
                    }
                });
        jButton2.setText("Sair");
        jButton2.setBounds(new Rectangle(330, 120, 65, 23));
        jButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton2_actionPerformed(e);
                    }
                });
        jPanel1.setBounds(new Rectangle(15, 45, 380, 65));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Serial"));
        jLabel1.setText("Informe abaixo o código serial e clique em Ok.");
        jLabel1.setBounds(new Rectangle(15, 10, 375, 25));
        jPanel1.add(jTextField1, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jPanel1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        String serial = jTextField1.getText().trim();
        SerialValidator sv = new SerialValidator();
        boolean valido = false;
        try{
            valido = sv.validaSerialDigitado(serial);
        }catch(Exception ex){
            valido = false;
        }
        if(valido){
            new EvilInformation(this).showMessage("Código serial válido. Obrigado!");
                       
            this.dispose();
        }else{
            String message = "Desculpe. Código serial inválido.";            
            JOptionPane.showMessageDialog(this,message, message, JOptionPane.ERROR_MESSAGE);            
        } 
        sv.saveNewSerial(serial);
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        ExitApplicationUtil.getCurrentInstance().exitEvilApplication(this);
    }
}
