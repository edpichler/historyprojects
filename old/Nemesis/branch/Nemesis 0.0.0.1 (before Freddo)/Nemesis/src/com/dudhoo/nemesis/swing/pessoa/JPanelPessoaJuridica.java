/*
 * JPanelPessoaJuridica.java
 *
 * Created on 16 de Fevereiro de 2006, 00:43
 */

package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author  duduzera
 */
public class JPanelPessoaJuridica
    extends JPanel{
    private PessoaJuridica pj;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JTextField jTextFieldCNPJ;
    private JTextField jTextFieldFantasia;
    private JTextField jTextFieldInscricaoEstadual;
    private JTextField jTextFieldNomeContato;
    private JTextField jTextFieldRazao;

    /** Creates new form JPanelPessoaJuridica */
    public JPanelPessoaJuridica(){
	jbInit();
    }

    public void setPessoaJuridica(PessoaJuridica _pj){
	this.pj = _pj;
	if(this.pj == null){
	    limpa();
	} else {
	    this.jTextFieldCNPJ.setText(pj.getCnpj());
	    this.jTextFieldFantasia.setText(pj.getFantasia());
	    this.jTextFieldInscricaoEstadual.setText(pj.getInscricaoEstadual());
	    this.jTextFieldNomeContato.setText(pj.getNomeCompletoContato());
	    this.jTextFieldRazao.setText(pj.getRazaoSocial());
	}
    }

    public PessoaJuridica getPessoaJuridica() throws ValidationException{
	if(this.pj == null){
	    pj = new PessoaJuridica();
	}
	String cnpj = this.jTextFieldCNPJ.getText().trim();
	int tamCnpj = 3;
	if(cnpj.length() < 3){ //TODO CNPJ TEM UM TAMANHO PADRÃO, ARRUMAR ISSO
	    throw new ValidationException("Cnpj não pode ter menos que 3 caracteres"); //TODO validar cnpj
	}
	String razSoc = this.jTextFieldRazao.getText().trim();
	if(razSoc.length() < 2){
	    throw new ValidationException("Razão social não pode ser em branco.");
	}
	String nomeCont = this.jTextFieldNomeContato.getText().trim();
	if(nomeCont.length() < 2){
	    throw new ValidationException("Nome do contato não pode ser em branco.");
	}
	String insEst = this.jTextFieldInscricaoEstadual.getText().trim();
	if(insEst.length() < 3){
	    throw new ValidationException("Inscrição estadual não pode estar em branco.");
	}
	String fantasia = this.jTextFieldFantasia.getText().trim();
	if(fantasia.length() < 2){
	    throw new ValidationException("Fantasia não pode ser em branco");
	}
	pj.setCnpj(cnpj);
	pj.setFantasia(fantasia);
	pj.setInscricaoEstadual(insEst);
	pj.setNomeCompletoContato(nomeCont);
	pj.setRazaoSocial(razSoc);
	return pj;
    }

    private void limpa(){
	this.jTextFieldCNPJ.setText(null);
	this.jTextFieldFantasia.setText(null);
	this.jTextFieldInscricaoEstadual.setText(null);
	this.jTextFieldNomeContato.setText(null);
	this.jTextFieldRazao.setText(null);
    }


    private void jbInit(){
	jLabel1 = new JLabel();
	jTextFieldRazao = new JTextField();
	jLabel2 = new JLabel();
	jTextFieldCNPJ = new JTextField();
	jLabel3 = new JLabel();
	jTextFieldFantasia = new JTextField();
	jLabel4 = new JLabel();
	jTextFieldInscricaoEstadual = new JTextField();
	jPanel1 = new JPanel();
	jTextFieldNomeContato = new JTextField();
	jLabel5 = new JLabel();


	setBorder(new EtchedBorder());
	this.setLayout(null);
	this.setSize(new Dimension(361, 263));
	jLabel1.setText("Raz\u00e3o Social:");
	jLabel1.setBounds(new Rectangle(25, 25, 95, 15));


	add(jLabel1);
	add(jTextFieldRazao);
	add(jLabel2);
	add(jTextFieldCNPJ);
	add(jLabel3);
	add(jTextFieldFantasia);
	add(jLabel4);
	add(jTextFieldInscricaoEstadual);
	add(jPanel1);
	jLabel2.setText("CNPJ:");
	jLabel2.setBounds(new Rectangle(25, 55, 95, 15));


	jLabel3.setText("Fantasia:");
	jLabel3.setBounds(new Rectangle(25, 85, 95, 15));


	jLabel4.setText("Inscri\u00e7\u00e3o Est.:");
	jLabel4.setBounds(new Rectangle(25, 115, 95, 15));


	jPanel1.setLayout(null);

	jPanel1.setBorder(new TitledBorder("Contato empresarial"));
	jPanel1.setBounds(new Rectangle(20, 155, 330, 80));
	jTextFieldCNPJ.setBounds(new Rectangle(125, 50, 180, 20));
	jTextFieldFantasia.setBounds(new Rectangle(125, 80, 180, 20));
	jTextFieldInscricaoEstadual.setBounds(new Rectangle(125, 110, 180, 20));
	jTextFieldNomeContato.setToolTipText("Nome completo de um contato empresarial");
	jTextFieldNomeContato.setBounds(new Rectangle(125, 20, 195, 20));
	jTextFieldRazao.setBounds(new Rectangle(125, 20, 180, 20));

	jLabel5.setText("Nome completo:");
	jLabel5.setBounds(new Rectangle(15, 25, 76, 15));
	jPanel1.add(jTextFieldNomeContato);
	jPanel1.add(jLabel5);


    }
    //TODO DEPOIS QUE ACABAR O TCC, CONVERTER TODOS OS LUGARES QUE FORAM IMPORTADOS O ABSOLUTElAYOUT PARA OUTRO QUALQUER. Pensar também se´será necessario.

}
