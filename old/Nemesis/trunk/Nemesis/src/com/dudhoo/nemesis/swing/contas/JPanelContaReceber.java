package com.dudhoo.nemesis.swing.contas;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.component.BotaoFindPessoa;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.swing.JPanelObservacoes;

import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelContaReceber extends JPanel{
    private ContaReceber contaReceber;
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextValor = new JTextField();
    private JCheckBox jCheckBoxContaPaga = new JCheckBox();
    private JDateChooser jDatePayment = new JDateChooser();
    private JPanel jPanel1 = new JPanel();
    private JPanelObservacoes jPanelObservacoes1 = new JPanelObservacoes();
    private JLabel jLabel2 = new JLabel();
    private BotaoFindPessoa botaoFindPessoa1 = new BotaoFindPessoa();
    private ComboTipoConta comboTipoConta1 = new ComboTipoConta(true);
    private JLabel jLabel3 = new JLabel();

    public JPanelContaReceber(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(538, 329));
	this.setLayout(null);
	jLabel1.setText("Valor:");
	jLabel1.setBounds(new Rectangle(25, 45, 50, 15));
	jTextValor.setBounds(new Rectangle(85, 45, 125, 20));
	jCheckBoxContaPaga.setText("Conta está paga");
	jCheckBoxContaPaga.setBounds(new Rectangle(85, 70, 200, 20));
	jDatePayment.setBounds(new Rectangle(20, 25, 235, 20));
	jPanel1.setBounds(new Rectangle(85, 125, 265, 60));
	jPanel1.setBorder(BorderFactory.createTitledBorder("Data de Pagamento:"));
	jPanel1.setLayout(null);
	jPanelObservacoes1.setBounds(new Rectangle(85, 195, 440, 125));
	jLabel2.setText("Pessoa");
	jLabel2.setBounds(new Rectangle(15, 25, 60, 15));
	botaoFindPessoa1.setBounds(new Rectangle(85, 20, 290, 25));
        comboTipoConta1.setBounds(new Rectangle(85, 95, 285, 20));
        jLabel3.setText("Conta:");
        jLabel3.setBounds(new Rectangle(10, 95, 75, 20));
        this.add(jLabel3, null);
        this.add(comboTipoConta1, null);
        this.add(botaoFindPessoa1, null);
	this.add(jLabel2, null);
        this.add(jPanelObservacoes1, null);
        jPanel1.add(jDatePayment, BorderLayout.CENTER);
        this.add(jPanel1, null);
        this.add(jCheckBoxContaPaga, null);
	this.add(jTextValor, null);
	this.add(jLabel1, null);
    }

    public void setContaReceber(ContaReceber conta){
	this.contaReceber = conta;
	if(this.contaReceber != null){
	    this.jCheckBoxContaPaga.setSelected(conta.isContaPaga());
	    this.jDatePayment.setDate(conta.getDataPagamento());
	    this.jPanelObservacoes1.setObs(conta.getObservacao());
	    this.jTextValor.setText(String.valueOf(conta.getValor()));
	    this.botaoFindPessoa1.setPessoa(conta.getPessoa());
            this.comboTipoConta1.setTipoConta(conta.getTipoConta());
	} else {
	    this.jCheckBoxContaPaga.setSelected(false);
	    this.jDatePayment.setDate(null);
	    this.jPanelObservacoes1.setObs(null);
	    this.jTextValor.setText(null);
	    this.botaoFindPessoa1.setPessoa(null);
	}
    }

    public ContaReceber getContaReceber() throws ValidationException{
	if(contaReceber == null){
	    contaReceber = new ContaReceber();
	}
	Pessoa pes = botaoFindPessoa1.getPessoa();
	long valor = Long.parseLong(this.jTextValor.getText());
	if(pes == null){
	    throw new ValidationException("Você precisa escolher uma pessoa");
	}
	contaReceber.setContaPaga(this.jCheckBoxContaPaga.isSelected());
	contaReceber.setDataPagamento(this.jDatePayment.getDate());
	contaReceber.setObservacao(jPanelObservacoes1.getObs());
	contaReceber.setPessoa(pes);
	contaReceber.setUsuario(Application.getUsuarioLogado());
	contaReceber.setValor(valor);
        contaReceber.setTipoConta(comboTipoConta1.getTipoConta());

	return contaReceber;
    }
}
