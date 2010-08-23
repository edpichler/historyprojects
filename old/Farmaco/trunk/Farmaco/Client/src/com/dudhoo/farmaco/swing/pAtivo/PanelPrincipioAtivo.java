package com.dudhoo.farmaco.swing.pAtivo;

import com.dudhoo.evilframework.components.PanelDescricao;
import com.dudhoo.evilframework.exception.ValidationException;
import com.dudhoo.farmaco.hibernate.PrincipioAtivo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PanelPrincipioAtivo extends JPanel{
    private PrincipioAtivo ativo ;
    
    private JTextField jTextFieldNome = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JTextField jTextFieldDescricao = new JTextField();
    private JTabbedPane jTabbedPane1 = new JTabbedPane();
    private JPanel paneInteracoes = new JPanel();
    private JPanel jPanelIndicacoes = new JPanel();
    private JPanel jPanelPrecacoes = new JPanel();
    private JPanel jPanelCuidadosEspeciais = new JPanel();
    private JPanel jPanelReacoesAdversas = new JPanel();
    private JPanel jPanelPosologia = new JPanel();
    private JPanel jPanelContraIndicacoes = new JPanel();
    private PanelDescricao panelDescricaoInteracoes = new PanelDescricao();
    private BorderLayout borderLayout1 = new BorderLayout();
    private BorderLayout borderLayout2 = new BorderLayout();
    private BorderLayout borderLayout3 = new BorderLayout();
    private BorderLayout borderLayout4 = new BorderLayout();
    private BorderLayout borderLayout5 = new BorderLayout();
    private BorderLayout borderLayout6 = new BorderLayout();
    private BorderLayout borderLayout7 = new BorderLayout();
    private PanelDescricao panelDescricaoIndicacoes = new PanelDescricao();
    private PanelDescricao panelDescricaoPrecaucoes = new PanelDescricao();
    private PanelDescricao panelDescricaoCuidadosEspeciais = new PanelDescricao();
    private PanelDescricao panelDescricaoReacoesAdversas = new PanelDescricao();
    private PanelDescricao panelDescricaoPosologia = new PanelDescricao();
    private PanelDescricao panelDescricaoContraIndicacoes = new PanelDescricao();

    public PanelPrincipioAtivo() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(628, 392));
        this.setLayout(null);
        jTextFieldNome.setBounds(new Rectangle(140, 15, 410, 20));
        jLabel1.setText("Nome:");
        jLabel1.setBounds(new Rectangle(0, 15, 130, 20));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Nome:");
        jLabel3.setBounds(new Rectangle(0, 45, 100, 20));
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("Nome:");
        jLabel4.setBounds(new Rectangle(0, 45, 100, 20));
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setText("Descrição:");
        jLabel5.setBounds(new Rectangle(0, 45, 130, 20));
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextFieldDescricao.setBounds(new Rectangle(140, 45, 410, 20));
        jTabbedPane1.setBounds(new Rectangle(25, 75, 585, 290));
        paneInteracoes.setToolTipText("Interações");
        paneInteracoes.setLayout(borderLayout1);
        jPanelIndicacoes.setToolTipText("Indicações");
        jPanelIndicacoes.setLayout(borderLayout2);
        jPanelPrecacoes.setToolTipText("Precauções");
        jPanelPrecacoes.setLayout(borderLayout3);
        jPanelCuidadosEspeciais.setToolTipText("Cuidados Especiais");
        jPanelCuidadosEspeciais.setLayout(borderLayout4);
        jPanelReacoesAdversas.setToolTipText("Reações Adversas");
        jPanelReacoesAdversas.setLayout(borderLayout5);
        jPanelPosologia.setToolTipText("Posologia");
        jPanelPosologia.setLayout(borderLayout6);
        jPanelContraIndicacoes.setToolTipText("Contra Indicações");
        jPanelContraIndicacoes.setLayout(borderLayout7);
        panelDescricaoInteracoes.setToolTipText("null");
        paneInteracoes.add(panelDescricaoInteracoes, BorderLayout.CENTER);
        jTabbedPane1.addTab("Interações", paneInteracoes);
        jPanelIndicacoes.add(panelDescricaoIndicacoes, BorderLayout.CENTER);
        jTabbedPane1.addTab("Indicações", jPanelIndicacoes);
        jPanelPrecacoes.add(panelDescricaoPrecaucoes, BorderLayout.CENTER);
        jTabbedPane1.addTab("Precauções", jPanelPrecacoes);
        jPanelCuidadosEspeciais.add(panelDescricaoCuidadosEspeciais, BorderLayout.CENTER);
        jTabbedPane1.addTab("Cuidad. Espec.", jPanelCuidadosEspeciais);
        jPanelReacoesAdversas.add(panelDescricaoReacoesAdversas, BorderLayout.CENTER);
        jTabbedPane1.addTab("Reações Adv.", jPanelReacoesAdversas);
        jPanelPosologia.add(panelDescricaoPosologia, BorderLayout.CENTER);
        jTabbedPane1.addTab("Posologia", jPanelPosologia);
        jPanelContraIndicacoes.add(panelDescricaoContraIndicacoes, BorderLayout.CENTER);
        jTabbedPane1.addTab("Cont. Indic.", jPanelContraIndicacoes);
        this.add(jTabbedPane1, null);
        this.add(jTextFieldDescricao, null);
        this.add(jLabel5, null);
        this.add(jLabel1, null);
        this.add(jTextFieldNome, null);
    }

    public void setPrincipioAtivo(PrincipioAtivo ativo) {
        this.ativo = ativo;
        if(ativo == null){
            this.panelDescricaoContraIndicacoes.setText(null);
            this.panelDescricaoCuidadosEspeciais.setText(null);
            this.jTextFieldDescricao.setText(null);
            this.panelDescricaoIndicacoes.setText(null);
            this.panelDescricaoInteracoes.setText(null);
            this.jTextFieldNome.setText(null);
            this.panelDescricaoPosologia.setText(null);
            this.panelDescricaoPrecaucoes.setText(null);
            this.panelDescricaoReacoesAdversas.setText(null);            
            this.jTextFieldNome.requestFocus(); 
        }else{
            this.panelDescricaoIndicacoes.setText(ativo.getContraIndicacoes());
            this.panelDescricaoCuidadosEspeciais.setText(ativo.getCuidadosEspeciais());
            this.jTextFieldDescricao.setText(ativo.getDescricao());
            this.panelDescricaoIndicacoes.setText(ativo.getIndicacoes());
            this.panelDescricaoInteracoes.setText(ativo.getInteracoes());
            this.jTextFieldNome.setText(ativo.getNome());
         //   this.panelDescricaoPosologia.setText(ativo.getPosologia());
            this.panelDescricaoPrecaucoes.setText(ativo.getPrecaucoes());
            this.panelDescricaoReacoesAdversas.setText(ativo.getReacoesAdversas());
        }
    }

    public PrincipioAtivo getPrincipioAtivo() throws ValidationException {
        if(ativo == null){
            ativo = new PrincipioAtivo();
        }        
        String nome = this.jTextFieldNome.getText().trim();
        if(nome.length() < 1 ){
            throw new ValidationException("O nome não pode ser em branco.");
        }
        ativo.setContraIndicacoes(this.panelDescricaoContraIndicacoes.getText().trim());
        ativo.setCuidadosEspeciais(this.panelDescricaoCuidadosEspeciais.getText().trim());
        ativo.setDescricao(this.jTextFieldDescricao.getText().trim());
        ativo.setIndicacoes(this.panelDescricaoIndicacoes.getText().trim());
        ativo.setInteracoes(this.panelDescricaoInteracoes.getText());
        ativo.setNome(nome);
       // ativo.setPosologia( this.panelDescricaoPosologia.getText().trim());
        ativo.setPrecaucoes(this.panelDescricaoPrecaucoes.getText().trim());
        ativo.setReacoesAdversas(this.panelDescricaoReacoesAdversas.getText());
        return ativo;
    }
}
