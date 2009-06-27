package com.dudhoo.nemesis.swing.contas.tipo;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.TipoConta;

import com.dudhoo.nemesis.swing.JPanelObservacoes;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelTipoContas extends JPanel {
    private TipoConta tipo;
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JPanelObservacoes jPanelObservacoes1 = new JPanelObservacoes();
    private JTextField jTextFieldNome = new JTextField();
    private JPanel jPanel1 = new JPanel();
    private JRadioButton jRadioButtonCredito = new JRadioButton();
    private JRadioButton jRadioButtonDebito = new JRadioButton();
    private JTextField jTextFieldDess = new JTextField();

    public PanelTipoContas() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(null);
        this.setSize(new Dimension(372, 220));
        jLabel1.setText("Descrição:");
        jLabel1.setBounds(new Rectangle(15, 40, 65, 15));
        jLabel3.setText("Nome:");
        jLabel3.setBounds(new Rectangle(15, 10, 65, 15));
        jLabel3.setToolTipText("null");
        jPanelObservacoes1.setBounds(new Rectangle(5, 130, 365, 90));
        jTextFieldNome.setBounds(new Rectangle(85, 10, 245, 20));
        jPanel1.setBounds(new Rectangle(80, 70, 250, 55));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Tipo do fluxo de caixa"));
        jRadioButtonCredito.setText("Crédito");
        jRadioButtonDebito.setText("Débito");
        jTextFieldDess.setBounds(new Rectangle(85, 40, 245, 20));
        jPanel1.add(jRadioButtonCredito, null);
        jPanel1.add(jRadioButtonDebito, null);
        this.add(jTextFieldDess, null);
        this.add(jPanel1, null);
        this.add(jTextFieldNome, null);
        this.add(jPanelObservacoes1, null);
        this.add(jLabel3, null);
        this.add(jLabel1, null);

        ButtonGroup btg = new ButtonGroup();
        btg.add(jRadioButtonCredito);
        btg.add(jRadioButtonDebito);
        jRadioButtonDebito.setSelected(true);
    }

    public void setTipo(TipoConta _tipo) {
        this.tipo = _tipo;
        if(_tipo == null){
            this.jPanelObservacoes1.setObs(null);
            this.jTextFieldDess.setText(null);
            this.jTextFieldNome.setText(null);            
        }else{
            this.jPanelObservacoes1.setObs(tipo.getObservacao());
            this.jTextFieldDess.setText(tipo.getDescricao());
            this.jTextFieldNome.setText(tipo.getNome());
            this.jRadioButtonCredito.setSelected(tipo.isCredito());
        }
    }

    public TipoConta getTipo() throws ValidationException{
        if (tipo == null) {
            tipo = new TipoConta();
        }
        String descricao = this.jTextFieldDess.getText().trim(); 
        String nome = jTextFieldNome.getText().trim();
        tipo.setCredito(this.jRadioButtonCredito.isSelected());
        tipo.setDescricao(descricao);
        tipo.setNome(nome);
        tipo.setObservacao(this.jPanelObservacoes1.getObs());
        tipo.setUsuario(Application.getUsuarioLogado());
        return tipo;
    }
}
