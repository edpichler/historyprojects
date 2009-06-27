package com.dudhoo.nemesis.swing.login;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.evilframework.util.ExitApplicationUtil;
import com.dudhoo.nemesis.Application;

import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.hibernate.UsuarioHome;
import com.dudhoo.nemesis.swing.StartFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class DailogLogin extends JDialog {

    private JPanel jPanel1 = new JPanel();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel2 = new JPanel();
    private JButton jButtonLogin = new JButton();
    private JButton jButtonSair = new JButton();
    private JTextField jTextField1 = new JTextField();
    private JPasswordField jPasswordField1 = new JPasswordField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private GridBagLayout gridBagLayout1 = new GridBagLayout();

    public DailogLogin() {
        try {
            jbInit();
            setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(386, 152));
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setModal(true);
        this.setTitle("Login");
        this.getContentPane().setLayout(borderLayout1);
        jPanel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jPanel2.setBorder(BorderFactory.createTitledBorder("Login"));
        jPanel2.setLayout(gridBagLayout1);
        jButtonLogin.setText("Entrar");
        jButtonLogin.setMnemonic('E');
        jButtonLogin.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtonLogin_actionPerformed(e);
                    }
                });
        jButtonSair.setText("Sair");
        jButtonSair.setMnemonic('S');
        jButtonSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtonSair_actionPerformed(e);
                    }
                });
        jTextField1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        firstEnter(e);
                    }
                });
        jPasswordField1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        login(e);
                    }
                });
        jLabel1.setText("Usuário:");
        jLabel2.setText("Senha:");
        jPanel1.add(jButtonLogin, null);
        jPanel1.add(jButtonSair, null);
        this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
        this.getContentPane().add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jLabel2, 
                    new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, 
                                           GridBagConstraints.NONE, 
                                           new Insets(10, 10, 2, 0), 46, 5));
        jPanel2.add(jLabel1, 
                    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, 
                                           GridBagConstraints.NONE, 
                                           new Insets(-6, 10, 0, 0), 40, 5));
        jPanel2.add(jPasswordField1, 
                    new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, 
                                           GridBagConstraints.WEST, 
                                           GridBagConstraints.HORIZONTAL, 
                                           new Insets(0, 0, 0, 5), 218, -1));
        jPanel2.add(jTextField1, 
                    new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, 
                                           GridBagConstraints.HORIZONTAL, 
                                           new Insets(0, 0, 0, 5), 218, -1));
    }

    private void jButtonSair_actionPerformed(ActionEvent e) {
        ExitApplicationUtil.getCurrentInstance().exitEvilApplication(this);
    }

    private void jButtonLogin_actionPerformed(ActionEvent e) {
        try {
            UsuarioHome home = new UsuarioHome();
            Usuario u = new Usuario();
            u.setUsername(this.jTextField1.getText().trim());
            u.setSenha(new String(this.jPasswordField1.getPassword()));
            u = home.findByLoginAndPass(u);
            if (u != null) {                
                Application.setUsuarioLogado(u);
                dispose();
            } else {
                new EvilInformation(this).showMessage("Usuário e/ou senha incorretos!");
            }
        } catch (Exception ex) {
            new EvilError(null, true, ex).setVisible(true);
        }
    }

    private void firstEnter(ActionEvent e) {
        this.jPasswordField1.requestFocus();
    }

    
    private void login(ActionEvent e) {
        this.jButtonLogin_actionPerformed(null);
    }
}
