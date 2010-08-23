package com.dudhoo.nemesis.swing.usuario;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.GrupoUsuario;
import com.dudhoo.nemesis.hibernate.Usuario;

import com.toedter.calendar.JCalendar;

import com.toedter.calendar.JCalendarBeanInfo;

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelUsuario extends JPanel{
    private Usuario user = null;
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextFieldNome = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextFieldEmail = new JTextField();
    private JPanel jPanel1 = new JPanel();
    private JCheckBox jCheckBox1 = new JCheckBox();
    private JDateChooser jDateChooser1 = new JDateChooser();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JTextField jTextFieldCelular = new JTextField();
    private JTextField jTextFieldUsername = new JTextField();
    private JPasswordField jPasswordField1 = new JPasswordField();
    private JPanel jPanel2 = new JPanel();


    public JPanelUsuario(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    public void setUser(Usuario user){
	this.user = user;
	if(this.user != null){
	    this.jTextFieldCelular.setText(user.getCelular());
	    this.jTextFieldEmail.setText(user.getEmail());
	    this.jTextFieldNome.setText(user.getNome());
	    this.jTextFieldUsername.setText(user.getUsername() );
	    if(user.getExpira() != null){
		this.jDateChooser1.setDate(user.getExpira());
	    }	    
	}else{
	    this.jTextFieldCelular.setText(null);
	    this.jTextFieldEmail.setText(null);
	    this.jTextFieldNome.setText(null);
	    this.jTextFieldUsername.setText(null );	         
	}
    }

    public Usuario getUser() throws ValidationException{
	if(user == null){
	    user = new Usuario();
	}
	String pass = new String(this.jPasswordField1.getPassword());
	String nome = this.jTextFieldNome.getText().trim();
	String username = this.jTextFieldUsername.getText().trim();
	if(username.length() < 5 ){
	    new ValidationException("O username precisa ter mais de 5 caracteres");
	}	
	if(nome.length() < 5){
	    new ValidationException("O nome precisa ter mais de 5 caracteres");
	}
	if(pass.length() < 4){
	    new ValidationException("A senha deve conter mais de 4 caracteres");
	}
	user.setNome(nome);
	user.setCelular(this.jTextFieldCelular.getText().trim());
	user.setEmail(this.jTextFieldEmail.getText().trim());
	user.setSenha(pass);
	user.setUsername(username);	
	if(this.jCheckBox1.isSelected()){
	    user.setExpira(this.jDateChooser1.getDate() );
	}
	return user;
    }

    private void jbInit() throws Exception{
	this.setLayout(null);
	this.setSize(new Dimension(361, 308));
	jLabel1.setText("Nome Completo:");
	jLabel1.setBounds(new Rectangle(10, 25, 110, 20));
	jTextFieldNome.setBounds(new Rectangle(120, 25, 220, 20));
	jLabel2.setText("Email:");
	jLabel2.setBounds(new Rectangle(10, 58, 110, 20));
	jTextFieldEmail.setBounds(new Rectangle(120, 58, 220, 20));
	jPanel1.setBounds(new Rectangle(10, 220, 345, 80));
	jPanel1.setBorder(BorderFactory.createTitledBorder("Usuário temporário"));
	jCheckBox1.setText("conta irá expirar");
	jCheckBox1.setToolTipText("Marque o checkBox se você deseja que a conta do usuário expire");
	jLabel4.setText("Usuário:");
	jLabel4.setBounds(new Rectangle(20, 25, 90, 20));
	jLabel5.setText("Senha:");
	jLabel5.setBounds(new Rectangle(20, 50, 90, 20));
	jLabel7.setText("Celular:");
	jLabel7.setBounds(new Rectangle(10, 91, 110, 20));
	jTextFieldCelular.setBounds(new Rectangle(120, 90, 220, 20));
	jTextFieldUsername.setToolTipText("Nome de usuário para logar no sistema");
	jTextFieldUsername.setBounds(new Rectangle(110, 25, 175, 20));
	jPasswordField1.setBounds(new Rectangle(110, 50, 175, 20));
	jPanel2.setBounds(new Rectangle(10, 120, 345, 100));
	jPanel2.setToolTipText("null");
	jPanel2.setLayout(null);
	jPanel2.setBorder(BorderFactory.createTitledBorder("Sistema"));
	jPanel1.add(jCheckBox1, null);
	jPanel1.add(jDateChooser1, null);
	jPanel2.add(jTextFieldUsername, null);
	jPanel2.add(jLabel4, null);
	jPanel2.add(jLabel5, null);
	jPanel2.add(jPasswordField1, null);
	this.add(jPanel2, null);
	this.add(jTextFieldCelular, null);
	this.add(jLabel7, null);
	this.add(jPanel1, null);
	this.add(jTextFieldEmail, null);
	this.add(jLabel2, null);
	this.add(jTextFieldNome, null);
	this.add(jLabel1, null);
	this.setSize(355,307);
    }
}
